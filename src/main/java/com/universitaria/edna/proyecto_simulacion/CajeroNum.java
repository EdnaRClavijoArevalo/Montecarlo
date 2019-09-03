package com.universitaria.edna.proyecto_simulacion;

public enum CajeroNum {
    CAJERO1("Cajero 1"),
    CAJERO2("Cajero 2");

    private final String value;

    CajeroNum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
