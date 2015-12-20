package common.demo;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.UUID;

import common.IChatroom;
import common.IUser;
import provided.datapacket.ADataPacket;

/**
 * Reference implementation of a chatroom.
 */
public class Chatroom implements IChatroom {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3144118296649252280L;
	
	private UUID id;
	private String displayName = "default";
	private HashSet<IUser> users;

	public Chatroom() {
		id = UUID.randomUUID();
		users = new HashSet<IUser>();
	}

	@Override
	public UUID id() {
		return id;
	}

	@Override
	public HashSet<IUser> getUsers() {
		return users;
	}

	@Override
	public boolean addUser(IUser user) {
		return users.add(user);
	}

	@Override
	public boolean removeUser(IUser user) {
		return users.remove(user);
	}

	@Override
	public void send(IUser me, ADataPacket message) {
		users.iterator().forEachRemaining(
					(user) ->{ 
						try{
							user.getConnect().sendReceive(me, message);
						}
						catch(RemoteException e)
						{
							e.printStackTrace();
						}
					});
	}

	@Override
	public String getName() {
		return displayName;
	}

	@Override
	public void setName(String name) {
		displayName = name;
	}
	
    /**
     * Overriden hashCode() method to create a hashcode from all the accessible values in IUser.
     * @return a hashCode tied to the values of this IUser.
     */
    @Override
    public int hashCode() {
            // using IP and name to calculate hashcode.
			int hash = 3;
			hash = hash * 23 + id.hashCode();
			hash = hash * 11 + displayName.hashCode();
            return hash;
    }

}