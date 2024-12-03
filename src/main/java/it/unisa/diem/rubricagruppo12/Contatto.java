package it.unisa.diem.rubricagruppo12;

import it.unisa.diem.exception.NomeECognomeMancanteException;

/**
 *
 * @author LELE
 */

public class Contatto implements Comparable<Contatto> {
    public String nome;
    public String cognome;
    // public String codiceFiscale; è NECESSARIO?
    public Email mail;
    public NumTelefono numeri;
    
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
        return "Contatto: [nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + ", numeri=" + numeri + "]\n";
    }

}    