package ls53_yh36.server.game.smodel;

import java.rmi.Remote;

/**
 * The server model adapter
 * @author ls53@rice.edu
 */
public interface ServerModelAdpt extends Remote {

	/**
	 * Receive a score from a remote client and return back his/her team's ranking 
	 * @param sco Final score points
	 */
	public void updateScore(String sco);
}
