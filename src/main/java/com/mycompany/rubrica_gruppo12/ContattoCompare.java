package com.mycompany.rubrica_gruppo12;

import java.util.Comparator;

/**
 *
 * @author luca
 */
public class ContattoCompare implements Comparator<Contatto> {

    @Override
    public int compare(Contatto o1, Contatto o2){
        if(!o1.cognome.equalsIgnoreCase(o2.cognome)){
            return o1.cognome.compareTo(o2.cognome);
        }else return o1.nome.compareTo(o2.nome);
    }
}
