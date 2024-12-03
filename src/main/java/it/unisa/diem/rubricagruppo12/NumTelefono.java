
package it.unisa.diem.rubricagruppo12;

import it.unisa.diem.exception.NumeroTelefonoNonValidoException;
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
    
      /*
      * Controlla se l'inserimento è = null, 
      * controlla che non ci sia un duplicato,
      * nel caso che l'inserimento è  un duplicato, mantiene l'inserimento originale.
      */
      
      public void aggiungiNumTelefono(String c) throws NumeroTelefonoNonValidoException {
    if (c != null) {
        // Controlla se il numero di telefono è valido
        if (!c.matches("\\+?\\d{8,15}")) { // Regex: numero di telefono valido (opzionale prefisso internazionale e 8-15 cifre)
            // Lancia l'eccezione se il formato del numero non è valido
            throw new NumeroTelefonoNonValidoException();
        }

        // Aggiunge il numero solo se non è duplicato
        if (!numeri.add(c)) {
            System.out.println("Errore: Il numero di telefono \"" + c + "\" è già presente.");
        } else {
            System.out.println("Il numero \"" + c + "\" è stato aggiunto correttamente.");
        }
    }
}

     
     public void modificaNumTelefono(String og, String mod) throws NumeroTelefonoNonValidoException {
        // Rimuove il numero originale se esiste
        if (og != null) {
            if (numeri.contains(og)) {
                numeri.remove(og);
                System.out.println("Il numero originale \"" + og + "\" è stato rimosso.");
            } else {
                System.out.println("Errore: Il numero \"" + og + "\" non è presente nella lista.");
                return;
            }
        }

        // Aggiunge il nuovo numero se specificato
        if (mod != null) {
            aggiungiNumTelefono(mod);
        }
    }
     
    /*public void modificaNumTelefono(String og,String mod){
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
    */
     
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println("I numeri di telefono sono: \n");
        for (String p : numeri){
            sb.append(p);
            sb.append("\n *** \n");
        }
            return sb.toString();
    }
     
    
}
