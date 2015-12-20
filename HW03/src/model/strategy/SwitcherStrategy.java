package model.strategy;

import model.Ball;

/**
 * Switch the ball's strategy
 * @author Li Shen
 *
 */
public class SwitcherStrategy implements IUpdateStrategy {

	/** strategy to switch to */
	private IUpdateStrategy strategy;

	/** Constructor of the class to init the strategy to StraightStrategy. */
	public SwitcherStrategy() {
		this.strategy = new StraightStrategy();
	}

	/* (non-Javadoc)
	 * @see model.strategy.IUpdateStrategy#updateState(model.Ball)
	 * Update the state of the ball with desired strategy
	 * @param _ball the ball to update strategy 
	 */
	@Override
	public void updateState(Ball _ball) {
		strategy.updateState(_ball);
	}

	/**
	 * Sets the strategy to the new switcherStrategy
	 * @param strategy the strategy the switcher holds
	 */
	public void setStrategy(IUpdateStrategy strategy) {
		this.strategy = strategy;
	}
}
