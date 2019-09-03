package com.universitaria.edna.proyecto_simulacion;

public enum TransactionType {
    CONSIGNACION("Consignacion"),
    RETIRO("Retiro"),
    PAGO_SERVICIOS("Pago Servicios"),
    NO_ATENDIDA("No atendida"),
    APERTURA_CUENTA("Apertura de Cuenta");

    private final String value;

    TransactionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
