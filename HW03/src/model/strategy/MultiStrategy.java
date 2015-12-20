package model.strategy;

import model.Ball;

/**
 * Hold two strategy instance to make a combination
 * @author JacobChen
 *
 */
public class MultiStrategy implements IUpdateStrategy {
	/**
	 * two strategy instance that will be combined
	 */
	private IUpdateStrategy is1;
	private IUpdateStrategy is2;

	/**
	 * constructor for MultiStrategy
	 * @param _is1 strategy instance one
	 * @param _is2 strategy instance two
	 */
	public MultiStrategy(IUpdateStrategy _is1, IUpdateStrategy _is2) {
		is1 = _is1;
		is2 = _is2;
	}

	/* (non-Javadoc)
	 * @see strategies.IUpdateStrategy#updateState(model.Ball)
	 * Update state for balls of both strategies
	 * @param _ball the ball of the desired strategy that will update state
	 */
	public void updateState(Ball _ball) {
		is1.updateState(_ball);
		is2.updateState(_ball);
	}
}