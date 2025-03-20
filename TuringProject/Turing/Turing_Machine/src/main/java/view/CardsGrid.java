package view;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.robot.Robot;
import model.Facade;
import model.Game;
import model.Round;
import util.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * The CardsGrid class represents the grid of cards containing images and buttons.
 * It displays the cards representing the validators in the game.
 * Each card consists of an image of the validator card, an image of a robot, and a letter button.
 * The class is an observer and updates the visual representation of the cards based on the game state.
 */
public class CardsGrid extends HBox implements Observer {

    private List<Integer> validatorIndex;

    private Button[] buttons;

    private Facade facade;


    /**
     * Constructs a CardsGrid with the specified facade.
     *
     * @param facade The facade object for interaction with the game.
     */
    public CardsGrid(Facade facade) {
        this.facade = facade;

    }

    /**
     * Adds cards to the grid based on the validator indices.
     * Each card includes an image of the validator card, an image of a robot, and a letter button.
     * The images and buttons are arranged in a grid layout.
     */
    public void addCards() {
        this.validatorIndex = facade.getGame().getProblemos().getValidatorNos();
        this.buttons = new Button[validatorIndex.size()];
        this.setSpacing(20);

        for (int i = 0; i < validatorIndex.size(); i++) {
            Image Cardimg = new Image("/TuringMachine-assets-20231127/card" + validatorIndex.get(i) + ".png");
            ImageView cardImage = new ImageView(Cardimg);
            cardImage.setFitWidth(200); // Ajustez selon vos besoins
            cardImage.setPreserveRatio(true);

            char letter = (char) ('A' + i); // A, B, C, etc.
            Image Robotimg = new Image("/TuringMachine-assets-20231127/robot" + letter + ".png");
            ImageView robotImage = new ImageView(Robotimg);
            robotImage.setFitWidth(100); // Ajustez selon vos besoins
            robotImage.setPreserveRatio(true);


            //Grid pane qui v'as rassembler tout les élèments
            GridPane gridPane = new GridPane();
            gridPane.add(cardImage, 0, 0); // Ajout de l'image de la carte en position (0, 0)
            GridPane.setHalignment(robotImage, HPos.CENTER); // Centre horizontalement l'image du robot
            gridPane.add(robotImage, 0, 1); // Ajout de l'image du robot en position (0, 1)


            //Boutons en dessous des mes robots
            Button letterButton = new Button(String.valueOf(letter));
            this.buttons[i] = letterButton;
            gridPane.add(letterButton, 0, 2); // Ajout du bouton en position (0, 2)
            GridPane.setHalignment(letterButton, HPos.CENTER);
            letterButton.setStyle("-fx-background-color: transparent; " +
                    "-fx-font-size: 20px; " +
                    "-fx-font-family: 'Comic Sans MS';"); // Remplacez 'Comic Sans MS' par la police souhaitée

            this.getChildren().add(gridPane); // Ajoute le GridPane à l'HBox
        }

        this.setAlignment(Pos.CENTER);
    }


    /**
     * Gets the array of letter buttons.
     *
     * @return The array of letter buttons.
     */
    public Button[] getButtons() {
        return this.buttons;
    }

    /**
     * Updates the visual representation of the cards based on the game state.
     * Highlights the cards with different colors based on correct and incorrect validations.
     */

    @Override
    public void update() {
        for (int i = 0; i < facade.getGame().getRound().getValidators().size(); i++) {
            if (facade.getGame().getRound().getGoodvalidators().contains(facade.getGame().getRound().getValidators().get(i))) {
                this.getChildren().get(i).setStyle("-fx-background-color: rgb(144, 238, 144)");


            } else if (facade.getGame().getRound().getBadvalidators().contains(facade.getGame().getRound().getValidators().get(i)) ){
                this.getChildren().get(i).setStyle("-fx-background-color: rgb(250, 30, 0)");

            }else{
                this.getChildren().get(i).setStyle("-fx-background-color: transparent;");
            }
        }
    }
}

