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

public class Email {
     HashSet <String> mail;
     
     //COSTRUTTORE
     public Email(){
         this.mail = new HashSet<>();
     }
    
    /*Se non inseriamo null controlla che non ci siano duplicati, se non ne trova aggiunge, altrimenti aggiunge null*/
     public void aggiungiEmail(String c) {
     if (c != null){    
     for (String p : mail){    
         if (p.equals(c)){
             c = null;
        }     
        }
     if (c != null){ 
     mail.add(c); 
     }
     }
    
    }
      
     public void modificaEmail(String og,String mod){
        if (og != null){ 
         for (String p : mail){
             if(p.equals(og)){
                 mail.remove(p);
              }
          }
         }
        if (mod != null){
      aggiungiEmail(mod);     
      }
     }
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
