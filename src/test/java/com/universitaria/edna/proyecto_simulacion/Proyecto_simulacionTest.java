package com.universitaria.edna.proyecto_simulacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Proyecto_simulacionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void buildClientTransaction() {
        Proyecto_simulacion ps = new Proyecto_simulacion();
        List<GeneratedTransaction> generatedTransactions = ps.buildClientTransaction();
        assertEquals(60, generatedTransactions.size());

    }
}