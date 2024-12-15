package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.NomeECognomeMancanteException;

public class Contatto{
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
     * @brief Setter Mail
     * @param mail 
     */
    public void setMail(Email mail) {
        this.mail = mail;
    }
    
    /**
     * @brief Setter Numeri
     * @param numeri 
    */
    public void setNumeri(NumTelefono numeri) {
        this.numeri = numeri;
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
