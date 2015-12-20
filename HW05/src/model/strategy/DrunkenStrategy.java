package model.strategy;

import java.awt.Point;

import model.Ball;
import util.IDispatcher;
import util.Randomizer;

/** generate a ball with random color, diameter and moving at random velocity */
public class DrunkenStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg>{
	
	/** change in ball diameter*/
	private int incrementD = 1;
	
	/**
	 * Initializes the strategy.   Should be called every time the Ball sets a new strategy.
	 * @param context  The ball using this strategy.
	 */
	@Override
	public void init(Ball context){}
	
	/**
	 * Update the state of the context Ball.
	 * @param context  The context (host) Ball whose state is to be updated
	 * @param dispatcher  The Dispatcher who sent the command that is calling through to here.
	 */
	@Override
	public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher){
		Randomizer rd = Randomizer.Singleton;
		Point dimension = context.getDimension();
		Point location = context.getLocation();
		Point velocity = context.getVelocity();
		
		
		dimension.x += incrementD;
		dimension.y += incrementD;
		if (dimension.x > 15) {
			incrementD = -incrementD;
		} else if (dimension.x < 5) {
			incrementD = -incrementD;
		}
		
		location.x += velocity.x * rd.randomInt(-3, 3);
		location.y += velocity.y * rd.randomInt(-3, 3);
		
		context.setLocation(location.x, location.y);		
		context.setColor(rd.randomColor());
		context.setDimension(dimension.x,dimension.y);
	}
}