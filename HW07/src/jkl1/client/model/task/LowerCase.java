package jkl1.client.model.task;

import java.rmi.RemoteException;

import java.io.*;

import provided.compute.ITask;
import provided.compute.ILocalTaskViewAdapter;

/**
 * Task that uses the server to convert an input string to lower case.
 * @author luej
 *
 */
public class LowerCase implements ITask<String> {

	
    /**
	 * Serial ID
	 */
	private static final long serialVersionUID = -5153461809566875837L;

	/**
     * Adapter to the local view.  Marked "transient" so that it is not serialized
     * and instead is reattached at the destination (the server).  
     */
	private transient ILocalTaskViewAdapter taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER;

	/**
	 * Input string given to the constructor
	 */
	private String input = "";

	/**
	 * Constructor for the class.
	 * 
	 * @param input  String to convert to lowercase.
	 */
	public LowerCase(String input) {
		this.input = input;
	}

	/**
	 * Convert the input string to lowercase on the server.
	 * 
	 * @return Input string converted to lowercase.
	 */
	@Override
	public String execute() throws RemoteException {
		taskView.append("LowerCase task called with input = " + input + "\n");
		return input.toLowerCase();
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
		viewAdapter.append("Received task from client: LowerCase\n");
	}

}
