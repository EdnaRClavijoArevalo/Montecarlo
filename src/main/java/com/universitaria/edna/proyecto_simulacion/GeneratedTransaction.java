package com.universitaria.edna.proyecto_simulacion;

import java.util.List;

public class GeneratedTransaction {
    private String timeSpan;
    private int clientAmount;
    private List<ClientTransaction> clientTransactions;

    public String getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(String timeSpan) {
        this.timeSpan = timeSpan;
    }

    public int getClientAmount() {
        return clientAmount;
    }

    public void setClientAmount(int clientAmount) {
        this.clientAmount = clientAmount;
    }

    public List<ClientTransaction> getClientTransactions() {
        return clientTransactions;
    }

    public void setClientTransactions(List<ClientTransaction> clientTransactions) {
        this.clientTransactions = clientTransactions;
    }

    @Override
    public String toString() {
        return "El lapso de tiempo a evaluar:       " + timeSpan + "\n" +
                "la cantidad de personas son:       " + clientAmount + "\n" +
                clientTransactions+ "\n";
    }
}
