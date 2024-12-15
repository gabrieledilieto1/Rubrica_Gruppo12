package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.DuplicatiException;
import java.util.HashSet;

public class Email {
    HashSet<String> mail;

    /**
     * @brief Costruttore della classe Email.
     * @post Inizializza l'insieme delle email come vuoto
     */
    public Email() {
        this.mail = new HashSet<>();
    }


    /**
     * @brief Metodo getter Email
     * @return 
     */
    public HashSet<String> getMail() {
        return mail;
    }
    
    /**
     * 
     * @param c
     * @return 
     */
    public String returnMail(String c) {
    if (c != null){ 
    if (mail.contains(c)){
        return c;
        }
    }
    return null;
    }
    
    
    /**
     * @brief Agginge un'email all'insieme, evitando duplicati
     * @param c la stringa che rappresenta l'email da aggiungere
     * 
     * @pre L'email fornita non deve essere null.
     * @post Se l'email non è duplicata, viene aggiunta all'insieme; in caso contrario, l'email originale viene mantenuta.
     * 
     */
    public void aggiungiEmail(String c) {
        if (c != null) {
            if (!mail.contains(c)) {
                //si potrebbe implementare il controllo sul corretto inserimento del formato della mail: nome@dominio.com 
                mail.add(c);
                System.out.println("L'e-mail \"" + c + "\" è stata aggiunta.");
            } else {
                System.out.println("Errore: L'e-mail \"" + c + "\" è già presente nella lista.");
            }
        }
    }

   /**
    * @brief Modifica un'e-mail esistente nell'insieme, rimuovendo quella originale e aggiungendone una nuova.
    * @param og l'email originale da modificare.
    * @param mod la nuova email da aggiungere
    * @throws DuplicatiException la nuova email è già presente
    * 
    * @pre L'e-mail originale deve esistere nell'insieme per poter essere rimossa.
     *      La nuova e-mail non deve già esistere come duplicato nell'insieme.
     * @post Se l'e-mail originale esiste ed è stata rimossa, la nuova e-mail viene aggiunta,
     *       a meno che non sia già presente come duplicato.
    */
    public void modificaEmail(String og, String mod) throws DuplicatiException {
        // Rimuove l'e-mail originale
        if (og != null) {
            if (mail.contains(og)) {
                mail.remove(og); // Rimuove l'e-mail originale
                System.out.println("L'e-mail originale \"" + og + "\" è stata rimossa.");
            } else {
                System.out.println("Errore: L'e-mail \"" + og + "\" non è presente nella lista.");
                return;
            }
        }

        // Aggiunge la nuova e-mail
        if (mod != null) {
            if (!mail.contains(mod)) { // Controllo duplicati
                mail.add(mod);
                System.out.println("L'e-mail \"" + mod + "\" è stata aggiunta con successo.");
            } else {
                throw new DuplicatiException(mod);
               // System.out.println("Errore: L'e-mail \"" + mod + "\" è già presente nella lista.");
            }
        }
    }

    /**
     * @brief Restituisce una rappresentazione testuale delle e-mail nell'insieme.
     *
     * @pre L'insieme delle e-mail non deve essere null (può essere vuoto).
     * @post Restituisce una stringa contenente tutte le e-mail separate da uno spazio.
     *
     * @return Una stringa che rappresenta l'insieme delle e-mail memorizzate.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (String p : mail) {
            sb.append(p);
            sb.append(" ");
        }
        return sb.toString();
    }
}