/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubrica_gruppo12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LELE
 */
public class NumTelefonoTest {
    
    public NumTelefonoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of aggiungiNumTelefono method, of class NumTelefono.
     */
    @Test
    public void testAggiungiNumTelefono() throws Exception {
        System.out.println("aggiungiNumTelefono");
        String c = "";
        NumTelefono instance = new NumTelefono();
        instance.aggiungiNumTelefono(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaNumTelefono method, of class NumTelefono.
     */
    @Test
    public void testModificaNumTelefono() throws Exception {
        System.out.println("modificaNumTelefono");
        String og = "";
        String mod = "";
        NumTelefono instance = new NumTelefono();
        instance.modificaNumTelefono(og, mod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class NumTelefono.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NumTelefono instance = new NumTelefono();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
