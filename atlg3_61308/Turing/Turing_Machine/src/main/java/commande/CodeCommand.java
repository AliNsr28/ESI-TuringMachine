package commande;

import model.Code;
import model.Facade;


/**
 * This class represents a command that adds a code to the game when executed
 * and removes the last added code when unexecuted.
 */
public class CodeCommand implements Command {

    /**
     * The facade providing access to the game functionality.
     */
    private Facade facade;

    /**
     * The code to be added or removed.
     */
    private Code code;

    /**
     * Constructor for the CodeCommand class.
     *
     * @param facade The facade providing access to the game functionality.
     * @param code   The code to be added or removed.
     */
    public CodeCommand(Facade facade, Code code) {
        this.facade = facade;
        this.code = code;
    }

    /**
     * Executes the command by adding the specified code to the game.
     */
    @Override
    public void execute() {
        this.facade.getGame().addCode(code);
    }

    /**
     * Unexecutes the command by removing the last added code from the game.
     */
    @Override
    public void unexecute() {
        this.facade.getGame().removeCode();
    }
}

