package atl.ascii.model;

import java.util.Stack;


/**
 * The {@code CommandeManager} class manages the execution, undoing, and redoing of commands
 * within the ASCII art application. It uses two stacks to track the history of commands executed
 * and commands that have been undone, allowing for undo and redo functionality.
 */
public class CommandeManager {

  private  Stack<Commande> stackUndo = new Stack<>();
   private Stack<Commande> stackRedo = new Stack<>();


    /**
     * Executes a given command and adds it to the undo stack. It also clears the redo stack
     * to maintain the correct order of operations.
     *
     * @param commande The command to be executed.
     */
    public void doCommande(Commande commande){
        commande.execute();
        stackUndo.push(commande);
        stackRedo.clear();
    }

    /**
     * Undoes the last command executed, if any. The undone command is moved to the redo stack.
     * If the undo stack is empty, no action is taken.
     */
    public void undo(){
        if (!stackUndo.isEmpty()) {
            Commande command = stackUndo.pop();
            command.unexecute();
            stackRedo.push(command);
        }
    }

    /**
     * Redoes the last command undone, if any. The redone command is moved back to the undo stack.
     * If the redo stack is empty, no action is taken.
     */

    public void redo(){
        if (!stackRedo.isEmpty()) {
            Commande command = stackRedo.pop();
            command.execute();
            stackUndo.push(command);
        }
    }

}
