package com.universitaria.edna.proyecto_simulacion;

import java.util.HashMap;
import java.util.Map;

public class SimulationResults {
    private Map<CashierIndex, CashierStats> cashierStats;
    private double clientAmount;
    private double totalDeposits;
    private double totalWithdrawal;
    private double totalServicePayment;
    private double totalAccountOpening;
    private double totalClientsNotServed;

    public SimulationResults() {
        this.cashierStats = new HashMap<>();
        for (CashierIndex value : CashierIndex.values()) {
            this.cashierStats.put(value, new CashierStats(value));
        }
    }

    public double getClientAmount() {
        return clientAmount;
    }

    public void setClientAmount(double clientAmount) {
        this.clientAmount = clientAmount;
    }

    public void addClientAmount() {
        this.clientAmount++;
    }

    public void addClientAmount(double clientAmount) {
        this.clientAmount += clientAmount;
    }

    public double getTotalDeposits() {
        return totalDeposits;
    }

    public void setTotalDeposits(double totalDeposits) {
        this.totalDeposits = totalDeposits;
    }

    public void addTotalDeposits() {
        this.totalDeposits++;
    }

    public double getTotalWithdrawal() {
        return totalWithdrawal;
    }

    public void setTotalWithdrawal(double totalWithdrawal) {
        this.totalWithdrawal = totalWithdrawal;
    }

    public void addTotalWithdrawal() {
        this.totalWithdrawal++;
    }

    public double getTotalServicePayment() {
        return totalServicePayment;
    }

    public void setTotalServicePayment(double totalServicePayment) {
        this.totalServicePayment = totalServicePayment;
    }

    public void addTotalServicePayment() {
        this.totalServicePayment++;
    }

    public double getTotalAccountOpening() {
        return totalAccountOpening;
    }

    public void setTotalAccountOpening(double totalAccountOpening) {
        this.totalAccountOpening = totalAccountOpening;
    }

    public void addTotalAccountOpening() {
        this.totalAccountOpening++;
    }

    public double getTotalClientsNotServed() {
        return totalClientsNotServed;
    }

    public void setTotalClientsNotServed(double totalClientsNotServed) {
        this.totalClientsNotServed = totalClientsNotServed;
    }

    public void addTotalClientsNotServed() {
        this.totalClientsNotServed++;
    }

    public Map<CashierIndex, CashierStats> getCashierStats() {
        return cashierStats;
    }

    public void setCashierStats(Map<CashierIndex, CashierStats> cashierStats) {
        this.cashierStats = cashierStats;
    }

    @Override
    public String toString() {
        return "SimulationResults{" +
                "clientAmount=" + clientAmount +
                ", totalDeposits=" + totalDeposits +
                ", totalWithdrawal=" + totalWithdrawal +
                ", totalServicePayment=" + totalServicePayment +
                ", totalAccountOpening=" + totalAccountOpening +
                ", totalClientsNotServed=" + totalClientsNotServed +
                '}';
    }
}
