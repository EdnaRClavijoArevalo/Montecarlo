package com.universitaria.edna.proyecto_simulacion;

public enum CashierIndex {
    CAJERO1("Cajero 1", 0),
    CAJERO2("Cajero 2", 1);

    private final String value;
    private final int index;

    CashierIndex(String value, int index) {
        this.value = value;
        this.index = index;
    }

    public static CashierIndex getByIndex(int index) {
        switch (index) {
            case 0:
                return CAJERO1;
            case 1:
                return CAJERO2;
            default:
                throw new IllegalArgumentException(index + ", is not present");
        }
    }

    public String getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}
