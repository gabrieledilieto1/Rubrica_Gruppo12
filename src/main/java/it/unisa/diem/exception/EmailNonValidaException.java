package it.unisa.diem.exception;
/**
 *
 * @author carlo
 */
public class EmailNonValidaException extends Exception {
    
    public EmailNonValidaException() {
        super("Errore: L'indirizzo email inserito non è valido. Assicurarsi che segua il formato nome@dominio.com.");
    }

    public EmailNonValidaException(String message) {
        super(message);
    }
}