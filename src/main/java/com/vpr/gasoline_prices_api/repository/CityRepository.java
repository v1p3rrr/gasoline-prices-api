package com.vpr.gasoline_prices_api.repository;

import com.vpr.gasoline_prices_api.model.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    CityEntity findCityEntityByName(String name);
}
