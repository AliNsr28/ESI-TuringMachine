package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Facade;
import model.Game;
import view.PrimaryStage;


public class AppJavaFx extends Application {


    private PrimaryStage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = new PrimaryStage(new Facade(new Game()), stage);
        primaryStage.setupScene();

    }



    public static void main(String[] args) {
        launch(args);
    }

}
