package com.mycompany.rubrica_gruppo12;

import com.mycompany.exception.NomeECognomeMancanteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        try {
          // Creazione della rubrica
            Rubrica rubrica = new Rubrica();

            // Creazione del primo contatto
            Email mail1 = new Email();
            mail1.aggiungiEmail("mario.rossi@example.com");
            NumTelefono num1 = new NumTelefono();
            num1.aggiungiNumTelefono("+390123456789");
            Contatto c1 = new Contatto("Mario", "Rossi", mail1, num1);
            rubrica.aggiungiContatto(c1);

            // Creazione del secondo contatto
            Email mail2 = new Email();
            mail2.aggiungiEmail("luigi.bianchi@example.com");
            NumTelefono num2 = new NumTelefono();
            num2.aggiungiNumTelefono("+390987654321");
            Contatto c2 = new Contatto("Luigi", "Bianchi", mail2, num2);
            rubrica.aggiungiContatto(c2);

            // Stampa della rubrica dopo l'aggiunta dei contatti
            System.out.println("Rubrica dopo l'aggiunta di contatti:");
            System.out.println(rubrica);

            // Esportazione della rubrica in un file
            String filePath = "rubrica_test.csv";
            rubrica.esporta(filePath);

            // Creazione di una nuova rubrica vuota e importazione dal file
            Rubrica nuovaRubrica = new Rubrica();
            nuovaRubrica.importa(filePath);

            // Stampa della rubrica importata
            System.out.println("Rubrica importata dal file:");
            System.out.println(nuovaRubrica);

        } catch (NomeECognomeMancanteException e) {
            System.err.println("Errore nella creazione di un contatto: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore durante l'importazione o l'esportazione: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Errore generico: " + e.getMessage());
        }
    }
    

}