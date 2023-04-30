package com.vpr.gasoline_prices_api.controller;

import com.vpr.gasoline_prices_api.model.dto.CityWithPriceListDTO;
import com.vpr.gasoline_prices_api.service.GasolinePriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class GasolinePriceController {

    private final GasolinePriceService gasolinePriceService;

    @GetMapping("/cities")
    public List<String> getCitiesList() {
        System.out.println("getCitiesList ");
        return gasolinePriceService.getCitiesList();

    }
    @GetMapping("/price/{city}")
    public List<CityWithPriceListDTO> getPriceListByCity(@PathVariable String city) {
        System.out.println("getPriceListByCity " + city);
        return gasolinePriceService.getPriceListByCity(city);

    }

    @GetMapping("/price/{city}/date-range/{dateStart}/{dateEnd}")
    public List<CityWithPriceListDTO> getPriceListByCityAndDateRange(
            @PathVariable String city,
            @PathVariable String dateStart,
            @PathVariable String dateEnd
    ) {
        System.out.println("getPriceListByCityAndDateRange " + city + ", " + dateStart+ ", "+dateEnd);
        return gasolinePriceService.getPriceListByCityAndDateRange(city, dateStart, dateEnd);
    }

    @GetMapping("/price/{city}/date/{date}")
    public CityWithPriceListDTO getPriceListByCityAndDate(
            @PathVariable String city,
            @PathVariable String date
    ) {
        System.out.println("getPriceListByCityAndDate " + city + ", " + date);
        return gasolinePriceService.getPriceListByCityAndDate(city, date);
    }

}
