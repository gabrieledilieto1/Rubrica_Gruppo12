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
import com.mycompany.rubrica_gruppo12.Contatto;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    private Label lblNumTelefono3;
    @FXML
    private Label lblNumTelefono2;
    @FXML
    private Label lblNumTelefono1;
    @FXML
    private Label lblCognome;
    @FXML
    private Label lblNome;
    @FXML
    private Button btnGoBack;
    
    private ObservableList<Contatto> contacts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setDettagliContatto(Contatto contattoSelezionato) {
        // Imposta i dettagli del nome e cognome
        lblNome.setText(contattoSelezionato.getNome());
        lblCognome.setText(contattoSelezionato.getCognome());

        // Gestione delle email
    lblEmail1.setText("");
    lblEmail2.setText("");
    lblEmail3.setText("");
    int emailIndex = 0;
    for (String email : contattoSelezionato.getMail().getMail()) { // Usa il getter per ottenere le email
        if (emailIndex == 0) lblEmail1.setText(email);
        else if (emailIndex == 1) lblEmail2.setText(email);
        else if (emailIndex == 2) lblEmail3.setText(email);
        emailIndex++;
    }

    // Gestione dei numeri di telefono
    lblNumTelefono1.setText("");
    lblNumTelefono2.setText("");
    lblNumTelefono3.setText("");
    int phoneIndex = 0;
    for (String numero : contattoSelezionato.getNumeri().getNumeri()) { // Usa il getter per ottenere i numeri
        if (phoneIndex == 0) lblNumTelefono1.setText(numero);
        else if (phoneIndex == 1) lblNumTelefono2.setText(numero);
        else if (phoneIndex == 2) lblNumTelefono3.setText(numero);
        phoneIndex++;
    }
    }

    @FXML
    private void goBack(ActionEvent event) {
       try {
        // Carica la prima scena
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();

        // Ottieni il controller della prima scena
        PrimaryController primaryController = loader.getController();

        // Passa la lista dei contatti al controller della prima scena
        primaryController.setContatti(contacts); // Assumi che 'contacts' sia la lista di contatti condivisa

        // Ottieni lo stage corrente e imposta la nuova scena
        Stage stage = (Stage) btnGoBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        System.err.println("Errore nel caricamento della prima schermata: " + e.getMessage());
    }
    }
    
    
    
    


    
}
