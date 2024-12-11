/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubrica_gruppo12;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * Label = lbl
 * Text = txt
 * Button = btn
 * 
 * @author LELE
 */
public class SecondaryController implements Initializable {

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
    private TextField txtCerca;
    @FXML
    private Button btnCerca;
    @FXML
    private Button btnTornaIndietro;
    @FXML
    private Label lblNomeContatto;
    @FXML
    private Label lblCognomeContatto;
    @FXML
    private Label lblNumtelefono1;
    @FXML
    private Label lblNumtelefono2;
    @FXML
    private Label lblNumtelefono3;
    @FXML
    private Label lblEmail1;
    @FXML
    private Label lblEmail2;
    @FXML
    private Label lblEmail3;
    @FXML
    private Button btnModifica;
    @FXML
    private Button btnElimina;
    @FXML
    private Button btnElimina1;
    @FXML
    private MenuItem mnImporta;
    @FXML
    private MenuItem mnEsporta;
    @FXML
    private Menu mnFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eliminaContatto(ActionEvent event) {
    }

    @FXML
    private void aggiungiContatto(ActionEvent event) {
        
    }

    @FXML
    private void cercaContatto(ActionEvent event) {
        
    }

    @FXML
    private void modificaContatto(ActionEvent event) {
        
    }

    @FXML
    private void elimina1Contatto(ActionEvent event) {
        
    }

    @FXML
    private void goBack(ActionEvent event) {
    }

    
}
