package model.ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

/**
 * The abstract ball class
 * @author ls53@rice.edu
 */
public abstract class ABall implements Observer {
    
    /**
     * The location of a ball
     */
    protected Point location;
    
    /**
     * The radius of a ball
     */
    protected int radius;
    
    /**
     * The velocity of a ball
     */
    protected Point velocity;
    
    /**
     * The color of a ball
     */
    protected Color color;
    
    /**
     * The canvas containing a ball
     */
    protected Component canvas;
    
    /**
     * The constructor for a ball
     * @param startLoc The initial location of a ball
     * @param startRadius The initial radius of a ball
     * @param startVel The initial velocity of a ball
     * @param color The color of a ball
     * @param canvas The canvas containing a ball
     */
    public ABall(Point startLoc, int startRadius, Point startVel, Color color, Component canvas) {
        location = startLoc;
        radius = startRadius;
        velocity = startVel;
        this.color = color;
        this.canvas = canvas;
    }
    
    /**
     * Update the properties of a ball every time slice
     * @param o The dispatcher
     * @param arg The Graphics object to paint a ball
     */
    @Override
    public void update(Observable o, Object arg) {
        updateUniqueProperty();
        move();
        bounce();
        paint((Graphics)arg);
    }
    
    /**
     * Update the unique property of concrete subclass
     */
    protected abstract void updateUniqueProperty();
    
    /**
     * Move a ball
     */
    protected void move() {
        location.x += velocity.x;
        location.y += velocity.y;
    }
    
    /**
     * handle ball bouncing event
     */
    protected void bounce() {
        if (location.x - radius < 0) {
            velocity.x = -velocity.x;
            location.x += 2 * (radius - location.x);
        }
        
        if (location.y - radius < 0) {
            velocity.y = -velocity.y;
            location.y += 2 * (radius - location.y);
        }
        
        if (location.x + radius > canvas.getWidth()) {
            velocity.x = -velocity.x;
            location.x -= 2 * (location.x - (canvas.getWidth() - radius));
        }
        
        if (location.y + radius > canvas.getHeight()) {
            velocity.y = -velocity.y;
            location.y -= 2 * (location.y - (canvas.getHeight() - radius));
        }
    }
    
    /**
     * Paint a ball
     * @param g The Graphics object to paint a ball
     */
    protected void paint(Graphics g) {
        g.setColor(color);
        int diameter = radius * 2;
        g.fillOval(location.x - radius, location.y - radius, diameter, diameter);
    }
}