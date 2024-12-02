package com.mycompany.rubrica_gruppo12;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LELE
 */
public class Contatto {
    public String nome;
    public String cognome;
    public String codiceFiscale;
    public Email mail;
    public NumTelefono numeri;
    
    public Contatto(String nome, String cognome, Email mail, NumTelefono numeri){ 
    if (nome.equals(null) && cognome.equals(null)){
     /* Tirare l'eccezione*/   
     }   
    else{
    this.nome = nome;
    this.cognome = cognome;
    this.mail = mail;
    this.numeri = numeri;
    }
    }
    
    public String getNome() {

        return nome;

    }
    
    public String getCognome() {

        return cognome;

    }
    
    public void setNome(String nome){
      if (nome == null && this.cognome == null ){ 
        /*Tirare l'eccezione*/  
       }   
      else{
      this.nome = nome;  
      }
    }
    
     public void setCognome(String cognome){
        if (this.nome == null && cognome == null ){ 
        /*Tirare l'eccezione*/  
       }   
      else{
      this.cognome = cognome;  
      }
    }   
    
    public Email getMail(){
      return mail;  
    }
    
    public NumTelefono getNumeri(){
        return numeri;
    }
    
}

