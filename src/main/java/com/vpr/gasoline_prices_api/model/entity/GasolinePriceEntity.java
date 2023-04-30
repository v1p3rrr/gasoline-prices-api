package com.vpr.gasoline_prices_api.model.entity;

import com.vpr.gasoline_prices_api.model.enums.GasolineType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "gasoline_type", nullable = false)
    private GasolineType gasolineType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    @Column(name = "price", nullable = false)
    private Long price;
    @Column(name = "currency", nullable = false)
    private String currency;
    @Column(name = "date", nullable = false)
    private LocalDate date;
}
