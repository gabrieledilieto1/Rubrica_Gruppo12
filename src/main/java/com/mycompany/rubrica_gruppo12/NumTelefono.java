package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.DuplicatiException;
import com.mycompany.exception.NumeroTelefonoNonValidoException;
import java.util.HashSet;

public class NumTelefono {
    
    HashSet <String> numeri; 
              
    /**
     * @brief Costruttore della classe NumTelefono
     * @post Inizializza l'insieme dei numeri come vuoto
     */
    public NumTelefono(){
        this.numeri = new HashSet<>();
    }

    /**
     * @brief Metodo getter
     * @return 
     */
    public HashSet<String> getNumeri() {
        return numeri;
    }
    
    
    
    
    
    
    
    
    public String returnNum(String c) {
    if (c != null){ 
    if (numeri.contains(c)){
        return c;
        }
    }
    return null;
    }
    
    
    
      /**
     * @brief Aggiunge un numero di telefono all'insieme, controllando la validità del formato
     * e l'assenza di duplicati.
     *
     * @pre Il numero di telefono fornito non deve essere null. Deve rispettare il formato:
     *      opzionale prefisso internazionale (+) e da 8 a 15 cifre.
     * @post Se il numero è valido e non duplicato, viene aggiunto all'insieme.
     *
     * @param c La stringa che rappresenta il numero di telefono da aggiungere.
     * @throws NumeroTelefonoNonValidoException Se il numero non rispetta il formato valido.
     * @throws DuplicatiException Se il numero è già presente nell'insieme.
     */
    public void aggiungiNumTelefono(String c) throws NumeroTelefonoNonValidoException, DuplicatiException {
        if (c != null) {
        // Controlla se il numero di telefono è valido
        /*
            if (!c.matches("\\+?\\d{8,15}")) { //  numero di telefono valido (opzionale prefisso internazionale e 8-15 cifre)
                // Lancia l'eccezione se il formato del numero non è valido
                System.out.println(c);
                throw new NumeroTelefonoNonValidoException();
            }
        */
            // Aggiunge il numero solo se non è duplicato
            if (!numeri.add(c)) {
                throw new DuplicatiException(c);
                // System.out.println("Errore: Il numero di telefono \"" + c + "\" è già presente.");
            } else {
                System.out.println("Il numero \"" + c + "\" è stato aggiunto correttamente.");
              }
        }
    }

     /**
     * Modifica un numero di telefono esistente, rimuovendo quello originale
     * e aggiungendone uno nuovo.
     *
     * @pre Il numero originale deve essere presente nell'insieme.
     *      Il nuovo numero deve essere valido e non duplicato.
     * @post Se il numero originale è stato rimosso, il nuovo viene aggiunto
     *       all'insieme, a meno che non sia duplicato o non valido.
     *
     * @param og Il numero originale da modificare.
     * @param mod Il nuovo numero di telefono da aggiungere.
     * @throws NumeroTelefonoNonValidoException Se il nuovo numero non rispetta il formato valido.
     * @throws DuplicatiException Se il nuovo numero è già presente nell'insieme.
     */
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
     
    /**
     * Restituisce una rappresentazione testuale dei numeri di telefono nell'insieme.
     *
     * @pre L'insieme dei numeri non deve essere null (può essere vuoto).
     * @post Restituisce una stringa contenente tutti i numeri di telefono separati da uno spazio.
     *
     * @return Una stringa che rappresenta l'insieme dei numeri di telefono memorizzati.
     */
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
