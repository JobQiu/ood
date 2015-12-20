package jkl1.client.model.task;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.io.*;

import provided.compute.ITask;
import provided.compute.ILocalTaskViewAdapter;

/**
 * Task that gets the server's local date and time.
 * @author luej
 *
 */
public class ServerTime implements ITask<LocalDateTime> {

    /**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -1358841250037983776L;

	/**
     * Adapter to the local view.  Marked "transient" so that it is not serialized
     * and instead is reattached at the destination (the server).  
     */
	private transient ILocalTaskViewAdapter taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER;

	/**
	 * Constructor for the class.
	 * 
	 * @param input  Not used.
	 */
	public ServerTime(String input) {
	}

	/**
	 * Gets the local date and time of the server as a LocalDateTime object.
	 * 
	 * @return Local date and time of the server.
	 */
	@Override
	public LocalDateTime execute() throws RemoteException {
		taskView.append("Getting local time for client\n");
		return java.time.LocalDateTime.now();
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
		viewAdapter.append("Received task from client: ServerTime\n");
	}

}
