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
import com.mycompany.exception.DuplicatiException;
import com.mycompany.exception.NomeECognomeMancanteException;
import com.mycompany.exception.NumeroTelefonoNonValidoException;
import java.util.TreeSet;

/**
 *
 * @author lucad_es3t3f8
 */
public class TestAggiunta {
    
    Rubrica rubrica;
    
    public void TestAggiunta(){
    rubrica = new Rubrica();
      }  
    
    public void aggiungidati1() throws NomeECognomeMancanteException {
    System.out.println("Testo aggiungidati1");  
    Contatto c = new Contatto("Luca","De Iuliis",null,null);
    rubrica.aggiungiContatto(c);
    }
    
    public void aggiungidati2()  throws NomeECognomeMancanteException, NumeroTelefonoNonValidoException,DuplicatiException  {
    System.out.println("Testo aggiungidati2");  
    Email mail = new Email() ;
    mail.aggiungiEmail("ldeiuliis@outlook.com");
    NumTelefono numTelefono = new NumTelefono();
    numTelefono.aggiungiNumTelefono("720000000");
    Contatto c = new Contatto("Luca","De Iuliis",mail,numTelefono);
    rubrica.aggiungiContatto(c);   
    }
    
    
    
}
