/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubrica_gruppo12;

import java.util.TreeSet;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


/**
 *
 * @author LELE
 */
public class Rubrica {
      TreeSet <Contatto> elenco = new TreeSet<>(compareTo);
    
     public void aggiungi(Contatto c) {
     elenco.add(c); 
    }   
     
       @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println("l'elenco è formato da: \n");
        for (Contatto c : elenco){
            sb.append(c);
            sb.append("\n *** \n");
        }
            return sb.toString();
    } 
    
    
    
}
