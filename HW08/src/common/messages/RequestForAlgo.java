package common.messages;

import java.io.Serializable;

/**
 * RequestForAlgo message. This message is used by a sender to request the command for an unknown
 * data packet type in response to an unknown message from a remote user. Usage:
 * SENDER:
 * 1.	Instantiate this message with the Class object of the unknown type in the data packet.
 * 2.	Pass it into a data packet and pass it into the remote user's IConnect.getNewCommand method.
 * 3.	Add the returned command to your Visitor.
 * 4.	Execute the visitor on the original data packet.
 * RECEIVER:
 * 1.	Get the command from your Visitor keyed to the Class returned by unknownType()
 * 2.	Return the command to the caller.
 */
public class RequestForAlgo implements Serializable{
	
	/**
	 * 
	 */
	public static final long serialVersionUID = -3165014455787956557L;
	
	private Class<?> type;
	
	public RequestForAlgo(Class<?> T){
		type = T;
	}
	
	/**
	 * The class type you need an algorithm for
	 */
	public Class<?> unknownType()
	{
		return type;
	}
	
}
