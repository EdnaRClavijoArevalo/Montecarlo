package com.universitaria.edna.proyecto_simulacion;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Proyecto_simulacion {

    private String[] dayHourPrefix = {"8:", "9:", "10:", "11:", "12:", "13:", "14:", "15:", "16:", "17:"};
    private int[] clientId = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int TotalDeposits = 0;
    private int TotalWithdrawal = 0;
    private int TotalServicePayment = 0;
    private int TotalAccountOpening = 0;
    private int ClientAmount = 0;
    private int NotServed = 0;
    private int TotalClientsNotServed = 0;

    public List<GeneratedTransaction> buildClientTransaction() {
        List<GeneratedTransaction> generatedTransactions = new ArrayList<>();
        for (int minute = 0; minute < 60; minute++) {
            GeneratedTransaction generatedTransaction = new GeneratedTransaction();
            //definimos la informacion respecto a la cantidad de personas segun el metodo montecarlonumcliente
            int randomPasses = 1;
            MontecarloClientAmountGenerator clientNumberGenerator = new MontecarloClientAmountGenerator(randomPasses); //instancia el metodo desde la clase random_montecarlo
            int clientAmount = clientNumberGenerator.clientRoundUp();
            ClientAmount = ClientAmount + (clientAmount + 1);
            TotalClientsNotServed = ClientAmount - NotServed;
            int dato = minute / 6;
            int mod = minute % 6;
            if (mod == 0) {
                String Message = dayHourPrefix[dato] +
                        mod * 10 + "0 - " +
                        dayHourPrefix[dato] +
                        "0" +
                        ((mod * 10) + 9) +
                        "\n";
                generatedTransaction.setTimeSpan(Message);
            } else {
                String Message = dayHourPrefix[dato] +
                        mod * 10 +
                        " - " +
                        dayHourPrefix[dato] +
                        ((mod * 10) + 9) +
                        "\n";
                generatedTransaction.setTimeSpan(Message);
            }
            generatedTransaction.setClientAmount(clientId[clientAmount]);
            int clientsByTransaction = clientId[clientAmount];
            List<ClientTransaction> clientTransactions = new ArrayList<>();
            for (int transactionClientIdx = 0; transactionClientIdx < clientsByTransaction; transactionClientIdx++) {
                ClientTransaction clientTransaction = new ClientTransaction();
                clientTransaction.setClientId(transactionClientIdx);
                clientTransaction.setTransactionType(transactionData());
                clientTransaction.setTransactionTimeSpan(transactionTimeSpan());
                clientTransactions.add(clientTransaction);
                NotServed = TotalDeposits + TotalWithdrawal + TotalServicePayment + TotalAccountOpening;
            }
            generatedTransaction.setClientTransactions(clientTransactions);
            generatedTransactions.add(generatedTransaction);
        }
        return generatedTransactions;
    }

    private TransactionType transactionData() {
        int randomPasses = 1;
        MontecarloTransactionTypeGenerator transactionGenerator = new MontecarloTransactionTypeGenerator(randomPasses); //instancia el metodo desde la clase random_montecarlo
        TransactionType transactionType = transactionGenerator.getTransactionType();
        switch (transactionType) {
            case CONSIGNACION:
                TotalDeposits++;
                break;
            case RETIRO:
                TotalWithdrawal++;
                break;
            case PAGO_SERVICIOS:
                TotalServicePayment++;
                break;
            case APERTURA_CUENTA:
                TotalAccountOpening++;
                break;
            default:
                throw new NotImplementedException();
        }
        return transactionType;
    }

    private double transactionTimeSpan() {
        int randomPasses = 1;
        MontecarloTransactionTimeGenerator generatedTimeSpan = new MontecarloTransactionTimeGenerator(randomPasses); //instancia el metodo desde la clase random_montecarlo
        return generatedTimeSpan.getTransactionTime();
    }

    public int getTotalDeposits() {
        return TotalDeposits;
    }

    public int getTotalWithdrawal() {
        return TotalWithdrawal;
    }

    public int getTotalServicePayment() {
        return TotalServicePayment;
    }

    public int getTotalAccountOpening() {
        return TotalAccountOpening;
    }

    public int getTotalClientsNotServed() {
        return TotalClientsNotServed;
    }

    public int getClientAmount() {
        return ClientAmount;
    }
}
