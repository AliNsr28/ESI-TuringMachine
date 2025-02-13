package com.example.bmr_61308.view;

/**
 * The `LifeStyle` enum represents different levels of activity or lifestyle.
 * It is used to categorize a person's activity level when calculating Basal Metabolic Rate (BMR).
 */
public enum LifeStyle {


    SEDENTAIRE("Sédentaire"),
    PEU_ACTIF("Peu Actif"),
    ACTIF("Actif"),
    FORT_ACTIF("Fortement Actif"),
    EXTREMENT_ACTIF("Extremement Actif");

    private final String description;

    /**
     * Constructs a `LifeStyle` enum with the specified description.
     *
     * @param description The description of the activity level.
     */
    LifeStyle(String description){
        this.description = description;
    }

    /**
     * Returns the description of the activity level.
     *
     * @return The description of the activity level.
     */

    public String getDescription() {
        return description;
    }
}
