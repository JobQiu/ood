package chatapp.model;

import java.net.InetAddress;

import common.IConnect;
import common.IUser;

/**
 * The User class that implements IUser interface
 * @author ls53@rice.edu
 */
public class User implements IUser {
    
    /**
     * The generated serial version UID
     */
    private static final long serialVersionUID = -119130136862198169L;

    /**
     * The IConnect object that belongs to the user
     */
    private IConnect myConnect;

    /**
     * The user name
     */
    private String name;
    
    /**
     * The IP address that belongs to that user
     */
    private InetAddress IP;

    /**
     * The constructor for User
     * @param myConnect
     * @param name
     * @param IP
     */
    public User(IConnect myConnect, String name, InetAddress IP) {
        this.myConnect = myConnect;
        this.name = name;
        this.IP = IP;
    }

    /**
     * Get a connect
     */
    public IConnect getConnect() {
        return myConnect;
    }
    
    /**
     * set AConnect associated with this user
     */
    public void setConnect(IConnect stub)
    {
        myConnect = stub;
    }
    
    /**
     * get user name
     */
    public String getName() {
        return name;
    }
    
    /**
     * set user name
     */
    public void setName(String name){
        this.name = name;
    }

    /** 
     * get IP address from this user
     */
    public InetAddress getIP() {
        return IP;
    }
    
    //Question: Should we allow to change the ip address?
    /** 
     * set IP address for this user
     */
    public void setIP(InetAddress newIP) {
        this.IP = newIP;
    }

    /**
     * Overriden equals() method to simply compare hashCodes.
     * @return  Equal if the hashCodes are the same.  False otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        
        if (other instanceof User) {
            User user = (User)other;
            return name.equals(user.getName()) &&
                   IP.getHostAddress().equals(user.getIP().getHostAddress());
        }
        
        return false;
    }
    /**
     * Overriden hashCode() method to create a hashcode from all the accessible values in IUser.
     * @return a hashCode tied to the values of this IUser.
     */
    @Override
    public int hashCode() {
            // using IP and name to calculate hashcode.
            int hash = 1;
            hash = hash * 17 + IP.hashCode();
            hash = hash * 31 + name.hashCode();
            return hash;
    }

    /**
     * Override the toString method
     */
    @Override
    public String toString() {
        return name;
    }
}
