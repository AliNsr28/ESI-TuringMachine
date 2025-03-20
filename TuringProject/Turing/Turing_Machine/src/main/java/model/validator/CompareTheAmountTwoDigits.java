package model.validator;

import model.Code;

/**
 * This class represents a validator that compares the sum of two digits of a user code with the value 6.
 * The comparison is based on whether the sum is smaller, equal, or larger than 6.
 */
public class CompareTheAmountTwoDigits extends Validator {

    /**
     * Constructor for the CompareTheAmountTwoDigits class.
     *
     * @param code The secret code to validate.
     */
    public CompareTheAmountTwoDigits(Code code) {
        super(code);
    }

    /**
     * Verifies if the sum of the first and second digits of the user code matches the value 6.
     *
     * @param utilisateur The user code to validate.
     * @return True if the sum is equal to 6, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        int sum = utilisateur.getHundred() + utilisateur.getTen();
        int secretSum = this.secret.getHundred() + this.secret.getTen();

        if (sum == 6) {
            return secretSum == 6;
        } else if (sum < 6) {
            return secretSum < 6;
        } else {
            return secretSum > 6;
        }
    }

    /**
     * Returns a string representation of the CompareTheAmountTwoDigits object.
     *
     * @return A string describing the comparison operation.
     */
    @Override
    public String toString() {
        return "Compare the sum of the first and second number in the code with the value 6: if it's smaller, equal, or larger";
    }
}
