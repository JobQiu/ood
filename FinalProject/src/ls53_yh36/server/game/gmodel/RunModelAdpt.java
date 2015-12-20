package ls53_yh36.server.game.gmodel;

import java.io.Serializable;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.Layer;

/**
 * The run model adapter
 * @author ls53@rice.edu
 */
public interface RunModelAdpt extends Serializable {

	/**
	 * Navigate to the position
	 * @param pos Position of the target place
	 */
	public void goPlace(Position pos);
	
	/**
	 * Add the layer to the map
	 * @param layer Layer to be added
	 */
	public void showLayer(Layer layer);
	
	/**
	 * Post information onto the game view
	 * @param info Information to be posted
	 */
	public void showInfo(String info);
	
	/**
	 * Post the team's history rank
	 * @param rank A string showing the rank
	 */
	public void showRank(String rank);
	
	/**
	 * Tell the game view to update the time
	 */
	public void updateTime();
	
	/**
	 * Disable buttons
	 */
	public void stopBtn();
}
