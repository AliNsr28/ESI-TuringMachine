package model;

import commande.*;
import model.validator.Validator;
import util.CSVReader;
import util.Observable;
import util.Observer;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Facade} class serves as a facade for the game system and implements the Observable interface.
 * It manages game-related operations, such as starting a new game, selecting validators, entering codes,
 * and handling rounds. It also maintains a list of observers and notifies them of relevant updates.
 *
 * @author Your Name
 * @version 1.0
 */
public class Facade implements Observable {

    private Game game;
    private CSVReader csvReader;
    private CommandManager commandManager;
    private final List<Observer> observers;

  //  private List< String> historique = new ArrayList<>();

    /**
     * Constructs a Facade object with the specified game instance.
     *
     * @param game The game instance to be managed by the facade.
     */

    public Facade(Game game) {

        this.game = game;
        csvReader = new CSVReader();
        commandManager = new CommandManager();
        this.observers = new ArrayList<>();
    }

    /**
     * Undoes the last command and notifies observers of the update.
     */
    public void undo() {
        commandManager.undo();
        //historique.add("undo");
        notifyObservers();
    }


    /**
     * Redoes the last undone command and notifies observers of the update.
     */
    public void redo() {
        commandManager.redo();
        //historique.add("Redo");
        notifyObservers();
    }


    /**
     * Starts a new game with the specified index and notifies observers of the update.
     *
     * @param index The index specifying the configuration of the new game.
     */
    public void startNewGame(int index) {
        this.game.startGame(this.csvReader,index);
    }


    /**
     * Selects a validator with the specified ID, tests it, and notifies observers of the update.
     *
     * @param id The ID of the validator to be selected and tested.
     */

    public void selectValidateur(int id) {
        game.getRound().setUser(getGame().getUser());  // ICIIIIIIIII
        List<Validator> validators = this.game.getRound().getValidators();
        System.out.println(game.getUser().getCode());
        if (!validators.isEmpty()  && id <= validators.size()) {
            Command command = new TestValidatorCommand(validators.get(id),this.game);
            commandManager.doCommande(command);
          //  historique.add("Test Validator");
            notifyObservers();
        }
    }

    /**
     * Enters the provided user code, executes the corresponding command, and notifies observers of the update.
     *
     * @param user The user code to be entered.
     */
    public void enterCode(Code user) {
        Command command = new CodeCommand(this, user);
        commandManager.doCommande(command);
        //historique.add("Enter Code");
        notifyObservers();
    }

    /**
     * Advances to the next round, executes the corresponding command, and notifies observers of the update.
     */
    public void nextRound() {
        Command command = new RoundCommand(this);
        commandManager.doCommande(command);
       // historique.add("Next Round");
        notifyObservers();
    }

    /**
     * Gets the number of completed rounds in the current game.
     *
     * @return The number of completed rounds.
     */
    public int getNumberRound(){
        return this.game.getRounds().size();
    }

    /**
     * Gets the number of validators that provided correct verifications in the current round.
     *
     * @return The number of correct verifications.
     */
    public int getVerificationsnumber() {
        return this.game.getRound().getGoodvalidators().size();
    }

    /**
     * Gets the list of validators for the current round.
     *
     * @return The list of validators.
     */
    public List<Validator> getValidators() {
        return this.game.getRound().getValidators();
    }

    /**
     * Gets the current game instance.
     *
     * @return The current game instance.
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Ends the current game session.
     */


    public void endGame(){
        this.game.leaveGame();
    }


    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public boolean register(Observer obs) {
        return false;
    }

    @Override
    public boolean unregister(Observer obs) {
        return false;
    }

    @Override
    public void notifyObservers() {
            for (Observer obs : observers) {
                obs.update();
            }
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }


/*

    public List<String> getHistorique() {
        return this.historique;
    }

     */
}
