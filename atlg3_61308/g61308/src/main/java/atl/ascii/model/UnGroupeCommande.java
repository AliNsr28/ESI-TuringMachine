package atl.ascii.model;

import java.util.List;


/**
 * The {@code UnGroupeCommande} class implements the {@code Commande} interface
 * for ungrouping a group of shapes ({@code Groupe}) in a drawing. It encapsulates
 * the command to disband a group of shapes and provides the functionality to reverse
 * the ungrouping (regroup functionality).
 */
public class UnGroupeCommande implements Commande{

    private Drawing drawing;
    private Group group;

    private final List<Shape> Shapes;

    private final int index;


    /**
     * Constructs an UnGroupeCommande for ungrouping a group of shapes at a specified index in a drawing.
     * If the shape at the specified index is not a group, an exception is thrown.
     *
     * @param drawing The drawing containing the group.
     * @param index   The index of the group in the drawing's list of shapes.
     * @throws IllegalArgumentException If the shape at the specified index is not a valid group.
     */
    public UnGroupeCommande(Drawing drawing , int index) {
        this.drawing = drawing;
        this.index = index;

        if (index >= 0 && index < drawing.getShapes().size() && drawing.getShapes().get(index) instanceof Group) {
            group = (Group) drawing.getShapes().get(index);
            Shapes = group.getShapes();
        } else {
            throw new IllegalArgumentException("Shape with id " + index + " is not a valid group to ungroup.");
        }
    }

    /**
     * Executes the ungroup command. This method disbands the group, re-adding the individual shapes
     * back to the drawing at the position of the group, and removes the group entity.
     */
    @Override
    public void execute() {
            drawing.getShapes().remove(index);
            drawing.getShapes().addAll(index, Shapes);
    }

    /**
     * Reverses the ungroup command. It regroups the shapes, removing the individual shapes from the drawing
     * and re-adding the group entity.
     */

    @Override
    public void unexecute() {
            drawing.getShapes().removeAll(Shapes);
            drawing.getShapes().add(index, group);
    }
}
