package model.paint.strategy;

import java.awt.geom.AffineTransform;

import model.paint.ShapePaintStrategy;
import model.paint.shape.EllipseShapeFactory;

/**
 * Paint strategy to paint an ellipse shape
 * @author ls53@rice.edu
 */
public class EllipsePaintStrategy extends ShapePaintStrategy {
    
    /**
     * No parameter constructor that creates a prototype ellipse 
     * that has twice the width as height but an average radius of 1.
     */
    public EllipsePaintStrategy() {
        this(new AffineTransform(), 0, 0, 5, 2);
    }
    
    /**
     * No parameter constructor that creates a prototype ellipse that has twice the width as height but 
     * an average radius of 1. An AffineTranform for internal use is instantiated.
     * @param at The AffineTransform to use for internal calculations
     * @param x floating point x-coordinate of center of circle
     * @param y floating point y-coordinate of center of circle
     * @param xScale floating point x-radius of the circle (ellipse)
     * @param yScale floating point y-radius of the circle (ellipse)
     */
    public EllipsePaintStrategy(AffineTransform at, double x, double y, double xScale, double yScale) {
        super(at, EllipseShapeFactory.Singleton.makeShape(x, y, xScale, yScale));
    }
}
