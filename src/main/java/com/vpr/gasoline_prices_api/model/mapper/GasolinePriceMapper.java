package com.vpr.gasoline_prices_api.model.mapper;

import com.vpr.gasoline_prices_api.model.dto.CityWithPriceListDTO;
import com.vpr.gasoline_prices_api.model.dto.PriceWithDateDTO;
import com.vpr.gasoline_prices_api.model.entity.GasolinePriceEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GasolinePriceMapper {

    private final ModelMapper modelMapper;


    public CityWithPriceListDTO toDto(GasolinePriceEntity gasolinePriceEntity) {
        CityWithPriceListDTO cityWithPriceListDTO = new CityWithPriceListDTO();
        cityWithPriceListDTO.setCity(gasolinePriceEntity.getCityEntity().getName());

        PriceWithDateDTO priceWithDateDTO = modelMapper.map(gasolinePriceEntity, PriceWithDateDTO.class);
        cityWithPriceListDTO.setPricesWithDateDTO(List.of(priceWithDateDTO));

        return cityWithPriceListDTO;
    }
}