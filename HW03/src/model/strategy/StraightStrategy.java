package model.strategy;

import model.Ball;

/**
 * Ball's strategy to move by default
 * @author JacobChen
 *
 */
public class StraightStrategy implements IUpdateStrategy {

	/* (non-Javadoc)
	 * @see strategies.IUpdateStrategy#updateState(model.Ball)
	 * No-op for StraightStrategy
	 * @param the ball to update state
	 */
	public void updateState(Ball _ball) {
		// Does what by default
	}
}
