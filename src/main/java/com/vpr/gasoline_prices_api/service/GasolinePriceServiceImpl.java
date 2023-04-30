package com.vpr.gasoline_prices_api.service;

import com.vpr.gasoline_prices_api.model.dto.CityWithPriceListDTO;
import com.vpr.gasoline_prices_api.model.entity.CityEntity;
import com.vpr.gasoline_prices_api.model.entity.GasolinePriceEntity;
import com.vpr.gasoline_prices_api.model.mapper.GasolinePriceMapper;
import com.vpr.gasoline_prices_api.repository.CityRepository;
import com.vpr.gasoline_prices_api.repository.GasolinePriceRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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

    @PostConstruct
    public void insertData() {
        // Insert cities
        List<CityEntity> cities = Arrays.asList(
                new CityEntity("Москва"),
                new CityEntity("Санкт-Петербург"),
                new CityEntity("Екатеринбург"),
                new CityEntity("Волгоград"),
                new CityEntity("Пермь"),
                new CityEntity("Новосибирск"),
                new CityEntity("Иркутск"),
                new CityEntity("Краснодар")
        );
        cityRepository.saveAll(cities);

        // Generate all possible combinations of gasoline_price objects
        List<GasolinePriceEntity> gasolinePrices = new ArrayList<>();
        List<String> gasolineTypes = Arrays.asList("92", "95", "98", "diesel");
        LocalDate startDate = LocalDate.of(2022, 9, 1);
        LocalDate endDate = LocalDate.of(2023, 4, 30);
        for (CityEntity city : cities) {
            for (String gasolineType : gasolineTypes) {
                for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
                    Double price = (Math.floor(Math.random() * (70 - 50 + 1) + 50));
                    GasolinePriceEntity gasolinePrice = new GasolinePriceEntity(gasolineType, city, price, "rub", date);
                    gasolinePrices.add(gasolinePrice);
                }
            }
        }
        gasolinePriceRepository.saveAll(gasolinePrices);
    }
}
