package com.donatoordep;


import com.donatoordep.api.ApiExchangeRateSpecification;
import com.donatoordep.api.impl.ExchangeRateService;
import com.donatoordep.dto.response.GetPairQuotationResponseDTO;
import com.donatoordep.entities.Currency;
import com.donatoordep.enums.CurrencyCode;
import com.donatoordep.mappers.libs.impl.JacksonDeserializer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ConverseTyApplication {

    private static final JacksonDeserializer<GetPairQuotationResponseDTO> jacksonDeserializer = JacksonDeserializer.createInstance(GetPairQuotationResponseDTO.class);
    private static final ApiExchangeRateSpecification<Currency> service = new ExchangeRateService(jacksonDeserializer);

    public static void main(String[] args) {

        Currency pairQuotation;
        List<CurrencyCode> currencies = Arrays.stream(CurrencyCode.values()).toList();

        try (Scanner sc = new Scanner(System.in)) {
            IntStream.range(0, currencies.size()).forEach(i -> {
                System.out.printf("[%s] %s ", i, currencies.get(i));

                if ((i + 1) % 6 == 0) {
                    System.out.println();
                }
            });

            System.out.print("Escolha a moeda que deseja converter: ");
            int baseChoice = sc.nextInt();

            System.out.print("Qual valor deseja converter? ");
            double value = sc.nextDouble();

            System.out.print("Para qual moeda você deseja converter? ");
            int secondaryChoice = sc.nextInt();

            pairQuotation = service.getPairQuotation(currencies.get(baseChoice), currencies.get(secondaryChoice), value);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        System.out.println(pairQuotation.getConversionRates() + " " + pairQuotation.getCode() + " " + pairQuotation.getLastUpdate());
    }
}