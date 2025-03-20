package model.validator;

import model.Code;
import model.TuringException;

/**
 * This class represents a validator that compares two digits of a user code with two digits of a secret code.
 * The digits to be compared and the comparison type are specified by a number.
 * Valid values for the number are 11, 12, and 13.
 */
public class CompareTwoDigits extends Validator {

    private int numberValidator;    // The number specifying which digits and how to compare them
    private int first;              // The first digit to compare
    private int second;             // The second digit to compare
    private int third;              // The third digit to compare
    private int fourth;             // The fourth digit to compare

    /**
     * Constructor for the CompareTwoDigits class.
     *
     * @param number The number specifying which digits and how to compare them (11, 12, or 13).
     * @param code   The secret code to validate.
     * @throws TuringException If the specified number is not between 11 and 13.
     */
    public CompareTwoDigits(int number, Code code) throws TuringException {
        super(code);
        if (number < 11 || number > 13) {
            throw new TuringException("The number needs to be between 11 and 13");
        }
        this.numberValidator = number;
    }

    /**
     * Verifies if the specified digits of the user code match the corresponding digits of the secret code.
     *
     * @param utilisateur The user code to validate.
     * @return True if the specified digits match, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        determineDigits(utilisateur, numberValidator);
        return compare(first, second, third, fourth);
    }

    /**
     * Determines which digits to compare based on the specified number.
     *
     * @param user   The user code.
     * @param number The number specifying which digits to compare (11, 12, or 13).
     */
    private void determineDigits(Code user, int number) {
        if (number == 11) {
            first = user.getHundred();
            second = user.getTen();
            third = secret.getHundred();
            fourth = secret.getTen();
        } else if (number == 12) {
            first = user.getHundred();
            second = user.getUnit();
            third = secret.getHundred();
            fourth = secret.getUnit();
        } else if (number == 13) {
            first = user.getTen();
            second = user.getUnit();
            third = secret.getTen();
            fourth = secret.getUnit();
        }
    }

    /**
     * Compares two pairs of digits and returns the result.
     *
     * @param nb1 The first digit from the user code.
     * @param nb2 The second digit from the user code.
     * @param nb3 The third digit from the secret code.
     * @param nb4 The fourth digit from the secret code.
     * @return True if the comparison is successful, otherwise false.
     */
    private boolean compare(int nb1, int nb2, int nb3, int nb4) {
        if (nb1 < nb2) {
            return nb3 < nb4;
        } else if (nb1 == nb2) {
            return nb3 == nb4;
        } else if (nb1 > nb2) {
            return nb3 > nb4;
        }
        return false;
    }

    /**
     * Returns a string representation of the CompareTwoDigits object.
     *
     * @return A string describing the comparison operation.
     */
    @Override
    public String toString() {
        if (numberValidator == 11) {
            return "Compare the first number with the second if it's smaller, equal, or larger";
        } else if (numberValidator == 12) {
            return "Compare the first number with the third if it's smaller, equal, or larger";
        } else {
            return "Compare the second number with the third if it's smaller, equal, or larger";
        }
    }
}


