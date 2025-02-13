package atl.ascii.model;

import java.text.ParsePosition;


/**
 * The {@code Line} class extends {@code ColoredShape} and represents a line
 * shape defined by two points. It includes methods for checking if a point
 * is on the line and for moving the line.
 */
public class Line extends ColoredShape {


    private Point a;
    private Point b;

    /**
     * Constructs a new Line with specified start and end points and a color.
     *
     * @param p1    The start point of the line.
     * @param p2    The end point of the line.
     * @param color The color of the line.
     */
    public Line(Point p1, Point p2, char color) {
        super(color);
        this.a = p1;
        this.b = p2;
    }

    /**
     * Checks if a given point is on the line. This method uses a mathematical approach
     * to determine if the point lies on the line segment between the start and end points.
     *
     * @param p The point to check.
     * @return true if the point is on the line, false otherwise.
     */

    public boolean isInside(Point p) {
        Point start = a;
        Point end = b;

        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();

        double dxc = p.getX() - start.getX();
        double dyc = p.getY() - start.getY();

        double crossProduct = dxc * dy - dyc * dx;

        if (Math.abs(crossProduct) > 0.5) {
            return false;
        }

        double dotProduct = dxc * dx + dyc * dy;
        if (dotProduct < 0) {
            return false;
        }

        double squaredLength = dx * dx + dy * dy;
        return dotProduct <= squaredLength;
    }

    /**
     * Moves the line by a specified distance in the x and y directions.
     * This effectively moves both the start and end points of the line.
     *
     * @param dx The distance to move in the x direction.
     * @param dy The distance to move in the y direction.
     */
    @Override
    public void move(double dx, double dy) {
        a.move(dx, dy);
        b.move(dx, dy);
    }

    /**
     * Returns the color of the line.
     *
     * @return The color character of the line.
     */
    @Override
    public char getcolor() {
        return this.getColor();
    }

    /**
     * Returns the name of the shape. This implementation specifically returns
     * the name for a line shape.
     *
     * @return A string "LINE", denoting the type of the shape.
     */
    @Override
    public String getName() {
        return "LINE";
    }


    /**
     * Retrieves the first point (Point A) of the line or shape.
     * This method is typically used to access the starting point or one of the vertices
     * of a geometric shape, depending on the context of the class.
     *
     * @return The first point (Point A) of the line or shape.
     */
    public Point getA() {
        return a;
    }
}
