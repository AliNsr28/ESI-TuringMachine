package atl.ascii.Test;

import static org.junit.jupiter.api.Assertions.*;

import atl.ascii.model.AsciiException;
import atl.ascii.model.Point;
import atl.ascii.model.Rectangle;
import org.junit.jupiter.api.Test;




class RectangleTest {

@Test
    public void testConstructorValid() {
        new Rectangle(new Point(0, 0), 5, 5, 'r');
    }

    @Test
    public void testConstructorNullPoint() {
        assertThrows(AsciiException.class, ()
                -> new Rectangle(null, 5, 5, 'r'));
    }

    @Test
    public void testConstructorZeroWidth() {
        assertThrows(AsciiException.class, ()
                -> new Rectangle(new Point(5, 5), 0, 5, 'r'));
    }

    @Test
    public void testConstructorZeroHeight() {
        assertThrows(AsciiException.class, ()
                -> new Rectangle(new Point(5, 5), 10, 0, 'r'));
    }

    @Test
    public void testIsInside() {
        Rectangle rect = new Rectangle(new Point(0, 0), 5, 5, 'a');
        assertTrue(rect.isInside(new Point(0, 0)));
        assertTrue(rect.isInside(new Point(0, 4)));
        assertTrue(rect.isInside(new Point(4, 0)));
        assertTrue(rect.isInside(new Point(4, 4)));
        assertTrue(rect.isInside(new Point(2, 3)));
    }

    @Test
    public void testIsNotInside() {
        Rectangle rect = new Rectangle(new Point(10, 10), 10, 5, '%');
        assertFalse(rect.isInside(new Point(9, 9)));
        assertFalse(rect.isInside(new Point(21, 9)));
        assertFalse(rect.isInside(new Point(21, 16)));
        assertFalse(rect.isInside(new Point(11, 16)));
    }

    @Test
    public void testIsInsideNullPoint() {
        assertThrows(AsciiException.class, ()
                -> new Rectangle(null, 5, 20, '$'));
    }
}

