package com.mycompany.rubrica_gruppo12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private ObservableList<Contatto> sharedContacts = FXCollections.observableArrayList();

   @FXML
    private void startApplication() throws IOException {
    // Passa 'sharedContacts' ai controller
    FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
    Parent root = loader.load();
    PrimaryController primaryController = loader.getController();
    primaryController.setContatti(sharedContacts);
}

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

         launch(args);
    }
}
    

