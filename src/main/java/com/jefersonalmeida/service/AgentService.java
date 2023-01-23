package com.jefersonalmeida.service;

import com.jefersonalmeida.api.model.AgentRequest;
import com.jefersonalmeida.api.model.PriceType;
import com.jefersonalmeida.entity.Agent;
import com.jefersonalmeida.repository.AgentRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(final AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public List<Integer> create(final AgentRequest[] requests) {

        // Simulate delay
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        final var listAgents = new ArrayList<Agent>();

        for (final AgentRequest request : requests) {
            final var agent = new Agent(request.code());
            agent.setDateAt(request.date());

            request.regions().forEach(model -> {
                model.average().forEach(it -> agent.addPrice(model.acronym(), PriceType.AVERAGE, it, request.date()));
                model.generation().forEach(it -> agent.addPrice(model.acronym(), PriceType.GENERATION, it, request.date()));
                model.purchase().forEach(it -> agent.addPrice(model.acronym(), PriceType.PURCHASE, it, request.date()));
            });
            listAgents.add(agent);
//            this.agentRepository.save(agent);
        }

        this.agentRepository.saveAll(listAgents);

        return listAgents.stream().map(Agent::getCode).toList();
    }
}
