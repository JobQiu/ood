package model.paint.shape;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

/**
 * Concrete IShapeFactory that provides the invariant behavior 
 * to instantiate a Shape that is a Polygon. This class can be 
 * instantiated and used simply by supplying the desired points 
 * in its constructor, or sub-classed an the constructor overridden. 
 * Note that this class cannot be used directly by the BallWar system 
 * because it does not have a no-parameter constructor.
 * @author ls53@rice.edu
 */
public class PolygonFactory implements IShapeFactory {
    
    /**
     * The Polygon shape to use as the prototype.
     */
    private Polygon poly = new Polygon();
    
    /**
     * The AffineTransform used for internal calculations
     */
    private AffineTransform at;
    
    /**
     * Scale factor that scales the integer Point-defined 
     * Polygon to a unit size, which requires doubles.
     */
    private double scaleFactor = 1.0;
    
    /**
     * Constructor that uses an externally defined AffineTransform for internal 
     * use plus takes the defining points of the prototype Polygon and a scale 
     * factor to scale the given points to the desired unit size.
     * @param at The AffineTransform to use.
     * @param scaleFactor The ratio of the desired unit size to the defined size 
     * of the prototype Polygon.
     * @param points Vararg parameters that are the Points that define the 
     * Polygon around the origin as its center.
     */
    public PolygonFactory(AffineTransform at, double scaleFactor, Point...points) {
        this.at = at;
        this.scaleFactor = scaleFactor;
        for (Point point : points) {
            poly.addPoint(point.x, point.y);
        }
    }
    
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
        at.setToTranslation(x, y);
        at.scale(xScale * scaleFactor, yScale * scaleFactor);
        return at.createTransformedShape(poly);
    }
}
