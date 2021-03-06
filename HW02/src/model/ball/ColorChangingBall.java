package model.ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import util.Randomizer;

/**
 * A ball that can change color randomly
 * @author ls53@rice.edu
 */
public class ColorChangingBall extends ABall {
    
    /**
     * The counter for slowing down the changing rate
     */
    private int count = 100;

    /**
     * The constructor for color changing ball
     * @param startLoc The initial location of a ball
     * @param startRadius The initial radius of a ball
     * @param startVel The initial velocity of a ball
     * @param color The color of a ball
     * @param canvas The canvas containing a ball
     */
    public ColorChangingBall(Point startLoc, int startRadius, Point startVel, Color color, Component canvas) {
        super(startLoc, startRadius, startVel, color, canvas);
    }
    
    /**
     * Update color for a ball
     */
    @Override
    protected void updateUniqueProperty() {
        --count;
        if (count == 0) {
            color = Randomizer.Singleton.randomColor();
            count = 100;
        }
    }
}
