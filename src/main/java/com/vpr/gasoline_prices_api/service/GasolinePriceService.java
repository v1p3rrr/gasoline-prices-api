package com.vpr.gasoline_prices_api.service;

import com.vpr.gasoline_prices_api.model.dto.CityWithPriceListDTO;
import com.vpr.gasoline_prices_api.model.entity.CityEntity;
import com.vpr.gasoline_prices_api.model.entity.GasolinePriceEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface GasolinePriceService {
    public List<String> getCitiesList();

    public List<CityWithPriceListDTO> getPriceListByCity(String cityName);

    public CityWithPriceListDTO getPriceListByCityAndDate(String cityName, String date);

    public List<CityWithPriceListDTO> getPriceListByCityAndDateRange(String cityName, String dateStart, String dateEnd);
}
