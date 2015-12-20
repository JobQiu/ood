package model.painting;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import model.Ball;
import model.IPaintStrategy;

/**
 * This class provides the basic affine transform services that
 * its subclasses will use to resize, translate and rotate their prototype images 
 * into their proper current locations and orientations on the screen.
 * @author caojian
 *
 */
public abstract class APaintStrategy implements IPaintStrategy{
	
    /**
     * The affine transform object
     */
	protected AffineTransform at = new AffineTransform();
	
	/**
	 * This method allows the subclass to inject additional processing 
	 * into the paint method process before the final transformations are performed.    
	 * @param g The graphics object to paint
	 * @param host The Ball
	 */
	protected void paintCfg(Graphics g, Ball host){}
	
	/**
	 * The constructor for APaintStrategy
	 * @param at The affine transform object
	 */
	public APaintStrategy(AffineTransform at){
		this.at = at;
	}


	/**
	 * A secondary paint operation that uses a supplied affine transform.  
	 * This allows the same affine transform to be shared amongst paint strategies, 
	 * reducing the number of times that it has to be calculated.
	 * @param g The graphics to paint
	 * @param host The ball
	 * @param at The affine transform object
	 */
	public abstract void paintXfrm(Graphics g, Ball host, AffineTransform at);
	
	/**
	 * The paint method
	 */
	public void paint(Graphics g, Ball host) {
		Point scale = host.getDimension();
		at.setToTranslation(host.getLocation().x, host.getLocation().y);
		at.scale(scale.x, scale.y);
		at.rotate(Math.atan2(host.getVelocity().y, host.getVelocity().x));
		g.setColor(host.getColor());    
		paintCfg(g, host);
		paintXfrm(g, host, at);
	}
}