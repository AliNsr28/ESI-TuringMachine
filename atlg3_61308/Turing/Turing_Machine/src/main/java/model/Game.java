package model;

import javafx.scene.layout.Background;
import model.validator.Validator;
import util.CSVReader;
import util.Observable;
import util.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Game} class represents the main game model, managing rounds, codes, and problems.
 * It provides methods to add codes, start the game, perform code verifications, and manage rounds.
 *
 * @author Your Name
 * @version 1.0
 */
public class Game   {
    private List <Round> rounds = new ArrayList<>();

    private boolean find;
    private boolean quit;
    private int roundNumber;
    private Problem problemos;
    private Code user;

    /**
     * Constructs a new Game instance.
     * Initializes the game with the first round.
     */

    public Game() {
        this.find = false;
        this.roundNumber =0;
        this.rounds.add(new Round());
    }



    /**
     * Adds a code to the game.
     *
     * @param code The code to be added.
     * @throws TuringException If the code is not within the valid range (100 to 555).
     */
    public void addCode(Code code){
        if(code.getCode() < 100 || code.getCode() > 555){
            throw new TuringException("Code need to be inside 100 and 555");
        }
        else{
            this.user = code;
        }
    }

    /**
     * Removes the user's code from the game.
     */
    public void removeCode(){
        this.user = null;
    }

    /**
     * Verifies the user's code against the problem code.
     *
     * @param utilisateur The user's code to be verified.
     */
    public void verificationCode(Code utilisateur){
        if(utilisateur == null){
            throw new TuringException("The code is null");
        }
        if(utilisateur.getCode() == this.problemos.getCode().getCode()){
            find = true;
        }
    }

    /**
     * Starts a new game round based on the specified CSVReader and problem index.
     *
     * @param csvReader The CSVReader to retrieve problems from.
     * @param index     The index of the problem to use.
     */
    public void startGame(CSVReader csvReader , int index){
        if(index < 1 || index > 16 ){
            throw new TuringException("the index need to be between 1 and 16");
        }
        this.rounds.get(0).setUser(user);
        this.quit = false;
        problemos = csvReader.getProblems().get(index-1);
        this.rounds.get(0).addValidators(problemos.getValidators());
    }

    /**
     * Adds a new round to the game.
     */
    public void addRound(){
        Round round = new Round();
        this.rounds.add(round);
        System.out.println(rounds.size());
        this.rounds.get(rounds.size()-1).addValidators(problemos.getValidators());
        roundNumber++;
    }

    /**
     * Removes the current round from the game.
     */

    public void removeRound(){
        rounds.remove(getRound());
        roundNumber--;

    }

    /**
     * Gets the list of rounds in the game.
     *
     * @return The list of rounds.
     */
    public List<Round> getRounds() {
        return this.rounds;
    }

    /**
     * Gets the current round in the game.
     *
     * @return The current round.
     */
    public Round getRound() {
        return rounds.get(rounds.size() - 1);
    }

    /**
     * Gets the current problem in the game.
     *
     * @return The current problem.
     */
    public Problem getProblemos() {
        return this.problemos;
    }

    /**
     * Checks if the code has been found.
     *
     * @return {@code true} if the code has been found, {@code false} otherwise.
     */
    public boolean isFind() {
        return this.find;
    }

    /**
     * Gets the user's code.
     *
     * @return The user's code.
     */
    public Code getUser() {
        return this.user;
    }

    /**
     * Leaves the current game.
     */
    public void leaveGame() {
        this.quit = true;
    }


}
