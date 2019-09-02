package com.universitaria.edna.controller;

import com.universitaria.edna.proyecto_simulacion.GeneratedTransaction;
import com.universitaria.edna.proyecto_simulacion.Proyecto_simulacion;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionController {
    public ModelAndView serveLoginPage(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();
        Proyecto_simulacion ps = new Proyecto_simulacion();
        List<GeneratedTransaction> generatedTransactions = ps.buildClientTransaction();
        model.put("transactions", generatedTransactions);
        model.put("clientAmount", ps.getClientAmount());
        model.put("totalDeposits", ps.getTotalDeposits());
        model.put("totalWithdrawal", ps.getTotalWithdrawal());
        model.put("totalServicePayment", ps.getTotalServicePayment());
        model.put("totalAccountOpening", ps.getTotalAccountOpening());
        model.put("totalClientsNotServed", ps.getTotalClientsNotServed());
        return new ModelAndView(model, "/views/transactions.vm");
    }
}