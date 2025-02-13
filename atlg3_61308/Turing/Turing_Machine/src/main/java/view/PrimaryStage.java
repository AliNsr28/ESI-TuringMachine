package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import model.Facade;

import java.util.Random;


/**
 * The PrimaryStage class represents the primary stage of the Turing Machine game.
 * It contains the setup for the main menu, where players can choose a game level or start a random game.
 * The class includes a ChoiceBox for level selection, a Start Game button, and an image background.
 */
public class PrimaryStage extends VBox {
    private Stage stage;
    private ChoiceBox<String> choiceBox;

    private Facade facade;

    private Integer selectedValue;

    private VBox vbox;

    private Button button;

    private SecondaryStage gameView;

    /**
     * Constructs a PrimaryStage with the specified facade and stage.
     *
     * @param facade The facade object for interaction with the game.
     * @param stage  The primary stage for the game.
     */
    public PrimaryStage(Facade facade ,Stage stage) {
        this.stage = stage;
        this.facade = facade;
    }

    /**
     * Sets up the main menu scene with a ChoiceBox, a Start Game button, and an image background.
     */
    public void setupScene() {
        // Création de la ChoiceBox

        choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("RANDOM");
        for (int i = 1; i <= 16; i++) {
            String str  = i+"";
            choiceBox.getItems().add(str);
        }
        choiceBox.setValue("RANDOM"); // Sélectionne la première valeur par défaut

        Button validateButton = new Button("Valider");
        validateButton.setOnAction(e -> handleValidation());

        this.createStartGameButton();
        vbox = new VBox(choiceBox,this.button);
        vbox.setAlignment(Pos.CENTER);
        this.getChildren().add(vbox);
        // Action à effectuer lors de la sélection d'une option
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Scène lancée avec la valeur " + newValue);
        });

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/turing3.png")));

        BackgroundImage backgroundImage = new BackgroundImage(
                imageView.getImage(),
                BackgroundRepeat.NO_REPEAT,  // Pas de répétition horizontale
                BackgroundRepeat.NO_REPEAT,  // Pas de répétition verticale
                BackgroundPosition.CENTER,   // Positionne l'image au centre
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, false) // Couvre l'écran
        );
        this.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(this, 1300, 1250);
        stage.setScene(scene);
        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            double newHeight = (double) newValue;
            double vboxHeight = newHeight * 0.7; // 30% de la hauteur de la fenêtre
            vbox.setPrefHeight(vboxHeight);
        });
        stage.show();
    }


    /**
     * Creates the Start Game button and displays a welcome message with instructions when the game starts.
     */

    private void createStartGameButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bienvenue");
        alert.setContentText("Pour commencer la partie choisissez un niveau ou lancé une partie au Hasard avec Random");
        alert.showAndWait();
        Button startGameButton = new Button("Start Game");
        startGameButton.setOnAction(event -> {
            if(this.choiceBox.getValue().equals("RANDOM")){
                Random rand = new Random();
                int randomNumber = rand.nextInt(16) + 1; // 0 à 15 + 1
                String random = randomNumber +"";
                int selected = Integer.parseInt(random);
                facade.startNewGame(selected);
                 gameView = new SecondaryStage (this.facade , stage);
                Scene scene = new Scene(gameView,1300,1200);
                gameView.setView(selected);
                this.stage.close();
                stage.setScene(scene);
                stage.show();
            }else {
                int selectedGame = Integer.parseInt(this.choiceBox.getValue());
                facade.startNewGame(selectedGame);
                gameView  = new SecondaryStage(this.facade ,stage);
                Scene scene = new Scene(gameView,1300,1200);
                gameView.setView(selectedGame);
                this.stage.close();
                stage.setScene(scene);
                stage.show();
            } });
         this.button = startGameButton;
    }

    /**
     * Handles the validation action, closing the current window.
     */
    private void handleValidation() {

        this.selectedValue = Integer.parseInt(choiceBox.getValue());
        stage.close(); // Ferme la fenêtre actuelle


    }


}
