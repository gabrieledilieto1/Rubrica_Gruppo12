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
import java.util.HashSet;

/**
 *
 * @author LELE
 */
public class EmailTest {
    
    Email instance;
    
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
    Email instance = new Email(); 
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of returnMail method, of class Email.
     */
    @Test
    public void testReturnMail() {
        System.out.println("returnMail");
        String c = "Tizio@mail.com";
        instance.aggiungiEmail(c);
        String exp = instance.returnMail(c);
        assertEquals(c, exp);
    }
    
    
    
    
    /**
     * Test of aggiungiEmail method, of class Email.
     */
    @Test
    public void testAggiungiEmail() {
        System.out.println("aggiungiEmail");
        String c = "Tizio@mail.com";
        instance.aggiungiEmail(c);
        assertEquals(c, instance.returnMail(c));
    }

    /**
     * Test of modificaEmail method, of class Email.
     */
    @Test
    public void testModificaEmail() throws Exception {
        System.out.println("modificaEmail");
        String og = "Tizio2@mail.com";
        instance.aggiungiEmail(og);
        String mod = "Tizio@mail.com";
        instance.modificaEmail(og, mod);
        if (instance.returnMail(og) != null){
            fail("errore modifica Mail");
        }    
        assertEquals(mod, instance.returnMail(mod));
    }

    /**
     * Test of toString method, of class Email.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
