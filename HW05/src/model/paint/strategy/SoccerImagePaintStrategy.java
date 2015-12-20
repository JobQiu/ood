package model.paint.strategy;


import java.awt.geom.AffineTransform;

import model.painting.ImagePaintStrategy;

/**
 * strategy that paints a FIFA soccer ball image on the screen
 * @author caojian
 *
 */
public class SoccerImagePaintStrategy extends ImagePaintStrategy{

	/**
	 * The path of image file
	 */
	private static final String filename = "images/FIFA_Soccer_Ball.png";
	
	/**
	 * The affine transform object
	 */
	private static AffineTransform at = new AffineTransform();
	
	/**
	 * The fill factor
	 */
	private static double fillFactor = 0.7;
	
	/**
	 * Constructor that loads the soccer ball image
	 */
	public SoccerImagePaintStrategy() {
		super(at, filename, fillFactor);
	}
} 
