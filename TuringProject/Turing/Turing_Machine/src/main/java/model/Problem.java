package model;

import model.validator.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Problem} class represents a problem within the game, containing a code and associated validators.
 * It initializes a code and a list of validators based on the provided parameters.
 *
 * @author Your Name
 * @version 1.0
 */

public class Problem {
 private int num;
 private int difficulty;
 private int luck;
 private Code code;
 private List<Validator> validators;

 private List<Integer> validatorNos;
  private Factory factory;

     // list de round


    /**
     * Constructs a new Problem instance with the specified parameters.
     *
     * @param num           The problem number.
     * @param difficulty    The difficulty level of the problem.
     * @param luck          The luck factor of the problem.
     * @param code          The code associated with the problem.
     * @param validatorNos  The list of validator numbers associated with the problem.
     */
    public Problem(int num, int difficulty, int luck, int code, List<Integer> validatorNos) {
        this.num = num;
        this.difficulty = difficulty;
        this.luck = luck;
        this.code  = new Code(code);
        this.factory = new Factory();
        this.validators = new ArrayList<>();
        this.validatorNos = validatorNos;
        for (int i = 0; i < validatorNos.size() ; i++) {
            Validator validator = factory.addValidator(this.code, validatorNos.get(i));
            this.validators.add(validator);
        }
    }



    /**
     * Gets the code associated with the problem.
     *
     * @return The code.
     */

    public Code getCode() {
        return this.code;
    }

    /**
     * Gets the list of validators associated with the problem.
     *
     * @return The list of validators.
     */
    public List<Validator> getValidators() {
        return this.validators;
    }

    /**
     * Gets the list of validator numbers associated with the problem.
     *
     * @return The list of validator numbers.
     */
    public List<Integer> getValidatorNos() {
        return this.validatorNos;
    }
}
