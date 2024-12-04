package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.DuplicatiException;
import com.mycompany.exception.NumeroTelefonoNonValidoException;
import java.util.HashSet;

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
      
    public void aggiungiNumTelefono(String c) throws NumeroTelefonoNonValidoException, DuplicatiException {
        if (c != null) {
        // Controlla se il numero di telefono è valido
            if (!c.matches("\\+?\\d{8,15}")) { //  numero di telefono valido (opzionale prefisso internazionale e 8-15 cifre)
                // Lancia l'eccezione se il formato del numero non è valido
                System.out.println(c);
                throw new NumeroTelefonoNonValidoException();
            }

            // Aggiunge il numero solo se non è duplicato
            if (!numeri.add(c)) {
                throw new DuplicatiException(c);
                // System.out.println("Errore: Il numero di telefono \"" + c + "\" è già presente.");
            } else {
                System.out.println("Il numero \"" + c + "\" è stato aggiunto correttamente.");
              }
        }
    }

     
    public void modificaNumTelefono(String og, String mod) throws NumeroTelefonoNonValidoException, DuplicatiException {
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
     
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (String p : numeri){
            sb.append(p);
            sb.append(" ");
        }
            return sb.toString();
    }
      
}
