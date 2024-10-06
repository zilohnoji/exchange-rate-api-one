package com.donatoordep.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetPairQuotationResponseDTO(

        @JsonProperty("time_last_update_utc")
        String lastUpdate,

        @JsonProperty("base_code")
        String baseCode,

        @JsonProperty("target_code")
        String targetCode,

        @JsonProperty("conversion_rate")
        Double conversionRate,

        @JsonProperty("conversion_result")
        Double conversionResult
) {
}
