package model.painting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.Ball;

/**
 * Decorator paint strategy that decorates another IPaintStrategy and 
 * causes the painted color to always be a specified, fixed color. 
 * Useful when you want a shape that is a specific color and not the color of the host Ball.
 * @author caojian
 *
 */
public class FixedColorDecoratorPaintStrategy extends ADecoratorPaintStrategy {

	/** The paint strategy that will be decorated*/
    private APaintStrategy decoree;
	/**The color that will be painted.*/
    private Color color;
	
    /**
     * Constructor that takes the fixed color and the decoree strategy
     * @param color The color
     * @param decoree The decoree
     */
	public FixedColorDecoratorPaintStrategy(Color color, APaintStrategy decoree) {
		super(decoree);
		this.decoree = decoree;
		this.color = color;
	}

	@Override
	/**
	 * Default behavior is to simply delegate to the decoree's paintXfrm method
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		g.setColor(color);
		decoree.paintXfrm(g, host, at);
	}
	
	/**
	 * Initialization
	 */
	@Override
	public void init(Ball host) {}
}
