package model.validator;

import model.Code;

/**
 * This class represents a validator that determines the extreme figure (smallest or greatest) in a user code
 * and compares it with the extreme figure in a secret code.
 */
public class ExtremeFigure extends Validator {

    private boolean verif;  // Indicates whether to find the smallest or greatest figure.

    /**
     * Constructor for the ExtremeFigure class.
     *
     * @param code  The secret code to validate.
     * @param verif Indicates whether to find the smallest or greatest figure.
     */
    public ExtremeFigure(Code code, boolean verif) {
        super(code);
        this.verif = verif;
    }

    /**
     * Verifies if the extreme figure in the user code matches the extreme figure in the secret code.
     *
     * @param utilisateur The user code to validate.
     * @return True if the extreme figures match, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        if (verif) {
            return findSmallestFigure(utilisateur) == findSmallestFigure(secret);
        } else {
            return findGreatestFigure(utilisateur) == findGreatestFigure(secret);
        }
    }

    /**
     * Finds the smallest figure in the given code.
     *
     * @param code The code to find the smallest figure from.
     * @return The smallest figure in the code.
     */
    private int findSmallestFigure(Code code) {
        return Math.min(Math.min(code.getUnit(), code.getTen()), code.getHundred());
    }

    /**
     * Finds the greatest figure in the given code.
     *
     * @param code The code to find the greatest figure from.
     * @return The greatest figure in the code.
     */
    private int findGreatestFigure(Code code) {
        return Math.max(Math.max(code.getUnit(), code.getTen()), code.getHundred());
    }

    /**
     * Returns a string representation of the ExtremeFigure object.
     *
     * @return A string describing the operation to determine the extreme figure.
     */
    @Override
    public String toString() {
        if (verif) {
            return "Determine which number is strictly the smallest: no number, the first one, the second one, the third one";
        } else {
            return "Determine which number is strictly the greatest: no number, the first one, the second one, the third one";
        }
    }
}
