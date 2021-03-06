package model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.lang.reflect.Constructor;

import javax.swing.Timer;

import model.ball.ABall;
import util.Dispatcher;
import util.Randomizer;

/**
 * The model class for ball world
 * @author ls53@rice.edu
 */
public class BallWorldModel {
    
    /**
     * The model to view adaptor
     */
    private IViewAdapter viewAdpt = IViewAdapter.NULL_OBJECT;
    
    /**
     * The dispatcher for managing all balls
     */
    private Dispatcher dispatcher = new Dispatcher();
    
    /**
     * The time slice for timer
     */
    private int timeSlice = 10;
    
    /**
     * The timer for animation
     */
    private Timer timer = new Timer(timeSlice, e -> viewAdpt.repaint());
    
    /**
     * The constructor for ball world model
     * @param viewAdpt The model to view adaptor
     */
    public BallWorldModel(IViewAdapter viewAdpt) {
        this.viewAdpt = viewAdpt;
    }
    
    /**
     * Make a new ball by class name
     * @param className The class name to initialize a new ball
     */
    public void makeBall(String className) {
        try {
            Component canvas = viewAdpt.getCanvas();
            Object[] args = new Object[]{Randomizer.Singleton.randomLoc(canvas.getSize()), 
                                         Randomizer.Singleton.randomInt(10, 25), 
                                         Randomizer.Singleton.randomVel(new Rectangle(0, 0, 5, 5)), 
                                         Randomizer.Singleton.randomColor(),
                                         canvas};
            
            Constructor<?> cs[] = Class.forName(className).getConstructors();
            for (Constructor<?> c : cs) {
                if (args.length == c.getParameterCount()) {
                    Object obj = c.newInstance(args);
                    if (obj instanceof ABall) {
                        ABall ball = (ABall)obj;
                        dispatcher.addObserver(ball);
                        break;                        
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Class " + className + " failed to load.\nException =\n" + e);
            e.printStackTrace();
        }
    }
    
    /**
     * Clear all balls
     */
    public void clearBalls() {
        dispatcher.deleteObservers();
    }
    
    /**
     * Start ball world model
     */
    public void start() {
        timer.start();
    }
    
    /**
     * Paint balls
     * @param g The Graphics object to paint
     */
    public void paint(Graphics g) {
        dispatcher.notifyAll(g);
    }
}