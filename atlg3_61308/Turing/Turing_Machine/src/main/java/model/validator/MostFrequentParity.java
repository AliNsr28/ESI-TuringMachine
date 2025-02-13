package model.validator;

import model.Code;

/**
 * This class represents a validator that determines if there are more even or odd numbers in a user code
 * and compares it with the parity distribution in a secret code.
 */
public class MostFrequentParity extends Validator {

    /**
     * Constructor for the MostFrequentParity class.
     *
     * @param code The secret code to validate.
     */
    public MostFrequentParity(Code code) {
        super(code);
    }

    /**
     * Verifies if there is a majority of even or odd numbers in the user code compared to the secret code.
     *
     * @param user The user code to validate.
     * @return True if the parity distribution matches, otherwise false.
     */
    @Override
    public boolean verify(Code user) {
        int evenCountUser = countEvenDigits(user);
        int evenCountSecret = countEvenDigits(secret);

        if (evenCountUser > 1 && evenCountSecret > 1) {
            return true; // Both have a majority of even numbers
        } else if (evenCountUser < 2 && evenCountSecret < 2) {
            return true; // Both have a majority of odd numbers
        }

        return false;
    }

    /**
     * Counts the number of even digits in the given code.
     *
     * @param code The code to count even digits from.
     * @return The count of even digits in the code.
     */
    private int countEvenDigits(Code code) {
        int count = 0;
        if (code.getUnit() % 2 == 0) {
            count++;
        }
        if (code.getTen() % 2 == 0) {
            count++;
        }
        if (code.getHundred() % 2 == 0) {
            count++;
        }
        return count;
    }

    /**
     * Returns a string representation of the MostFrequentParity object.
     *
     * @return A string describing the operation to determine the parity majority.
     */
    @Override
    public String toString() {
        return "Determine if there are more even or odd numbers in the code: Odd majority or Even majority";
    }
}
