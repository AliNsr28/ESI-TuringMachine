package atl.ascii.model;

/**
 * The {@code Circle} class represents a circle, a geometric shape defined by its center point and radius.
 * It extends the {@code ColoredShape} class.
 */

public class Circle extends ColoredShape {
    private double radius;
    private Point center;

    /**
     * Circle Constructor
     * @param color color of the circle
     * @param radius radius of the circle
     * @param center center of the circle
     */

    public Circle(Point center, double radius, char color ) {
        super(color);
        if(radius <= 0){
            throw new AsciiException("Radius is not possible");
        }

        if(center == null){
            throw new AsciiException("The point doesn't exist");

        }

        this.radius = radius;
        this.center = new Point(center.getX(), center.getY()); //defensive copy
    }

    /**
     * Determines whether a given point is inside the shape.
     * For a circle, this method checks if the point lies within the radius of the circle
     * from its center.
     *
     * @param P The point to be checked.
     * @return true if the point is inside the shape; false otherwise.
     */
    @Override
    public boolean isInside(Point P) {
       if( P.distance(center )<=radius){
           return true;
       }
       else{
           return false;
       }
    }

    /**
     * Moves the circle by the specified amounts along the x and y axes.
     *
     * @param dx The amount to move along the x-axis.
     * @param dy The amount to move along the y-axis.
     */

    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    /**
     * Gets the color of the circle.
     *
     * @return The color of the circle as a character.
     */
    @Override
    public char getcolor() {
        return this.getColor();
    }

    /**
     * Returns the name of the shape. This implementation specifically returns
     * the name for a circle shape.
     *
     * @return A string "CIRCLE", denoting the type of the shape.
     */

    @Override
    public String getName() {
        return "CIRCLE";
    }

    /**
     * Returns a defensive copy of the center coordinates of the geometric shape.
     *
     * <p>
     * The method creates and returns a new {@link Point} object with the same coordinates
     * as the center of the geometric shape. This ensures that external code receives
     * a copy of the center coordinates, preventing inadvertent modification of the
     * internal state.
     * </p>
     *
     * @return a new {@link Point} representing the center coordinates
     */
    public Point getCenter (){
        // Defensive copy: Create and return a new Point with the same coordinates as the center
            return new Point(center.getX(), center.getY()); // defensive copy
        }




}







