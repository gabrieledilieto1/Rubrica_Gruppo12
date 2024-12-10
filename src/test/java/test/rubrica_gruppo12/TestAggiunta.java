/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.rubrica_gruppo12;

import com.mycompany.rubrica_gruppo12.Contatto;
import com.mycompany.rubrica_gruppo12.Email;
import com.mycompany.rubrica_gruppo12.NumTelefono;
import com.mycompany.rubrica_gruppo12.Rubrica;
import java.util.TreeSet;

/**
 *
 * @author lucad_es3t3f8
 */
public class TestAggiunta {
    
    private Rubrica rubrica;
    
    public void TestAggiunta(){
      }  
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        rubrica = new Rubrica();
    }
    
    @AfterEach
    public void tearDown() {   
   }
    
    @test
    public void aggiungidati1(){
    System.out.println("Testo aggiungidati1");  
    rubrica.add(new Contatto("Luca","De Iuliis",null,null));   
    }
    
    @test
    public void aggiungidati2(){
    System.out.println("Testo aggiungidati2");  
    Email mail = new Email() ;
    mail.aggiungiEmail("ldeiuliis@outlook.com");
    NumTelefono numTelefono = new NumTelefono();
    numTelefono.aggiungiNumTelefono("720000000");
    rubrica.add(new Contatto("Luca","De Iuliis",mail,numTelefono));   
    }
    
    
    
}
