package atl.ascii.model;

/**
 * The {@code Commande} interface is part of the command pattern used in the ASCII art application.
 * It declares the essential methods for executing and undoing commands. Classes implementing this
 * interface are responsible for defining the specific actions for these methods.
 *
 * This interface enables actions like adding, moving, changing color of shapes, etc., and their reversal.
 */
public interface Commande {

    /**
     * Executes the command. Implementing classes will define the specific action to be performed.
     * This could include operations like adding a shape, changing a shape's color, moving a shape, etc.
     */
    void execute();

    /**
     * Reverses (undoes) the command executed by the {@code execute} method.
     * Implementing classes will define the specific undo action.
     */
    void unexecute();

}
