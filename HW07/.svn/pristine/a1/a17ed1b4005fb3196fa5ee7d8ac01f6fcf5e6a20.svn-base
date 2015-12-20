package jkl1.client.model;

import java.math.BigDecimal;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;
import java.util.Map;
import java.util.function.Function;

import jkl1.client.model.task.*;
import provided.compute.*;
import provided.rmiUtils.*;
import provided.util.IVoidLambda;

/**
 * The model of the client system.
 * 
 * @author swong, jkl1
 * 
 */
public class ClientModel {

	/**
	 * output command used to put multiple strings up onto the view.
	 */
	private IVoidLambda<String> outputCmd = new IVoidLambda<String>() {

		@Override
		public void apply(String... params) {
			for (String s : params) {
				view.append(s + "\n");
			}
		}
	};

	/**
	 * Factory for the Registry and other uses.
	 */
	IRMIUtils rmiUtils = new RMIUtils(outputCmd);

	/**
	 * Adapter to the view
	 */
	private IViewAdapter view;


	/**
	 * A reference to the proxy stub of the remote ICompute object.
	 */
	private ICompute comp;

	/**
	 * The adapter that connects all the way back to the remote system's view
	 * enabling this client to append messages to the server's view.
	 */
	private IRemoteTaskViewAdapter serverTA;

	/**
	 * The view adapter that the server can use to append messages to this
	 * client's view.
	 */
	private IRemoteTaskViewAdapter clientTA = new IRemoteTaskViewAdapter() {
		public void append(String s) {
			view.append("[Server] " + s);
		}
	};
	
	/**
	 * RMI stub for clientTA.  null=> clientTA needs to be exported, do not re-export otherwise. 
	 */
	private IRemoteTaskViewAdapter clientTAstub = null;
	
	/**
	 * Lookup table mapping ID names to calculation methods in this class.
	 */
	private Map<String, Function<String, String>> taskTable = new Hashtable<>();

	/**
	 * Constructor for the class
	 * 
	 * @param view
	 *            The adapter to the view.
	 */
	public ClientModel(IViewAdapter view) {
		this.view = view;
	}

	/**
	 * Starts the model by setting all the required RMI system properties,
	 * starts up the class server and installs the security manager.
	 */
	public void start() {
		rmiUtils.startRMI(IRMI_Defs.CLASS_SERVER_PORT_CLIENT);

		try {
			view.setRemoteHost(rmiUtils.getLocalAddress()); //TODO Is this stored somewhere?
		} catch (Exception e) {
			System.err.println("Error getting local address: " + e);
		}
		
		addTasks();
	}

	/**
	 * Stops the client by shutting down the class server.
	 */
	public void stop() {
		System.out.println("ClientModel.stop(): client is quitting.");
		try {
			rmiUtils.stopRMI();
			
		} catch (Exception e) {
			System.err
					.println("ClientModel.stop(): Error stopping class server: "
							+ e);
		}
		System.exit(0);
	}

	/**
	 * Add methods to the task lookup table. The lookup table is used by the executeTask method
	 * to determine which method to call based on a String ID. This allows the view or other external
	 * users to call executeTask with a method ID parameter instead of calling the methods directly.
	 */
	private void addTasks() {
		taskTable.put("chat", this::twoWayChat);
		taskTable.put("getinfo", this::calcGetInfo);
		taskTable.put("lowercase", this::calcLowerCase);
		taskTable.put("servertime", this::calcServerTime);
	}
	/**
	 * Connects to the given remote host and retrieves the stub to the ICompute object bound 
	 * to the ICompute.BOUND_NAME name in the remote Registry on port 
	 * IRMI_Defs.REGISTRY_PORT.  
	 * 
	 * @param remoteHost The IP address or host name of the remote server.
	 * @return  A status string on the connection.
	 */
	public String connectTo(String remoteHost) {
		try {
			view.append("Locating registry at " + remoteHost + "...\n");
			//Registry registry = registryFac.getRemoteRegistry(remoteHost);
			Registry registry = rmiUtils.getRemoteRegistry(remoteHost);
			view.append("Found registry: " + registry + "\n");
			comp = (ICompute) registry.lookup(ICompute.BOUND_NAME);
			view.append("Found remote Compute object: " + comp + "\n");
			if(null==clientTAstub){  // Don't re-export clientTA if already done.
				clientTAstub = (IRemoteTaskViewAdapter) UnicastRemoteObject
					.exportObject(clientTA, IRemoteTaskViewAdapter.BOUND_PORT_CLIENT);
			}
			serverTA = comp.setTextAdapter(clientTAstub);
			view.append("Got text adapter: " + serverTA + "\n");
			serverTA.append("Hello from the client!\n");
		} catch (Exception e) {
			view.append("Exception connecting to " + remoteHost + ": " + e
					+ "\n");
			e.printStackTrace();
			return "No connection established!";
		}
		return "Connection to " + remoteHost + " established!";
	}

