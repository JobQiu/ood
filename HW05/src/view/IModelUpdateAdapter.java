package view;

import java.awt.Graphics;

/**
 * adapter for model update tasks
 *
 */
public interface IModelUpdateAdapter {
	
	/**
	 * The update method
	 * @param g The graphics object
	 */
	public void updatePaint(Graphics g);
	
	/**
	 * The default adapter doing nothing
	 */
	public static final IModelUpdateAdapter NULL_OBJECT = new IModelUpdateAdapter() {
		
	    @Override
		public void updatePaint(Graphics g) {}
	};
}