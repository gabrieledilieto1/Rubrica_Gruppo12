package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.NomeECognomeMancanteException;

public class Contatto implements Comparable<Contatto> {
    public String nome;
    public String cognome;
    private Email mail;
    private NumTelefono numeri;
    
   /**
    * @brief Costruttre classe Contatto
    * @param nome
    * @param cognome
    * @param mail
    * @param numeri
    * @throws NomeECognomeMancanteException 
    * 
    * @pre le stringhe nome e cognome vengono fornite
    * @post Viene create un'istanze della classe Contatto contenente nome e/o cognome.
    */
    public Contatto(String nome, String cognome, Email mail, NumTelefono numeri) throws NomeECognomeMancanteException{ 
        if (nome == null && cognome == null){
            /* Tirare l'eccezione*/   
            throw new NomeECognomeMancanteException();
        }else {
            this.nome = nome;
            this.cognome = cognome;
            this.mail = mail;
            this.numeri = numeri;
        }
    }

    
    /**
     * @brief Setter del Nome
     * @param nome
     * @throws NomeECognomeMancanteException 
     * 
     * @pre
     * @post
     */
     public void setNome(String nome) throws NomeECognomeMancanteException{
        if (nome == null && this.cognome == null ) { 
            /*Tirare l'eccezione*/  
            throw new NomeECognomeMancanteException();
        }else {
            this.nome = nome;  
        }
    }
    /**
     * @brief Setter del cognome
     * @param cognome
     * @throws NomeECognomeMancanteException 
     */
     public void setCognome(String cognome) throws NomeECognomeMancanteException{
        if (this.nome == null && cognome == null ){ 
            /*Tirare l'eccezione*/  
             throw new NomeECognomeMancanteException();
        }else {
            this.cognome = cognome;  
        }
    }   
     
     /**
      * @bried Getter Nome
      * @return 
      */
    public String getNome() {
        return nome;
    }
    /**
     * @brief Getter Cognome
     * @return 
     */
    public String getCognome() {
        return cognome;
    }
    /**
     * @brief Getter Mail
     * @return 
     */
    public Email getMail(){
        return mail;  
    }
    /**
     * @bried Getter Numero
     * @return 
     */
    public NumTelefono getNumeri(){
        return numeri;
    }
    
    /**
    * @brief Confronta questo contatto con un altro in base all'ordine alfabetico del cognome e, in caso di uguaglianza, del nome.
    * 
    *
    * @pre Il contatto passato come parametro non deve essere nullo.
    * @post Restituisce un valore intero che rappresenta l'ordine relativo 
    *       tra i due contatti: negativo se questo contatto precede, zero
    *       se sono uguali, positivo se segue.
    *
    * @param o Il contatto da confrontare con l'oggetto corrente.
    * @return Un valore negativo, zero o positivo se questo contatto è rispettivamente  minore, uguale o maggiore rispetto al contatto passato.
    *         
    * @throws NullPointerException Se il contatto passato come parametro è nullo.
    */
    @Override
    public int compareTo(Contatto o){
         if (o == null) {
            throw new NullPointerException("Il contatto da confrontare è nullo.");
        }
        if(!this.cognome.equals(o.cognome)){
            return this.cognome.compareTo(o.cognome);
        } else return this.nome.compareTo(o.nome);
    }
    
    /**
    * @brief Restituisce una rappresentazione testuale del contatto, includendo nome, cognome, email e numeri di telefono.
    * 
    *
    * @pre Gli attributi del contatto (nome, cognome, email, numeri) devono essere inizializzati.
    * @post Restituisce una stringa che rappresenta il contatto in formato leggibile.
    *
    * @return Una stringa che contiene le informazioni del contatto, con nome, cognome, email e numeri di telefono.
    *         
    */
      @Override
    public String toString() {
        return "Contatto: [nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + ", numeri=" + numeri + "]";
    }

}    