	/**
	 * Calculates PI to the given number of decimal places by 
	 * sending an entire Pi2 object to the remote ICompute object. 
	 * @param numDigits  The number of digits to compute PI to.
	 * @return A status string on the computation.
	 */
	public String calcPi(int numDigits) {
		String result = "";
		if (null == comp)
			return "No ICompute object yet!";
		Pi2 task = new Pi2(numDigits);

		try {
			BigDecimal pi = comp.executeTask(task);
			result = pi.toString();
		} catch (Exception e) {
			view.append("\nComputePi exception: " + e + "\n");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Opens a new ChatWindow on the client and the server which supports basic two-way
	 * text chat. The task sent to ICompute contains a stub of the client's chat adapter,
	 * and the result returned is a stub of the server's chat adapter.
	 * @param p	Not used.
	 * @return	Status string on the chat connection.
	 */
	public String twoWayChat(String p) {
		if (null == comp)
			return "No ICompute object yet!";
		
		ChatWindow localWindow = new ChatWindow();
		
		// create the client's chat adapter and its stub
		ChatWindowAdapter serverAdapter = (msg) -> localWindow.receive(msg);
		ChatWindowAdapter serverAdptStub;
		try {
			serverAdptStub = (ChatWindowAdapter) UnicastRemoteObject.exportObject(serverAdapter, IRemoteTaskViewAdapter.BOUND_PORT_CLIENT);
		} catch (Exception e1) {
			e1.printStackTrace();
			return "Error initializing chat session: failed to create local adapter stub";
		}
		
		// send the client stub to the server via a Chat task
		Chat task = new Chat(serverAdptStub);
		try {
			// attach the client window to the sever's chat stub
			localWindow.setAdapter(comp.executeTask(task));
			localWindow.start();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error initializing chat session: failed to establish session with server";
		}
		return "Chat session successfully initialized";
	}
	
	/**
	 * Gets the system information from the remote server by sending an entire GetInfo
	 * object to the remote server.   
	 * @param p   A string passed to the GetInfo object to use as it pleases.
	 * @return A status string on the GetInfo task.
	 */
	public String calcGetInfo(String p) {
		String result = "";
		if (null == comp)
			return "No ICompute object yet!";
		GetInfo task = new GetInfo(p);

		try {
			result = comp.executeTask(task);
		} catch (Exception e) {
			view.append("\nCompute GetInfo exception: " + e + "\n");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Convert the input parameter to a lowercase String by sending it via task
	 * to the server.
	 * @param p	Input string to convert to lowercase.
	 * @return	Result of the execution.
	 */
	public String calcLowerCase(String p) {
		if (null == comp) return "No ICompute object yet!";
		
		try {
			return comp.executeTask(new LowerCase(p));
		} catch (Exception e) {
			e.printStackTrace();
			return "Compute LowerCase exception: " + e;
		}
	}
	
	/**
	 * Get the server's local time and date by sending it a ServerTime task.
	 * @param p	Not used.
	 * @return	Status string of server time.
	 */
	public String calcServerTime(String p) {
		if (null == comp) return "No ICompute object yet!";
		try {
			return comp.executeTask(new ServerTime(p)).format(java.time.format.DateTimeFormatter
					.ofPattern("EEE MMM dd, hh:mm:ss a"));
		} catch (Exception e) {
			e.printStackTrace();
			return "Compute ServerTime exception: " + e;
		}
	}
	
	/**
	 * Invoke a method in the task lookup table. This allows the view to invoke the task-sending
	 * methods in this class by a String name instead of invoking each separate method directly.
	 * @param id	String name of the method to invoke, e.g. "chat"
	 * @param input	Input parameter to pass to the method.
	 * @return	Result of invoking the specified method; a status string to print to the view window.
	 */
	public String executeTask(String id, String input) {
		return taskTable.containsKey(id) ? taskTable.get(id).apply(input) : "Unknown task id = " + id;
	}
}
