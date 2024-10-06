package com.donatoordep.api.impl;

import com.donatoordep.api.ApiExchangeRateSpecification;
import com.donatoordep.dto.response.GetPairQuotationResponseDTO;
import com.donatoordep.entities.Currency;
import com.donatoordep.enums.CurrencyCode;
import com.donatoordep.mappers.entities.CurrencyMapper;
import com.donatoordep.mappers.libs.impl.JacksonDeserializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ExchangeRateService implements ApiExchangeRateSpecification<Currency> {

    private final String API_KEY = "ab2772276d2d4d4b8add7f1d";
    private final JacksonDeserializer<GetPairQuotationResponseDTO> jacksonDeserializer;

    public ExchangeRateService(JacksonDeserializer<GetPairQuotationResponseDTO> jacksonDeserializer) {
        this.jacksonDeserializer = jacksonDeserializer;
    }

    @Override
    public Currency getPairQuotation(CurrencyCode baseCode, CurrencyCode targetCode, Double amount) throws Exception {
        HttpResponse<String> response = this.requestFrom(String.format("pair/%s/%s/%s", baseCode, targetCode, amount));
        return CurrencyMapper.fromPairResponse(jacksonDeserializer.deserialize(response.body()));
    }

    private HttpClient getHttpClient() {
        return HttpClient.newBuilder().build();
    }

    private HttpResponse<String> requestFrom(String uri) throws IOException, InterruptedException {
        return this.getHttpClient().send(HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + API_KEY)
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + uri))
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString());
    }
}