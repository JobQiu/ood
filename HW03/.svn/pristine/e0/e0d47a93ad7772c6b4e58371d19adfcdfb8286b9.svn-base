package model.strategy;

import java.awt.Point;

import model.Ball;
import util.Randomizer;

/**
 * Ball's strategy to change its movement
 * @author Li Shen
 *
 */
public class WanderStrategy implements IUpdateStrategy {

	/* (non-Javadoc)
	 * @see model.strategy.IUpdateStrategy#updateState(model.Ball)
	 * this updateState strategy is used to change
	 * the ball's movement all the time
	 */
	@Override
	public void updateState(Ball _ball) {
		/** current velocity */
		Point velocity = _ball.getVelocity();
		velocity.x += Randomizer.Singleton.randomInt(-5, 5);
		velocity.y += Randomizer.Singleton.randomInt(-5, 5);
	}
}
