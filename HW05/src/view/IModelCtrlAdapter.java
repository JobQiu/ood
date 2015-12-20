package view;

/**
 * adapter for model control tasks
 *
 */
public interface IModelCtrlAdapter<TStrategyDropListItem, TPaintDropListItem> {

	/**
     * Take the given short strategy name and return a corresponding something to put onto both drop lists.
     * @param classname  The shortened class name of the desired strategy
     * @return Something to put onto both the drop lists.
     */
    public TStrategyDropListItem addUpdateStrategy(String classname);
    
    /**
     * add paint strategy
     * @param classname The class name
     * @return paint strategy factory
     */
    public TPaintDropListItem addPaintStrategy(String classname);

    /**
     * Make a ball with the selected short strategy name.
     * @param selectedItem1 The selected item 1
     * @param selectedItem2 The selected item 2
     */
    public void makeBall(TStrategyDropListItem selectedItem1, TPaintDropListItem selectedItem2);
    
    /**
     * Return a new object to put on both lists, given two items from the lists.
     * @param selectedItem1  An object from one drop list
     * @param selectedItem2 An object from the other drop list
     * @return An object to put back on both lists.
     */
    public TStrategyDropListItem combineUpdateStrategies(TStrategyDropListItem selectedItem1, TStrategyDropListItem selectedItem2);
	
    /**
     * Make a switcher ball
     * @param selectedItem The selected paint strategy
     */
    public void makeSwitcher(TPaintDropListItem selectedItem);
    
    /**
     * Switch strategy
     * @param selectedItem The selected update strategy
     */
    public void switchUpdateStrategy(TStrategyDropListItem selectedItem);
    
	/** clear Balls */
	public void clearAllBalls();	
}
