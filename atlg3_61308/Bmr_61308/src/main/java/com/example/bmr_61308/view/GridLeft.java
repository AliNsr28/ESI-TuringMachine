package com.example.bmr_61308.view;

import javafx.scene.control.*;
import javafx.scene.layout.*;


/**
 * The `GridLeft` class represents the left part of a user interface for a Basal Metabolic Rate (BMR) calculator.
 * It provides input fields for users to enter data such as height, weight, age, gender, and activity level.
 * The class does not implement the Observer pattern.
 */

public class GridLeft extends GridPane  {

    private TextField tailletxt;
    private TextField poidstxt;
    private TextField agetxt;

    private ChoiceBox<String> style_vie;

    private RadioButton sexe_m = new RadioButton("Homme");
    private RadioButton sexe_f = new RadioButton("Femme");

    private ToggleGroup group;



    /**
     * Constructs a new instance of the `GridLeft` class, setting up the layout and adding components.
     */
    public GridLeft() {
        super(2, 6);
        add();
    }

    /**
     * Adds input components to the grid.
     */
    private void add() {
        this.group = new ToggleGroup();
        sexe_m.setToggleGroup(group);
        sexe_f.setToggleGroup(group);
        HBox sexe = new HBox(sexe_m, sexe_f);

        Label donnée = new Label("Données");
        Label taile = new Label("Taille en (cm)");
        Label poids = new Label("Poids en (kg)");
        Label age = new Label("Age (années)");
        Label gendre = new Label("Sexe");
        Label style_de_vie = new Label("Style de vie");

        this.tailletxt = new TextField();
        this.poidstxt = new TextField();
        this.agetxt = new TextField();
        this.style_vie = new ChoiceBox<>();


        this.add(donnée, 0, 0, 1, 1);
        this.add(taile, 0, 1, 1, 1);
        this.add(tailletxt, 1, 1, 1, 1);
        this.add(poids, 0, 2, 1, 1);
        this.add(poidstxt, 1, 2, 1, 1);
        this.add(age, 0, 3, 1, 1);
        this.add(agetxt, 1, 3, 1, 1);
        this.add(gendre, 0, 4, 1, 1);
        this.add(style_de_vie, 0, 5, 1, 1);

        this.style_vie.getItems().addAll(
                LifeStyle.SEDENTAIRE.getDescription(),
                LifeStyle.PEU_ACTIF.getDescription(),
                LifeStyle.ACTIF.getDescription(),
                LifeStyle.FORT_ACTIF.getDescription(),
                LifeStyle.EXTREMENT_ACTIF.getDescription()
        );
        this.add(style_vie, 1, 5, 1, 1);

        this.add(sexe, 1, 4, 1, 1);

        donnée.setUnderline(true);
    }


    /**
     * Returns the `TextField` for entering height.
     *
     * @return The `TextField` for height.
     */

    public TextField getTailletxt() {
        return this.tailletxt;
    }
    /**
     * Returns the `TextField` for entering weight.
     *
     * @return The `TextField` for weight.
     */

    public TextField getPoidstxt() {
        return this.poidstxt;
    }
    /**
     * Returns the `TextField` for entering weight.
     *
     * @return The `TextField` for weight.
     */

    public TextField getAgetxt() {
        return this.agetxt;
    }

    /**
     * Returns the `ChoiceBox` for selecting the user's activity level.
     *
     * @return The `ChoiceBox` for activity level.
     */
    public ChoiceBox<String> getStyle_vie() {
        return this.style_vie;
    }

    /**
     * Returns the selected gender as a string ("Homme" for male, "Femme" for female).
     *
     * @return The selected gender.
     */
    public String getGroupString() {
        if (sexe_f.isSelected()) {
            return "Femme";
        }
        return "Homme";
    }

    /**
     * Returns the `ToggleGroup` for gender selection.
     *
     * @return The `ToggleGroup` for gender selection.
     */
    public ToggleGroup getGroup() {
        return group;
    }


}
