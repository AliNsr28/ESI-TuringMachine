package atl.ascii.model;


/**
 * The AddCommande class implements the Commande interface and provides functionality
 * to add a shape to a drawing. It encapsulates the action of adding a shape and
 * provides the ability to execute or undo this action.
 */
public class AddCommande implements Commande{

    private Shape shape;
    private Drawing drawing;
    /**
     * Constructs an AddCommande object with a specified shape and drawing.
     *
     * @param shape   The shape to be added to the drawing.
     * @param drawing The drawing to which the shape will be added.
     */
    public AddCommande(Shape shape , Drawing drawing) {
        this.shape = shape;
        this.drawing = drawing;

    }
    /**
     * Executes the command to add the shape to the drawing.
     */
    @Override
    public void execute() {
        drawing.addShape(shape);
    }
    /**
     * Undoes the add command by removing the shape from the drawing.
     */
    @Override
    public void unexecute() {
        drawing.remove(shape);
    }
}
