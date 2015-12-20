package model.painting;


import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.Ball;
/**
 * A composite design pattern extension of APaintStrategy that paints a set of paint strategies. 
 * @author caojian
 */
public abstract class MultiPaintStrategy extends APaintStrategy{

	/**The set of paint strategies to paint*/
	private APaintStrategy[] pstrats;
	
	/**
	 * Constructor that takes the paint strategies that will part of the composite.
	 * @param at The affine transform object
	 * @param pstrats The paint strategy
	 */
	public MultiPaintStrategy(AffineTransform at, APaintStrategy... pstrats){
		super(at);
		this.pstrats = pstrats;
	}
	
	/**
	 * Constructor that takes the paint strategies that will part of the composite.
	 * @param pstrats The paint strategy
	 */
	public MultiPaintStrategy(APaintStrategy... pstrats) {
		this(new AffineTransform(),  pstrats);
	}

	/**Delegates to all the IPaintStrategies in the composite.*/
	public void init(Ball host){
		for (APaintStrategy strategy : pstrats) {
		    strategy.init(host);
		}
	}
	
	/**Delegates to all the IPaintStrategies in the composite.*/
	public void paintXfrm(Graphics g, Ball host, AffineTransform at){
		for (APaintStrategy strategy : pstrats) {
			strategy.paintXfrm(g, host, at);
		}
	}
}
