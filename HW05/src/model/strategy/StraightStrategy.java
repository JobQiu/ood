package model.strategy;

import model.Ball;
import util.IDispatcher;

/**
 * strategy that creates a straight moving ball
 */
public class StraightStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg>{

	@Override
	/**
	 * Initializes the strategy.   Should be called every time the Ball sets a new strategy.
	 * @param context  The ball using this strategy.
	 */
	public void init(Ball context){}
	
	
	@Override
	/**
	 * change the diameter of the ball by 1 each time
	 * if it reaches the threshold, reverse the change direction
	 * @param <IDispMsg>
	 */
	public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher){}
}
