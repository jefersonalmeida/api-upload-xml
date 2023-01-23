package com.jefersonalmeida.entity;

import com.jefersonalmeida.api.model.Acronym;
import com.jefersonalmeida.api.model.PriceType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Table(schema = "public", name = "regions")
@Entity(name = "Region")
public class Region {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Agent.class)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @Column(name = "acronym", nullable = false)
    @Enumerated(EnumType.STRING)
    private Acronym acronym;

    @OneToMany(
            mappedBy = "region",
            targetEntity = Price.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private final List<Price> prices = new ArrayList<>();

    public Region() {
    }

    public Region(Agent agent, Acronym acronym) {
        this.agent = agent;
        this.acronym = acronym;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Acronym getAcronym() {
        return acronym;
    }

    public void setAcronym(Acronym acronym) {
        this.acronym = acronym;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void addPrice(final PriceType type, BigDecimal value) {
        this.prices.add(new Price(this, type, value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Region region = (Region) o;
        return Objects.equals(id, region.id) && acronym == region.acronym && Objects.equals(agent, region.agent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acronym, agent);
    }
}
