package com.jefersonalmeida.api.rest.controller;

import com.jefersonalmeida.api.model.AgentRequest;
import com.jefersonalmeida.api.rest.UploadXmlAPI;
import com.jefersonalmeida.service.AgentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadXmlController implements UploadXmlAPI {

    private final AgentService agentService;

    public UploadXmlController(final AgentService agentService) {
        this.agentService = agentService;
    }

    @Override
    public void createAgent(final AgentRequest[] input) {
        final var resut = this.agentService.create(input);
        System.out.println(resut);
    }
}
