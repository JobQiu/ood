package model.strategy;

/**
 * An interface that defines a factory that instantiates 
 * a specific IUpdateStrategy
 * 
 * @author supplied code
 * 
 */
public interface IStrategyFac {
	/**
	 * Instantiate the specific IUpdateStrategy for which this factory is defined.
	 * @return An IUpdateStrategy instance.
	 */
	public IUpdateStrategy make();
}
