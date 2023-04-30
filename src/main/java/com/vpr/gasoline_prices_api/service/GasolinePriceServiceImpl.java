package com.vpr.gasoline_prices_api.service;

import com.vpr.gasoline_prices_api.model.dto.CityWithPriceListDTO;
import com.vpr.gasoline_prices_api.model.entity.CityEntity;
import com.vpr.gasoline_prices_api.model.entity.GasolinePriceEntity;
import com.vpr.gasoline_prices_api.model.mapper.GasolinePriceMapper;
import com.vpr.gasoline_prices_api.repository.CityRepository;
import com.vpr.gasoline_prices_api.repository.GasolinePriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GasolinePriceServiceImpl implements GasolinePriceService{
    private final CityRepository cityRepository;
    private final GasolinePriceRepository gasolinePriceRepository;
    private final GasolinePriceMapper gasolinePriceMapper;


    @Override
    public List<String> getCitiesList() {
        List<CityEntity> cities = cityRepository.findAll();
        List<String> cityNames = new ArrayList<>();

        for(CityEntity city : cities) {
            cityNames.add(city.getName());
        }
        return cityNames;
    }

    @Override
    public List<CityWithPriceListDTO> getPriceListByCity(String cityName) {
        List<GasolinePriceEntity> prices = gasolinePriceRepository.findAllByCityEntityName(cityName);
        List<CityWithPriceListDTO> pricesDTO = prices.stream()
                .map(gasolinePriceMapper::toDto)
                .toList();
        return pricesDTO;
    }

    @Override
    public CityWithPriceListDTO getPriceListByCityAndDate(String cityName, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        GasolinePriceEntity price = gasolinePriceRepository.findByCityEntityNameAndDate(cityName, localDate);
        CityWithPriceListDTO priceDTO = gasolinePriceMapper.toDto(price);
        return priceDTO;
    }

    @Override
    public List<CityWithPriceListDTO> getPriceListByCityAndDateRange(String cityName, String dateStart, String dateEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateStart = LocalDate.parse(dateStart, formatter);
        LocalDate localDateEnd = LocalDate.parse(dateEnd, formatter);
        List<GasolinePriceEntity> prices = gasolinePriceRepository.findAllByCityEntityNameAndDateBetween(cityName, localDateStart, localDateEnd);
        List<CityWithPriceListDTO> pricesDTO = prices.stream()
                .map(gasolinePriceMapper::toDto)
                .toList();
        return pricesDTO;
    }
}
