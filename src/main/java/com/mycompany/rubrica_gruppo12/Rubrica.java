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
import java.util.HashSet;

/**
 * Classe che rappresenta una rubrica contenente un insieme di contatti.
 * Consente operazioni come aggiunta, ricerca, esportazione e importazione di contatti.
 */
public class Rubrica{
    
     private TreeSet<Contatto> elenco;
     private HashSet<Contatto> filtro;
     
     /**
     * @brief Costruttore della classe Rubrica.
     * @pre Nessuna.
     * @post Inizializza l'elenco dei contatti come vuoto.
     */
    public Rubrica(){
        this.elenco = new TreeSet<>(new ContattoCompare());
    }
    
     /**
     * @brief Restituisce l'elenco dei contatti nella rubrica.
     * 
     * 
     * @post Restituisce l'elenco corrente dei contatti memorizzati.
     *
     * @return Un TreeSet contenente i contatti.
     */
    public TreeSet<Contatto> getElenco() {
        return this.elenco;
    }

    /**
     * @brief Restituisce l'elenco dei contatti filtrati nella rubrica.
     * @return Un HashSet contenente i contatti filtrati
     */
    public HashSet<Contatto> getFiltro() {
        return filtro;
    }
    
        
    public Contatto getContatto(Contatto c){
        if (elenco.contains(c)){
            return c;
         }   
        return null;
        }
    
    
    
    
    /**
     * @brief Aggiunge un contatto alla rubrica.
     * 
     * @pre Il contatto fornito non deve essere nullo e deve essere un'istanza valida di Contatto.
     * @post Il contatto viene aggiunto all'elenco, se non già presente.
     *
     * @param c Il contatto da aggiungere alla rubrica.
     */
    public void aggiungiContatto(Contatto c) {
        elenco.add(c); 
    }   
    
    
    public void rimuoviContatto(Contatto c){
        if (elenco.contains(c)){
            elenco.remove(c);
        }
    }
    
    /**
     * Filtra i contatti nella rubrica in base a un criterio di ricerca (nome o cognome).
     * 
     * @param filtro
     * @pre Il parametro cerca non deve essere null.
     * @post L'insieme filtro contiene solo i contatti che corrispondono al criterio di ricerca.
     *
     * @param cerca Il criterio di ricerca (nome o cognome).
     */
       public void Ricerca(String cerca, HashSet filtro){
    if (!filtro.isEmpty()){    
     filtro.clear();
    }     
    if (cerca != null){      
    for (Contatto c: elenco) {   
       if (c.cognome.contains(cerca) || c.nome.contains(cerca)){  
       filtro.add(c);   
       } 
    }
    }
    }
    
    
    
  /**
     * Esporta l'elenco dei contatti in un file CSV.
     * 
     * @pre L'elenco deve essere non nullo (può essere vuoto).
     * @post Il file specificato contiene l'elenco dei contatti in formato CSV.
     *
     * @param filePath Il percorso del file in cui esportare la rubrica.
     * @throws IOException Se si verifica un errore durante la scrittura del file.
     */
    public void esporta(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
             // Aggiungere l'intestazione
            writer.write("Nome, Cognome, Email, Numeri");
            writer.newLine(); // Nuova riga dopo l'intestazione

            for (Contatto c : elenco) {
                 // Scrivi i dettagli del contatto
                    writer.write(c.getNome() + ", " +
                         c.getCognome() + ", " +
                         c.getMail() + ", " +
                         c.getNumeri());
                    writer.newLine();
            }
        System.out.println("Rubrica esportata correttamente in: " + filePath);
        }
    }

    
   /**
     * Importa i contatti da un file CSV e li aggiunge alla rubrica.
     * 
     * @pre Il file deve esistere e avere un formato valido. Ogni riga deve contenere 
     *      nome, cognome, email e numero di telefono separati da virgole.
     * @post I contatti validi vengono aggiunti all'elenco, ignorando le righe non valide.
     *
     * @param filePath Il percorso del file CSV da cui importare i contatti.
     * @throws IOException Se si verifica un errore durante la lettura del file.
     * @throws NomeECognomeMancanteException Se nome e cognome non sono validi.
     * @throws NumeroTelefonoNonValidoException Se il numero di telefono ha un formato non valido.
     * @throws DuplicatiException Se un contatto già esiste nella rubrica.
     */
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
                if (dati[3].trim().equals("Numeri")){
                    continue;
                    }
                // Estrae i dati e crea un nuovo Contatto
                System.out.println("\n");
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
    
    /**
     * @brief Restituisce una rappresentazione testuale della rubrica, con tutti i contatti elencati.;;
     * 
     * @pre L'elenco non deve essere nullo (può essere vuoto).
     * @post Restituisce una stringa con i dettagli dei contatti, uno per riga.
     *
     * @return Una stringa che rappresenta l'elenco dei contatti nella rubrica.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
            for (Contatto c : elenco){
                sb.append(c);
                sb.append("\n");
            }
        return sb.toString();
    }        
    
}
