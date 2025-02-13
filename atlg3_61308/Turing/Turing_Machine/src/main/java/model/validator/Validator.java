package model.validator;

import model.Code;

/**
 * This abstract class serves as a base class for various code validators.
 */
public abstract class Validator {

    /**
     * The secret code used for validation.
     */
    protected Code secret;

    /**
     * The identifier number associated with the validator.
     */
    protected int numero;

    /**
     * Constructor for the Validator class.
     *
     * @param code The secret code to be used for validation.
     */
    public Validator(Code code) {
        this.secret = code;
    }

    /**
     * Abstract method to be implemented by subclasses to provide a string representation of the validator.
     *
     * @return A string describing the validator.
     */
    public abstract String toString();

    /**
     * Abstract method to be implemented by subclasses to verify if a user code meets certain criteria.
     *
     * @param utilisateur The user code to be verified.
     * @return True if the user code meets the criteria, otherwise false.
     */
    public abstract boolean verify(Code utilisateur);
}
