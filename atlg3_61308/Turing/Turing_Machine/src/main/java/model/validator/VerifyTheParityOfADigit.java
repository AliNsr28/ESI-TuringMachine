package model.validator;

import model.Code;
import model.TuringException;

/**
 * This class represents a validator that verifies the parity of a specific digit in a user code
 * and compares it with the parity of the corresponding digit in a secret code.
 */
public class VerifyTheParityOfADigit extends Validator {

    /**
     * The position of the digit to verify (5 for hundred, 6 for ten, 7 for unit).
     */
    private int number;

    /**
     * The digit from the secret code for comparison.
     */
    private int number2;

    /**
     * The digit from the user code for comparison.
     */
    private int number3;

    /**
     * Constructor for the VerifyTheParityOfADigit class.
     *
     * @param number The position of the digit to verify (5 for hundred, 6 for ten, 7 for unit).
     * @param code   The secret code to validate.
     * @throws TuringException if the specified number is not between 5 and 7.
     */
    public VerifyTheParityOfADigit(int number, Code code) {
        super(code);

        if (number < 5 || number > 7) {
            throw new TuringException("The number needs to be between 5 and 7");
        }
        this.number = number;
    }

    /**
     * Verifies the parity of the specified digit in the user code and compares it with the parity
     * of the corresponding digit in the secret code.
     *
     * @param utilisateur The user code to validate.
     * @return True if the parity of the digit matches, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        if (number == 5) {
            number2 = this.secret.getHundred();
            number3 = utilisateur.getHundred();
        }
        if (number == 6) {
            number2 = this.secret.getTen();
            number3 = utilisateur.getTen();
        }
        if (number == 7) {
            number2 = this.secret.getUnit();
            number3 = utilisateur.getUnit();
        }
        return parity(number2, number3);
    }

    /**
     * Checks the parity of two integers.
     *
     * @param secret     The digit from the secret code.
     * @param utilisateur The digit from the user code.
     * @return True if the parity of the digits matches, otherwise false.
     */
    public boolean parity(int secret, int utilisateur) {
        if ((utilisateur % 2) == 0) {
            return (secret % 2) == 0;
        } else {
            return (secret % 2) != 0;
        }
    }

    /**
     * Returns a string representation of the VerifyTheParityOfADigit object.
     *
     * @return A string describing the operation to verify the parity of a specific digit.
     */
    @Override
    public String toString() {
        if (number == 5) {
            return "Verify the parity of the first number if it's even or odd";
        }
        if (number == 6) {
            return "Verify the parity of the second number if it's even or odd";
        } else {
            return "Verify the parity of the third number if it's even or odd";
        }
    }
}

