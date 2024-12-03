/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.DuplicatiException;
import com.mycompany.exception.NomeECognomeMancanteException;
import com.mycompany.exception.NumeroTelefonoNonValidoException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    //IMPLEMENTO ESPORTA E IMPORTA
   public void esporta(String filePath) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        // Aggiungere l'intestazione
        writer.write("Nome,Cognome,Email,Numeri");
        writer.newLine(); // Nuova riga dopo l'intestazione

        for (Contatto c : elenco) {
            // Scrivi i dettagli del contatto
            writer.write(c.getNome() + "," +
                         c.getCognome() + "," +
                         c.getMail() + "," +
                         c.getNumeri());
            writer.newLine();
        }
        System.out.println("Rubrica esportata correttamente in: " + filePath);
    }
}

    
    //da rivedere
    public void importa(String filePath) throws IOException, NomeECognomeMancanteException, NumeroTelefonoNonValidoException, DuplicatiException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Divide la riga in base al separatore ','
                String[] dati = line.split(",");

                // Verifica che la riga contenga almeno Nome e Cognome
                if (dati.length < 4) {
                    System.err.println("Riga ignorata, formato non valido: " + line);
                    continue;
                }

                // Estrae i dati e crea un nuovo Contatto
                String nome = dati[0].trim();
                String cognome = dati[1].trim();
                Email mail = new Email();
                mail.aggiungiEmail(dati[2].trim());
                NumTelefono numeri = new NumTelefono();
                numeri.aggiungiNumTelefono(dati[3].trim());

                Contatto nuovoContatto = new Contatto(nome, cognome, mail, numeri);
                elenco.add(nuovoContatto);
            }
            System.out.println("Rubrica importata correttamente da: " + filePath);
        } catch (IOException | NomeECognomeMancanteException e) {
            System.err.println("Errore durante l'importazione: " + e.getMessage());
            throw e;
        }
    }
}
