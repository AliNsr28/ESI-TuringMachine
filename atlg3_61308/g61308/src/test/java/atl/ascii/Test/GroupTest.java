package atl.ascii.Test;

import atl.ascii.model.Circle;
import atl.ascii.model.Drawing;
import atl.ascii.model.Group;
import atl.ascii.model.Point;
import org.junit.jupiter.api.Test;

public class GroupTest {

    @Test
    public void Group(){
        Drawing drawing = new Drawing(100,100);
        Circle circle = new Circle(new Point(50, 50), 10, 'c');
        Circle circle1 = new Circle(new Point(0, 0), 10, 'r');
        Group group = new Group('c');
        drawing.addShape(group);

    }
}
