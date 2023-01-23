package com.jefersonalmeida.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(schema = "public", name = "agents")
@Entity(name = "Agent")
public class Agent {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "code", nullable = false)
    private Integer code;
    @Column(name = "date_at", nullable = false)
    private Instant dateAt;

    @OneToMany(
            mappedBy = "agent",
            targetEntity = Region.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Region> regions;

    public Agent() {
    }

    public Agent(
            final UUID id,
            final Integer code,
            final Instant dateAt,
            final List<Region> regions
    ) {
        this.id = id;
        this.code = code;
        this.dateAt = dateAt;
        this.regions = regions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
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
        return Objects.equals(id, agent.id) && Objects.equals(code, agent.code) && Objects.equals(dateAt, agent.dateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, dateAt);
    }
}
