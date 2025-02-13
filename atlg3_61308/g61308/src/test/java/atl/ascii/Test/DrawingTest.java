package atl.ascii.Test;

import atl.ascii.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawingTest {
    @Test
    public void testConstructorValid() {
        new Drawing(10, 10);
    }

    @Test
    public void testConstructorNullPoint() {
        assertThrows(AsciiException.class, ()
                -> new Drawing(0, 0));
    }

    @Test
    public void testAddShapeNull() {
        Drawing drawing = new Drawing(10, 10);
        assertThrows(AsciiException.class, ()
                -> drawing.addShape(null));
    }

    @Test
    public void testAddShape() {
        Drawing drawing = new Drawing(10, 10);
        drawing.addShape(new Circle(new Point(1, 1), 5, '$'));
        drawing.addShape(new Rectangle(new Point(1, 1), 5, 4, 'r'));
        assertTrue(drawing.getShapes().get(0) instanceof Circle);
        assertTrue(drawing.getShapes().get(1) instanceof Rectangle);
        assertEquals(2, drawing.getShapes().size());
    }

    @Test
    public void testGetShapeAtNullPoint() {
        Drawing drawing = new Drawing(10, 10);
        assertThrows(AsciiException.class, ()
                -> drawing.getShapeAt(null));
    }

    @Test
    public void testGetShape() {
        Drawing drawing = new Drawing(100, 100);
        drawing.addShape(new Square(new Point(25, 25), 25, 'c'));
        drawing.addShape(new Circle(new Point(0, 0), 5, 'd'));
        assertTrue(drawing.getShapeAt(new Point(25, 25)) instanceof Square);
        assertTrue(drawing.getShapeAt(new Point(49, 49)) instanceof Square);
        assertTrue(drawing.getShapeAt(new Point(0, 0)) instanceof Circle);
        assertTrue(drawing.getShapeAt(new Point(100, 100)) == null);
        assertFalse(drawing.getShapeAt(new Point(0, 0)) instanceof Square);
    }


    @Test
    public void testAddLine(){
        Drawing drawing = new Drawing(100, 100);
        drawing.addShape(new Line(new Point(0,0),new Point(5,5),'k'));
        assertTrue(drawing.getShapes().get(0) instanceof Line);
    }

    @Test
    public void Group(){
        Drawing drawing = new Drawing(100,100);
        Circle circle = new Circle(new Point(50, 50), 10, 'c');
        Circle circle1 = new Circle(new Point(0, 0), 10, 'r');
        Group group = new Group('c');
        drawing.addShape(group);
        assertTrue(drawing.getShapes().get(0) instanceof Group);
    }

    @Test
    public void Undo(){
        AsciiPaint asciiPaint = new AsciiPaint(100,100);
        asciiPaint.newCircle(50,50,10,'c');
        asciiPaint.newCircle(50,50,10,'c');
    }

}