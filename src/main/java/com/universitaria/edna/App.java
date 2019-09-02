package com.universitaria.edna;

import com.universitaria.edna.controller.TransactionController;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        TransactionController transactionController = new TransactionController();
        get("/", transactionController::serveLoginPage, new VelocityTemplateEngine());
    }
}
