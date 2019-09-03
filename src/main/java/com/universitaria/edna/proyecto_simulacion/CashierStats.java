package com.universitaria.edna.proyecto_simulacion;

import java.math.BigDecimal;

public class CashierStats {
    private CashierIndex name;
    private double servedCustomers;
    private double servedTime;

    public CashierStats(CashierIndex name) {
        this.name = name;
    }

    public CashierIndex getName() {
        return name;
    }

    public String getTimeAvg() {
        return String.format("%.2f", servedTime / servedCustomers);
    }

    public void setName(CashierIndex name) {
        this.name = name;
    }

    public String getServedCustomers() {
        return String.format("%.0f", servedCustomers);
    }

    public void setServedCustomers(double servedCustomers) {
        this.servedCustomers = servedCustomers;
    }

    public void addServedCustomers(double servedCustomers) {
        this.servedCustomers += servedCustomers;
    }

    public String getServedTime() {
        return String.format("%.1f", servedTime);
    }

    public void setServedTime(double servedTime) {
        this.servedTime = servedTime;
    }

    public void addServedTime(double servedTime) {
        this.servedTime += servedTime;
    }

    @Override
    public String toString() {
        return "CashierStats{" +
                "name=" + name +
                ", servedCustomers=" + servedCustomers +
                ", servedTime=" + servedTime +
                '}';
    }
}
