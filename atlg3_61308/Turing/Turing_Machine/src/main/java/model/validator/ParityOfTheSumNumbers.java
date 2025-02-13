package model.validator;

import model.Code;

/**
 * This class represents a validator that determines if the sum of the numbers in a user code is even or odd
 * and compares it with the parity of the sum in a secret code.
 */
public class ParityOfTheSumNumbers extends Validator {

    /**
     * Constructor for the ParityOfTheSumNumbers class.
     *
     * @param code The secret code to validate.
     */
    public ParityOfTheSumNumbers(Code code) {
        super(code);
    }

    /**
     * Verifies if the sum of the numbers in the user code is even or odd
     * and compares it with the parity of the sum in the secret code.
     *
     * @param utilisateur The user code to validate.
     * @return True if the parity of the sum matches, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        int sumUser = utilisateur.getTen() + utilisateur.getUnit() + utilisateur.getHundred();
        int sumSecret = secret.getTen() + secret.getUnit() + secret.getHundred();

        return (sumUser % 2 == 0) == (sumSecret % 2 == 0);
    }

    /**
     * Returns a string representation of the ParityOfTheSumNumbers object.
     *
     * @return A string describing the operation to determine if the sum of the numbers is even or odd.
     */
    @Override
    public String toString() {
        return "Determine if the sum of the numbers in the code is even or odd";
    }
}
