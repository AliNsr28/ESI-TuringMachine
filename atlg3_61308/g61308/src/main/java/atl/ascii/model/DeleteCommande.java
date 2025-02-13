package atl.ascii.model;

/**
 * The {@code DeleteCommande} class implements the {@code Commande} interface
 * for the action of deleting a shape from a drawing. This class encapsulates
 * the command to remove a shape and provides the functionality to undo (re-add)
 * the shape if needed.
 */
public class DeleteCommande implements Commande{

    Shape shape;

    Drawing drawing;

    /**
     * Constructs a DeleteCommande with the specified shape and drawing.
     * This command will remove the shape from the drawing when executed.
     *
     * @param shape   The shape to be deleted from the drawing.
     * @param drawing The drawing from which the shape will be removed.
     */
    public DeleteCommande(Shape shape,Drawing drawing) {
        this.shape = shape;
        this.drawing = drawing;
    }

    /**
     * Executes the delete command. This method removes the shape from the drawing.
     */
    @Override
    public void execute() {
        drawing.remove(shape);
    }

    /**
     * Reverses the delete command. It re-adds the previously removed shape back to the drawing,
     * effectively undoing the delete operation.
     */

    @Override
    public void unexecute() {
        drawing.addShape(shape);
    }
}
