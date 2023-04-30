package com.vpr.gasoline_prices_api.model.dto;

import java.time.LocalDate;

public class PriceWithDateDTO {
    private String gasolineType;
    private Long price;
    private String currency;
    private LocalDate date;
}
