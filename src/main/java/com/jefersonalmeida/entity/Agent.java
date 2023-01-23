package com.jefersonalmeida.entity;

import com.jefersonalmeida.api.model.Acronym;
import com.jefersonalmeida.api.model.PriceType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(schema = "public", name = "agents")
@Entity(name = "Agent")
public class Agent {
    @Id
    @Column(name = "code", nullable = false)
    private Integer code;
    @Column(name = "date_at", nullable = false)
    private Instant dateAt;

    @OneToMany(
            mappedBy = "agent",
            targetEntity = Price.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Price> prices = new HashSet<>();

    public Agent() {
    }

    public Agent(final Integer code) {
        this.code = code;
    }

    public Agent(
            final Integer code,
            final Instant dateAt,
            final Set<Price> prices
    ) {
        this.code = code;
        this.dateAt = dateAt;
        this.prices = prices;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Instant getDateAt() {
        return dateAt;
    }

    public void setDateAt(Instant dateAt) {
        this.dateAt = dateAt;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }

    public void addPrice(final Acronym acronym, final PriceType type, final BigDecimal value, final Instant dateAt) {
        this.prices.add(new Price(this, acronym, type, value, dateAt));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Agent agent = (Agent) o;
        return Objects.equals(code, agent.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
