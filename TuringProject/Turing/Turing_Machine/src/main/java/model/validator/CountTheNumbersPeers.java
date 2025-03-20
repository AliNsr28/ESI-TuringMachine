package model.validator;

import model.Code;

/**
 * This class represents a validator that counts the number of even digits in a user code and compares it with
 * the number of even digits in a secret code.
 */
public class CountTheNumbersPeers extends Validator {

    /**
     * Constructor for the CountTheNumbersPeers class.
     *
     * @param code The secret code to validate.
     */
    public CountTheNumbersPeers(Code code) {
        super(code);
    }

    /**
     * Verifies if the count of even digits in the user code is equal to the count of even digits in the secret code.
     *
     * @param user The user code to validate.
     * @return True if the counts are equal, otherwise false.
     */
    @Override
    public boolean verify(Code user) {
        int peerSecret = countEvenDigits(secret);
        int peerUser = countEvenDigits(user);
        return peerUser == peerSecret;
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
     * Returns a string representation of the CountTheNumbersPeers object.
     *
     * @return A string describing the counting operation.
     */
    @Override
    public String toString() {
        return "Count how many numbers in the code are even: No number, 1 number, 2 numbers, 3 numbers";
    }
}
