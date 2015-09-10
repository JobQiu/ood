package shape;

import java.awt.Graphics;
import java.awt.Point;

/**
 * @author ls53@rice.edu
 * The Composite Shape with two simple shapes
 */
public class BinaryShape extends AShape {

    /**
     * Two simple shapes
     */
    private AShape[] shapes;

    /**
     * The constructor for BinaryShape
     * @param shape1 The first shape
     * @param shape2 The second shape
     */
    public BinaryShape(AShape shape1, AShape shape2) {
        shapes = new AShape[] { shape1, shape2 };

        int locX = (shape1.getLocation().getX() < shape2.getLocation().getX()) ? (int) shape1.getLocation().getX()
                : (int) shape2.getLocation().getX();
        int locY = (shape1.getLocation().getY() < shape2.getLocation().getY()) ? (int) shape1.getLocation().getY()
                : (int) shape2.getLocation().getY();
        this.location = (new Point(locX, locY));
    }

    /**
     * The painting method for BinaryShape
     * @param g The Graphics object to paint BinaryShape
     */
    @Override
    public void paint(Graphics g) {
        for (AShape shape : shapes) {
            shape.paint(g);
        }
    }

    /**
     * Set the location of BinaryShape
     * @param location The location of BinaryShape
     */
    @Override
    public void setLocation(Point location) {
        int xMove = (int) location.getX() - (int) this.getLocation().getX();
        int yMove = (int) location.getY() - (int) this.getLocation().getY();

        for (AShape shape : shapes) {
            Point oriLoc = shape.getLocation();
            Point newLoc = new Point((int) oriLoc.getX() + xMove, (int) oriLoc.getY() + yMove);
            shape.setLocation(newLoc);
        }
    }

}