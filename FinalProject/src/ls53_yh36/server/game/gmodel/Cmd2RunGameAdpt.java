package ls53_yh36.server.game.gmodel;

import java.io.Serializable;

/**
 * The command to run game adapter
 * @author ls53@rice.edu
 */
public interface Cmd2RunGameAdpt extends Serializable {

	/**
	 * Post the information onto game view
	 * @param msg The message
	 */
	public void post(String msg);
}
