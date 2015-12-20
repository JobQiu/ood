package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;


import util.IDispatcher;
import util.IObserver;
;
/**
 * Ball class to generate balls with different strategies
 * @author: Jian Cao
 */
public class Ball implements IObserver<IBallCmd> {

	/** color of the ball */
	private Color color;
	/** dimension of the ball */
	private Point dimension;
	/** velocity of ball */
	private Point velocity;	
	/**coordinate of ball */
	private Point location;
	/** panel to paint on */
	private JPanel centerPanel;
	/** strategy of ball movement */
	private IUpdateStrategy<IBallCmd> updateStrategy;
	
	/**
	 * paint strategy
	 */
	private IPaintStrategy paintStrategy;
	
	/**
	 * interact strategy
	 */
	private IInteractStrategy interactStrategy;
	
	/**
	 * constructor of ball
	 * @param color The color
	 * @param dimension The dimension
	 * @param location The location
	 * @param velocity The velocity
	 * @param centerPanel The center panel
	 * @param updateStrategy The udpate strategy
	 * @param paintStrategy The paint strategy
	 */
	public Ball(Color color, Point dimension, Point location, Point velocity, JPanel centerPanel, IUpdateStrategy<IBallCmd> updateStrategy, IPaintStrategy paintStrategy) {
		this.color = color;
		this.dimension = dimension;
		this.velocity = velocity;
		this.location = location;
		this.centerPanel = centerPanel;
		setInteractStrategy(IInteractStrategy.NULL_STRATEGY);
		setUpdateStrategy(updateStrategy);
		setPaintStrategy(paintStrategy);
	}
	
	/**
	 * get the color of ball
	 * @return The color
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * set the color of ball
	 * @param color The color
	 */
	public void setColor(Color color){
		this.color = color;		
	}
	
	/**
	 * get the dimension of ball
	 * @return The dimension
	 */
	public Point getDimension(){
		return dimension; 
	}
	
	/**
	 * set the dimension of ball
	 * @param length The length
	 * @param width The width
	 */
	public void setDimension(int length, int width){
		this.dimension.y = length;
		this.dimension.x = width;
	}

	/**
	 * get the coordinate of ball
	 * @return The location
	 */
	public Point getLocation(){
		return this.location;
	}
	
	/**
	 * set the x, y coordinate of ball
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public void setLocation(int x, int y){
		this.location.x = x;
		this.location.y = y;
	}
	
	/**
	 * Get the velocity
	 * @return The velocity
	 */
	public Point getVelocity(){
		return velocity;
	}
	
	/**
	 * set the x, y velocity of ball
	 * @param incrementX The Vx
	 * @param incrementY The Vy
	 */
	public void setVelocity(int incrementX, int incrementY){
		this.velocity.x = incrementX;
		this.velocity.y = incrementY;
	}
	
	/**
	 * get the update strategy of ball
	 * @return the update strategy
	 */
	public IUpdateStrategy<IBallCmd> getUpdateStrategy(){
		return this.updateStrategy;
	}
	
	/**
	 * set the update strategy of ball
	 * @param strategy The update strategy
	 */
	public void setUpdateStrategy(IUpdateStrategy<IBallCmd> strategy){
		updateStrategy = strategy;
		updateStrategy.init(this);
	}
	
	/**
	 * get the paint strategy of ball
	 * @return The paint strategy
	 */
	public IPaintStrategy getPaintStrategy(){
		return this.paintStrategy;
	}
	
	/**
	 * set the paint strategy of ball
	 * @param strategy the strategy to use
	 */
	public void setPaintStrategy(IPaintStrategy strategy){
		paintStrategy = strategy;
		paintStrategy.init(this);
	}
	
	/**
	 * Get the interact strategy
	 * @return the interact strategy
	 */
	public IInteractStrategy getInteractStrategy() {
        return interactStrategy;
    }
	
	/**
	 * Set the interact strategy
	 * @param interactStrategy the interact strategy to set
	 */
    public void setInteractStrategy(IInteractStrategy interactStrategy) {
        this.interactStrategy = interactStrategy;
    }

    /**
     * get the panel to paint on
     * @return The canvas
     */
	public JPanel getCanvas(){
		return this.centerPanel;
	}
	
	/**
	 * update the state of ball based on different strategy 
	 * @param dispatcher The dispatcher
	 */
	public void changeState(IDispatcher<IBallCmd> dispatcher){
		updateStrategy.updateState(this, dispatcher);
	}
	
	/**
	 * paint the ball on panel for given paint strategy
	 * @param g The graphics object
	 * @param ball The ball
	 */
	public void updatePaint(Graphics g, Ball ball){
		paintStrategy.paint(g, ball);
	}
	
	/** bounce the ball of the wall */
	public void bounce(){
	    int radius = (int)Math.max(dimension.getX(), dimension.getY());
	    
		if (location.x - radius < 0) {
			velocity.x = -velocity.x;
			location.x = 2 * radius - location.x;
		}
		
		if (location.x + radius > centerPanel.getWidth()) {
			velocity.x = -velocity.x;
			location.x = 2 * (centerPanel.getWidth() - radius) - location.x;
		}

		if (location.y - radius < 0) {
			velocity.y = -velocity.y;
			location.y = 2 * radius - location.y;
		}
		
		if (location.y + radius > centerPanel.getHeight()) {
			velocity.y = -velocity.y;
			location.y = 2 * (centerPanel.getHeight() - radius) - location.y;
		}
	}
	
	/** move the ball depending on velocity */
	public void move(){
		location.x += velocity.x;
		location.y += velocity.y;
	}
	
	/**
	 * interact with other ball
	 * @param target taget ball to interact wtih
	 * @param dispatcher the dispatcher managing all balls
	 */
	public void interactWith(Ball target, IDispatcher<IBallCmd> dispatcher) {
		interactStrategy.interact(this, target, dispatcher);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * Update things such as changing the position, creating animated motion or other 
	 * characteristics of the sprite by calling abstract updateBall() method.
	 * @param o observable
	 * @param g the Graphics object to paint the ball onto
	 */
	public void update(IDispatcher<IBallCmd> dispatcher, IBallCmd msg){
		msg.apply(this, dispatcher);
	}
}