package com.universitaria.edna.proyecto_simulacion;

public class ClientTransaction {
    private int clientId;
    private TransactionType transactionType;
    private double transactionTimeSpan;
    private String cajeroNum;

    public String getCajeroNum(){ return  cajeroNum;}
    public void setCajeroNum(String cajeroNum) {
        this.cajeroNum = cajeroNum;
    }
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionTimeSpan() {
        return transactionTimeSpan;
    }

    public void setTransactionTimeSpan(double transactionTimeSpan) {
        this.transactionTimeSpan = transactionTimeSpan;
    }

    @Override
    public String toString() {
        return String.format("%-10s, %-15s, %-15s", "Cliente #", "Transacción", "Duración Minutos") + "\n" +
                String.format("%10s, %15s, %15s", clientId, transactionType.getValue(), transactionTimeSpan) + "\n";

    }
}
