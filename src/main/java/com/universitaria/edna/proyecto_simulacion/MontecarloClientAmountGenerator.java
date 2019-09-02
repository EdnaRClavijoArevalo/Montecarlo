package com.universitaria.edna.proyecto_simulacion;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;


public class MontecarloClientAmountGenerator {
    private double generatedValue = 0;

    public MontecarloClientAmountGenerator(int valuesToGenerate) {
        Random randomGenerator = new Random();
        double seed = randomGenerator.nextDouble();
        for (int index = 0; index < valuesToGenerate; index++) {
            double beta = 100;
            // X = β ((-ln [1-U])^1/α)
            double alpha = 1;
            generatedValue = beta * Math.pow((-Math.log(1 - seed)), (1 / alpha));
            for (int i = 0; generatedValue > 1; i++) {
                generatedValue = (generatedValue / 10);
            }
            seed = generatedValue;
        }
    }

    public int clientRoundUp() {
        if (generatedValue <= 0.10 && generatedValue > 0) {
            return 0;
        } else if (generatedValue <= 0.20 && generatedValue > 0.10) {
            return 1;
        } else if (generatedValue <= 0.30 && generatedValue > 0.20) {
            return 2;
        } else if (generatedValue <= 0.40 && generatedValue > 0.30) {
            return 3;
        } else if (generatedValue <= 0.50 && generatedValue > 0.40) {
            return 4;
        } else if (generatedValue <= 0.60 && generatedValue > 0.50) {
            return 5;
        } else if (generatedValue <= 0.70 && generatedValue > 0.60) {
            return 6;
        } else if (generatedValue <= 0.80 && generatedValue > 0.70) {
            return 7;
        } else if (generatedValue <= 0.90 && generatedValue > 0.80) {
            return 8;
        } else if (generatedValue <= 1 && generatedValue > 0.90) {
            return 9;
        }
        throw new NotImplementedException();
    }

    public double getGeneratedValue() {
        return generatedValue;
    }

    public void setGeneratedValue(double generatedValue) {
        this.generatedValue = generatedValue;
    }
}
