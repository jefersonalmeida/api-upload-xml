package com.jefersonalmeida.entity;

import com.jefersonalmeida.api.model.Acronym;
import com.jefersonalmeida.api.model.PriceType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "Price")
@Table(schema = "public", name = "regions_prices")
public class Price {
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

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PriceType type;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "date_at", nullable = false)
    private Instant dateAt;

    public Price() {
    }

    public Price(final PriceType type, final BigDecimal value) {
        this.type = type;
        this.value = value;
    }

    public Price(
            final Agent agent,
            final Acronym acronym,
            final PriceType type,
            final BigDecimal value,
            final Instant dateAt
    ) {
        this.agent = agent;
        this.acronym = acronym;
        this.type = type;
        this.value = value;
        this.dateAt = dateAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Acronym getAcronym() {
        return acronym;
    }

    public void setAcronym(Acronym acronym) {
        this.acronym = acronym;
    }

    public PriceType getType() {
        return type;
    }

    public void setType(PriceType type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Instant getDateAt() {
        return dateAt;
    }

    public void setDateAt(Instant dateAt) {
        this.dateAt = dateAt;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Price price = (Price) o;
        return Objects.equals(agent, price.agent) && acronym == price.acronym && type == price.type && Objects.equals(value, price.value) && Objects.equals(dateAt, price.dateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agent, acronym, type, value, dateAt);
    }
}
