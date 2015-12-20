package ls53_yh36.server.game.smodel.message;

import java.util.UUID;

import common.message.IChatMessage;
import ls53_yh36.server.game.scontroller.RunGameFac;
import provided.datapacket.DataPacket;

/**
 * Start game command
 * @author ls53@rice.edu
 *
 */
public class StartGame implements IChatMessage {

    /**
     * The generated serial version UID
     */
	private static final long serialVersionUID = 6792665386262706142L;

	/**
	 * Store a game factory
	 */
	private RunGameFac gameFac;
	
	/**
	 * UUID of this message
	 */
	private UUID id = UUID.randomUUID();
	
	
	/**
	 * Constructor
	 * @param gFac Game factory
	 */
	public StartGame(RunGameFac gFac) {
		gameFac = gFac;
	}

	/**
	 * Get the game factory
	 * @return Return a game factory
	 */
	public RunGameFac getGameFac() {
		return gameFac; 
	}

	/**
	 * Get ID
	 * @return ID
	 */
	@Override
	public UUID getID() {
		return id;
	}

	/**
	 * Get data packet
	 * @return The data packet
	 */
	@Override
	public DataPacket<? extends IChatMessage> getDataPacket() {
		return new DataPacket<StartGame>(StartGame.class, this);
	}
}
