package com.jefersonalmeida.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public record RegionModel(
        @JsonProperty("acronym") Acronym acronym,
        @JsonProperty("average") List<BigDecimal> average,
        @JsonProperty("generation") List<BigDecimal> generation,
        @JsonProperty("purchase") List<BigDecimal> purchase
) {
}
