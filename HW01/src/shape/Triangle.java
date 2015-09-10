package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author ls53@rice.edu
 * The concrete class triangle that extends from AShape
 */
public class Triangle extends AShape {

    /**
     * A series of x-coordinates for a triangle
     */
    private int xPoints[];

    /**
     * A series of y-coordinates for a triangle
     */
    private int yPoints[];

    /**
     * The constructor for a triangle
     * @param color The color of a triangle
     * @param A The location of a angle
     * @param B The location of a angle
     * @param C The location of a angle
     */
    public Triangle(Color color, Point A, Point B, Point C) {
        this.xPoints = new int[] { (int) A.getX(), (int) B.getX(), (int) C.getX() };
        this.yPoints = new int[] { (int) A.getY(), (int) B.getY(), (int) C.getY() };

        this.color = color;
        this.location = findLocation();
    }

    /**
     * The painting method for a triangle
     * @param g The Graphics object to paint a triangle
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    /**
     * Find the upper left corner of a triangle
     * @return The upper left corner of a triangle
     */
    private Point findLocation() {

        int x = xPoints[0] < xPoints[1] ? (xPoints[0] < xPoints[2] ? xPoints[0] : xPoints[2])
                : (xPoints[1] < xPoints[2] ? xPoints[1] : xPoints[2]);

        int y = yPoints[0] > yPoints[1] ? (yPoints[0] > yPoints[2] ? yPoints[0] : yPoints[2])
                : (yPoints[1] > yPoints[2] ? yPoints[1] : yPoints[2]);

        return new Point(x, y);
    }

    /**
     * Set the location of a triangle
     * @param location The location of a triangle
     */
    @Override
    public void setLocation(Point location) {
        int xOri = (int) this.location.getX();
        int yOri = (int) this.location.getY();

        int xNew = (int) location.getX();
        int yNew = (int) location.getY();

        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] += (xNew - xOri);
            yPoints[i] += (yNew - yOri);
        }

        this.location = location;
    }
}