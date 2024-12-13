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
public class ContattoTest {
    
    Contatto instance;
    
    public ContattoTest() {
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
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() throws Exception {
        System.out.println("setNome");
        String nome = "Luca";
        instance = new Contatto(null,"De Iuliis",null,null);
        instance.setNome(nome);
        assertEquals(nome, instance.getNome());
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() throws Exception {
        System.out.println("setCognome");
        String cognome = "De Iuliis";
        instance = new Contatto("Luca",null,null,null);
        instance.setCognome(cognome);
        assertEquals(cognome, instance.getCognome());
    }

    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() throws Exception {
        System.out.println("getNome");
        instance = new Contatto("Luca",null,null,null);
        String expResult = "Luca";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() throws Exception {
        System.out.println("getCognome");
        instance = new Contatto(null,"De Iuliis",null,null);
        String expResult = "De Iuliis";
        String result = instance.getCognome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMail method, of class Contatto.
     */
    @Test
    public void testGetMail() throws Exception {
        System.out.println("getMail");
        Email mail = new Email();
        mail.aggiungiEmail("tizio@mail.com");
        instance = new Contatto(null,"De Iuliis",mail,null);
        Email expResult = new Email ();
        mail.aggiungiEmail("tizio@mail.com");
        Email result = instance.getMail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumeri method, of class Contatto.
     */
    @Test
    public void testGetNumeri() throws Exception{
        System.out.println("getNumeri");
        NumTelefono num = new NumTelefono();
        num.aggiungiNumTelefono("720000000");
        instance = new Contatto(null,"De Iuliis",null,num);
        NumTelefono expResult = new NumTelefono();
        expResult.aggiungiNumTelefono("720000000");
        NumTelefono result = instance.getNumeri();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo() throws Exception{
        System.out.println("compareTo");
        Contatto o = new Contatto(null,"Verdi",null,null);
        instance = new Contatto(null,"De Iuliis",null,null);
        int expResult = 1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Contatto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Contatto instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
