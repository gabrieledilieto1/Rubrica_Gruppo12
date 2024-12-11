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
public class EmailTest {
    
    public EmailTest() {
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
     * Test of aggiungiEmail method, of class Email.
     */
    @Test
    public void testAggiungiEmail() {
        System.out.println("aggiungiEmail");
        String c = "";
        Email instance = new Email();
        instance.aggiungiEmail(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaEmail method, of class Email.
     */
    @Test
    public void testModificaEmail() throws Exception {
        System.out.println("modificaEmail");
        String og = "";
        String mod = "";
        Email instance = new Email();
        instance.modificaEmail(og, mod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Email.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Email instance = new Email();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
