package atl.ascii.model;

/**
 * The {@code Shape} interface represents a geometric shape in a two-dimensional space.
 * It defines common methods that shapes should implement, such as checking if a point is inside the shape,
 * moving the shape, and retrieving the color of the shape.
 */

public interface  Shape {
    /**
     * Checks if a given point is inside the shape.
     *
     * @param p The point to check.
     * @return {@code true} if the point is inside the shape, {@code false} otherwise.
     */
    boolean isInside(Point p);

    /**
     * Moves the shape by the specified amounts along the x and y axes.
     *
     * @param dx The amount to move along the x-axis.
     * @param dy The amount to move along the y-axis.
     */
     void move(double dx , double dy);

    /**
     * Gets the color of the shape.
     *
     * @return The color of the shape as a character.
     */
     char getcolor();

    /**
     * Sets the color of the shape to the specified character.
     *
     * @param color The new color to assign to the shape.
     */
     void setColor(char color);


     String getName();


}
