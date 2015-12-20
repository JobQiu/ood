package model.strategy;

import model.Ball;
import util.Dispatcher;

/**
 * An IUpdateStrategy implementation that updates the radius of a ball.
 *
 */
public class BreathingStrategy implements IUpdateStrategy {
	/**
	 * The maximum allowed radius of the ball.
	 */
	private final static int RADIUS_UPPER_LIMIT = 20;
	/**
	 * The minimum allowed radius of the ball.
	 */
	private final static int RADIUS_LOWER_LIMIT = 5;
	/**
	 * If the radius should be incremented or decremented.
	 */
	private boolean increasing = true;

	@Override
	public void updateState(Ball context, Dispatcher dispatcher) {
		if(context.getRadius() == RADIUS_UPPER_LIMIT) {
			increasing = false;
		}
		else if(context.getRadius() == RADIUS_LOWER_LIMIT) {
			increasing = true;
		}
		if(increasing) {
			context.setRadius(context.getRadius() + 1);
		}
		else {
			context.setRadius(context.getRadius() - 1);
		}
	}

}
