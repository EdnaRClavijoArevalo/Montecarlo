package com.universitaria.edna.proyecto_simulacion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Proyecto_simulacion {

    private String[] dayHourPrefix = {"8:", "9:", "10:", "11:", "12:", "13:", "14:", "15:", "16:", "17:"};
    private int[] clientId = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private double timeSpan = 10;
    private double timeRange = 9;
    private CashierIndex lastActiveCashier = null;

    private Cashier getNextCashier(Map<CashierIndex, Cashier> cashiers, double usedTime) {
        Cashier cashier1 = cashiers.get(CashierIndex.CAJERO1);
        if (CashierIndex.CAJERO1 != lastActiveCashier && cashier1.hasTimeToProcess(usedTime)) {
            lastActiveCashier = CashierIndex.CAJERO1;
            cashier1.processTransaction(usedTime);
            return cashier1;
        }
        Cashier cashier2 = cashiers.get(CashierIndex.CAJERO2);
        if (CashierIndex.CAJERO2 != lastActiveCashier && cashier2.hasTimeToProcess(usedTime)) {
            lastActiveCashier = CashierIndex.CAJERO2;
            cashier2.processTransaction(usedTime);
            return cashier2;
        }
        if (!cashier1.hasTimeToProcess(usedTime) && cashier2.hasTimeToProcess(usedTime)) {
            lastActiveCashier = CashierIndex.CAJERO2;
            cashier2.processTransaction(usedTime);
            return cashier2;
        } else if (!cashier2.hasTimeToProcess(usedTime) && cashier1.hasTimeToProcess(usedTime)) {
            lastActiveCashier = CashierIndex.CAJERO1;
            cashier1.processTransaction(usedTime);
            return cashier1;
        }
        System.out.println("There are no cashiers available");
        lastActiveCashier = null;
        return null;
    }

    private Map<CashierIndex, Cashier> buildCashiers() {
        Map<CashierIndex, Cashier> cashiers = new HashMap<>();
        for (CashierIndex value : CashierIndex.values()) {
            Cashier cashier = new Cashier();
            cashier.setBusy(false);
            cashier.setNum(value);
            cashier.setTimeAvailable(timeSpan);
            cashiers.put(value, cashier);
        }
        return cashiers;
    }

    public List<GeneratedTransaction> buildClientTransaction() {
        List<GeneratedTransaction> generatedTransactions = new ArrayList<>();
        Map<CashierIndex, Cashier> cashiers = buildCashiers();
        for (int minute = 0; minute < 60; minute++) {
            GeneratedTransaction generatedTransaction = new GeneratedTransaction();
            lastActiveCashier = null;
            for (CashierIndex value : CashierIndex.values()) {
                cashiers.get(value).setUsedTime(0);
            }
            //definimos la informacion respecto a la cantidad de personas segun el metodo montecarlonumcliente
            int randomPasses = 1;
            MontecarloClientAmountGenerator clientNumberGenerator = new MontecarloClientAmountGenerator(randomPasses); //instancia el metodo desde la clase random_montecarlo
            int clientAmount = clientNumberGenerator.clientRoundUp();
            int hourIndex = minute / 6;
            int minutesOffset = minute % 6;
            if (minutesOffset == 0) {
                String Message = dayHourPrefix[hourIndex] +
                        minutesOffset * timeSpan + "0 - " +
                        dayHourPrefix[hourIndex] +
                        "0" +
                        ((minutesOffset * timeSpan) + timeRange) +
                        "\n";
                generatedTransaction.setTimeSpan(Message);
            } else {
                String Message = dayHourPrefix[hourIndex] +
                        minutesOffset * timeSpan +
                        " - " +
                        dayHourPrefix[hourIndex] +
                        ((minutesOffset * timeSpan) + timeRange) +
                        "\n";
                generatedTransaction.setTimeSpan(Message);
            }
            generatedTransaction.setClientAmount(clientId[clientAmount]);
            int clientsByTransaction = clientId[clientAmount];
            List<ClientTransaction> clientTransactions = new ArrayList<>();

            for (int transactionClientIdx = 0; transactionClientIdx < clientsByTransaction; transactionClientIdx++) {
                double requiredTime = transactionTimeSpan();
                Cashier nextCashier = getNextCashier(cashiers, requiredTime);
                ClientTransaction clientTransaction = new ClientTransaction();
                if (nextCashier != null) {
                    clientTransaction.setServedBy(nextCashier.getNum());
                    clientTransaction.setTransactionType(transactionData());
                    clientTransaction.setTransactionTimeSpan(requiredTime);
                } else {
                    clientTransaction.setTransactionType(TransactionType.NO_ATENDIDA);
                }
                clientTransaction.setClientId(transactionClientIdx);
                clientTransactions.add(clientTransaction);
            }
            generatedTransaction.setClientTransactions(clientTransactions);
            generatedTransactions.add(generatedTransaction);
        }
        return generatedTransactions;
    }

    public SimulationResults getResults(List<GeneratedTransaction> generatedTransactions) {
        SimulationResults simulationResults = new SimulationResults();
        for (GeneratedTransaction generatedTransaction : generatedTransactions) {
            simulationResults.addClientAmount(generatedTransaction.getClientAmount());
            for (ClientTransaction clientTransaction : generatedTransaction.getClientTransactions()) {
                if (clientTransaction.getServedBy() != null) {
                    simulationResults
                            .getCashierStats()
                            .get(clientTransaction.getServedBy())
                            .addServedCustomers(1);
                    simulationResults
                            .getCashierStats()
                            .get(clientTransaction.getServedBy())
                            .addServedTime(clientTransaction.getTransactionTimeSpan());

                    generatedTransaction
                            .getCashierStats()
                            .get(clientTransaction.getServedBy())
                            .addServedCustomers(1);
                    generatedTransaction
                            .getCashierStats()
                            .get(clientTransaction.getServedBy())
                            .addServedTime(clientTransaction.getTransactionTimeSpan());
                }
                switch (clientTransaction.getTransactionType()) {
                    case APERTURA_CUENTA:
                        simulationResults.addTotalAccountOpening();
                        break;
                    case CONSIGNACION:
                        simulationResults.addTotalDeposits();
                        break;
                    case PAGO_SERVICIOS:
                        simulationResults.addTotalServicePayment();
                        break;
                    case RETIRO:
                        simulationResults.addTotalWithdrawal();
                        break;
                    case NO_ATENDIDA:
                        simulationResults.addTotalClientsNotServed();
                        break;
                }
            }
        }
        return simulationResults;
    }

    private TransactionType transactionData() {
        int randomPasses = 1;
        MontecarloTransactionTypeGenerator transactionGenerator = new MontecarloTransactionTypeGenerator(randomPasses); //instancia el metodo desde la clase random_montecarlo
        return transactionGenerator.getTransactionType();
    }

    private double transactionTimeSpan() {
        int randomPasses = 1;
        MontecarloTransactionTimeGenerator generatedTimeSpan = new MontecarloTransactionTimeGenerator(randomPasses); //instancia el metodo desde la clase random_montecarlo
        return generatedTimeSpan.getTransactionTime();
    }
}
