package atl.ascii.model;

/**
 * The {@code GroupeCommande} class implements the {@code Commande} interface
 * for grouping multiple shapes into a single {@code Groupe} within a drawing.
 * This class encapsulates the command to create a group and provides the functionality
 * to undo (disband) the group if needed.
 */
public class GroupCommande implements Commande  {

   private int [] indexTab;

   private Drawing drawing;

   private Group group;

    /**
     * Constructs a GroupeCommande with the specified drawing, group, and indices of shapes to be grouped.
     * The indices represent positions of shapes within the drawing that will be added to the group.
     *
     * @param drawing The drawing to which the shapes belong and in which the group will be created.
     * @param group  The group where the shapes will be added.
     * @param index   The indices of the shapes in the drawing to be grouped.
     */
    public GroupCommande(Drawing drawing, Group group, int... index) {
        this.indexTab = index;
        this.drawing = drawing;
        this.group = group;
    }

    /**
     * Executes the group command. This method groups the specified shapes into the group
     * and adds the group to the drawing, removing individual shapes from the drawing.
     */

    @Override
    public void execute() {
        for (int i = 0; i < indexTab.length; i++) {
            group.addShape(drawing.getShapeWithIndex(indexTab[i]));
        }
        for (int i = indexTab.length - 1; i >= 0; i--) {

            drawing.getShapes().remove(indexTab[i]);
        }

        drawing.addShape(group);
    }

    /**
     * Reverses the group command. It disbands the group, re-adding the individual shapes back to the drawing,
     * and removes the group entity from the drawing.
     */
    @Override
    public void unexecute() {
        for (Shape shape : group.getShapes()) {
            drawing.addShape(shape);
        }
            drawing.getShapes().remove(group);

    }



}
