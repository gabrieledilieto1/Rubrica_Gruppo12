/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exception;

/**
 *
 * @author LELE
 */
public class NumeroTelefonoNonValidoException extends RubricaException {
    public NumeroTelefonoNonValidoException() {
        super("Errore: Numero di telefono non valido. Assicurarsi che contenga solo cifre e sia compreso tra 8 e 15 caratteri.");
    }

    public NumeroTelefonoNonValidoException(String message) {
        super(message);
    }
}

