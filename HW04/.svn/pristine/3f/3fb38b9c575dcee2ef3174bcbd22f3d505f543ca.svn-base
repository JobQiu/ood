package model.paint;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.Ball;

/**
 * A composite design pattern extension of APaintStrategy 
 * that paints a set of paint strategies. Note: This paint 
 * strategy cannot be used directly by the BallWorld system 
 * because it lacks a no-parameter constructor.
 * @author ls53@rice.edu
 */
public class MultiplePaintStrategy extends APaintStrategy {
    
    /**
     * The set of paint strategies to paint
     */
    private APaintStrategy[] paintStrategies;
    
    /**
     * Constructor that takes the paint strategies that will part 
     * of the composite. An AffineTransform is instantiated for 
     * internal use.
     * @param paintStrategies Vararg parameter that are the paint strategies that will make up the composite.
     */
    public MultiplePaintStrategy(APaintStrategy... paintStrategies) {
        this(new AffineTransform(), paintStrategies);
    }
    
    /**
     * Constructor that takes the paint strategies that will part of the composite. 
     * An external AffineTransform is supplied for internal use.
     * @param at The AffineTransform to use.
     * @param paintStrategies Vararg parameter that are the paint strategies that will make up the composite.
     */
    public MultiplePaintStrategy(AffineTransform at, APaintStrategy... paintStrategies) {
        super(at);
        this.paintStrategies = paintStrategies;
    }
    
    /**
     * Delegates to all the IPaintStrategies in the composite. Used to initialize the paint strategies.
     * @param host The host ball
     */
    public void init(Ball host) {
        for (APaintStrategy strategy : paintStrategies) {
            strategy.init(host);
        }
    }
    
    /**
     * Delegates to all the IPaintStrategies in the composite. Paints using given Graphics context 
     * using the supplied AffineTransform. Called by the inherited paint method.
     * @param g The Graphics context to paint upon.
     * @param host The host Ball
     * @param at The AffineTransform to use
     */
    @Override
    public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
        for (APaintStrategy strategy : paintStrategies) {
            strategy.paintXfrm(g, host, at);
        }
    }
}