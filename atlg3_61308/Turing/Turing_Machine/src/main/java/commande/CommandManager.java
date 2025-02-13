package commande;

import model.TuringException;

import java.util.Stack;

    /**
     * The {@code CommandeManager} class manages the execution, undoing, and redoing of commands
     * within the ASCII art application. It uses two stacks to track the history of commands executed
     * and commands that have been undone, allowing for undo and redo functionality.
     */
    public class CommandManager {

        private Stack<Command> stackUndo = new Stack<>();
        private Stack<Command> stackRedo = new Stack<>();

        private int score = 0;



        /**
         * Executes a given command and adds it to the undo stack. It also clears the redo stack
         * to maintain the correct order of operations.
         *
         * @param commande The command to be executed.
         */
        public void doCommande(Command commande){
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
                Command command = stackUndo.pop();

                command.unexecute();
                if (command instanceof TestValidatorCommand){
                    score --;
                }
                stackRedo.push(command);
            }
            else {
                throw new TuringException("The undo Stack is empty");
            }
        }

        /**
         * Redoes the last command undone, if any. The redone command is moved back to the undo stack.
         * If the redo stack is empty, no action is taken.
         */

        public void redo(){
            if (!stackRedo.isEmpty()) {
                Command command = stackRedo.pop();
                command.execute();
                if(command instanceof TestValidatorCommand){
                    score++;
                }
                stackUndo.push(command);
            }
            else {
                throw new TuringException("The redo Stack is empty");
            }
        }

        public int getScore() {
            return this.score;
        }
    }
