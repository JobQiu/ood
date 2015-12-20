package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Timer;

import model.strategy.IUpdateStrategy;
import model.strategy.IUpdateStrategyFac;
import model.strategy.MultiStrategy;
import model.strategy.StraightStrategy;
import model.strategy.SwitcherStrategy;
import util.Dispatcher;
import util.IRandomizer;
import util.ObjectLoader;
import util.Randomizer;


/**
 * The model in the ball world application.
 */
public class BallWorldModel {
    
    /** 
     * The View adapter used to request view update.
     */
    private IViewUpdateAdapter viewUpdateAdpt;
    
    /**
     * The dispatcher that dispatches update() calls to all balls.
     */
    private final Dispatcher dispatcher = new Dispatcher();
	
	private static final int UPDATE_TIME_SLICE = 40;
	
	private Timer paintTimer = new Timer(UPDATE_TIME_SLICE, e -> {
	    dispatcher.notifyAll((IBallCmd)(context, disp) -> {
	        context.updateState(disp);
	        context.move();
	        context.bounce();
	    });
	});
	
    /**
     * The timer period in milliseconds to update the model.
     */
    private static final int PAINT_TIME_SLICE = 50;
	
	/**
	 * The timer that updates the model periodically.
	 */
	private Timer updateTimer = new Timer(PAINT_TIME_SLICE, e -> viewUpdateAdpt.update());
	
	/**
	 * The switchable strategy that switcher balls will use to update their states.
	 */
	private SwitcherStrategy switcherStrategy = new SwitcherStrategy(new StraightStrategy());
	
	/**
	 * A UpdateStrategy factory for a beeping error strategy that beeps the speaker every 25 updates.
	 * Either use the _errorStrategyFac variable directly if you need a factory that makes an error 
	 * strategy, or call _errorStrategyFac.make() to create an instance of a beeping error strategy.
	 */
	private IUpdateStrategyFac errorUpdateStrategyFac = new IUpdateStrategyFac(){
		/**
		 * Make the beeping error strategy
		 * @return  An instance of a beeping error strategy
		 */
		@Override
		public IUpdateStrategy make() {
			return new IUpdateStrategy() {
				private int count = 0;
				/**
				 * Beep the speaker every 25 updates
				 */
				@Override
				public void updateState(Ball context, Dispatcher dispatcher) {
					if(25 < count++){
						java.awt.Toolkit.getDefaultToolkit().beep(); 
						count = 0;
					}
				}
			};
		}
	};
	
	/**
	 * The error paint strategy factory that produces error paint strategy doing nothing
	 */
	private IPaintStrategyFac errorPaintStrategyFac = new IPaintStrategyFac() {
        
        @Override
        public IPaintStrategy make() {
            return IPaintStrategy.NULL_OBJECT;
        }
    };
	
	
	/**
	 * The randomizer that generates ball properties randomly.
	 */
	private final IRandomizer randomizer = Randomizer.Singleton;
	
	/**
	 * Construct a model with given view adapter.
	 * @param viewAdapter The view adapter used to communicate with view.
	 */
	public BallWorldModel(IViewUpdateAdapter viewAdapter) {
		this.viewUpdateAdpt = viewAdapter;
	}

	/**
	 * Start the model.
	 */
	public void start() {
		updateTimer.start();
		paintTimer.start();
	}
	
	/**
	 * Clear all balls in the model.
	 */
	public void clearBalls() {
		dispatcher.deleteObservers();
	}
	
	/**
	 * Add a ball with given update strategy which cannot be changed thereafter.
	 * @param updateStrategy the strategy to update the state of the ball created
	 * @param canvas the canvas where the ball will be painted
	 */
	public void addBall(IUpdateStrategy updateStrategy, IPaintStrategy paintStrategy, Component canvas) {
		Point startingLoc = randomizer.randomLoc(canvas.getBounds());
		int radius = randomizer.randomInt(5, 20);
		Point velocity = randomizer.randomVel(new Rectangle(10, 10));
		Color color = randomizer.randomColor();
		dispatcher.addObserver(new Ball(startingLoc, radius, velocity, color, canvas, updateStrategy, paintStrategy));
	}
	
	/**
	 * Add a ball with the switchable strategy to the model.
	 * @param canvas The canvas where the ball will be moving and painted
	 */
	public void addSwitcherBall(IPaintStrategy paintStrategy, Component canvas) {
		Point startingLoc = randomizer.randomLoc(canvas.getBounds());
		int radius = randomizer.randomInt(5, 20);
		Point velocity = randomizer.randomVel(new Rectangle(10, 10));
		Color color = randomizer.randomColor();
		dispatcher.addObserver(new Ball(startingLoc, radius, velocity, color, canvas, switcherStrategy, paintStrategy));
	}
	
