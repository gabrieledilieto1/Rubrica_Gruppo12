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
public class NumTelefono {
      HashSet <String> numeri = new HashSet<String>();
    
    /*Se non inseriamo null controlla che non ci siano duplicati, se non ne trova aggiunge, altrimenti aggiunge null*/
     public void aggiungi(String c) {
     if (c != null){       
     for (String p : numeri){    
         if (p.equals(c)){
             p = null;
        }     
        }
     numeri.add(c); 
     }
    
    }
     
    public void modifica(String og,String mod){
     if (og != null){  
         for (String p : numeri){
             if(p.equals(og)){
                 numeri.remove(p);
              }
          }
        } 
     if (mod != null){
     aggiungi (mod);     
      }     
     } 
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println("i numeri di telefono sono: \n");
        for (String p : numeri){
            sb.append(p);
            sb.append("\n *** \n");
        }
            return sb.toString();
    }
     
     
}
