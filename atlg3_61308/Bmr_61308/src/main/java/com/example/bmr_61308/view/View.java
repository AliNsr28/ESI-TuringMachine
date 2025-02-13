package com.example.bmr_61308.view;

import com.example.bmr_61308.model.Calcul;
import com.example.bmr_61308.model.Calcul;
import com.example.bmr_61308.util.Observer;
import com.example.bmr_61308.view.GridLeft;
import com.example.bmr_61308.view.GridRight;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.*;



/**
 * The `View` class represents the user interface for a Basal Metabolic Rate (BMR) calculator application.
 * It provides a graphical user interface (GUI) that allows users to input their information and view BMR and calorie results.
 * This class also implements the Observer pattern to observe changes in the calculation results.
 */

public class View extends Parent implements Observer {

    private GridLeft gridLeft;
    private GridRight gridRight;
    private Calcul calcul;
    private VBox vbox;

    Text failed = new Text();

    /**
     * Initializes and displays the BMR calculator user interface.
     *
     * @param stage The main stage for the application.
     */

    public void display(Stage stage){


        gridLeft = new GridLeft();

        gridRight = new GridRight();

        calcul = new Calcul();

        failed = new Text("Failed");

        failed.setFill(Color.RED);

        calcul.addObserver(this);

        Menu fileMenu = new Menu("Fichier");

        MenuItem exitItem = new MenuItem("Quitter");

        MenuBar menuBar = new MenuBar();

        fileMenu.getItems().add(exitItem);

        menuBar.getMenus().add(fileMenu);

        Button bmr = new Button("Calcul du Bmr");

        Button clear = new Button("Clear");

        stage.setTitle("BMR!");


        HBox hbox = new HBox(gridLeft,gridRight);
        vbox = new VBox(menuBar,hbox,bmr,clear);
        vbox.setSpacing(10);
        HBox.setHgrow(hbox, javafx.scene.layout.Priority.ALWAYS);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);



        bmr.setMaxWidth(Double.MAX_VALUE);

        clear.setMaxWidth(Double.MAX_VALUE);

        bmr.setOnAction(e ->{

            String agetxt = gridLeft.getAgetxt().getText();

            String tailletxt = gridLeft.getTailletxt().getText();

            String poidstxt = gridLeft.getPoidstxt().getText();

            String sexe = gridLeft.getGroupString();

            String style = gridLeft.getStyle_vie().getValue();

            if(agetxt.isEmpty() || tailletxt.isEmpty() || poidstxt .isEmpty() || style == null){
                gridRight.setFailed();

                return;
            }

            int age = Integer.parseInt(gridLeft.getAgetxt().getText());

            int taille = Integer.parseInt(gridLeft.getTailletxt().getText());

            int poids = Integer.parseInt(gridLeft.getPoidstxt().getText());

            if(age == 0 || taille == 0 || poids== 0 ){
                ShowErrorDialog("Les Valeurs rentrée ne peuvent pas être égale à 0");
                return;
            }

            gridRight.setColor();
            calcul.setAll(poids,taille,age,sexe,style);

        });

        clear.setOnAction(e -> {
            gridRight.setCalorie_c("");
            gridRight.setBmr_c("");
            gridLeft.getTailletxt().setText("");
            gridLeft.getAgetxt().setText("");
            gridLeft.getPoidstxt().setText("");
            gridLeft.getGroup().selectToggle(null);
            gridLeft.getStyle_vie().setValue(null);

        });

        exitItem.setOnAction(e -> {
            stage.close();
        });

    }

    /**
     * Displays an error dialog with the specified message.
     *
     * @param message The error message to display in the dialog.
     */
    private void ShowErrorDialog(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Gets the main layout container (VBox) of the user interface.
     *
     * @return The main layout container.
     */

    public VBox getVbox() {
        return vbox;
    }

    @Override
    public void update() {
        gridRight.setBmr_c(Double.toString(calcul.getBmr()));
        gridRight.setCalorie_c(Double.toString(calcul.getCal()));
    }


}