package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.DuplicatiException;
import com.mycompany.exception.NomeECognomeMancanteException;
import com.mycompany.exception.NumeroTelefonoNonValidoException;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    @FXML
    private Button btnApriInfo;
    
    private Label fldNome;
    private Label fldNumTelefono;
    private Label fldCognome;
    private Label fldEmail;
    
    private FilteredList<Contatto> filteredContacts;
    private ObservableList<Contatto> contacts; 
    private Rubrica rubrica; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        contacts = FXCollections.observableArrayList(); //istanzio una array list osservabile
        filteredContacts = new FilteredList<>(contacts, p->true);
        
        //tblContatti.setItems(contacts); //colegamento tra le tabelle
        tblContatti.setItems(filteredContacts);

        clmNome.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getNome());});
        clmCognome.setCellValueFactory(s -> { return new SimpleStringProperty(s.getValue().getCognome());});
       /*
        //DISABILITAZIONE DEI BOTTONI QUANDO I CAMPI OBBLIGATORI NON SONO INSERITI
        btnAggiungi.disableProperty().bind(Bindings.createBooleanBinding(() -> txtNome.getText().isEmpty() && txtCognome.getText().isEmpty(), txtNome.textProperty(), txtCognome.textProperty() ));
        */
       controllaInput();
    }   
    
    
    private void controllaInput() {
    // DISABILITAZIONE DEL BOTTONE QUANDO I CAMPI OBBLIGATORI NON SONO INSERITI
    BooleanBinding nomeCognomeMancanti = Bindings.createBooleanBinding(
        () -> txtNome.getText().isEmpty() && txtCognome.getText().isEmpty(),
        txtNome.textProperty(),
        txtCognome.textProperty()
    );

    // DISABILITAZIONE DEL BOTTONE QUANDO IL CAMPO EMAIL CONTIENE PIÙ DI DUE VIRGOLE
    BooleanBinding troppeVirgoleEmail = Bindings.createBooleanBinding(
        () -> contaVirgole(txtEmail.getText()) >= 3,
        txtEmail.textProperty()
    );

    // DISABILITAZIONE DEL BOTTONE QUANDO IL CAMPO NUMERI DI TELEFONO CONTIENE PIÙ DI DUE VIRGOLE
    BooleanBinding troppeVirgoleNumeri = Bindings.createBooleanBinding(
        () -> contaVirgole(txtNumTelefono.getText()) >= 3,
        txtNumTelefono.textProperty()
    );

    // COMBINAZIONE DEI BINDING
    btnAggiungi.disableProperty().bind(
        nomeCognomeMancanti.or(troppeVirgoleEmail).or(troppeVirgoleNumeri)
    );
}

// Metodo per contare le virgole in una stringa
private int contaVirgole(String text) {
    if (text == null || text.isEmpty()) {
        return 0;
    }
    return text.length() - text.replace(",", "").length();
}

    @FXML
