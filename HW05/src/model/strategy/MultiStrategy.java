package model.strategy;

import model.Ball;
import model.IUpdateStrategy;
import util.IDispatcher;

/**
 * a strategy capable of composing arbitrarily complex behaviors
 *
 */
public class MultiStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg>{

	/** the first strategy */
	private IUpdateStrategy<TDispMsg> strat1;
	/** the second strategy */
	private IUpdateStrategy<TDispMsg> strat2;
	
	/**
	 * construct that takes in two individual strategies
	 * @param strat1 The first strategy
	 * @param strat2 The second strategy
	 */
	public MultiStrategy(IUpdateStrategy<TDispMsg> strat1, IUpdateStrategy<TDispMsg> strat2){
		this.strat1 = strat1;
		this.strat2 = strat2;
	}
	
	@Override
	/**
	 * Initializes the strategy.   Should be called every time the Ball sets a new strategy.
	 * @param context  The ball using this strategy.
	 */
	public void init(Ball context){}
	
	@Override
	/**
	 * Update the state of the context Ball.
	 * @param context  The context (host) Ball whose state is to be updated
	 * @param dispatcher  The Dispatcher who sent the command that is calling through to here.
	 */
	public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher) {
		strat1.updateState(context, dispatcher);
		strat2.updateState(context, dispatcher);
	}
}
