package model.strategy;

import model.Ball;
import model.IBallCmd;
import model.IUpdateStrategy;
import util.IDispatcher;

/**
 * The interaction strategy will increase the radius of other balls
 * @author ls53@rice.edu
 */
public class FatStrategy implements IUpdateStrategy<IBallCmd> {
    
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
        dispatcher.dispatch((other,disp) -> {
            if (context != other) {
                if (context.getLocation().distance(other.getLocation()) < effectDist) {
                    int radius = (int)Math.max(other.getDimension().getX(), other.getDimension().getY());
                    if (radius < 50) {
                        other.setDimension((int)other.getDimension().getY() + 2, (int)other.getDimension().getX() + 2);
                    }
                }
            }
        });
    }

}
