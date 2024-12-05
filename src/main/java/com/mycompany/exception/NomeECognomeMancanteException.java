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
public class NomeECognomeMancanteException extends RubricaException {
    public NomeECognomeMancanteException() {
        super("Errore: È necessario inserire almeno il nome o il cognome.");
    }

    public NomeECognomeMancanteException(String message) {
        super(message);
    }
}

