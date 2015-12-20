package model.strategy;

import model.Ball;

/**
 * Ball's strategy to change its speed
 * @author JacobChen
 *
 */
public class SpeedStrategy implements IUpdateStrategy {

	/** whether the ball is slowing down or not */
	private boolean slowDown = false;

	/*
	 * A timer counter used to decide when to slow down or speed up
	 */
	private int counter = 0;

	/* (non-Javadoc)
	 * @see strategies.IUpdateStrategy#updateState(model.Ball)
	 * this updateState strategy is used to change
	 * the ball's speed all the time
	 * @param the ball to update state
	 */
	@Override
	public void updateState(Ball _ball) {

		/*
		 * direction change of ball
		 */
		int xDirection = 1;
		if (_ball.getVelX() < 0) {
			xDirection = -1;
		}
		int yDirection = 1;
		if (_ball.getVelY() < 0) {
			yDirection = -1;
		}

		/*
		 * change the ball's speed
		 */
		if (slowDown) {
			_ball.setVelX(_ball.getVelX() - xDirection);
			_ball.setVelY(_ball.getVelY() - yDirection);
		} else {
			_ball.setVelX(_ball.getVelX() + xDirection);
			_ball.setVelY(_ball.getVelY() + yDirection);
		}

		/*
		 * update the counter
		 */
		counter += 1;
		if (counter >= 50) {
			slowDown = !slowDown;
			counter = 0;
		}
	}
}
