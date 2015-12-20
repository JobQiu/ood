package model;

import java.awt.Component;

/**
 * Adapter that the model uses to communicate to the view for 
 * getting the canvas of the view to update
 * @author JacobChen
 *
 */
public interface IViewControlAdapter {
	/**
	 * Gets canvas of the view
	 * @return the canvas of the view
	 */
	public Component getCanvas();

	/**
	 * No-op singleton implementation of IViewControlAdapter.
	 */
	public static final IViewControlAdapter NULL_OBJECT = new IViewControlAdapter() {
		public Component getCanvas() {
			return null;
		}
	};
}
