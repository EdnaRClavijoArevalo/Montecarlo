package com.universitaria.edna.proyecto_simulacion;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;


public class MontecarloTransactionTypeGenerator {

    private double generatedValue = 0;

    public MontecarloTransactionTypeGenerator(int randomPasses) {
        Random randomGenerator = new Random();
        double seed = randomGenerator.nextDouble();
        for (int index = 0; index < randomPasses; index++) {
            double beta = 100;
            // X = β ((-ln [1-U])^1/α)
            double alfa = 1;
            generatedValue = beta * Math.pow((-Math.log(1 - seed)), (1 / alfa));
            for (int indexEx = 0; generatedValue > 1; indexEx++) {
                generatedValue = (generatedValue / 10);
            }
            seed = generatedValue;
        }
    }

    public TransactionType getTransactionType() {
        if (generatedValue <= 0.25 && generatedValue > 0) {
            return TransactionType.CONSIGNACION;
        } else if (generatedValue <= 0.50 && generatedValue > 0.25) {
            return TransactionType.RETIRO;
        } else if (generatedValue <= 0.75 && generatedValue > 0.50) {
            return TransactionType.PAGO_SERVICIOS;
        } else if (generatedValue <= 1 && generatedValue > 0.75) {
            return TransactionType.APERTURA_CUENTA;
        }
        throw new NotImplementedException();
    }

}
