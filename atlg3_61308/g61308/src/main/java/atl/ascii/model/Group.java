package atl.ascii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Groupe} class extends {@code ColoredShape} and represents a collection of
 * {@code Shape} objects that are treated as a single entity. This class allows for
 * collective operations like moving all shapes in the group simultaneously.
 * The color of the group is initially set based on the color of the first shape in the group.
 */
public class Group extends ColoredShape{
    private final List<Shape> shapes;
    /**
     * Constructs a new {@code ColoredShape} object with the specified color.
     *
     * @param color The color of the shape.
     */

    /**
     * Constructs a new {@code Groupe} object with the specified color.
     * Initializes an empty list of shapes.
     *
     * @param color The color of the group.
     */
    public Group(char color) {
        super(color);
        this.shapes = new ArrayList<>();
    }

    /**
     * Adds a shape to the group.
     *
     * @param shape The shape to be added to the group.
     */
    public void addShape(Shape shape){
        shapes.add(shape);
    }

    /**
     * Checks if a given point is inside any of the shapes in the group.
     *
     * @param p The point to be checked.
     * @return true if the point is inside any shape in the group, false otherwise.
     */

    @Override
    public boolean isInside(Point p) {
        for (Shape shape : shapes) {
            if (shape.isInside(p))
                return true;
        }
        return false;
    }


    /**
     * Moves all shapes in the group by the specified distances in the x and y directions.
     *
     * @param dx The distance to move in the x direction.
     * @param dy The distance to move in the y direction.
     */
    @Override
    public void move(double dx, double dy) {
        for (Shape shape :shapes) {
            shape.move(dx, dy);
        }
    }

    /**
     * Returns the color of the group.
     *
     * @return The color character of the group.
     */

    @Override
    public char getcolor() {
       return this.getColor();
    }

    /**
     * Returns the name of the shape. This implementation specifically returns
     * the name for a groyp shape.
     *
     * @return A string "GROUP", denoting the type of the shape.
     */
    @Override
    public String getName() {
        return "GROUP";
    }

    /**
     * Retrieves the list of shapes in the group.
     *
     * @return A list containing all the shapes in the group.
     */
    public List<Shape> getShapes() {
        return shapes;
    }




}
