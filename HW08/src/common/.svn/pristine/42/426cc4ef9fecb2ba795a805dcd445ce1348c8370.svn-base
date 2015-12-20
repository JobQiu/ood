package common;

import java.rmi.Remote;

import java.rmi.RemoteException;
import java.util.HashSet;

import common.messages.RequestForAlgo;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;

public interface IConnect extends Remote {
  /* private transient ConnectToWorldAdapter _adapter */
	
  /**
   * The name the ICompute object will be bound to in the RMI Registry
   */
  public static final String BOUND_NAME = "Connect";
  
  /**
   * The port that the client will use to communicate with the ICompute object
   * Note that this port must be opened of inbound traffic on the server machine
   */
  public static final int BOUND_PORT = 2100;
  
  /*This function is used when you have an IConnect stub for a user, but not their
   * IUser object. When you call this function, you will receive an IUser object 
   * that contains the appropriate name and IP address for the remote user, as well
   * as the IConnect stub being passed in here. The reason for passing in the IConnect 
   * stub is that the remote user does not necessarily have a copy of this IConnect stub
   * easiliy accessible. 
   */
  public IUser getUser(IConnect stub) throws RemoteException;
  
  /**
   * get a HashSet of chatrooms from this IUser
   * @return a HashSet of chatrooms corresponding to this user
   * */
  public HashSet<IChatroom> getChatrooms() throws RemoteException;

  /**
   * process the data sent by the remote application. Most of the time, the implementation
   * of this function will just be "data.execute(myVisitor,me);"
   * @param IUser - the user who sent the message
   * @param ADataPacket - the data packet that they sent
   * */
  public void sendReceive(IUser me, ADataPacket data) throws RemoteException;
  
  /**
   * Get a command to handle a packet we've never seen before 
   * IMPORTANT -- this function is synchronous, which means that the thread which executed this
   * command will be blocked until the remote user returns a new ADataPacketAlgoCmd. it is highly 
   * recommended that this is only run inside of a new thread.
   * The new commands are parameterized to take an IUser representing the message sender as input
   * and return a String status message
   * */
  public ADataPacketAlgoCmd<String,?,IUser> getNewCommand(RequestForAlgo request) throws RemoteException;
}

