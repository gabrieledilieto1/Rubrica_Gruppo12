package it.unisa.diem.exception;
/**
 *
 * @author carlo
 */
public class FormatoFileNonValidoException extends Exception {
    
    public FormatoFileNonValidoException() {
        super("Errore: Il formato del file selezionato non è valido. Si accettano solo file JSON o CSV.");
    }

    public FormatoFileNonValidoException(String message) {
        super(message);
    }
}
