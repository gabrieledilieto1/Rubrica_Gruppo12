package it.unisa.diem.rubricagruppo12;

import it.unisa.diem.exception.DuplicatiException;
import java.util.HashSet;

public class Email {
    HashSet<String> mail;

    // Costruttore
    public Email() {
        this.mail = new HashSet<>();
    }

    /*
      * Controlla se l'inserimento è = null, 
      * controlla che non ci sia un duplicato,
      * nel caso che l'inserimento è  un duplicato, mantiene l'inserimento originale.
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

    // Modifica un'e-mail esistente
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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println("Le mail sono: \n");
        for (String p : mail) {
            sb.append(p);
            sb.append("\n *** \n");
        }
        return sb.toString();
    }
}