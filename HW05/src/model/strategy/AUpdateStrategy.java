/**
 * 
 */
package model.strategy;

import model.Ball;
import model.IUpdateStrategy;
import util.IDispatcher;

/**
 * The abstract update strategy
 * @author caojian
 */
public abstract class AUpdateStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg>{
	
	/**
	 * Update the state of the context Ball.
	 * @param context  The context (host) Ball whose state is to be updated
	 * @param dispatcher  The Dispatcher who sent the command that is calling through to here.
	 */
	public abstract void updateState(Ball context, IDispatcher<TDispMsg> dispatcher);

	/**
	 * Initializes the strategy.   Should be called every time the Ball sets a new strategy.
	 * @param context  The ball using this strategy.
	 */
	public void init(Ball context){}
}
