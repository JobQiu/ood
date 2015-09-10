package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author ls53@rice.edu
 * The concrete class oval that extends from AShape
 */
public class Oval extends AShape {

    /*
     * The width of an oval
     */
    private int width;

    /**
     * The height of an oval
     */
    private int height;

    /**
     * The constructor for an oval
     * @param location The upper left corner of an oval
     * @param color The color of an oval
     * @param width The width of an oval
     * @param height The height of an oval
     */
    public Oval(Point location, Color color, int width, int height) {
        this.location = location;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    /**
     * The painting method for an oval
     * @param g The Graphics object to paint an oval
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(location.x, location.y, width, height);
    }
}