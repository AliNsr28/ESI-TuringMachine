package atl.ascii.model;

/**
 * The {@code ChangeColorCommande} class implements the {@code Commande} interface
 * and is used for changing the color of a {@code Shape}. This class encapsulates
 * both the execution of the color change and its reversal (undo functionality).
 */
public class ChangeColorCommande implements Commande {

    private Shape shape;
    private char oldColor;

    private char newColor;

    /**
     * Constructs a ChangeColorCommande for a given shape and a new color.
     * It stores the current color of the shape for possible undoing of the command.
     *
     * @param shape The shape whose color is to be changed.
     * @param color The new color to be set for the shape.
     */
    public ChangeColorCommande(Shape shape , char color) {
     this.shape = shape;
     oldColor = shape.getcolor();
     this.newColor = color;
    }

    /**
     * Executes the color change command. This method changes the color of
     * the shape to the new color specified in the constructor.
     */
    @Override
    public void execute() {
     shape.setColor(newColor);
    }

    /**
     * Reverses the execute command. It changes the color of the shape back to
     * its original color, effectively undoing the color change.
     */
    @Override
    public void unexecute() {
     shape.setColor(oldColor);
    }


}
