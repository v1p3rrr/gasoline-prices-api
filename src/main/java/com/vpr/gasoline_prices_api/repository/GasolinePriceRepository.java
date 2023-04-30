package com.vpr.gasoline_prices_api.repository;

import com.vpr.gasoline_prices_api.model.entity.CityEntity;
import com.vpr.gasoline_prices_api.model.entity.GasolinePriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GasolinePriceRepository extends JpaRepository<GasolinePriceEntity, Long> {
    List<GasolinePriceEntity> findAllByCityEntity(CityEntity city);
    List<GasolinePriceEntity> findAllByCityEntityName(String cityName);
    GasolinePriceEntity findByCityEntityNameAndDate(String cityName, LocalDate date);
    List<GasolinePriceEntity> findAllByCityEntityNameAndDateBetween(String cityName, LocalDate dateStart, LocalDate dateEnd);
}
