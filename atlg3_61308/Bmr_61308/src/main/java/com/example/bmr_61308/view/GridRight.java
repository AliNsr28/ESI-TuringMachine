package com.example.bmr_61308.view;

import com.example.bmr_61308.util.Observer;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


/**
 * The `GridRight` class represents the right part of a user interface for displaying BMR (Basal Metabolic Rate) and Calorie results.
 * It provides text fields for displaying BMR and calorie values, as well as methods for setting and styling the displayed values.
 */
public class GridRight extends GridPane   {

    private TextField bmr_c = new TextField();

    private TextField calorie_c = new TextField();


    /**
     * Constructs a new instance of the `GridRight` class, setting up the layout and adding components.
     */
    public GridRight() {
        super(2, 6);
        add();
    }


    /**
     * Adds the components for displaying results to the grid.
     */

    private void add() {
        Label result = new Label("Résultats");
        result.setUnderline(true);
        Label bmr = new Label("BMR");
        Label calorie = new Label("Calories");

        bmr_c.setEditable(false);
        calorie_c.setEditable(false);


        this.add(result, 0, 0, 1, 1);
        this.add(bmr, 0, 1, 1, 1);
        this.add(bmr_c, 1, 1, 1, 1);
        this.add(calorie, 0, 2, 1, 1);
        this.add(calorie_c, 1, 2, 1, 1);


    }

    /**
     * Sets the BMR value in the BMR text field.
     *
     * @param bmr_c The BMR value to set.
     */

    public void setBmr_c(String bmr_c) {
        this.bmr_c.setText(bmr_c);

    }

    /**
     * Sets the calorie value in the calorie text field.
     *
     * @param calorie_c The calorie value to set.
     */
    public void setCalorie_c(String calorie_c) {
        this.calorie_c.setText(calorie_c);
    }

    /**
     * Sets the BMR and calorie fields to indicate a failed calculation (in red).
     */
    public void setFailed(){
       bmr_c.setStyle("-fx-text-fill: red;");
       bmr_c.setText("Failed");
       this.calorie_c.setStyle("-fx-text-fill: red;");
       this.calorie_c.setText("Failed");

    }

    /**
     * Sets the text color of the BMR and calorie fields to black.
     */
    public void setColor(){
        this.bmr_c.setStyle("-fx-text-fill: black;");
        this.calorie_c.setStyle("-fx-text-fill: black;");
    }


}
