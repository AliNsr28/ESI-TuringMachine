package atl.ascii.Test;

import static org.junit.jupiter.api.Assertions.*;

import atl.ascii.model.*;
import org.junit.jupiter.api.Test;


class AsciiPaintTest {

    @Test
    public void testMakeShapeRectangle() {
        AsciiPaint paint = new AsciiPaint(10, 10);
        paint.newRectangle(0, 0, 3.5, 9.5, '¥');

    }

    @Test
    public void testMakeShapeCircle() {
        AsciiPaint paint = new AsciiPaint(10, 10);
        paint.newCircle(10,10,3.5,'c');
    }

    @Test
    public void testMakeShapeSquare() {
        AsciiPaint paint = new AsciiPaint(10, 10);
        paint.newSquare(10,10,3.5,'c');

    }


    @Test
    public void testNormalMoveRectangle() {
        AsciiPaint paint = new AsciiPaint(300, 300);
        paint.newRectangle(0,0,200,200,'r');
        paint.moveShape(0,3,3);
        Rectangle rectangle = (Rectangle) paint.getShape(0);
        assertEquals(3, rectangle.getUpperLeft().getX());
        assertEquals(3, rectangle.getUpperLeft().getY());
    }

    @Test
    public void testNormalMoveCircle() {
        AsciiPaint paint = new AsciiPaint(300, 300);
        paint.newCircle(0,0,200,'c');
        paint.moveShape(0,3,3);
        Circle circle = (Circle) paint.getShape(0);
        assertEquals(3, circle.getCenter().getX());
        assertEquals(3, circle.getCenter().getY());
    }


    @Test
    public void testMoveShapeEmpty() {

        AsciiPaint paint = new AsciiPaint(30, 30);
        assertThrows(IndexOutOfBoundsException.class, () ->  paint.moveShape(0,20,20));
    }


    @Test
    public void testNormalChangeColorCircle() {

        AsciiPaint paint = new AsciiPaint(100, 100);
        paint.newRectangle(50,50,10,20,'r');
        paint.setColor(0,'v');
        assertEquals('v', paint.getShape(0).getcolor());
    }

    @Test
    public void testNormalChangeColorRectangle() {

        AsciiPaint paint = new AsciiPaint(100, 100);
        paint.newSquare(50,50,10,'s');
        paint.setColor(0,'v');
        assertEquals('v', paint.getShape(0).getcolor());
    }
    @Test
    public void testNormalChangeColorSquare() {

        AsciiPaint paint = new AsciiPaint(100, 100);
        paint.newCircle(50,50,10,'c');
        paint.setColor(0,'v');
        assertEquals('v', paint.getShape(0).getcolor());
    }

    @Test
    public void testNormalChangeColorLine() {
        AsciiPaint paint = new AsciiPaint(100, 100);
        paint.newLine(50,50,10,20,'r');
        paint.setColor(0,'v');
        assertEquals('v', paint.getShape(0).getcolor());
    }

    @Test
    public void testNormalMoveLine() {
        AsciiPaint paint = new AsciiPaint(300, 300);
        paint.newLine(0,0,200,200,'L');
        paint.moveShape(0,3,3);
        Line line = (Line) paint.getShape(0);
        assertEquals(3, line.getA().getX());
        assertEquals(3, line.getA().getY());
    }

    @Test
    public void testNormalChangeColorGroup() {

        AsciiPaint paint = new AsciiPaint(100, 100);
        paint.newRectangle(50,50,10,20,'r');
        paint.newLine(50,50,10,20,'r');
        paint.group(0,1);
        paint.setColor(0,'v');
        assertEquals('v', paint.getShape(0).getcolor());
    }


    @Test
    public void Undo(){
        AsciiPaint asciiPaint = new AsciiPaint(100,100);
        asciiPaint.newCircle(50,50,10,'c');
        asciiPaint.newCircle(50,50,10,'r');
        asciiPaint.group(0,1);
        asciiPaint.undo();
        assertTrue(asciiPaint.getDrawing().getShapes().get(0) instanceof Circle);
    }

    @Test
    public void redo(){
        AsciiPaint asciiPaint = new AsciiPaint(100,100);
        asciiPaint.newCircle(50,50,10,'c');
        asciiPaint.newCircle(50,50,10,'r');
        asciiPaint.group(0,1);
        asciiPaint.undo();
        asciiPaint.redo();
        assertTrue(asciiPaint.getDrawing().getShapes().get(0) instanceof Group);
    }

    @Test
    public void deleteShape(){
        AsciiPaint asciiPaint = new AsciiPaint(100,100);
        asciiPaint.newCircle(50,50,10,'c');
        asciiPaint.newRectangle(50,50,10,10,'r');
        asciiPaint.deleteShape(0);
        assertTrue(asciiPaint.getDrawing().getShapes().get(0) instanceof Rectangle);
    }






}