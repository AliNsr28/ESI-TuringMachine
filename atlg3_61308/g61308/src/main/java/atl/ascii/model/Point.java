package atl.ascii.model;

/**
 * The {@code Point} class represents a point in a two-dimensional space with coordinates (x, y).
 * It provides methods to retrieve the x and y coordinates, move the point, and calculate the distance
 * between two points.
 */
public class  Point {
    private double x;
    private double y;
    
        /**
         * Constructs a new {@code Point} object with the specified x and y coordinates.
         *
         * @param x The x-coordinate of the point.
         * @param y The y-coordinate of the point.
         */
    public Point(double x, double y) {
        if( x < 0 || y < 0){
            throw new AsciiException("Is not possible");
        }
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this(p.x, p.y);
    }


    /**
     * Gets the x-coordinate of the point.
     *
     * @return The x-coordinate of the point.
     */

    public double getX() {return x;}

    /**
     * Gets the y-coordinate of the point.
     *
     * @return The y-coordinate of the point.
     */
    public double getY() {return y;}

    /**
     * Moves the point by the specified amounts along the x and y axes.
     *
     * @param dx The amount to move along the x-axis.
     * @param dy The amount to move along the y-axis.
     */
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Calculates the Euclidean distance between this point and another point.
     *other The other point to calculate the distance to.
     * @return The distance between this point and the specified point.
     */
    public double distance (Point other){
        return Math.sqrt(Math.pow((other.x - this.x), 2)
                + Math.pow((other.y - this.y), 2));
    }


}

