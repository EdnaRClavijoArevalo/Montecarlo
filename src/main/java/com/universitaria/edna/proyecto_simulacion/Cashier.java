package com.universitaria.edna.proyecto_simulacion;

public class Cashier {
    private boolean busy;
    private double timeAvailable;
    private double usedTime;
    private CashierIndex num;

    public boolean hasTimeToProcess(double requiredTime) {
        return usedTime + requiredTime < timeAvailable;
    }

    public void processTransaction(double processingTime) {
        usedTime += processingTime;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public double getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(double timeAvailable) {
        this.timeAvailable = timeAvailable;
    }

    public CashierIndex getNum() {
        return num;
    }

    public void setNum(CashierIndex num) {
        this.num = num;
    }

    public double getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(double usedTime) {
        this.usedTime = usedTime;
    }
}