private void aggiungiContatto(javafx.event.ActionEvent event) throws NomeECognomeMancanteException, NumeroTelefonoNonValidoException, DuplicatiException {
    Email email = new Email();
    if (!txtEmail.getText().isEmpty()) {
        String[] emailArray = txtEmail.getText().split(","); // Email separate da virgola
        for (String mail : emailArray) {
            email.aggiungiEmail(mail.trim());
        }
    }

    NumTelefono numTelefono = new NumTelefono();
    if (!txtNumTelefono.getText().isEmpty()) {
        String[] numeriArray = txtNumTelefono.getText().split(","); // Numeri separati da virgola
        for (String numero : numeriArray) {
            numTelefono.aggiungiNumTelefono(numero.trim());
        }
    }

    String nome = txtNome.getText().isEmpty() ? "<vuoto>" : txtNome.getText();
    String cognome = txtCognome.getText().isEmpty() ? "<vuoto>" : txtCognome.getText();

    Contatto contatto = new Contatto(nome, cognome, email, numTelefono);
    contacts.add(contatto);
    contacts.sort(new ContattoCompare());
    tblContatti.refresh(); // Aggiorna la tabella
}


    /*
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
        String nome;
        String cognome;
        if (txtNome.getText().isEmpty()){
            nome = "<vuoto>";
        }            
        else{
            nome = txtNome.getText();   
            }
        if (txtCognome.getText().isEmpty()){
            cognome = "<vuoto>";
        }            
        else{
            cognome = txtCognome.getText();   
        }  
        System.out.println(nome);
        //Crea il contatto
        Contatto contatto= new Contatto(nome, cognome, email, numTelefono);
        //Aggiungo il contatto alla rubrica
        contacts.add(new Contatto(nome, cognome, email, numTelefono ));
        tblContatti.setItems(FXCollections.observableArrayList(rubrica.getElenco()));
        
    }
    */
    @FXML
    private void cercaContatto(javafx.event.ActionEvent event) {
    String testoRicerca = txtCercaContatto.getText().toLowerCase();

    // Filtra i contatti in base al nome o cognome
    filteredContacts.setPredicate(contatto -> {
        if (testoRicerca == null || testoRicerca.isEmpty()) {
            return true; // Mostra tutti i contatti
        }
        // Filtra per nome o cognome
        return contatto.getNome().toLowerCase().contains(testoRicerca) || 
               contatto.getCognome().toLowerCase().contains(testoRicerca);
    });

    if (filteredContacts.isEmpty()) {
        System.out.println("Nessun contatto trovato.");
    } else {
        System.out.println("Contatti trovati: " + filteredContacts.size());
    }
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

    @FXML
    private void importaRubrica(javafx.event.ActionEvent event) throws NumeroTelefonoNonValidoException, DuplicatiException, NomeECognomeMancanteException {
        
        contacts.removeAll(contacts);
        
        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(new Stage());
        
        if(f == null) return; 
        
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(f)))){
          scan.useDelimiter("[;\n]");
          
          while(scan.hasNext()){
            // Legge i dati base del contatto  
            String nome = scan.next();
            String cognome = scan.next();
            String emailString = scan.next();
            String numeroString = scan.next();
            // Crea l'oggetto Email e aggiunge l'indirizzo letto
            Email email = new Email();
            for (String mail : emailString.split(",")) {
              email.aggiungiEmail(mail.trim());
            }
            // Crea l'oggetto NumTelefono e aggiunge il numero letto
             NumTelefono numero = new NumTelefono();
             for (String numeroTelefono : numeroString.split(",")) {
            numero.aggiungiNumTelefono(numeroTelefono.trim());
            }
              
/*// Legge i dati base del contatto
            String nome = scan.next();
            String cognome = scan.next();
            String emailString = scan.next(); // Stringa rappresentante l'email
            String numeroString = scan.next(); // Stringa rappresentante il numero di telefono

             // Crea l'oggetto Email e aggiunge l'indirizzo letto
            Email email = new Email();
            email.aggiungiEmail(emailString); // Metodo per aggiungere email al set interno

            // Crea l'oggetto NumTelefono e aggiunge il numero letto
            NumTelefono numero = new NumTelefono();
            numero.aggiungiNumTelefono(numeroString); // Metodo per aggiungere il numero al set interno
*/
            // Aggiunge il nuovo contatto alla lista
            contacts.add(new Contatto(nome, cognome, email, numero));}         
        } catch(IOException e){
            System.out.println("Errore! Impossibile caricare il file!"+ e.getMessage());
        }
    }
    
    
    @FXML
    private void esportaRubrica(javafx.event.ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        
        File f = fc.showSaveDialog(txtNome.getParent().getScene().getWindow());
        
        if(f == null) return; 
        
        try( PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f))) ) {
            for(Contatto con : contacts){
                  String emailString = String.join(",", con.getMail().getMail());
                  String numeroString = String.join(",", con.getNumeri().getNumeri());
                  pw.println(con.getNome() + ";" + con.getCognome() + ";" + emailString + ";" + numeroString);

                //pw.println(con.getNome()+";"+con.getCognome()+";"+con.getMail()+";"+con.getNumeri());
            }
        } catch (IOException e){
            System.out.println("Errore! Impossibile salvare il file!"+ e.getMessage());

        }
       
        
    }

     @FXML
    private void apriDettagliContatto(javafx.event.ActionEvent event) throws IOException{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
         Parent secondViewParent = loader.load();
        Scene secondViewScene = new Scene(secondViewParent);
        //Prende  le informazioni dallo Stage
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondViewScene);
        window.show();
        
         // Ottieni il controller della seconda scena
        SecondaryController secondaryController = loader.getController();
         // Ottieni il contatto selezionato
        Contatto contattoSelezionato = tblContatti.getSelectionModel().getSelectedItem();
         // Passa il contatto selezionato al controller secondario
        secondaryController.setDettagliContatto(contattoSelezionato);
    }
 
    /*
    @FXML
    private void apriDettagliContatto(javafx.event.ActionEvent event) {
        // Ottieni il contatto selezionato
    Contatto contattoSelezionato = tblContatti.getSelectionModel().getSelectedItem();

    if (contattoSelezionato == null) {
        System.out.println("Nessun contatto selezionato!");
        return; // Se non c'è contatto selezionato, interrompi
    }

    try {
        // Carica la seconda scena
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent root = loader.load();

        // Ottieni il controller della seconda scena
        SecondaryController secondaryController = loader.getController();

        // Passa il contatto selezionato al controller secondario
        secondaryController.setDettagliContatto(contattoSelezionato);

        // Mostra la seconda scena
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // Chiudi la scena attuale, se necessario
        ((Stage) btnApriInfo.getScene().getWindow()).close();

    } catch (IOException e) {
        System.err.println("Errore nel caricamento della seconda scena: " + e.getMessage());
    }
    }
*/

    
    public void setContatti(ObservableList<Contatto> contatti) {
    if (contatti == null) {
        System.err.println("Errore: la lista dei contatti è null.");
        return;
    }
    this.contacts = contatti;

    // Reinizializza la FilteredList solo se necessario
    if (filteredContacts == null) {
        filteredContacts = new FilteredList<>(contacts, p -> true);
        tblContatti.setItems(filteredContacts); // Aggiorna la TableView
    } else {
        filteredContacts = new FilteredList<>(contacts, p -> true);
        }
    }
    
    // Metodo per aggiornare il contatto
    public void updateContatto(Contatto contattoAggiornato) {
        // Trova il contatto nella lista
        for (int i = 0; i < contacts.size(); i++) {
            Contatto contatto = contacts.get(i);
            if (contatto.getCognome().equals(contattoAggiornato.getCognome())) { // Supponiamo che ogni contatto abbia un ID unico
                // Sostituisci il contatto esistente con quello aggiornato
                contacts.set(i, contattoAggiornato);
                break;
            }
        }
    }
   
}