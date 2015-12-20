package model.paint.strategy;


import java.awt.Color;
import java.awt.geom.AffineTransform;

import model.Ball;
import model.painting.APaintStrategy;
import model.painting.FixedColorDecoratorPaintStrategy;
import model.painting.MultiPaintStrategy;
/** 
 * multi paint strategy to paint a fish with black eye
 */ 
public class NiceFishPaintStrategy extends MultiPaintStrategy{

	/**fish paint strategy*/
	private static APaintStrategy strat1 = new Fish1PaintStrategy();
	/** decorate paint strategy to keep the eye black*/
	private static APaintStrategy strat2 = new FixedColorDecoratorPaintStrategy(Color.black, new EllipsePaintStrategy(new AffineTransform(), 1.8, 1.0, 1.0/3.0, 1.0/3.0));
	
	/**
	 * Override paintCfg to add the transform needed to keep the fish upright at all times.
	 */
	protected void paintCfg(java.awt.Graphics g, Ball host){
		super.paintCfg(g, host);
		if(Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x))> Math.PI/2.0) {
			at.scale(1.0, -1.0);
	    }
	}
	
    /**
     * No-parameter constructor that instantiates the AffineTransform for internal use.
     */
	public NiceFishPaintStrategy(){
		super(strat1, strat2);
	}
}
