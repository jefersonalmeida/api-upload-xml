package com.jefersonalmeida.service;

import com.jefersonalmeida.api.model.AgentRequest;
import com.jefersonalmeida.api.model.PriceType;
import com.jefersonalmeida.entity.Agent;
import com.jefersonalmeida.entity.Region;
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

    @Transactional
    public List<Integer> create(final AgentRequest[] requests) {

        // Simulate delay
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        final var listAgents = new ArrayList<Agent>();

        for (final AgentRequest request : requests) {

            final var listRegions = new ArrayList<Region>();
            final var agent = new Agent();

            request.regions().forEach(model -> {
                final var region = new Region(agent, model.acronym());

                model.average().forEach(average -> region.addPrice(PriceType.AVERAGE, average));
                model.generation().forEach(average -> region.addPrice(PriceType.GENERATION, average));
                model.purchase().forEach(average -> region.addPrice(PriceType.PURCHASE, average));

                listRegions.add(region);
            });

            agent.setCode(request.code());
            agent.setDateAt(request.date());
            agent.setRegions(listRegions);

            listAgents.add(agent);
        }

        this.agentRepository.saveAll(listAgents);

        return listAgents.stream().map(Agent::getCode).toList();
    }
}
