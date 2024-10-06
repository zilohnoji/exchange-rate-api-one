package com.donatoordep.mappers.entities;

import com.donatoordep.dto.response.GetPairQuotationResponseDTO;
import com.donatoordep.entities.Currency;

public class CurrencyMapper {

    public static Currency fromPairResponse(GetPairQuotationResponseDTO response) {
        Currency currency = Currency.createInstance(response.baseCode());
        currency.setLastUpdate(response.lastUpdate());
        currency.addConversionRate(response.targetCode(), response.conversionResult());
        return currency;
    }
}