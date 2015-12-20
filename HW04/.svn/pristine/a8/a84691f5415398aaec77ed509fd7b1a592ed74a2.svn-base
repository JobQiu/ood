package model.paint;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.Ball;

/**
 * Abstract class that provides default behavior for subclasses 
 * that will decorate another IPaintStrategy to add functionality 
 * to that strategy. All this class's methods do is to simply 
 * delegate to the decoree. A subclass should override one or more 
 * methods, adding additional processing either before or after 
 * delegating to the decoree. Note that this class cannot be used 
 * by the BallWorld system directly as it lacks a no-parameter 
 * constructor.
 * @author ls53@rice.edu
 */
public class ADecoratorPaintStrategy extends APaintStrategy {
    
    /**
     * The "decoree" paint strategy whose methods are being augmented by this decorator paint strategy.
     */
    private APaintStrategy decoree;
    
    /**
     * Constructor that takes the decoree paint strategy
     * @param decoree The paint strategy that is to be decorated
     */
    public ADecoratorPaintStrategy(APaintStrategy decoree) {
        super(new AffineTransform());
        this.decoree = decoree;
    }
    
    /**
     * Default behavior is to simply delegate to the decoree's init method
     * @param host The host Ball which is passed to the decoree.
     */
    @Override
    public void init(Ball host) {
        decoree.init(host);
    };
    
    /**
     * Paints the host onto the given Graphics context. The image 
     * is translated, scaled and rotated as determined by the given 
     * affine transformation. This method is intended to be called 
     * either by a class's (or superclass's) own paint method or 
     * by another paint strategy who is sharing the affine transform. 
     * This allows the same transformation to be shared amongst 
     * multiple paint strategies.
     * @param g The graphics context to draw upon.
     * @param host The host ball.
     * @param at The affine transform to use.
     */
    @Override
    public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
        decoree.paintXfrm(g, host, at);
    }
    
    /**
     * Paints on the given graphics context using the color, 
     * scale and direction provided by the host. This is done 
     * by setting up the AffineTransform to rotate then scale 
     * then translate. Calls paintXfrm to actually perform the 
     * painting, using the set up transform. Calls paintCfg 
     * just before calling paintXfrm
     * @param g The Graphics context that will be paint on
     * @param host The host Ball that the required information will be pulled from.
     */
    @Override
    public void paint(Graphics g, Ball host) {
        decoree.paint(g, host);
    }
}
