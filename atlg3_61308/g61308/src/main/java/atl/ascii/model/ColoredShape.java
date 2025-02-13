package atl.ascii.model;

/**
 * The {@code ColoredShape} abstract class serves as a base class for geometric shapes with a color attribute.
 * It implements the {@code Shape} interface and provides methods for getting and setting the color of the shape.
 */

public abstract  class  ColoredShape implements Shape {


    /** The color of the shape. */

    private char color ;

    /**
     * Constructs a new {@code ColoredShape} object with the specified color.
     *
     * @param color The color of the shape.
     */

    public ColoredShape(char color) {
        this.color = color;
    }



    /**
     * Gets the color of the shape.
     *
     * @return The color of the shape as a character.
     */
    public char getColor() {
        return color;
    }


    /**
     * Sets the color of the shape.
     *
     * @param color The new color to set for the shape.
     */
    public void setColor(char color) {
        this.color = color;
    }
}
