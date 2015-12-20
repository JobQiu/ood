package model.strategy;

import model.Ball;
import util.Dispatcher;

/**
 * Define an interface to update the state of balls.
 */
public interface IUpdateStrategy {
    /**
     * Update the state of the ball with the desired strategy
     * @param context  The context (host) Ball whose state is to be updated
     * @param dispatcher  The Dispatcher who sent the command that is calling through to here.
     */
    public void updateState(Ball context, Dispatcher dispatcher);
}
