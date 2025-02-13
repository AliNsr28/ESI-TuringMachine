package model.validator;

import model.Code;

/**
 * This class represents a validator that determines if the three numbers in a user code are in ascending or descending order
 * and compares it with the order of numbers in a secret code.
 */
public class OrderOfNumbers extends Validator {

    /**
     * Constructor for the OrderOfNumbers class.
     *
     * @param code The secret code to validate.
     */
    public OrderOfNumbers(Code code) {
        super(code);
    }

    /**
     * Verifies if the three numbers in the user code are in ascending or descending order
     * and compares it with the order of numbers in the secret code.
     *
     * @param utilisateur The user code to validate.
     * @return True if the order of numbers matches, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        if ((utilisateur.getUnit() < utilisateur.getTen()) && (utilisateur.getTen() < utilisateur.getHundred())) {
            return (this.secret.getUnit() < this.secret.getTen()) && (this.secret.getTen() < this.secret.getHundred());
        }

        if ((utilisateur.getUnit() > utilisateur.getTen()) && (utilisateur.getTen() > utilisateur.getHundred())) {
            return ((this.secret.getUnit() > this.secret.getTen()) && (this.secret.getTen() > this.secret.getHundred()));
        }

        if ((utilisateur.getUnit() == utilisateur.getTen()) && (utilisateur.getTen() == utilisateur.getHundred())) {
            return ((this.secret.getUnit() == this.secret.getTen()) == (this.secret.getTen() == this.secret.getHundred()));
        }

        if ((utilisateur.getUnit() > utilisateur.getTen()) && (utilisateur.getTen() < utilisateur.getHundred())) {
            return ((this.secret.getUnit() > this.secret.getTen()) && (this.secret.getTen() < this.secret.getHundred()));
        }

        if ((utilisateur.getUnit() < utilisateur.getTen()) && (utilisateur.getTen() > utilisateur.getHundred())) {
            return ((this.secret.getUnit() < this.secret.getTen()) && (this.secret.getTen() > this.secret.getHundred()));
        }

        if ((utilisateur.getUnit() > utilisateur.getTen()) && (utilisateur.getTen() < utilisateur.getHundred())) {
            return ((this.secret.getUnit() > this.secret.getTen()) && (this.secret.getTen() > this.secret.getHundred()));
        }

        return false;
    }

    /**
     * Returns a string representation of the OrderOfNumbers object.
     *
     * @return A string describing the operation to determine if the three numbers are in order.
     */
    @Override
    public String toString() {
        return "Determine if the three numbers in the code are in ascending or descending order: Increasing, Decreasing, or None";
    }
}



