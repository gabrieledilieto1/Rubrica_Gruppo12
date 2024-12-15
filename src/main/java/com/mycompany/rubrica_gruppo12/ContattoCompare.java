package com.mycompany.rubrica_gruppo12;

import java.util.Comparator;

/**
 *
 * @author luca
 */
public class ContattoCompare implements Comparator<Contatto> {

    /**
 * Confronta due oggetti di tipo Contatto basandosi su cognome e nome.
 * 
 * Se i cognomi dei due contatti sono diversi, il confronto avviene 
 * basandosi sul cognome in ordine alfabetico. Se i cognomi sono uguali, 
 * il confronto viene effettuato sul nome in ordine alfabetico.
 *
 * @param o1 Il primo oggetto Contatto da confrontare.
 * @param o2 Il secondo oggetto Contatto da confrontare.
 * @return Un valore negativo se o1 precede o2, un valore positivo se o1 segue o2,
 *         o 0 se i due contatti sono considerati uguali.
 */
    @Override
    public int compare(Contatto o1, Contatto o2){
        if(!o1.cognome.equalsIgnoreCase(o2.cognome)){
            return o1.cognome.compareTo(o2.cognome);
        }else return o1.nome.compareTo(o2.nome);
    }
}
