package model.strategy;

import model.Ball;
import util.Dispatcher;

/**
 * An IUpdateStrategy implementation that represents a pair of two strategies.
 *
 */
public class MultiStrategy implements IUpdateStrategy {
	/**
	 * The first update strategy.
	 */
	private IUpdateStrategy strategy1;
	/**
	 * The second update strategy.
	 */
	private IUpdateStrategy strategy2;
	
	/**
	 * Construct a multistrategy as a combination  of two given update strategies.
	 * @param strat1 the first update strategy to combine
	 * @param strat2 the second update strategy to combine
	 */
	public MultiStrategy(IUpdateStrategy strat1, IUpdateStrategy strat2) {
		if(null == strat1) {
			throw new IllegalArgumentException("Strategy 1 is null");
		}
		if(null == strat2) {
			throw new IllegalArgumentException("Strategy 2 is null");
		}
		this.strategy1 = strat1;
		this.strategy2 = strat2;
	}

	@Override
	public void updateState(Ball context, Dispatcher dispatcher) {
		strategy1.updateState(context, dispatcher);
		strategy2.updateState(context, dispatcher);
	}

}
