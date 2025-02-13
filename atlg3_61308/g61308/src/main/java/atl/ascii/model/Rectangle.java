package atl.ascii.model;


/**
 * Class
 */
public class Rectangle extends ColoredShape {
    private Point upperLeft; //Upper left corner

    private double width;

    private double height;

    /**
     * Rectangle constructor
     *
     * @param color     Color of the rectangle
     * @param upperLeft the point upperleft of the rectangle
     */

    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        if (height <= 0 || width <= 0) {
            throw new AsciiException("Is not possible");
        } else if (upperLeft == null) {

            throw new AsciiException("Point doesn't exit");

        }

        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY()); //defensive copy
        this.height = height;
        this.width = width;
    }

    /**
     * Method that checks if a point is in the form
     *
     * @param P The point
     * @return a boolean if is true or false
     */
    @Override
    public boolean isInside(Point P) {
        if ((P.getX() >= upperLeft.getX() && P.getX() <= (upperLeft.getX() + width)) && ((P.getY() >= upperLeft.getY()) && P.getY() <= (upperLeft.getY() + height))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for moving a shape
     *
     * @param dx Coordinate in x
     * @param dy Coordinate in y
     */

    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    /**
     * The methode that gives colour
     *
     * @return the color
     */

    @Override
    public char getcolor() {
        return this.getColor();
    }

    /**
     * Returns the name of the shape. This implementation specifically returns
     * the name for a rectangle shape.
     *
     * @return A string "RECTANGLE", denoting the type of the shape.
     */
    @Override
    public String getName() {
        return "RECTANGLE";
    }

    /**
     * Retrieves a new point representing the upper-left corner of the shape.
     *
     * @return A new point representing the coordinates of the upper-left corner.
     */
    public Point getUpperLeft() {
        return new Point(upperLeft.getX(), upperLeft.getY());
    }


}





