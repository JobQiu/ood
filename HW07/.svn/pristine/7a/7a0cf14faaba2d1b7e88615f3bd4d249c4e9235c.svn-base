package jkl1.client.model.task;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

import provided.compute.ITask;
import provided.compute.ILocalTaskViewAdapter;
import provided.compute.IRemoteTaskViewAdapter;

/**
 * Task that initiates two-way text chat between client and server using a ChatWindow.
 * The task takes a client's ChatWindow adapter stub, instantiates a chat window on the server
 * with it, and returns the server's chat window adapter stub to the client.
 * @author luej
 *
 */
public class Chat implements ITask<ChatWindowAdapter> {

	
    /**
	 * Serial ID
	 */
	private static final long serialVersionUID = -3684266771412988539L;

	/**
     * Adapter to the local view.  Marked "transient" so that it is not serialized
     * and instead is reattached at the destination (the server).  
     */
	@SuppressWarnings("unused")
	private transient ILocalTaskViewAdapter taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER;

	/**
	 * Client's chat window adapter stub given to the constructor
	 */
	private ChatWindowAdapter input;

	/**
	 * Constructor for the class.
	 * 
	 * @param window	Chat window adapter stub from the client.
	 */
	public Chat(ChatWindowAdapter window) {
		input = window;
	}

	/**
	 * Start a new ChatWindow on the server with the client's chat window adapter stub, then
	 * return to the client a stub of its own chat window adapter.
	 * 
	 * @return Server's chat window adapter stub.
	 */
	@Override
	public ChatWindowAdapter execute() throws RemoteException {
		ChatWindow serverWindow = new ChatWindow(input);
		serverWindow.start();
		ChatWindowAdapter clientAdapter = (msg) -> serverWindow.receive(msg);
		return (ChatWindowAdapter) UnicastRemoteObject.exportObject(clientAdapter, IRemoteTaskViewAdapter.BOUND_PORT_SERVER);
	}

	/**
	 * Reinitializes transient fields upon deserialization. See the <a href=
	 * "http://download.oracle.com/javase/6/docs/api/java/io/Serializable.html">
	 * Serializable</a> marker interface docs.
	 * taskView is set to a default value for now (ILocalTaskViewAdapter.DEFAULT_ADAPTER).
	 * 
	 * @param stream
	 *            The object stream with the serialized data
	 */
	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		stream.defaultReadObject(); // Deserialize the non-transient data
		taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER; // re-initialize the
															// transient field
	}

	/**
	 * Sets the task view adapter to a new value. Called by the server to 
	 * attach the task to its view.
	 * 
	 * @param viewAdapter
	 *            the adapter to the view.
	 */
	@Override
	public void setTaskViewAdapter(ILocalTaskViewAdapter viewAdapter) {
		this.taskView = viewAdapter;
		viewAdapter.append("Client initialized chat session\n");
	}

}
