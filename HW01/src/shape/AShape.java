package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author ls53@rice.edu
 * Abstract class for shape
 */
public abstract class AShape {

    /**
     * The upper left corner of a shape
     */
    protected Point location;

    /**
     * The color of a shape
     */
    protected Color color;

    /**
     * The abstract painting method for an abstract shape
     * @param g The Graphics object to paint an abstract shape
     */
    public abstract void paint(Graphics g);

    /**
     * Get the location of an abstract shape
     * @return The location of an abstract shape
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Set the location of an abstract shape
     * @param location The location of an abstract shape
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * Get the color for an abstract shape
     * @return The color for an abstract shape
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set the color for an abstract shape
     * @param color The color for an abstract shape
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
