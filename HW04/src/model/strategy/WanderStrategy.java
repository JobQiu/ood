package model.strategy;

import java.awt.Rectangle;

import model.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * An IUpdateStrategy implementation that set the velocity of a ball randomly.
 *
 */
public class WanderStrategy implements IUpdateStrategy {

	@Override
	public void updateState(Ball context, Dispatcher dispatcher) {
		context.setVelocity(Randomizer.Singleton.randomVel(new Rectangle(10,10)));
	}
}
