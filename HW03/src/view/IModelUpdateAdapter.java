package view;

import java.awt.Graphics;

/**
 * Adapter that the view uses to pass the update request to the model
 * @author JacobChen
 *
 */
public interface IModelUpdateAdapter<TDropListItem> {

	/**
	 * Pass the update request to the model
	 * @param g The Graphics object the balls use to draw themselves.
	 */
	public void update(Graphics g);

	/**
	 * No-op singleton implementation of IModelUpdateAdapter.
	 */
	@SuppressWarnings("rawtypes")
	public static final IModelUpdateAdapter NULL_OBJECT = new IModelUpdateAdapter() {
		public void update(Graphics g) {}
	};
}
