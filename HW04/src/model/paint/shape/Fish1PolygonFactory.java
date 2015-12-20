package model.paint.shape;

import java.awt.Point;
import java.awt.geom.AffineTransform;

/**
 * Concrete PolygonFactory that creates fish-shaped Polygons that have a longer tail and an open mouth.
 * @author ls53@rice.edu
 */
public class Fish1PolygonFactory extends PolygonFactory {
    /**
     * Constructor that calls the PolygonFactory superclass 
     * constructor with the scale factor and polygon points 
     * that define the fish shape.
     */
	public Fish1PolygonFactory() {
		super(new AffineTransform(), 0.1, new Point(-5, 2), 
		                                  new Point(-5, -2), 
		                                  new Point(-3, 0), 
		                                  new Point(3, -3), 
		                                  new Point(5, -1), 
		                                  new Point(3, 0), 
		                                  new Point(5, 1), 
		                                  new Point(3, 3), 
		                                  new Point(-3, 0));
	}

}
