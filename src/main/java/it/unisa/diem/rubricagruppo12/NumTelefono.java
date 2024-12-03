/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.rubricagruppo12;

import java.util.HashSet;

/**
 *
 * @author LELE
 */
public class NumTelefono {
    
      HashSet <String> numeri; 
              
    //COSTRUTTORE
      public NumTelefono(){
          this.numeri = new HashSet<>();
      }
    
      /**
      * Controlla se l'inserimento è = null, 
      * controlla che non ci sia un duplicato,
      * nel caso che l'inserimento è  un duplicato, mantiene l'inserimento originale.
      */
      
     public void aggiungiNumTelefono(String c) {
        if (c != null){       
            for (String p : numeri){    
                if (p.equals(c)){
                   c = null;
                } else numeri.add(c);    
            }
        }
     }
     
     
    public void modificaNumTelefono(String og,String mod){
     if (og != null){  
         for (String p : numeri){
             if(p.equals(og)){
                 numeri.remove(p);
              }
          }
        } 
     if (mod != null){
     aggiungiNumTelefono(mod);     
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
