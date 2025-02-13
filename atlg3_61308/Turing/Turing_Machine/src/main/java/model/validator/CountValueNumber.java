package model.validator;

import model.Code;

/**
 * This class represents a validator that counts the occurrences of a specific value in a user code
 * and compares it with the occurrences in a secret code.
 */
public class CountValueNumber extends Validator {

    private int number;  // The value to count in the codes.

    /**
     * Constructor for the CountValueNumber class.
     *
     * @param code   The secret code to validate.
     * @param number The value to count in the codes.
     */
    public CountValueNumber(Code code, int number) {
        super(code);
        this.number = number;
    }

    /**
     * Verifies if the count of the specified value in the user code is equal to the count in the secret code.
     *
     * @param utilisateur The user code to validate.
     * @return True if the counts are equal, otherwise false.
     */
    @Override
    public boolean verify(Code utilisateur) {
        int countUser = countValueOccurrences(utilisateur, number);
        int countSecret = countValueOccurrences(secret, number);
        return countUser == countSecret;
    }

    /**
     * Counts the occurrences of the specified value in the given code.
     *
     * @param code   The code to count value occurrences from.
     * @param number The value to count.
     * @return The count of occurrences of the specified value in the code.
     */
    private int countValueOccurrences(Code code, int number) {
        int count = 0;
        if (code.getUnit() == number) {
            count++;
        }
        if (code.getTen() == number) {
            count++;
        }
        if (code.getHundred() == number) {
            count++;
        }
        return count;
    }

    /**
     * Returns a string representation of the CountValueNumber object.
     *
     * @return A string describing the counting operation.
     */
    @Override
    public String toString() {
        return "Count how many times the value " + this.number + " appears in the code: no time, one time, two times, three times";
    }
}
