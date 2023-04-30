package com.vpr.gasoline_prices_api.model.entity;

import com.vpr.gasoline_prices_api.model.enums.GasolineType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "gasoline_price")
public class GasolinePriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "gasoline_type", nullable = false)
    private String gasolineType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "currency", nullable = false)
    private String currency;
    @Column(name = "date", nullable = false)
    private LocalDate date;

    public GasolinePriceEntity(String gasolineType, CityEntity cityEntity, Double price, String currency, LocalDate date) {
        this.gasolineType = gasolineType;
        this.cityEntity = cityEntity;
        this.price = price;
        this.currency = currency;
        this.date = date;
    }
}
