package ls53_yh36.server.game.smodel.message;

import java.util.UUID;

import common.IChatUser;
import common.message.IChatMessage;
import common.message.chat.ACommandRequest;
import common.message.chat.ACommandResponse;
import ls53_yh36.server.game.smodel.command.StartGameCmd;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;

/**
 * Start game response message
 * @author ls53@rice.edu
 */
public class StartGameResponse extends ACommandResponse {

    /**
     * The generated serial version UID
     */
	private static final long serialVersionUID = -7590328689960737986L;

	/**
	 * Unknown class type
	 */
	private Class<?> unknownType;
	
	/**
	 * UUID for the mixed dictionary, which will be used for Cmd2RunGameAdpt
	 */
	private UUID id;
	
	/**
	 * Constructor
	 * @param request Corresponding unknown request
	 * @param unknown Unknown class type
	 * @param id UUID
	 */
	public StartGameResponse(ACommandRequest request, Class<?> unknown, UUID id) {
		super(request);
		unknownType = unknown;
		this.id = id;
	}

	/**
     * Get data packet
     * @return The data packet
     */
	@Override
	public DataPacket<? extends IChatMessage> getDataPacket() {
		return new DataPacket<ACommandResponse>(ACommandResponse.class, this);
	}

	/**
     * Get the unknown type
     * @return The type
     */
	@Override
	public Class<?> getUnknownType() {
		return unknownType;
	}

	/**
     * Get command
     * @return The command
     */
	@Override
	public ADataPacketAlgoCmd<String, ?, IChatUser> getCommand() {
		return new StartGameCmd(id);
	}

}
