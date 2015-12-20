package common;

import java.io.Serializable;
/**
 * This interface defines the properties assocaited with the user.
 *
 * @author xc7, bb26
 */
import java.net.InetAddress;

public interface IUser extends Serializable {
	/* private transient IConnect connection */

	/**
	 *  set IConnect associated with this user 
	 *  This will likely never need to be used, but is
	 *  included just in case
	 *  @param IConnect stub to set
	 *  */
	public void setConnect(IConnect stub);
	  
	/**
	 *  get IConnect associated with this user. This is how you gain access
	 *  to commands like sendReceive and getNewAlgorithm
	 *  @return the IConnect stub that can be used to communicate with the
	 *  remote user.
	 *  */
	public IConnect getConnect();
	
	/**
	 *  get user name 
	 *  @return the name for this user
	 *  */
	public String getName();
	
	/**
	 *  set user name
	 *  @param Set the user name for this User 
	 */
	public void setName(String name);

	/**
	 *  get IP address from this user 
	 *  @return the InetAddress for this user
	 */
	public InetAddress getIP();

	/**
	 * set IP address for this user. This will almost always be set to
	 * InetAddress.getLoopbackAddress();
	 * @param the address for this user
	 */
	@Deprecated
	public void setIP(InetAddress address);
}