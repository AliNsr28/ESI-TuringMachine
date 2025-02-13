package view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Code;
import model.Facade;
import model.TuringException;
import util.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * The SecondaryStage class represents the secondary stage of the Turing Machine game.
 * It contains the main gameplay elements, including the button grid, cards grid, and various labels.
 * The class handles user interactions, updates, and provides a visual representation of the game.
 */

public class SecondaryStage extends VBox implements Observer {

    private ButtonGrid buttonGrid = new ButtonGrid();

    private CardsGrid cardsGrid;

    private Facade facade;

    private int number;

    private Stage stage;

    private Label label_Update;

    private Label label_info;

    private Label label_error;

    private Label history;


    private PrimaryStage primaryStage;
    private int score = 0;



    /**
     * Constructs a SecondaryStage with the specified facade and stage.
     *
     * @param facade The facade object for interaction with the game.
     * @param stage  The secondary stage for the game.
     */

    public SecondaryStage(Facade facade , Stage stage) {
        this.facade = facade;
        this.stage = stage;
        this.cardsGrid = new CardsGrid(this.facade);

    }


    /**
     * Sets up the view for the game with the specified game level.
     *
     * @param nbr The game level.
     */
    public void setView(int nbr) {

        try {

            this.number = nbr;
            buttonGrid.createButtonGrid();
            HBox mainBox = new HBox(150); // Espacement entre les éléments de HBox
            mainBox.setAlignment(Pos.CENTER); // Centrer les éléments dans le HBox

            label_Update = new Label();
            label_Update.setPrefWidth(600);
            label_Update.setPrefHeight(200);
            label_Update.setAlignment(Pos.CENTER);

            label_info = new Label();
            label_info.setPrefWidth(600);
            label_info.setPrefHeight(200);
            label_info.setAlignment(Pos.CENTER);
            label_info.setText("Undo : Control + Z " +
                    "\nRedo: Control + Y"+
                    "\nClick on the letter for the validator");
            String labelStyle =
                    "-fx-font-size: 20px; " // Ajustez la taille de la police ici
                            + "-fx-text-fill: green;"
                            +"-fx-font-family: Comic Sans MS"; // Couleur du texte


            label_info.setStyle(labelStyle);

            label_error = new Label();
            label_error.setPrefWidth(600);
            label_error.setPrefHeight(200);
            label_error.setAlignment(Pos.CENTER);

            VBox vbox_label = new VBox(label_info,label_Update,label_error);

            mainBox.getChildren().addAll(buttonGrid,vbox_label);
            mainBox.setSpacing(50.0);


            this.facade.startNewGame(number);
            cardsGrid.addCards();


            this.getChildren().add(cardsGrid);
            this.getChildren().add(mainBox);
            this.setSpacing(50);
            ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/white.jpeg")));

            BackgroundImage backgroundImage = new BackgroundImage(
                    imageView.getImage(),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true) // Couvre l'écran
            );
            this.setBackground(new Background(backgroundImage));

            this.buttonGrid.getEnterCodeButton().setOnAction(event -> {
                buttonGrid.handleEnterCode();
                Code code = new Code(buttonGrid.getCodeUser());
                System.out.println(code.getCode());
                facade.enterCode(code);
                facade.getGame().getRound().setUser(code);
                update();
            });

            this.buttonGrid.getScene().setOnKeyPressed(event -> {

                if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                    try {
                        facade.undo();

                    }
                    catch (TuringException e){
                        label_error.setText(e.getMessage());

                        label_error.setStyle(labelStyle);
                    }
                    update();
                }

                if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                    try {
                        facade.redo();

                    }
                    catch (TuringException e){
                        label_error.setText(e.getMessage());

                        label_error.setStyle(labelStyle);
                    }
                    update();
                }
            });

            this.buttonGrid.getQuitButton().setOnAction(event -> {
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Confirmation");
                confirmationAlert.setHeaderText("Lancer une nouvelle partie");
                confirmationAlert.setContentText("Voulez vous lancer une nouvelle partie?");
                confirmationAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
                ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);
                if (result == ButtonType.YES) {
                    handleBack();
                    //handleHistory();

                }else {
                    stage.close();
                }
            });

            this.buttonGrid.getNextRoundButton().setOnAction((event -> {
                buttonGrid.handleNextRound();
                facade.getGame().getRound().setUser(facade.getGame().getUser());
                facade.nextRound();
                update();
            }));

            this.buttonGrid.getVerifyCodeButton().setOnAction(event -> {
                try {
                facade.getGame().verificationCode(facade.getGame().getUser());

                }
                catch (TuringException e){
                    label_error.setText(e.getMessage());
                    label_error.setStyle(labelStyle);
                }
                if (facade.getGame().isFind()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Vous avez Gagné et trouver le Code secret");
                    alert.setContentText("Vous avez Gagné et trouver le Code secret");
                    alert.showAndWait();


                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Vous avez Perdu");
                    alert.showAndWait();

                }

                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Confirmation");
                confirmationAlert.setHeaderText("Lancer une nouvelle partie");
                confirmationAlert.setContentText("Voulez vous lancer une nouvelle partie?");
                confirmationAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
                ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);

                if (result == ButtonType.YES) {
                    handleBack();
                }else {
                    stage.close();
                }

            });

            //Pour les robots
            for (int i = 0; i < cardsGrid.getButtons().length; i++) {
                int index = i;

                    cardsGrid.getButtons()[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                           public void handle(MouseEvent event) { try {
                               ;
                               facade.selectValidateur(index);
                               score++;
                               update();
                           }catch (TuringException e){
                               label_error.setText(String.valueOf(e.getMessage()));
                               String labelStyle =
                                       "-fx-font-size: 20px; " // Ajustez la taille de la police ici
                                               + "-fx-text-fill: green;"
                                               +"-fx-font-family: Comic Sans MS"; // Couleur du texte

                               label_error.setStyle(labelStyle);
                               System.out.println(e.getMessage());
                        }

                }});

            }

        }
        catch (TuringException e ){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This is methode is called if I want restart a game
     */

    private void handleBack() {
        Stage facadeStage = new Stage();
        this.primaryStage = new PrimaryStage(facade, facadeStage);
        primaryStage.setupScene();
        Stage currentStage = (Stage) getScene().getWindow();
        currentStage.close();
    }

    /*
    private void handleHistory(){
        history = new Label();
        facade.getHistorique();
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : facade.getHistorique()) {
            stringBuilder.append(element).append("\n");
        }
        history.setText(stringBuilder.toString());
        Scene scene = new Scene(history,1200,1222);
        Stage stage1 = new Stage();
        Stage currentStage = (Stage) getScene().getWindow();
        currentStage.close();

        stage1.setScene(scene);
        stage1.show();

    }

     */

    /**
     * This method is called to update the visual representation of the game.
     * It updates the cards grid, displays round information, user code, and score.
     */

    @Override
    public void update() {
        cardsGrid.update();
        label_Update.setText("ROUND :  " + facade.getNumberRound()
                +"\nYour Code is :  " + facade.getGame().getUser().getCode()
                +"\nYour score is : " + (this.score + this.facade.getCommandManager().getScore())
                );
        String labelStyle =
                "-fx-font-size: 20px; " // Ajustez la taille de la police ici
                + "-fx-text-fill: green;"
                +"-fx-font-family: Comic Sans MS"; // Couleur du texte

        label_Update.setStyle(labelStyle);
        label_error.setText("");

    }

}

