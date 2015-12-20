package model.paint.shape;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
/**
 * Paint strategy that paints a filled circle with the Ball's radius. 
 * @author caojian
 *
 */
public class BallShapeFactory implements IShapeFactory{

	/**Singleton pattern*/
	public static final BallShapeFactory Singleton = new BallShapeFactory();

	@Override
	/**Instantiates a ball*/
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		
		return new Ellipse2D.Double(x, y, xScale, yScale);
	}
	
}
