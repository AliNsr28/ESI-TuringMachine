package model.validator;

import model.Code;

/**
 * This class represents a validator that determines if a number in a user code appears in exactly two instances
 * (but not three) and compares it with the occurrence pattern in a secret code.
 */
public class TwinDigits extends Validator {

    /**
     * Constructor for the TwinDigits class.
     *
     * @param code The secret code to validate.
     */
    public TwinDigits(Code code) {
        super(code);
    }

    /**
     * Verifies if a number in the user code appears in exactly two instances (but not three)
     * and compares it with the occurrence pattern in the secret code.
     *
     * @param utilisateur The user code to validate.
     * @return True if the occurrence pattern matches, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        if (utilisateur.getTen() == utilisateur.getUnit() && utilisateur.getTen() == utilisateur.getHundred()) {
            return true;
        }

        if (((utilisateur.getTen() == utilisateur.getUnit()) && (utilisateur.getTen() != utilisateur.getHundred()))
                || ((utilisateur.getTen() == utilisateur.getHundred()) && (utilisateur.getTen() != utilisateur.getUnit()))
                || ((utilisateur.getUnit() == utilisateur.getHundred()) && (utilisateur.getHundred() != utilisateur.getTen()))) {
            return (((this.secret.getTen() == this.secret.getUnit()) && (this.secret.getTen() != this.secret.getHundred()))
                    || ((this.secret.getTen() == this.secret.getHundred()) && (this.secret.getTen() != this.secret.getUnit()))
                    || ((this.secret.getUnit() == this.secret.getHundred()) && (this.secret.getHundred() != this.secret.getTen())));
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of the TwinDigits object.
     *
     * @return A string describing the operation to determine if a number appears in exactly two instances.
     */
    @Override
    public String toString() {
        return "Determine if a number in the code appears in exactly two instances (but not three): True or false";
    }
}

