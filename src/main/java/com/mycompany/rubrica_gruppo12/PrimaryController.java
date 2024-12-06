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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private Label fldNome;
    @FXML
    private Label fldNumTelefono;
    @FXML
    private Label fldCognome;
    @FXML
    private Label fldEmail;
    
    private ObservableList<Contatto> contacts; 
    @FXML
    private TableView<?> tblContatti;
    @FXML
    private TableColumn<?, ?> clmCognome;
    @FXML
    private TableColumn<?, ?> clmNome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        contacts = FXCollections.observableArrayList(); 
    }    
    
    private void aggiungiContatto() throws NomeECognomeMancanteException, NumeroTelefonoNonValidoException, DuplicatiException{
        // Creazione di un oggetto Email
        Email email = new Email();
        if (!fldEmail.getText().isEmpty()) {
            email.aggiungiEmail(fldEmail.getText());
        }
        // Creazione di un oggetto NumTelefono
        NumTelefono numTelefono = new NumTelefono();
        if (!fldNumTelefono.getText().isEmpty()) {
            numTelefono.aggiungiNumTelefono(fldNumTelefono.getText());
        }
        //Aggiungo il contatto alla rubrica
        contacts.add(new Contatto(fldNome.getText(), fldCognome.getText(), email, numTelefono));
}
    
    
}
