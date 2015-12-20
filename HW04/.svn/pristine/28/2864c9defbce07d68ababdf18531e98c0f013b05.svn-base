package model.paint.strategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.Ball;
import model.paint.FixedColorDecoratorPaintStrategy;
import model.paint.MultiplePaintStrategy;

/**
 * Subclass of MultiPaintStrategy that uses a SwimFishPaintStrategy 
 * and an EllipsePaintStrategy to paint a swimming fish shape that has an eye.
 * @author ls53@rice.edu
 */
public class NiceFishPaintStrategy extends MultiplePaintStrategy {
    /**
     * No-parameter constructor that instantiates the AffineTransform for internal use.
     */
    public NiceFishPaintStrategy() {
        this(new AffineTransform());
    }
    
    /**
     * Constructor that uses an externally supplied AFfineTransform for internal use.
     * @param at The AffineTransform to use.
     */
    public NiceFishPaintStrategy(AffineTransform at) {
        super(new SwimFishPaintStrategy(), 
              new FixedColorDecoratorPaintStrategy(Color.BLACK, new EllipsePaintStrategy(at, 0.3, -0.15, 0.1, 0.1)));
    }
    
    /**
     * Override paintCfg to add the transform needed to keep the fish upright at all times.
     * @param g The Graphics context that will be drawn upon.
     * @param host The host ball
     */
    protected void paintCfg(Graphics g, Ball host) {
        if (Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x)) > Math.PI / 2.0) {
            at.scale(1.0, -1.0);
        }
    }
}
