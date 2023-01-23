package com.jefersonalmeida.api.rest;

import com.jefersonalmeida.api.model.AgentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping(value = "upload")
@Tag(name = "Upload XML")
public interface UploadXmlAPI {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new Agent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "Validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "Internal server error was thrown")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void createAgent(@RequestBody AgentRequest[] input);
}
