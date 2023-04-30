package com.vpr.gasoline_prices_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityWithPriceListDTO {
    private String city;
    private List<PriceWithDateDTO> pricesWithDateDTO;
}
