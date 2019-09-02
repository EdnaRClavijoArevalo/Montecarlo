package com.universitaria.edna.proyecto_simulacion;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;


public class MontecarloTransactionTimeGenerator {
    private double generatedValue = 0;
    private final double[] timeSpan = {1.5, 2.2, 4.5, 5.0};

    public MontecarloTransactionTimeGenerator(int valuesToGenerate) {
        Random random1 = new Random();
        double seed = random1.nextDouble();
        for (int index = 0; index < valuesToGenerate; index++) {
            // X = β ((-ln [1-U])^1/α)
            double alpha = 1;
            double beta = 100;
            generatedValue = beta * Math.pow((-Math.log(1 - seed)), (1 / alpha));
            for (int i = 0; generatedValue > 1; i++) {
                generatedValue = (generatedValue / 10);
            }
            seed = generatedValue;
        }
    }

    public double getTransactionTime() {
        if (generatedValue < 0.25 && generatedValue >= 0) {
            return timeSpan[0];
        } else if (generatedValue < 0.50 && generatedValue >= 0.25) {
            return timeSpan[1];
        } else if (generatedValue < 0.75 && generatedValue >= 0.50) {
            return timeSpan[2];
        } else if (generatedValue < 1 && generatedValue >= 0.75) {
            return timeSpan[3];
        } else {
            throw new NotImplementedException();
        }
    }

    public double getGeneratedValue() {
        return generatedValue;
    }
}
