package view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import model.Facade;
import util.Observer;

/**
 * The ButtonGrid class represents the grid of buttons used in the user interface.
 * It allows the selection of digits to form a code.
 */
public class ButtonGrid extends GridPane  {


    private final Button[] selectedButtons = new Button[3];
    private boolean codeEntered = false;

    private int codeUser;

    private Button enterCodeButton;
    private Button verifyCodeButton;

    private Button nextRoundButton;
    private Button quitButton;

    private String buttonStyleNumber;

    /**
     * Creates the button grid with digits, action buttons, and geometric shapes.
     */
    public void createButtonGrid() {


        String buttonStyle = "-fx-font-size: 15px; "
                + "-fx-font-family: 'Times New Roman'; "
                + "-fx-padding: 5px 10px; "
                + "-fx-border-radius: 5px; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-color: #FFFFFF;"; // Remplacez par la couleur de fond souhaitée

         buttonStyleNumber = "-fx-font-size: 25px; "
                + "-fx-text-fill: green; "
                + "-fx-border-radius: 5px; "
                + "-fx-background-radius: 5px; "
                + "-fx-background-color: transparent;"
                + "-fx-font-family: 'VideoGameFont';";


         enterCodeButton = new Button("Enter Code");
         verifyCodeButton = new Button("Verify Code");
         nextRoundButton = new Button("Next Round");
         quitButton = new Button("Quit");

        enterCodeButton.setStyle(buttonStyle);
        verifyCodeButton.setStyle(buttonStyle);
        nextRoundButton.setStyle(buttonStyle);
        quitButton.setStyle(buttonStyle);


        this.setAlignment(Pos.CENTER); // Centrer le contenu du GridPane
        this.setHgap(20); // Espacement horizontal entre les boutons
        this.setVgap(20); // Espacement vertical entre les boutons

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(50.0, 25.0, 75.0, 75.0, 25.0, 75.0);
        triangle.setFill(Color.SKYBLUE);
        Rectangle carre = new Rectangle(50, 50, Color.ORANGE);
        Circle cercle = new Circle(28, Color.PURPLE);


        this.add(triangle,0,0);
        this.add(carre,1,0);
        this.add(cercle,2,0);
        GridPane.setHalignment(triangle, HPos.CENTER);// Centrer chaque bouton horizontalement
        GridPane.setHalignment(carre, HPos.CENTER);// Centrer chaque bouton horizontalement
        GridPane.setHalignment(cercle, HPos.CENTER);// Centrer chaque bouton horizontalement



        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button(String.valueOf(row+1));
                int finalCol = col;
                button.setOnAction(event -> handleButtonSelection(button, finalCol));
                this.add(button, col, row+1);
                GridPane.setHalignment(button, HPos.CENTER);// Centrer chaque bouton horizontalement
                button.setStyle(buttonStyleNumber);
            }

        }


        this.add(enterCodeButton, 1, 6); // Positionner à la colonne 0, ligne 5
        this.add(verifyCodeButton, 4, 0); // Positionner à la colonne 1, ligne 5
        this.add(nextRoundButton, 4, 1); // Positionner à la colonne 2, ligne 6
        this.add(quitButton, 4, 2); // Positionner à la colonne 2, ligne 7

        enterCodeButton.setOnAction(event -> handleEnterCode());
        nextRoundButton.setOnAction(event -> handleNextRound());
    }
    /**
     * Handles the selection of a button in the grid.
     *
     * @param button The button being selected.
     * @param col    The column index of the selected button.
     */
    private void handleButtonSelection(Button button, int col) {
        if (codeEntered) return;

        // Réinitialiser le style du bouton précédemment sélectionné
        if (selectedButtons[col] != null) {
            selectedButtons[col].setStyle(buttonStyleNumber);
            selectedButtons[col].setEffect(null); // Enlever l'ombre si nécessaire
        }

        // Mettre à jour le bouton sélectionné et changer son style
        selectedButtons[col] = button;
        button.setStyle("-fx-background-color: green; "
                + "-fx-text-fill: white; "
                + "-fx-font-size: 25px; " // Ajustez la taille de la police ici
                + "-fx-border-radius: 5px; "
                + "-fx-background-radius: 5px; "
        );

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GREY);
        dropShadow.setRadius(10.0);
        dropShadow.setOffsetX(5.0);
        dropShadow.setOffsetY(5.0);

        button.setEffect(dropShadow);
    }

    /**
     * Handles entering the code based on the selected buttons.
     * Disables number buttons after entering the code.
     */

    protected void handleEnterCode() {
        if (codeEntered) return;
        codeEntered = true;

        StringBuilder selectedButtonsText = new StringBuilder();
        for (Button selectedButton : selectedButtons) {
            if (selectedButton != null) {
                selectedButtonsText.append(selectedButton.getText()).append("");
            }
        }

        codeUser = Integer.parseInt(selectedButtonsText.toString().trim());

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = (Button) this.getChildren().get((row + 1) * 3 + col);
                button.setDisable(true);
            }
        }
    }


    /**
     * Handles moving to the next round.
     * Resets the selected buttons and enables number buttons for the new round.
     */
    public void handleNextRound() {
        codeEntered = false;
        for (int i = 0; i < selectedButtons.length; i++) {
            if (selectedButtons[i] != null) {
                // Réinitialiser le style des chiffres
                selectedButtons[i].setStyle(buttonStyleNumber);
                selectedButtons[i].setEffect(null); // Enlever l'ombre si nécessaire
                selectedButtons[i] = null; // Effacer la référence au bouton sélectionné
            }
        }
        for (int row = 1; row < 6; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = (Button) this.getChildren().get((row) * 3 + col);
                button.setDisable(false);
            }
        }
    }

    /**
     * Gets the "Enter Code" button from the grid.
     *
     * @return The "Enter Code" button.
     */
    public Button getEnterCodeButton() {
        return this.enterCodeButton;
    }

    /**
     * Gets the "Verify Code" button from the grid.
     *
     * @return The "Verify Code" button.
     */
    public Button getVerifyCodeButton() {
        return this.verifyCodeButton;
    }

    /**
     * Gets the user-entered code.
     *
     * @return The user-entered code.
     */
    public int getCodeUser() {
        return codeUser;
    }

    /**
     * Gets the "Next Round" button from the grid.
     *
     * @return The "Next Round" button.
     */
    public Button getNextRoundButton() {
        return this.nextRoundButton;
    }

    /**
     * Gets the "Quit" button from the grid.
     *
     * @return The "Quit" button.
     */
    public Button getQuitButton() {
        return  this.quitButton;
    }


}
