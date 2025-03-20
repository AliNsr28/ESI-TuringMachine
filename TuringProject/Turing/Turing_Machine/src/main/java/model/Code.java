package model;

/**
 * The {@code Code} class represents a three-digit code used in the game.
 * The code is composed of three digits where each digit ranges from 1 to 5.
 * This class provides methods to retrieve individual digits and the complete code.
 *
 * @author Your Name
 * @version 1.0
 */

public class Code {

    /** The three-digit code. */
    protected int code;

    /**
     * Constructs a Code object with the specified three-digit code.
     *
     * @param code The three-digit code, where each digit must be between 1 and 5.
     * @throws TuringException If the provided code does not meet the specified criteria.
     */
    public Code(int code) {
        if (code / 100 == 0 || code / 100 > 5 || ((code / 10) % 10) == 0 || ((code / 10) % 10) > 5 || code % 10 == 0 || code % 10 > 5) {
            throw new TuringException("The code must be >100 and <550");
        }
        if (code < 100 || code > 555) throw new TuringException("The code must be >100 and <550");
        this.code = code;
    }

    /**
     * Gets the complete three-digit code.
     *
     * @return The three-digit code.
     */
    public int getCode() {

        return code;
    }

    /**
     * Gets the digit in the hundreds place of the code.
     *
     * @return The digit in the hundreds place.
     */
    public int getHundred() {
        return (code / 100);
    }

    /**
     * Gets the digit in the tens place of the code.
     *
     * @return The digit in the tens place.
     */
    public int getTen() {
        return (code / 10) % 10;
    }

    /**
     * Gets the digit in the units place of the code.
     *
     * @return The digit in the units place.
     */
    public int getUnit() {
        return code % 10;
    }
}

