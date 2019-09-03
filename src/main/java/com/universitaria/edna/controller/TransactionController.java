package com.universitaria.edna.controller;

import com.universitaria.edna.proyecto_simulacion.CashierStats;
import com.universitaria.edna.proyecto_simulacion.GeneratedTransaction;
import com.universitaria.edna.proyecto_simulacion.Proyecto_simulacion;
import com.universitaria.edna.proyecto_simulacion.SimulationResults;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionController {

    public ModelAndView servePlainPage(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();
        model.put("clientAmount", "0");
        model.put("totalDeposits", "0");
        model.put("totalWithdrawal", "0");
        model.put("totalServicePayment", "0");
        model.put("totalAccountOpening", "0");
        model.put("totalClientsNotServed", "0");
        return new ModelAndView(model, "/views/transactions.vm");
    }

    public ModelAndView serveLoginPage(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();
        Proyecto_simulacion simulation = new Proyecto_simulacion();
        List<GeneratedTransaction> generatedTransactions = simulation.buildClientTransaction();
        SimulationResults ps = simulation.getResults(generatedTransactions);
        model.put("transactions", generatedTransactions);
        model.put("clientAmount", String.format("%.0f", ps.getClientAmount()));
        model.put("cashierStats", ps.getCashierStats().values());
        model.put("totalDeposits", String.format("%.0f", ps.getTotalDeposits()));
        model.put("totalWithdrawal", String.format("%.0f", ps.getTotalWithdrawal()));
        model.put("totalServicePayment", String.format("%.0f", ps.getTotalServicePayment()));
        model.put("totalAccountOpening", String.format("%.0f", ps.getTotalAccountOpening()));
        model.put("totalClientsNotServed", String.format("%.0f", ps.getTotalClientsNotServed()));
        return new ModelAndView(model, "/views/transactions.vm");
    }
}
