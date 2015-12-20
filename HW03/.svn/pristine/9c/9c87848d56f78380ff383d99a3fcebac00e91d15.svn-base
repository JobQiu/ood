package model.strategy;

import model.Ball;
import util.Randomizer;

/**
 * Ball's strategy to change its color
 * @author JacobChen
 *
 */
public class ColorStrategy implements IUpdateStrategy {

	/* (non-Javadoc)
	 * @see strategies.IUpdateStrategy#updateState(model.Ball)
	 * this updateState strategy is used to randomly change
	 * the ball's color
	 */
	@Override
	public void updateState(Ball _ball) {
		/** set color randomly */
		_ball.setColor(Randomizer.Singleton.randomColor());
	}
}
