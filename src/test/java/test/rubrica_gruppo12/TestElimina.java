/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.rubrica_gruppo12;

import com.mycompany.exception.NomeECognomeMancanteException;
import com.mycompany.rubrica_gruppo12.Contatto;
import com.mycompany.rubrica_gruppo12.Rubrica;

/**
 *
 * @author lucad_es3t3f8
 */
public class TestElimina {
    
    Rubrica rubrica;
    
    public void TestElimina(){
    rubrica = new Rubrica();
     }     
    
    public void eliminadati1() throws NomeECognomeMancanteException {
    System.out.println("Testo aggiungidati1");  
    Contatto c = new Contatto("Luca","De Iuliis",null,null);
    rubrica.aggiungiContatto(c);
    rubrica.rimuoviContatto(c);
    }
}
