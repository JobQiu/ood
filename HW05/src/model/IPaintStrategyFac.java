package model;

/**
 * @author caojian
 * An interface that defines a factory that instantiates a specific IPaintStrategy
 */
public interface IPaintStrategyFac {

	/**
	 * Instantiate the specific IPaintStrategy for which this factory is defined.
	 * @return The paint strategy
	 */
	public IPaintStrategy make();
}
