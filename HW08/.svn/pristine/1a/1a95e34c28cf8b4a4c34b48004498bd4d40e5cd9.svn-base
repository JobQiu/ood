package chatapp.model;

import java.net.InetAddress;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.IConnect;
import common.IUser;
import provided.rmiUtils.IRMIUtils;
import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIUtils;
import provided.util.IVoidLambda;

/**
 * Bootstrap for RMI
 * @author ls53@rice.edu
 */
public class Bootstrap {

    
    /**
     * The RMI Registry
     */
    private Registry registry;
    
    /**
     * Utility object used to get the Registry
     */
    private IRMIUtils rmiUtils;
    
    /**
     * The constructor for Bootstrap
     * @param outputCmd The output command
     */
    public Bootstrap(IVoidLambda<String> outputCmd) {
        rmiUtils = new RMIUtils(outputCmd);
        rmiUtils.startRMI(IRMI_Defs.CLASS_SERVER_PORT_SERVER);
    }
    
    /**
     * Initialize a user
     * @param userId The user id
     * @param connect The IConnect object
     * @return The IUser object
     */
    public IUser init(String userId,IConnect connect) {
        try {
            
            /**
             * IMPORTANT FOR CREATING A NEW STUB
             * This is how to create a new stub from an existing IConnect object
             */
            IConnect stub =(IConnect) UnicastRemoteObject.exportObject(connect, IConnect.BOUND_PORT);

            registry = rmiUtils.getLocalRegistry();

            registry.rebind(IConnect.BOUND_NAME, stub);
            
            System.out.println("Waiting..."+"\n");
            
            return new User(connect,userId,InetAddress.getLocalHost());
        } 
        catch (Exception e) {
            System.err.println("Connect exception:"+"\n");
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }
    
    /**
     * Connect to a user
     * @param ip The IP address of that user
     * @return
     */
    public IUser connectToUser(String ip)
    {
        try {
            
            //Registry registry = registryFac.getRemoteRegistry(remoteHost);
            Registry registry = rmiUtils.getRemoteRegistry(ip);
            System.out.println("Found registry: " + registry + "\n");
            IConnect connect = (IConnect) registry.lookup(IConnect.BOUND_NAME);
            System.out.println("Found remote Connect object: " + connect + "\n");
            return connect.getUser(connect);

        } catch (Exception e) {
            System.out.println("Exception connecting to " + ip + ": " + e
                    + "\n");
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Shutdown RMI
     */
    public void shutdown() {
        try {
            registry.unbind(IConnect.BOUND_NAME);
            System.out.println("EngineController: " + IConnect.BOUND_NAME
                    + " has been unbound.");
            
            rmiUtils.stopRMI();
            
            System.exit(0);
        } catch (Exception e) {
            System.err.println("EngineController: Error unbinding "
                    + IConnect.BOUND_NAME + ":\n" + e);
            System.exit(-1);
        }
    }

}