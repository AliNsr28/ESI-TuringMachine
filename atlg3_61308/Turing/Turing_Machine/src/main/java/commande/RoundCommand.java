package commande;

import model.Facade;


/**
 * This class represents a command that adds a round to the game when executed
 * and removes the last added round when unexecuted.
 */
public class RoundCommand implements Command {

    /**
     * The facade providing access to the game functionality.
     */
    private Facade facade;

    /**
     * Constructor for the RoundCommand class.
     *
     * @param facade The facade providing access to the game functionality.
     */
    public RoundCommand(Facade facade) {
        this.facade = facade;
    }

    /**
     * Executes the command by adding a round to the game.
     */
    @Override
    public void execute() {
        this.facade.getGame().addRound();
    }

    /**
     * Unexecutes the command by removing the last added round from the game.
     */
    @Override
    public void unexecute() {
        this.facade.getGame().removeRound();
    }
}
