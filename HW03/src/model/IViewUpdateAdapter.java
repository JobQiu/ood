package model;

/**
 * Adapter that the model uses to pass the update request to the view
 * @author JacobChen
 *
 */
public interface IViewUpdateAdapter {
	/**
	 * Pass the update request to the view
	 */
	public void update();

	/**
	 * No-op singleton implementation of IViewUpdateAdapter.
	 */
	public static final IViewUpdateAdapter NULL_OBJECT = new IViewUpdateAdapter() {
		public void update() {
		}
	};
}
