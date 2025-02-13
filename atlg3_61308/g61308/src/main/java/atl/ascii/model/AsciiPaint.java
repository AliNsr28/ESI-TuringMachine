package atl.ascii.model;


/**
 * The {@code AsciiPaint} class represents an ASCII art drawing application.
 * It allows the creation of different shapes, displaying them, generating ASCII art,
 * and moving shapes within the drawing.
 */

public class AsciiPaint {
    Drawing drawing;
    CommandeManager commandeManager = new CommandeManager();

    /**
     * Constructs an ASCII paint with a drawing of specified width and height.
     *
     * @param width  the width of the drawing
     * @param height the height of the drawing
     */

    public AsciiPaint(int width, int height) {
        this.drawing = new Drawing(height, width);
    }

    /**
     * Creates a new circle and adds it to the drawing.
     *
     * @param x      the x-coordinate of the center of the circle
     * @param y      the y-coordinate of the center of the circle
     * @param radius the radius of the circle
     * @param color  the color character of the circle
     */

    public void newCircle(int x, int y, double radius, char color) {
        Circle circle = new Circle(new Point(x, y), radius, color);
        Commande command = new AddCommande(circle,drawing);
        commandeManager.doCommande(command);

    }

    /**
     * Creates a new rectangle and adds it to the drawing.
     *
     * @param x      the x-coordinate of the top-left corner of the rectangle
     * @param y      the y-coordinate of the top-left corner of the rectangle
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     * @param color  the color character of the rectangle
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        Rectangle rectangle = new Rectangle(new Point(x,y),width,height,color);
        Commande commande = new AddCommande(rectangle,drawing);
        commandeManager.doCommande(commande);
    }

    /**
     * Creates a new square and adds it to the drawing.
     *
     * @param x     the x-coordinate of the top-left corner of the square
     * @param y     the y-coordinate of the top-left corner of the square
     * @param side  the side length of the square
     * @param color the color character of the square
     */

    public void newSquare(int x, int y, double side, char color) {
        Square square = new Square(new Point(x,y),side,color);
        Commande commande = new AddCommande(square,drawing);
        commandeManager.doCommande(commande);
    }

    public void newLine(int x1 , int y1,int x2,int y2 , char color){
       Line line = new Line(new Point(x1,y1),new Point(x2,y2),color);
       Commande commande = new AddCommande(line,drawing);
       commandeManager.doCommande(commande);
    }

    /**
     * Displays the types of shapes in the drawing.
     */


    public void displayShapes() {

        int size = drawing.getShapes().size();

        for (int i = 0; i < size; i++) {

            Shape shape = drawing.getShapeWithIndex(i);
            String square = shape.getName();

            System.out.println(i +") " + square);
        }
    }

    /**
     * Generates an ASCII representation of the drawing.
     *
     * @return the ASCII representation of the drawing
     */
    public String ascii() {
        StringBuilder s = new StringBuilder((drawing.getHeight() + 1) * drawing.getWidth());
        System.out.print("\u001B[38;2;255;165;0m");
        for (int i = 0; i < drawing.getHeight(); i++) {
            for (int j = 0; j < drawing.getWidth(); j++) {
                Shape shape = drawing.getShapeAt(new Point(i, j));
                if (shape == null) {
                    s.append("  .  ");
                } else {
                    s.append("  ").append(shape.getcolor()).append("  ");
                }
            }
            s.append('\n');
        }
        return s.toString();
    }

    /**
     * Moves a shape in the drawing to new coordinates.
     *
     * @param index the index of the shape to be moved
     * @param x     the new x-coordinate
     * @param y     the new y-coordinate
     * @throws AsciiException if the coordinates are out of bounds
     */
    public void moveShape(int index, int x, int y) {
       if( x > drawing.getWidth() || y > drawing.getHeight()){
            throw new AsciiException("Impossible coordinates, please try again");
        }
        Shape shape = drawing.getShapeWithIndex(index);
        Commande commande = new MoveCommande(shape,x,y);
        commandeManager.doCommande(commande);
    }

    /**
     * Retrieves the shape at the specified index from the drawing.
     *
     * @param index The index of the shape to retrieve.
     * @return The shape corresponding to the specified index.
     */
    public Shape getShape(int index){
        return drawing.getShapeWithIndex(index);
    }

    /**
     * Modifies the color of the shape at the specified index in the drawing.
     *
     * @param index The index of the shape whose color needs to be modified.
     * @param color The new color to assign to the shape.
     */

    public void setColor(int index , char color){
     Shape shape = drawing.getShapeWithIndex(index);
     Commande commande = new ChangeColorCommande(shape,color);
    commandeManager.doCommande(commande);
    }

    /**
     * Deletes a shape from the drawing.
     *
     * @param index the index of the shape to be deleted. This index corresponds
     *              to the position of the shape in the drawing's shape list.
     */
    public void deleteShape(int index){
        Shape shape = drawing.getShapeWithIndex(index);
        Commande commande = new DeleteCommande(shape,drawing);
        commandeManager.doCommande(commande);
    }

    /**
     * Undoes the last command performed. This can include actions like adding or moving a shape.
     * If no actions have been performed or all have been undone, this method will have no effect.
     */
    public void undo(){
        commandeManager.undo();
    }

    /**
     * Redoes the last command that was undone. This can only be used after the `undo` method.
     * If there are no actions to redo, this method will have no effect.
     */
    public void redo(){
        commandeManager.redo();
    }
    /**
     * Groups multiple shapes into a single entity. This allows multiple shapes to be
     * treated as a single object in terms of movement or deletion.
     *
     * @param index the indexes of the shapes to be grouped. These indexes correspond
     *              to the positions of the shapes in the drawing's shape list.
     */
    public void group(int... index){
        char color = drawing.getShapeWithIndex(index[0]).getcolor();
        Group group = new Group(color);
        Commande commande = new GroupCommande(drawing, group,index);
        commandeManager.doCommande(commande);

    }

    /**
     * Ungroups a previously grouped set of shapes into individual shapes.
     *
     * @param index the index of the group to be ungrouped. This index corresponds
     *              to the position of the group in the drawing's shape list.
     */
    public void ungroup(int index){
        Commande commande = new UnGroupeCommande(drawing,index);
        commandeManager.doCommande(commande);
    }

    /**
     * Retrieves the drawing associated with this instance.
     * This method is typically used to access the drawing object for operations like rendering,
     * manipulating shapes, or querying drawing properties.
     *
     * @return The {@code Drawing} object associated with this instance.
     */
    public Drawing getDrawing() {
        return drawing;
    }
}
