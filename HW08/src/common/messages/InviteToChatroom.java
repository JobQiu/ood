package common.messages;

import java.io.Serializable;

import common.IChatroom;

/**
 * InviteToChatroom message. This message is used by a sender to add a remote user to
 * a chatroom. Usage:
 * SENDER:
 * 1.   Instantiate this message, passing the IChatroom to invite the remote user to as the
 *      constructor argument.
 * 2.   Pass it into a data packet and send it to the remote user's IConnect. No further action
 *      is necessary.
 * RECEIVER:
 * 1.   Create a new chatroom model, using the chatroom supplied in this message.
 * 2.   Create a new IConnect object associated with the model.
 * 3.   Create the stub.
 * 4.   Instantiate a new IUser containing the stub and your user information.
 * 5.   Create an AddMe message containing the IUser along with the IChatroom UUID.
 * 6.   Pass the AddMe into a data packet and send it to all users in this chatroom.
 * 7.   Add yourself to this chatroom (locally).
 */
public class InviteToChatroom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9149863039861372087L;
	
	public InviteToChatroom(IChatroom chatroom)
	{
		this.chatroom = chatroom;
	}
	
	/**
	 * Chatroom you want to invite the recipient to
	 */
	public IChatroom chatroom;

}
