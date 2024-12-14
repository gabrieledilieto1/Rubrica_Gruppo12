/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubrica_gruppo12;


import java.util.Comparator;

/**
 *
 * @author luca
 */
public class ContattoCompare implements Comparator<Contatto> {

    @Override
    public int compare(Contatto o1, Contatto o2) {
        if(!o1.cognome.equals(o2.cognome)){
            return o1.cognome.compareTo(o2.cognome);
        } else return o1.nome.compareTo(o2.nome);
        
       }
    
}
