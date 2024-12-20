package com.mycompany.rubrica_gruppo12;

import java.util.HashSet;
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
        expResult.aggiungiEmail("tizio@mail.com");
        Email result = instance.getMail();        
        assertEquals(expResult.returnMail("tizio@mail.com"), result.returnMail("tizio@mail.com"));        
    }

    /**
     * Test of getNumeri method, of class Contatto.
     */
    @Test
    public void testGetNumeri() throws Exception{
        System.out.println("getNumeri");
        NumTelefono num = new NumTelefono();
        num.aggiungiNumTelefono("7200000000");
        instance = new Contatto(null,"De Iuliis",null,num);     
        NumTelefono result = instance.getNumeri();
        assertEquals(result.returnNum("7200000000"),num.returnNum("7200000000"));
    }


    /**
     * Test of toString method, of class Contatto.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        instance = new Contatto("Luca",null,null,null);
        String expResult = "Contatto: [nome=Luca, cognome=null, mail=null, numeri=null]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
