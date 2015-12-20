package model.paint.shape;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Concrete IShapeFactory that instantiates Rectangle2d.Double shapes.
 * @author ls53@rice.edu
 */
public class RectangleShapeFactory implements IShapeFactory {
    
    /**
     * Singleton pattern
     */
    public static final RectangleShapeFactory Singleton = new RectangleShapeFactory();
    
    /**
     * Constructor for Singleton pattern
     */
    private RectangleShapeFactory() {}
    
    /**
     * Returns a Shape object centered at (x, y) and with the specified x and y dimensions.
     * @param x x-coordinate of the center of the shape
     * @param y y-coordinate of the center of the shape
     * @param xScale The x-dimension of the shape, usually the x-radius.
     * @param yScale The y-dimension of the shape, usually the y-radius.
     * @return A Shape instance.
     */
    @Override
    public Shape makeShape(double x, double y, double xScale, double yScale) {
        return new Rectangle2D.Double(x - xScale, y - yScale, 2 * xScale, 2 * yScale);
    }
}
