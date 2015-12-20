package model.paint;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.Ball;

/**
 * Concrete paint strategy that cycles through a sequence 
 * of paint strategies, painting one per paint update. 
 * Note: This paint strategy cannot be directly instantiated 
 * by the BallWorld system because it does not have a no-parameter 
 * constructor.
 * @author ls53@rice.edu
 */
public class AnimatePaintStrategy extends APaintStrategy {
    
    /**
     * The paint strategies to cycle through
     */
    private APaintStrategy[] paintStrategies;
    
    /**
     * The counter that keeps track of which paint strategy to use next.
     */
    private int count;
    
    /**
     * Constructor that instantiates an AffineTransform for internal use.
     * @param paintStrategies vararg input of the paint strategies to cycle through, in order.
     */
    public AnimatePaintStrategy(APaintStrategy... paintStrategies) {
        this(new AffineTransform(), paintStrategies);
    }
    
    /**
     * Constructor that uses the supplied AffineTransform for internal use.
     * @param at The AffineTransform to use.
     * @param paintStrategies vararg input of the paint strategies to cycle through, in order.
     */
    public AnimatePaintStrategy(AffineTransform at, APaintStrategy... paintStrategies) {
        super(at);
        this.paintStrategies = paintStrategies;
    }
    
    /***
     * Paints the currently indexed paint strategy on the given Graphics 
     * context using the supplied AffineTransform. Called by the inherited 
     * paint method.
     * @param g The graphics context to draw upon.
     * @param host The host ball.
     * @param at The affine transform to use.
     */
    @Override
    public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
        paintStrategies[count++].paintXfrm(g, host, at);
        if (count == paintStrategies.length) {
            count = 0;
        }
    }

}
