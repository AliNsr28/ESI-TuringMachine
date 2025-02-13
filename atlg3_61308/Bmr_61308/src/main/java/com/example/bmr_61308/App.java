package com.example.bmr_61308;

import com.example.bmr_61308.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * The `App` class represents the main entry point for the BMR calculator application.
 * It extends the JavaFX `Application` class and initializes the user interface.
 */
public class App extends Application  {
     private  View view;

    /**
     * Initializes and displays the user interface for the BMR calculator application.
     *
     * @param stage The primary stage for displaying the application.
     * @throws IOException If an I/O error occurs (not used in this application).
     */
    @Override
    public void start(Stage stage) throws IOException {
        view = new View();
        view.display(stage);
        Scene scene = new Scene(view.getVbox(),600,280);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * The main entry point for the application. It launches the JavaFX application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch();
    }



}