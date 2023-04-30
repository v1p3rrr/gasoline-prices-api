package com.vpr.gasoline_prices_api.controller;

import com.vpr.gasoline_prices_api.model.dto.CityWithPriceListDTO;
import com.vpr.gasoline_prices_api.service.GasolinePriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class GasolinePriceController {

    private GasolinePriceService gasolinePriceService;

    @GetMapping("/{city}")
    public List<CityWithPriceListDTO> getPriceListByCity(@PathVariable String city) {
        return gasolinePriceService.getPriceListByCity(city);
    }

    @GetMapping("/{city}/date-range/{dateStart}/{dateEnd}")
    public List<CityWithPriceListDTO> getPriceListByCityAndDateRange(
            @PathVariable String city,
            @PathVariable String dateStart,
            @PathVariable String dateEnd
    ) {
        return gasolinePriceService.getPriceListByCityAndDateRange(city, dateStart, dateEnd);
    }

    @GetMapping("/{city}/date/{date}")
    public CityWithPriceListDTO getPriceListByCityAndDate(
            @PathVariable String city,
            @PathVariable String date
    ) {
        return gasolinePriceService.getPriceListByCityAndDate(city, date);
    }

}
