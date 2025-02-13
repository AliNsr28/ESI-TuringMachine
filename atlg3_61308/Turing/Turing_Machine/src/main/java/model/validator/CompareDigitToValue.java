package model.validator;

import model.Code;

/**
 * This class represents a validator that compares a digit of a user code with a given value.
 * The comparison can be based on the first or second digit of the code, depending on the specified configuration.
 */
public class CompareDigitToValue extends Validator {

    private int value;          // The comparison value
    private boolean verif;      // Indicates whether the comparison should be done with the first or second digit

    /**
     * Constructor for the CompareDigitToValue class.
     *
     * @param secret    The secret code to validate.
     * @param value     The comparison value.
     * @param verif     Indicates whether the comparison should be done with the first or second digit.
     */
    public CompareDigitToValue(Code secret, int value, boolean verif) {
        super(secret);
        this.value = value;
        this.verif = verif;
    }

    /**
     * Checks if the specified digit of the user code matches the comparison value.
     *
     * @param utilisateur   The user code to validate.
     * @return              True if the comparison is successful, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        return compareDigits(this.secret, utilisateur, value, verif);
    }

    /**
     * Performs the comparison between the specified digit of the user code and the comparison value.
     *
     * @param secret    The secret code.
     * @param utilisateur   The user code.
     * @param value     The comparison value.
     * @param verif     Indicates whether the comparison should be done with the first or second digit.
     * @return          True if the comparison is successful, otherwise false.
     */
    private boolean compareDigits(Code secret, Code utilisateur, int value, boolean verif) {
        if (verif) {
            if (utilisateur.getHundred() == value) {
                return secret.getHundred() == value;
            } else if (utilisateur.getHundred() > value) {
                return secret.getHundred() > value;
            } else {
                return secret.getHundred() < value;
            }
        } else {
            if (utilisateur.getTen() == value) {
                return secret.getTen() == value;
            } else if (utilisateur.getTen() > value) {
                return secret.getTen() > value;
            } else {
                return secret.getTen() < value;
            }
        }
    }

    /**
     * Returns a string representation of the CompareDigitToValue object.
     *
     * @return  A string describing the comparison operation.
     */
    @Override
    public String toString() {
        if (verif) {
            return "Compare the first number with " + this.numero + "If it's smaller, equal or larger";
        } else {
            return "Compare the second number with " + this.numero + "If it's smaller, equal or larger";
        }
    }
}
