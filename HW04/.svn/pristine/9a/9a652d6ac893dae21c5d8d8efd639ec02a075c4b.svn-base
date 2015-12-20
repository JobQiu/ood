package model.strategy;

import model.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * A IUpdateStrategy implementation that randomly chooses a strategy out of 
 * Breathing, Color, Wander and Curve Strategy to update the ball.
 */
public class DrunkStrategy implements IUpdateStrategy {
	/**
	 * The set of update strategies to randomly choose from.
	 */
	private static final IUpdateStrategy[] STRATEGIES = new IUpdateStrategy[] {
		new BreathingStrategy(), new ColorStrategy(), new WanderStrategy(), new CurveStrategy()
	};

	@Override
	public void updateState(Ball context, Dispatcher dispatcher) {
		int stratIndex = Randomizer.Singleton.randomInt(0, STRATEGIES.length - 1);
		STRATEGIES[stratIndex].updateState(context, dispatcher);
	}

}
