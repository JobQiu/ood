package model.strategy;

import java.awt.Point;

import model.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * An IUpdateStrategy implementation that turns the direction by a random
 * angle between 0 and 18 degree clockwise. 
 *
 */
public class CurveStrategy implements IUpdateStrategy {

	@Override
	public void updateState(Ball context, Dispatcher dispatcher) {
		double turningAngle = Randomizer.Singleton.randomDouble(0, Math.PI/10);
		int velX = (int)Math.round(context.getVelocity().x * Math.cos(turningAngle) - context.getVelocity().y *Math.sin(turningAngle));
		int velY = (int)Math.round(context.getVelocity().y * Math.cos(turningAngle) + context.getVelocity().x *Math.sin(turningAngle));
		context.setVelocity(new Point(velX, velY));
	}

}
