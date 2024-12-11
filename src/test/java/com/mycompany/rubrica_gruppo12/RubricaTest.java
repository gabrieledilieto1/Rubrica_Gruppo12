/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubrica_gruppo12;

import java.util.HashSet;
import java.util.TreeSet;
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
public class RubricaTest {
    
    public RubricaTest() {
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
     * Test of getElenco method, of class Rubrica.
     */
    @Test
    public void testGetElenco() {
        System.out.println("getElenco");
        Rubrica instance = new Rubrica();
        TreeSet<Contatto> expResult = null;
        TreeSet<Contatto> result = instance.getElenco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFiltro method, of class Rubrica.
     */
    @Test
    public void testGetFiltro() {
        System.out.println("getFiltro");
        Rubrica instance = new Rubrica();
        HashSet<Contatto> expResult = null;
        HashSet<Contatto> result = instance.getFiltro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        Contatto c = null;
        Rubrica instance = new Rubrica();
        instance.aggiungiContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuoviContatto method, of class Rubrica.
     */
    @Test
    public void testRimuoviContatto() {
        System.out.println("rimuoviContatto");
        Contatto c = null;
        Rubrica instance = new Rubrica();
        instance.rimuoviContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Ricerca method, of class Rubrica.
     */
    @Test
    public void testRicerca() {
        System.out.println("Ricerca");
        String cerca = "";
        Rubrica instance = new Rubrica();
        instance.Ricerca(cerca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esporta method, of class Rubrica.
     */
    @Test
    public void testEsporta() throws Exception {
        System.out.println("esporta");
        String filePath = "";
        Rubrica instance = new Rubrica();
        instance.esporta(filePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importa method, of class Rubrica.
     */
    @Test
    public void testImporta() throws Exception {
        System.out.println("importa");
        String filePath = "";
        Rubrica instance = new Rubrica();
        instance.importa(filePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Rubrica.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Rubrica instance = new Rubrica();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
