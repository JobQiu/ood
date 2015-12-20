package common.messages;

import java.io.Serializable;
import java.util.UUID;

import common.IUser;

/**
 * AddMe message. This message is used by a sender to notify a remote user to add him to
 * a specific chatroom. Usage:
 * SENDER:
 * 1.	Create a new chatroom model containing the chatroom you wish to join.
 * 2.	Create a new IConnect object associated with the model.
 * 3.	Create the stub.
 * 4.	Instantiate a new IUser containing the stub and your user information.
 * 5.	Instantiate this message with the IUser and the chatroom UUID.
 * 6.	Pass this message into a data packet and send it to all users in this chatroom.
 * 7.	Add yourself to this chatroom locally.
 * RECEIVER:
 * 1.	Add this user to the IChatroom matching chatroomID.
 */
public class AddMe implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7738562854732574759L;

	public AddMe(IUser me,UUID chatroomID)
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
