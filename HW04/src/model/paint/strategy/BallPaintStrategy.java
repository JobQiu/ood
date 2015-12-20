package model.paint.strategy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import model.Ball;
import model.IPaintStrategy;

/**
 * Paint strategy that paints a filled circle with the Ball's radius. 
 * @author ls53@rice.edu
 */
public class BallPaintStrategy implements IPaintStrategy {
    
    /**
     * The AffineTransformed used for internal calculations.
     */
    private AffineTransform at;
    
    /**
     * Unit sized circle used as a prototype
     */
    private Ellipse2D.Double ball;
    
    /**
     * No parameter constructor that creates a 1 pixel radius ball at the origin.
     */
    public BallPaintStrategy() {
        this(new AffineTransform(), 0, 0, 1, 1);
    }
    
    /**
     * Constructor that allows one to create the prototype ball of arbitrary dimension and location.
     * @param at The AffineTransform to use for internal calculations
     * @param x floating point x-coordinate of center of circle
     * @param y floating point y-coordinate of center of circle
     * @param width floating point x-radius of the circle (ellipse)
     * @param height floating point y-radius of the circle (ellipse)
     */
    public BallPaintStrategy(AffineTransform at, double x, double y, double width, double height) {
        this.at = at;
        double diameter = 2 * width;
        this.ball = new Ellipse2D.Double(x - width, y - height, diameter, diameter);
    }
    
    /**
     * By default, do nothing for initialization.
     * @param host The ball to initialize.
     */
    @Override
    public void init(Ball host) {}
    
    /**
     * Paints the host onto the given Graphics context. The image is translated, 
     * scaled and rotated as determined by the host's location, radius, and velocity.
     * @param g The graphics context to draw upon.
     * @param host The host ball.
     */
    @Override
    public void paint(Graphics g, Ball host) {
        double scale = host.getRadius();
        at.setToTranslation(host.getLocation().getX(), host.getLocation().getY());
        at.scale(scale, scale);
        g.setColor(host.getColor());
        paintXfrm(g, host, at);
    }
    
    /**
     * Paints a transformed circle, as per the given AffineTransform Uses 
     * color already set in Graphics context
     * @param g The Graphics context to paint on
     * @param host The Ball host
     * @param at the AffineTransform to use
     */
    public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
        ((Graphics2D)g).fill(at.createTransformedShape(ball));
    }
}