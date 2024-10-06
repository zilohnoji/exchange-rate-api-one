package com.donatoordep.api;

import com.donatoordep.enums.CurrencyCode;

public interface ApiExchangeRateSpecification<T> {

    T getPairQuotation(CurrencyCode baseCode, CurrencyCode targetCode, Double amount) throws Throwable;
}