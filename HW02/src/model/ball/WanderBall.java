package model.ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import util.Randomizer;

/**
 * A wander ball
 * @author ls53@rice.edu
 */
public class WanderBall extends ABall {
    
    /**
     * The counter for slowing down the changing rate
     */
    private int count = 100;
    
    /**
     * The constructor for a wander ball
     * @param startLoc The initial location of a ball
     * @param startRadius The initial radius of a ball
     * @param startVel The initial velocity of a ball
     * @param color The color of a ball
     * @param canvas The canvas containing a ball
     */
    public WanderBall(Point startLoc, int startRadius, Point startVel, Color color, Component canvas) {
        super(startLoc, startRadius, startVel, color, canvas);
    }
    
    /**
     * Update the velocity of a ball
     */
    @Override
    protected void updateUniqueProperty() {
        --count;
        if (count == 0) {
            velocity.x += Randomizer.Singleton.randomInt(-5, 5);
            velocity.y += Randomizer.Singleton.randomInt(-5, 5);
            count = 100;
        }
    }
}
