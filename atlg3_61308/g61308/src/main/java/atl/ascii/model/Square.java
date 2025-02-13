package atl.ascii.model;

/**
 * The {@code Square} class represents a square, which is a specific type of rectangle with equal width and height.
 * It extends the {@code Rectangle} class.
 */
public class Square extends Rectangle {

    /**
     * Constructs a new {@code Square} object with the specified color, width, height, and upper-left corner.
     *
     * @param upperLeft The upper-left corner {@code Point} of the square.
     * @param side     The width of the square.

     */
    public Square(Point upperLeft,  double side , char color) {
        super(upperLeft, side, side, color);
        if(side <= 0 ){
            throw new AsciiException("width or height is not possible");
        }

        if ( upperLeft == null){
            throw new AsciiException("the point doesn't exit");
        }
    }
    /**
     * Returns the name of the shape. This implementation specifically returns
     * the name for a square shape.
     *
     * @return A string "SQUARE", denoting the type of the shape.
     */

    public String getName(){
        return "SQUARE";
    }


}