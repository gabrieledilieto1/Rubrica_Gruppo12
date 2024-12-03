/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.rubricagruppo12;

import java.util.TreeSet;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


/**
 *
 * @author LELE
 */

//SE VUOI METTERE LA CompareTo devi mettere: Rubrica implements Comparable<>
public class Rubrica {
    
     private TreeSet<Contatto> elenco;
     
     //COSTRUTTORE
    public Rubrica(){
        this.elenco = new TreeSet<>();
    }
    
    public void aggiungi(Contatto c) {
        elenco.add(c); 
    }   
     
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println("L'elenco è formato da: \n");
            for (Contatto c : elenco){
                sb.append(c);
                sb.append("\n *** \n");
            }
        return sb.toString();
    }        
}
