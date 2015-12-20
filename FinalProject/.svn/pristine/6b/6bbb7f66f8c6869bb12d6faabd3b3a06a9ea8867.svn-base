package ls53_yh36.server.game.smodel.message;

import java.util.UUID;

import common.IChatUser;
import common.message.IChatMessage;
import common.message.chat.ACommandRequest;
import common.message.chat.ACommandResponse;
import ls53_yh36.server.game.smodel.command.ReplyRankCmd;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;

/**
 * The reply rank response message
 * @author ls53@rice.edu
 */
public class ReplyRankResponse extends ACommandResponse {

    /**
     * The generated serial version UID
     */
	private static final long serialVersionUID = 3221022744311442834L;

	/**
	 * Unknown type
	 */
	private Class<?> unknownType;
	
	/**
	 * UUID for the mixedDictionary
	 */
	private UUID id;
	
	/**
	 * Constructor
	 * @param request Corresponding request
	 * @param unknown Unknown class type 
	 * @param id UUID
	 */
	public ReplyRankResponse(ACommandRequest request, Class<?> unknown, UUID id) {
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
		return new ReplyRankCmd(id);
	}

}
