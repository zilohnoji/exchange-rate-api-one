package com.donatoordep;


import com.donatoordep.api.ApiExchangeRateSpecification;
import com.donatoordep.api.impl.ExchangeRateService;
import com.donatoordep.dto.response.GetPairQuotationResponseDTO;
import com.donatoordep.entities.Currency;
import com.donatoordep.enums.CurrencyCode;
import com.donatoordep.mappers.libs.impl.JacksonDeserializer;

public class ConverseTyApplication {

    private static final JacksonDeserializer<GetPairQuotationResponseDTO> jacksonDeserializer = JacksonDeserializer.createInstance(GetPairQuotationResponseDTO.class);
    private static final ApiExchangeRateSpecification<Currency> service = new ExchangeRateService(jacksonDeserializer);

    public static void main(String[] args) throws Throwable {
        Currency pairQuotation = service.getPairQuotation(CurrencyCode.BRL, CurrencyCode.USD, 20D);

        System.out.println(pairQuotation.getLastUpdate());
        System.out.println(pairQuotation.getCode());
        System.out.println(pairQuotation.getConversionRates());
    }
}