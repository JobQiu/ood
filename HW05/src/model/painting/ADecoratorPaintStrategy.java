package model.painting;

import java.awt.geom.AffineTransform;

/**
 * Abstract class that provides default behavior for subclasses 
 * that will decorate another IPaintStrategy to add functionality to that strategy. 
 * All this class's methods do is to simply delegate to the decoree. 
 */
public abstract class ADecoratorPaintStrategy extends APaintStrategy{

	/**
	 * The "decoree" paint strategy whose methods are being augmented by this decorator paint strategy.
	 * @param decoree The decoree
	 */
	public ADecoratorPaintStrategy(APaintStrategy decoree) {
		super(new AffineTransform());
	}
}
