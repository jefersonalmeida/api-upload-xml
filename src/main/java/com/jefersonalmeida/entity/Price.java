package com.jefersonalmeida.entity;

import com.jefersonalmeida.api.model.PriceType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Region.class)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PriceType type;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    public Price() {
    }

    public Price(final PriceType type, final BigDecimal value) {
        this.type = type;
        this.value = value;
    }

    public Price(final Region region, final PriceType type, final BigDecimal value) {
        this.region = region;
        this.type = type;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Price price = (Price) o;
        return Objects.equals(id, price.id) && Objects.equals(region, price.region) && type == price.type && Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, region, type, value);
    }
}
