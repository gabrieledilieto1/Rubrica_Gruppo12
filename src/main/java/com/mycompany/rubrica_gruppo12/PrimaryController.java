/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.DuplicatiException;
import com.mycompany.exception.NomeECognomeMancanteException;
import com.mycompany.exception.NumeroTelefonoNonValidoException;
import com.mycompany.rubrica_gruppo12.Contatto;
import com.mycompany.rubrica_gruppo12.Email;
import com.mycompany.rubrica_gruppo12.NumTelefono;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LELE
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCognome;
    @FXML
    private TextField txtNumTelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnAggiungi;
    @FXML
    private TextField txtCercaContatto;
    @FXML
    private Button btnCerca;
    @FXML
    private TableView<Contatto> tblContatti;
    @FXML
    private TableColumn<Contatto, String > clmCognome;
    @FXML
    private TableColumn<Contatto, String> clmNome;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblNumTelefono;
    @FXML
    private Label lblCognome;
    @FXML
    private Label lblEmail;
    @FXML
    private Button btnElimina;
    @FXML
    private MenuItem mnImporta;
    @FXML
    private MenuItem mnEsporta;
    @FXML
    private Menu mnFile;
    
    private Label fldNome;
    private Label fldNumTelefono;
    private Label fldCognome;
    private Label fldEmail;
    
    private ObservableList<Contatto> filteredContacts = FXCollections.observableArrayList(); // Lista filtrata
    private ObservableList<Contatto> contacts; 
    private Rubrica rubrica; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        contacts = FXCollections.observableArrayList(); //istanzio una array list osservabile
        tblContatti.setItems(contacts); //colegamento tra le tabelle

        clmNome.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getNome());});
        clmCognome.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getCognome());});
       
        //DISABILITAZIONE DEI BOTTONI QUANDO I CAMPI OBBLIGATORI NON SONO INSERITI
        btnAggiungi.disableProperty().bind(Bindings.createBooleanBinding(() -> txtNome.getText().isEmpty() || txtCognome.getText().isEmpty(), txtNome.textProperty(), txtCognome.textProperty() ));
        
    }    
    
    @FXML
    private void aggiungiContatto(javafx.event.ActionEvent event) throws NomeECognomeMancanteException, NumeroTelefonoNonValidoException, DuplicatiException {
        
        // Creazione di un oggetto Email
        Email email = new Email();
        if (!txtEmail.getText().isEmpty()) {
            email.aggiungiEmail(txtEmail.getText());
        }
        // Creazione di un oggetto NumTelefono
        NumTelefono numTelefono = new NumTelefono();
        if (!txtNumTelefono.getText().isEmpty()) {
            numTelefono.aggiungiNumTelefono(txtNumTelefono.getText());
        }
        String nome = txtNome.getText();
        String cognome = txtCognome.getText();
        //Crea il contatto
        Contatto contatto= new Contatto(nome, cognome, email, numTelefono);
        //Aggiungo il contatto alla rubrica
        contacts.add(new Contatto(txtNome.getText(), txtCognome.getText(), email, numTelefono ));
        tblContatti.setItems(FXCollections.observableArrayList(rubrica.getElenco()));
        
    }
    

@FXML
private void cercaContatto(javafx.event.ActionEvent event) {
    String testoRicerca = txtCercaContatto.getText().toLowerCase(); // Legge il testo e lo converte in minuscolo

    // Filtra la lista di contatti
    filteredContacts.clear(); // Puliamo la lista filtrata
    for (Contatto contatto : contacts) { // "contacts" è la lista principale
        if (contatto.getNome().toLowerCase().contains(testoRicerca) || contatto.getCognome().toLowerCase().contains(testoRicerca)) { // Cerca contatti parziali
            filteredContacts.add(contatto); // Aggiunge il contatto alla lista filtrata
        }
    }

    // Controlla se ci sono risultati
    if (filteredContacts.isEmpty()) {
        System.out.println("Nessun contatto trovato.");
    } else {
        System.out.println("Contatti trovati: " + filteredContacts.size());
    }

    // Aggiorna la visualizzazione della lista (esempio con una TableView)
    tblContatti.setItems(filteredContacts); // Aggiorna la lista mostrata nella TableView
}

    @FXML
    private void eliminaContatto(javafx.event.ActionEvent event) {
        
        //Ottieni lo studente selezionato
        Contatto selectedContatto = tblContatti.getSelectionModel().getSelectedItem();
        
        //Controllo se lo studente selezionato è presente
        if ( selectedContatto != null){
            //rimozione studente dalla collezione
            contacts.remove(selectedContatto);
        } else {
            System.out.println("Nessun Contatto Selezionato");
        }
    }

    

    
    
}