	/**
	 * Update all balls in the model.
	 * @param g	the graphics object used to paint balls
	 */
	public void update(Graphics g) {
		dispatcher.notifyAll((IBallCmd)(context, disp) -> {
		    context.paint(g);
		});
	}
	
	
	/**
	 * Make a UpdateStrategyFac object that creates strategy instances of the the given type
	 * @param strategyName strategy type
	 * @return A StrategyFac object
	 */
	public IUpdateStrategyFac makeUpdateStrategyFac(String strategyName) {
		if (null == strategyName)  {
			return errorUpdateStrategyFac;
		}
		
        return new IUpdateStrategyFac() {
		    /**
		     * Instantiate a strategy corresponding to the given class name.
		     * @return An IUpdateStrategy instance
		     */
		    public IUpdateStrategy make() {
		    	IUpdateStrategy strategy = ObjectLoader.load(fixName("model.strategy.", strategyName, "Strategy")); 
                if(null == strategy) {
                	strategy = errorUpdateStrategyFac.make();
                }
		        return  strategy;
		    }

		    @Override
		    public String toString() {
		        return strategyName;
		    }
		};
	}
	
	/**
	 * Returns an IPaintStrategyFac that can instantiate the strategy 
	 * specified by classname. Returns a factory for a beeping error 
	 * strategy if classname is null. The toString() of the returned 
	 * factory is the classname.
	 * @param paintStrategyName Shortened name of desired strategy
	 * @return A factory to make that strategy
	 */
	public IPaintStrategyFac makePaintStrategyFac(String paintStrategyName) {
	    if (paintStrategyName == null) {
	        return errorPaintStrategyFac;
	    }
	    
	    return new IPaintStrategyFac() {
            
            @Override
            public IPaintStrategy make() {
                IPaintStrategy strategy = ObjectLoader.load(fixName("model.paint.strategy.", paintStrategyName, "PaintStrategy"));
                if (strategy == null) {
                    return errorPaintStrategyFac.make();
                }
                
                return strategy;
            }
            
            @Override
            public String toString() {
                return paintStrategyName;
            }
        };
	}
	
	
	/**
	 * Convert the strategy name passed from the view to the corresponding strategy class name
	 * under the strategy package. 
	 * @param prefix The prefix of strategy name
	 * @param strategyName the strategy name without Strategy suffix and strategy. package prefix
	 * @param suffix The suffix of strategy name
	 * @return the full strategy class name under strategy package
	 */
	private String fixName(String prefix, String strategyName, String suffix) {
		return prefix + strategyName + suffix;
	}
	
	/**
	 * Combine two update strategy Factories together that creates UpdateStrategy having a combination
	 * of behaviors of the two strategies that the factories correspond to.
	 * @param stratFac1 the first Strategy Factory to combine
	 * @param stratFac2 the second Strategy Factory to combine
	 * @return A IStrategyFac that can make instances of multistrategy, a combination of two strategies
	 */
	public IUpdateStrategyFac combineStrategyFacs(final IUpdateStrategyFac stratFac1, final IUpdateStrategyFac stratFac2) {
		if (null == stratFac1 || null == stratFac2) {
			return errorUpdateStrategyFac;
		}
		
		return new IUpdateStrategyFac() {
			/**
		     * Instantiate a new MultiStrategy with the strategies from the given strategy factories
		     * @return A MultiStrategy instance
		     */
		    public IUpdateStrategy make() {
		        return new MultiStrategy(stratFac1.make(), stratFac2.make());
		    }
		    /**
		     * Return a string that is the toString()'s of the given strategy factories concatenated with a "-"
		     */
		    public String toString() {
		        return stratFac1.toString() + "-" + stratFac2.toString();
		    }
		};
	}
	
	/**
	 * Set the switchable strategy in current model that all switcher balls use.
	 * @param strategy the new update strategy for all switcher balls
	 */
	public void setSwitcherStrategy(IUpdateStrategy strategy) {
		switcherStrategy.setUpdateStrategy(strategy);
	}
	
	/**
	 * Get the switchable strategy that is currently used by all switcher balls in the model.
	 * @return the switchable strategy
	 */
	public SwitcherStrategy getSwitcherStrategy() {
		return switcherStrategy;
	}
}
