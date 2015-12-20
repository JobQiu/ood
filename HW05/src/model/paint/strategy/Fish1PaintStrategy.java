package model.paint.strategy;

import java.awt.geom.AffineTransform;

import model.paint.shape.Fish1PolygonFactory;
import model.painting.ShapePaintStrategy;

/** 
 * concrete paint strategy to paint a fish shape
 */ 
public class Fish1PaintStrategy extends ShapePaintStrategy{

	/**
	   * No parameter constructor that creates a prototype fish that 
	   * has twice the width as height but an average radius of 1.
	   * An AffineTranform for internal use is instantiated.
	   */
	public Fish1PaintStrategy(){
		  this(new AffineTransform(), 0.0, 0.0, 2.0/3.0, 4.0/3.0);
	  }
	  
	  
	/**
	   * Constructor that allows the specification of the location, x-radius and y-radius
	   * of the prototype ellipse.   The AffineTransform to use is given.
	   * @param at The AffineTransform to use for internal calculations
	   * @param x floating point x-coordinate of center of circle
	   * @param y floating point y-coordinate of center of circle
	   * @param width floating point x-radius of the circle (ellipse)
	   * @param height floating point y-radius of the circle (ellipse)
	   */
	public Fish1PaintStrategy(AffineTransform at, double x, double y, double width, double height){
		  
		super(at, new Fish1PolygonFactory().makeShape(x,y,width,height));
	}
}
