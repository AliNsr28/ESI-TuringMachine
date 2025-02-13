package com.example.bmr_61308.model;

import com.example.bmr_61308.util.Observable;
import com.example.bmr_61308.util.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The `Calcul` class represents a calculator for Basal Metabolic Rate (BMR) and Total Daily Caloric Expenditure.
 * It allows users to calculate BMR and daily caloric expenditure based on their weight, height, age, gender, and activity level.
 * This class implements the Observer pattern to notify registered observers when the calculated values change.
 */

public class Calcul implements Observable {

    private double bmr;
    private List<Observer> observers = new ArrayList<>();


    private double cal;


    /**
     * Calculates BMR and total daily caloric expenditure based on user inputs.
     *
     * @param poids  The user's weight in kilograms.
     * @param taille The user's height in centimeters.
     * @param age    The user's age in years.
     * @param sexe   The user's gender ("Homme" for male, otherwise female).
     * @param style  The user's activity level ("Sédentaire," "Peu Actif," "Actif," "Fortement Actif," or "Extremement Actif").
     */

    public void setAll(int poids, int taille, int age, String sexe , String style) {

        if (sexe.equals("Homme")) {
            bmr = 13.7 * poids + 5 * taille - 6.8 * age + 655;
        } else {
            bmr = 9.6 * poids + 1.8 * taille - 4.7 * age + 655;
        }

        switch (style) {
            case "Sédentaire":
                cal = bmr * 1.2;
                break;
            case "Peu Actif":
                cal = bmr * 1.375;
                break;
            case "Actif":
                cal = bmr * 1.55;
                break;
            case "Fortement Actif":
                cal = bmr * 1.725;
                break;
            case "Extremement Actif":
                cal = bmr * 1.9;
                break;
            default:
        }

        notifyObservers();

    }

    /**
     * Returns the calculated Basal Metabolic Rate (BMR).
     *
     * @return The calculated BMR value.
     */

    public double getBmr() {
        return this.bmr;
    }

    /**
     * Returns the calculated total daily caloric expenditure.
     *
     * @return The calculated total daily caloric expenditure (cal).
     */
    public double getCal() {
       return this.cal;
    }

    /**
     * Adds an observer to the list of observers. Observers will be notified when the data changes.
     *
     * @param observer The observer to be added.
     */

    @Override
    public void addObserver(Observer observer) {
        if(!(observers.contains(observer))){
            observers.add(observer);
        }
    }

    /**
     * Currently an empty method. It does not remove observers from the list.
     *
     * @param observer The observer to be removed.
     */

    @Override
    public void removeObserver(Observer observer) {

    }

    /**
     * Notifies all registered observers when the data changes.
     */

    @Override
    public void notifyObservers() {

        for (Observer observer: observers) {
            observer.update();
        }
    }


}



