package com.universitaria.edna.proyecto_simulacion;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneratedTransaction {
    private String timeSpan;
    private int clientAmount;
    private Map<CashierIndex, CashierStats> cashierStats;
    private List<ClientTransaction> clientTransactions;

    public GeneratedTransaction() {
        this.cashierStats = new HashMap<>();
        for (CashierIndex value : CashierIndex.values()) {
            this.cashierStats.put(value, new CashierStats(value));
        }
    }

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

    public Map<CashierIndex, CashierStats> getCashierStats() {
        return cashierStats;
    }

    public Collection<CashierStats> getCashiers() {
        return cashierStats.values();
    }

    public void setCashierStats(Map<CashierIndex, CashierStats> cashierStats) {
        this.cashierStats = cashierStats;
    }

    @Override
    public String toString() {
        return "El lapso de tiempo a evaluar:       " + timeSpan + "\n" +
                "la cantidad de personas son:       " + clientAmount + "\n" +
                "atención de cajeros:       " + cashierStats + "\n" +
                clientTransactions + "\n";
    }
}
