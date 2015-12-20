package model.strategy;

import model.Ball;
import model.IBallCmd;
import model.IUpdateStrategy;
import util.IDispatcher;
import util.Randomizer;

/**
 * The interaction strategy that can make other balls flash
 * @author ls53@rice.edu
 */
public class FlashStrategy implements IUpdateStrategy<IBallCmd> {
    
    /**
     * The effective distance
     */
    public static int effectDist = 100;
    
    /**
     * Initialization
     * @param context The ball
     */
    @Override
    public void init(Ball context) {}
    
    /**
     * Update state
     * @param context The ball
     * @param dispatcher The dispatcher managing other balls
     */
    @Override
    public void updateState(Ball context, IDispatcher<IBallCmd> dispatcher) {
        context.setColor(Randomizer.Singleton.randomColor());
        dispatcher.dispatch((other,disp) -> {
            if (context != other) {
                if (context.getLocation().distance(other.getLocation()) < effectDist) {
                    other.setColor(Randomizer.Singleton.randomColor());
                }
            }
        });
    }
}
