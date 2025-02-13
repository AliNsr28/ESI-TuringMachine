package atl.ascii.model;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The Drawing class represents a canvas for creating and managing shapes.
 */
public class Drawing {
    private List<Shape> shapes;
    private int height;  // height of the draw
    private int width;  // width of the draw



    /**
     * Constructs a new Drawing with the specified height and width.
     */


    public Drawing(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new AsciiException("Your length and height must be greater than 0");
        }
            this.height = height;
            this.width = width;
            shapes = new ArrayList<>();

    }

    /**
     * Adds a shape to the drawing.
     *
     * @param shape The shape to be added.
     */
    public void addShape(Shape shape) {
        if(shape == null){
            throw new AsciiException("Point doesn't exist");
        }
        shapes.add(shape);
    }


    /**
     * Retrieves the shape at the specified point on the drawing.
     *
     * @param p The point to check for a shape.
     * @return The shape at the specified point, or null if no shape is found.
     */

    public Shape getShapeAt(Point p) {
        if(p == null){
            throw new AsciiException("Point doesn't exist");
        }

        Shape lastShape = null;
        for (Shape shape : shapes) {
            if (shape.isInside(p)) {
                lastShape = shape;
            }
        }
        return lastShape;
    }


    /**
     * Gets the height of the drawing canvas.
     *
     * @return The height of the drawing canvas.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets the width of the drawing canvas.
     *
     * @return The width of the drawing canvas.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Returns the shape at the specified index in the collection.
     *
     * @param index the index of the shape to be retrieved
     * @return the shape at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Shape getShapeWithIndex(int index) {
        return this.shapes.get(index);
    }

    /**
     *
     *
     * <p>
     * The returned list is unmodifiable, meaning that it cannot be modified
     * (elements cannot be added, removed, or changed). This is useful for
     * providing read-only access to the collection of shapes.
     * </p>
     *
     * @return an unmodifiable list of shapes in the collection
     */

    public List<Shape> getShapes() {
        return this.shapes;
    }


    /**
     * Removes the specified shape from the collection of shapes.
     * If the shape is not present in the collection, this method will have no effect.
     *
     * @param shape The shape to be removed from the collection.
     */
    protected void remove(Shape shape) {
        shapes.remove(shape);
    }


}
