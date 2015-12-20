package model.paint.shape;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Concrete shape factory that instantiates Ellipse2D.Double shapes.
 * @author caojian
 *
 */
public class EllipseShapeFactory implements IShapeFactory{
    
    /**
     * The singleton
     */
	public static final EllipseShapeFactory Singleton = new EllipseShapeFactory();

	@Override
	/**Instantiates an ellipse*/
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		
		return new Ellipse2D.Double(x, y, xScale, yScale);
	}

}
