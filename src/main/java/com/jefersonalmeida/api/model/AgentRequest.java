package com.jefersonalmeida.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

public record AgentRequest(
        @JsonProperty("code") Integer code,
        @JsonProperty("date") Instant date,
        @JsonProperty("regions") List<RegionModel> regions
) {
}
