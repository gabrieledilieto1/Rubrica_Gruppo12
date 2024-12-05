/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exception;

/**
 *
 * @author LELE 
 * ciao
 */
public class DuplicatiException extends RubricaException{

    
    public DuplicatiException() {
        super("Errore: Inserimento già presente: cambia -> ");
    }

    public DuplicatiException(String msg) {
        super(msg);
    }
}
