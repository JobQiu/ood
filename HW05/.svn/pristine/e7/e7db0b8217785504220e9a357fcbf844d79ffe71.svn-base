package model.paint.strategy;

import java.awt.geom.AffineTransform;
import model.painting.ShapePaintStrategy;
import model.paint.shape.*;

/** 
 * concrete paint strategy to paint a ball shape
 */ 
public class BallPaintStrategy extends ShapePaintStrategy {
  
  /**
   * No parameter constructor that creates a prototype ball that 
   * has an radius of 1.
   * An AffineTranform for internal use is instantiated.
   */
  public BallPaintStrategy(){
    this(new AffineTransform(), 0, 0, 1, 1);
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
  public BallPaintStrategy(AffineTransform at, double x, double y, double width, double height){
    super(at, BallShapeFactory.Singleton.makeShape(x,y,width,height));
  }
}