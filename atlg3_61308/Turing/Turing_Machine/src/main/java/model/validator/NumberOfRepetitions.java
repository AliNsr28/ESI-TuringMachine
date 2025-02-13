package model.validator;

import model.Code;

/**
 * This class represents a validator that determines if a number in a user code repeats
 * and compares it with the repetition pattern in a secret code.
 */
public class NumberOfRepetitions extends Validator {

    /**
     * Constructor for the NumberOfRepetitions class.
     *
     * @param code The secret code to validate.
     */
    public NumberOfRepetitions(Code code) {
        super(code);
    }

    /**
     * Verifies if a number in the user code repeats and compares it with the repetition pattern in the secret code.
     *
     * @param utilisateur The user code to validate.
     * @return True if the repetition pattern matches, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        if ((utilisateur.getTen() == utilisateur.getUnit()) && (utilisateur.getHundred() == utilisateur.getUnit())) {
            return (this.secret.getTen() == this.secret.getUnit()) && (this.secret.getHundred() == this.secret.getUnit());
        } else if ((utilisateur.getTen() == utilisateur.getUnit()) || (utilisateur.getHundred() == utilisateur.getUnit()) || (utilisateur.getTen() == utilisateur.getHundred())) {
            return ((this.secret.getTen() == this.secret.getUnit()) || (this.secret.getHundred() == this.secret.getUnit()) || this.secret.getTen() == this.secret.getHundred());
        } else if (utilisateur.getTen() != utilisateur.getUnit() && utilisateur.getUnit() != utilisateur.getHundred() && utilisateur.getHundred() != utilisateur.getTen()) {
            return (this.secret.getTen() != this.secret.getUnit() && this.secret.getUnit() != this.secret.getHundred() && this.secret.getHundred() != this.secret.getTen());
        }
        return true;
    }

    /**
     * Returns a string representation of the NumberOfRepetitions object.
     *
     * @return A string describing the operation to determine if a number repeats.
     */
    @Override
    public String toString() {
        return "Determine if a number in the code repeats, and if so, how many times: No duplicate, Two duplicates, Three duplicates";
    }
}

