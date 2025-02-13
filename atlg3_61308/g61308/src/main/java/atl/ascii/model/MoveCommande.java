package atl.ascii.model;


/**
 * The {@code MoveCommande} class implements the {@code Commande} interface
 * for moving a shape within a drawing. It encapsulates the action of moving a shape
 * and provides the functionality to reverse the move (undo functionality).
 */
public class MoveCommande implements Commande{

    private Shape shape;

    private double x;

    private double y;

    /**
     * Constructs a MoveCommande for moving a shape by specified distances in x and y directions.
     *
     * @param shape The shape to be moved.
     * @param x     The distance to move the shape along the x-axis.
     * @param y     The distance to move the shape along the y-axis.
     */
    public MoveCommande(Shape shape , double x , double y) {
        this.shape = shape;
        this.x = x;
        this.y = y;

    }

    /**
     * Executes the move command. This method moves the shape by the specified distances
     * along the x and y axes.
     */

    @Override
    public void execute() {
        shape.move(x,y);
    }

    /**
     * Reverses the move command. It moves the shape back to its original position,
     * effectively undoing the previous move operation.
     */
    @Override
    public void unexecute() {
        shape.move(-x,-y);
    }
}
