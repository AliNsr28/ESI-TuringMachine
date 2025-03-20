package model;

import javafx.scene.control.Tab;
import model.validator.Validator;

import java.util.*;

/**
 * The {@code Round} class represents a round in the game, including user input, validators, and round statistics.
 * It allows testing and managing validators during the round.
 *
 * @author Your Name
 * @version 1.0
 */
public class Round {

    private int number; //Number of round

    private Code user = null;

    private List <Validator> Goodvalidators;

    private List <Validator> validators;

    private List <Validator> Badvalidators;

    private Tab [] validatorStatut;

    private int score;

    /**
     * Constructs a new Round instance.
     */
    public Round() {
        this.Goodvalidators = new ArrayList<>();
        this.number = 0;
        this.validators = new ArrayList<>();
        this.Badvalidators = new ArrayList<>();
        this.score = 0;

    }


    /**
     * Tests a validator during the round and updates the validator status accordingly.
     *
     * @param validator The validator to test.
     * @throws TuringException if the maximum number of validators is reached.
     */
    public void testValidator(Validator validator){
        if(number == 3){
            throw new TuringException("You can use only 3 validator in 1 round");
        }

        if(!(validator.verify(user))){
            Badvalidators.add(validator);
            System.out.println("The validator is not ok");
            number++;
            score++;

        }
        else{
            Goodvalidators.add(validator);
            number++;
            System.out.println("The validator is ok");
        }
    }

    /**
     * Untests a validator, removing it from the goodValidators list.
     *
     * @param validator The validator to untest.
     * @throws TuringException if the validator was not previously marked as good.
     */
    public void unTestValidator(Validator validator) {
        if (number != 0) {
            number--;
            if (Goodvalidators.contains(validator)) {
                Goodvalidators.remove(validator);
            }
            else if(Badvalidators.contains(validator)) {
                Badvalidators.remove(validator);
            }
            else {
                throw new TuringException("the Validator was not tested");
            }


            score--;
        }
    }


    /**
     * Prints the details of the validators associated with the round.
     */

    public void toStringValidators (){
        for (int i = 0; i < validators.size(); i++) {
            System.out.print(i+") ");
            System.out.println(validators.get(i).toString());
        }

    }

    /**
     * Sets the validators for the round and initializes their status tabs.
     *
     * @param validators The list of validators to set.
     */

    public void addValidators(List <Validator> validators){
        this.validators = validators;
        this.validatorStatut = new Tab[validators.size()];
        for (int i = 0; i < validators.size(); i++) {
            validatorStatut[i] = null;
        }
    }

    /**
     * Gets the list of good validators during the round.
     *
     * @return The list of good validators.
     */
    public List<Validator> getGoodvalidators() {
        return Collections.unmodifiableList(Goodvalidators);
    }

    /**
     * Gets the list of bad validators during the round.
     *
     * @return The list of bad validators.
     */
    public List<Validator> getBadvalidators() {
        return Collections.unmodifiableList(this.Badvalidators);
    }

    /**
     * Gets the list of all validators associated with the round.
     *
     * @return The list of validators.
     */
    public List<Validator> getValidators() {
        return this.validators;
    }

    /**
     * Gets the number of the validatorTested.
     *
     * @return The number of validatorTested.
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Sets the user input for the round.
     *
     * @param user The user input code.
     */
    public void setUser(Code user) {
        this.user = user;
    }


}


