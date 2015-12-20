package common.messages;

import java.io.Serializable;
import java.util.UUID;

import common.IUser;

/**
 * RemoveMe message. This message is used by a sender to notify a remote user to remove him from
 * a chatroom. Usage:
 * SENDER:
 * 1.	Instantiate this message, using the IUser object and IChatroom UUID associated with the
 * 		chatroom you wish to leave.
 * 2.	Pass it into a data packet and send it to everyone in the IChatroom.
 * 3.	Remove the IChatroom from your chatroom list.
 * RECEIVER:
 * 1.	Remove the IUser in this message from the IChatroom with matching UUID.
 */
public class RemoveMe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6772035205940259261L;

	public RemoveMe(IUser me, UUID chatroomID)
	{
		this.me = me;
		this.chatroomID = chatroomID;
	}
	
	/**
	 * The user self
	 */
	public IUser me;
	
	/**
	 * Target chat room ID
	 */
	public UUID chatroomID;

}
