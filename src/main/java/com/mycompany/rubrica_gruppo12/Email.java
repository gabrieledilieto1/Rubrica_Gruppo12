/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubrica_gruppo12;

import java.util.HashSet;

/**
 *
 * @author LELE
 */
public class Email {
     HashSet <String> mail = new HashSet<String>();
    
    /*Se non inseriamo null controlla che non ci siano duplicati, se non ne trova aggiunge, altrimenti aggiunge null*/
     public void aggiungi(String c) {
     if (c != null){    
     for (String p : mail){    
         if (p.equals(c)){
             p = null;
        }     
        }
     }
     mail.add(c); 
    
    }
      
    /* Inserire "modifica", prende in entrata la posizione da modificare e una stringa. Rende la posizione null e poi fa aggiungi con la stringa*/ 
     
        @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println("le mail sono: \n");
        for (String p : mail){
            sb.append(p);
            sb.append("\n *** \n");
        }
            return sb.toString();
    } 
}
