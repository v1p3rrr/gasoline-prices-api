package com.vpr.gasoline_prices_api.model.enums;

public enum GasolineType {
    NINETY_TWO("92"),
    NINETY_FIVE("95"),
    NINETY_EIGHT("98"),
    DIESEL("diesel");

    private final String value;

    GasolineType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}