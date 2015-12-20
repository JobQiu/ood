package model.strategy;


import java.awt.Point;
import model.Ball;
import model.IBallCmd;

import util.IDispatcher;

/**
 * update strategy that spawns new balls when a ball contacts another
 * @author caojian
 */
public class SpawnStrategy extends AUpdateStrategy<IBallCmd> {
    
    /**
     * tick counter that counts out the delay before another ball can be spawned.
     */
	private int count = 0;
	
	/**
	 * tick delay which increases at each spawn to keep total spawn rate from exponentially exploding.
	 */
	private int delay = 100;

	@Override
	/**
	 * Initializes the strategy.   Should be called every time the Ball sets a new strategy.
	 * @param context  The ball using this strategy.
	 */
	public void init(Ball context){}
	
	/**
	 * Update the state of the context Ball.
	 * @param context  The context (host) Ball whose state is to be updated
	 * @param dispatcher  The Dispatcher who sent the command that is calling through to here.
	 */
	@Override
	public void updateState(final Ball context, IDispatcher<IBallCmd> dispatcher) {
	
		if (delay < count++) {
			dispatcher.dispatch(new IBallCmd() {

				@Override
				public void apply(Ball other, IDispatcher<IBallCmd> disp) {

					if (count != 0 && context != other) {
						if ((context.getDimension().x + other.getDimension().x) > 
						    context.getLocation().distance(other.getLocation())) {
							disp.addObserver(new Ball(
									context.getColor(),
									context.getDimension(),
									new Point(context.getLocation()),
									new Point(-context.getVelocity().x+1, -context.getVelocity().y+1),
									context.getCanvas(), 
									new SpawnStrategy(),
									context.getPaintStrategy()));
							count = 0;
							delay *= 5;
						}
					}
				}
			});
		}
	}
}