package jkl1.client.view;

/**
 * Adapter the view uses to communicate to the model
 */
public interface IModelAdapter {
	/**
	 * Requests that model connect to the RMI Registry at the given remote host
	 * 
	 * @param remoteHost
	 *            The remote host to connect to.
	 * @return A status string regarding the connection result
	 */
	public String connectTo(String remoteHost);

	/**
	 * Calculates PI to the given number of decimal places by sending an entire
	 * Pi2 object to the remote ICompute object.
	 * 
	 * @param numDigits
	 *            The number of digits to compute PI to.
	 * @return A status string on the computation.
	 */
	public String calcPi(int numDigits);
	
	/**
	 * Execute the task on with the specified name ID with the given input on the remote
	 * ICompute object.
	 * @param id	Name of task, e.g. "getinfo".
	 * @param input	Input parameter given to the task.
	 * @return	Status string on the task execution.
	 */
	public String executeTask(String id, String input);

	/**
	 * Quits the applications and gracefully shuts down the RMI-related resources.
	 */
	public void quit();

}