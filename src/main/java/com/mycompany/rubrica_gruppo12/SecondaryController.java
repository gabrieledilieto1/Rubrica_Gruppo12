package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.DuplicatiException;
import com.mycompany.exception.NomeECognomeMancanteException;
import com.mycompany.exception.NumeroTelefonoNonValidoException;
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
import javafx.scene.control.TextField;
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
    private Label lblNome;

    @FXML
    private Label lblCognome;

    @FXML
    private Label lblEmail1;

    @FXML
    private Label lblEmail2;

    @FXML
    private Label lblEmail3;

    @FXML
    private Label lblNumTelefono1;

    @FXML
    private Label lblNumTelefono2;

    @FXML
    private Label lblNumTelefono3;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtEmail1;

    @FXML
    private TextField txtEmail2;

    @FXML
    private TextField txtEmail3;

    @FXML
    private TextField txtNumTelefono1;

    @FXML
    private TextField txtNumTelefono2;

    @FXML
    private TextField txtNumTelefono3;

    @FXML
    private Button btnModifica;

    @FXML
    private Button btnGoBack;

    private Contatto contatto; // Riferimento al contatto da modificare

    private PrimaryController primaryController; // Riferimento al controller principale

    private ObservableList<Contatto> contacts;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (contacts == null) {
            contacts = FXCollections.observableArrayList(); // Inizializza la lista se non esiste
        }
    }

    
    public void setContatti(ObservableList<Contatto> contact){
    contacts = contact;    
    }
    
    // Metodo per impostare il contatto da modificare
    public void setDettagliContatto(Contatto contattoSelezionato) {
        this.contatto = contattoSelezionato;

        // Popolamento dei campi con i dati del contatto
        lblNome.setText(contattoSelezionato.getNome());
        txtNome.setText(contattoSelezionato.getNome());

        lblCognome.setText(contattoSelezionato.getCognome());
        txtCognome.setText(contattoSelezionato.getCognome());

        // Email
        String[] emails = contattoSelezionato.getMail().getMail().toArray(new String[0]);
        lblEmail1.setText(emails.length > 0 ? emails[0] : "");
        txtEmail1.setText(emails.length > 0 ? emails[0] : "");

        lblEmail2.setText(emails.length > 1 ? emails[1] : "");
        txtEmail2.setText(emails.length > 1 ? emails[1] : "");

        lblEmail3.setText(emails.length > 2 ? emails[2] : "");
        txtEmail3.setText(emails.length > 2 ? emails[2] : "");

        // Numeri di telefono
        String[] numeri = contattoSelezionato.getNumeri().getNumeri().toArray(new String[0]);
        lblNumTelefono1.setText(numeri.length > 0 ? numeri[0] : "");
        txtNumTelefono1.setText(numeri.length > 0 ? numeri[0] : "");

        lblNumTelefono2.setText(numeri.length > 1 ? numeri[1] : "");
        txtNumTelefono2.setText(numeri.length > 1 ? numeri[1] : "");

        lblNumTelefono3.setText(numeri.length > 2 ? numeri[2] : "");
        txtNumTelefono3.setText(numeri.length > 2 ? numeri[2] : "");
    }

    // Metodo per impostare il riferimento al controller principale
    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }

    @FXML
    private void modificaContatto(ActionEvent event) throws NomeECognomeMancanteException, NumeroTelefonoNonValidoException, DuplicatiException {
        // Aggiorna i dati del contatto con i valori dei campi di input
        contatto.setNome(txtNome.getText());
        contatto.setCognome(txtCognome.getText());
        Email email = new Email();
        NumTelefono numTelefono = new NumTelefono();
        
        
        // Gestione delle email
        
        if (!txtEmail1.getText().isEmpty()) {
            email.aggiungiEmail(txtEmail1.getText().trim());
        }
        if (!txtEmail2.getText().isEmpty()) {
            email.aggiungiEmail(txtEmail2.getText().trim());
        }
        if (!txtEmail3.getText().isEmpty()) {
            email.aggiungiEmail(txtEmail3.getText().trim());
        }
        

        // Gestione dei numeri di telefono
       
        if (!txtNumTelefono1.getText().isEmpty()) {
            numTelefono.aggiungiNumTelefono(txtNumTelefono1.getText().trim());
        }
        if (!txtNumTelefono2.getText().isEmpty()) {
            numTelefono.aggiungiNumTelefono(txtNumTelefono2.getText().trim());
        }
        if (!txtNumTelefono3.getText().isEmpty()) {
            numTelefono.aggiungiNumTelefono(txtNumTelefono3.getText().trim());
        }
       

        // Aggiorna la lista nella scena principale
         /*Dà nullpointerexception, se riesci a farlo partire abbiamo risolto il problema*/
        primaryController.updateContatto(contatto);
        primaryController.setContatti(contacts);
        
        // Chiudi la finestra secondaria
        Stage stage = (Stage) btnModifica.getScene().getWindow();
       
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent secondViewParent = FXMLLoader.load(getClass().getResource("primary.fxml"));
        Scene secondViewScene = new Scene(secondViewParent);
        // Prende le informazioni dallo Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(secondViewScene);
        primaryController.setContatti(contacts); /*Dà nullpointerexception, se riesci a farlo partire abbiamo risolto il problema*/
        window.show();  
    }
}
