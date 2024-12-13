
package com.mycompany.rubrica_gruppo12;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if (contacts == null) {
        contacts = FXCollections.observableArrayList(); // Inizializza la lista se non esiste

    }
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
private void goBack(ActionEvent event) throws IOException{
     Parent secondViewParent = FXMLLoader.load(getClass().getResource("primary.fxml"));
        Scene secondViewScene = new Scene(secondViewParent);
        //Prende  le informazioni dallo Stage
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondViewScene);
        window.show();
}
    
    /*
  @FXML
private void goBack(ActionEvent event) {
    try {
        // Carica la scena principale
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();

        // Ottieni il controller della scena principale
        PrimaryController primaryController = loader.getController();

        // Passa la stessa lista 'contacts'
        if (contacts == null) {
            System.err.println("Errore: la lista dei contatti è null.");
            return;
        }
        primaryController.setContatti(contacts);

        // Cambia scena
        Stage stage = (Stage) btnGoBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        System.err.println("Errore nel caricamento della scena principale: " + e.getMessage());
    }
}
*/
    @FXML
    private void modificaContatto(ActionEvent event) {
    }


    
}


