package com.donatoordep.entities;

import com.donatoordep.enums.CurrencyCode;

import java.util.HashMap;

public class Currency {

    private String lastUpdate;
    private CurrencyCode code;
    private final HashMap<CurrencyCode, Double> conversionRates = new HashMap<>();

    private Currency() {
    }

    private Currency(CurrencyCode code) {
        this.code = code;
    }

    public static Currency createInstance(String baseCode) {
        return new Currency(CurrencyCode.valueOf(baseCode.toUpperCase()));
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void addConversionRate(String code, Double value) {
        conversionRates.put(CurrencyCode.valueOf(code.toUpperCase()), value);
    }

    public CurrencyCode getCode() {
        return code;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public HashMap<CurrencyCode, Double> getConversionRates() {
        return conversionRates;
    }
}