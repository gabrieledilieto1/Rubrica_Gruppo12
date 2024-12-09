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
    
     public void setCognome(String cognome) throws NomeECognomeMancanteException{
        if (this.nome == null && cognome == null ){ 
            /*Tirare l'eccezione*/  
             throw new NomeECognomeMancanteException();
        }else {
            this.cognome = cognome;  
        }
    }   
     
    public String getNome() {
        return nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public Email getMail(){
        return mail;  
    }
    
    public NumTelefono getNumeri(){
        return numeri;
    }
    
    
    @Override
    public int compareTo(Contatto o){
         if (o == null) {
            throw new NullPointerException("Il contatto da confrontare è nullo.");
        }
        if(!this.cognome.equals(o.cognome)){
            return this.cognome.compareTo(o.cognome);
        } else return this.nome.compareTo(o.nome);
    }
    
      @Override
    public String toString() {
        return "Contatto: [nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + ", numeri=" + numeri + "]";
    }

}    