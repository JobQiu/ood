package util;

import java.util.Observable;

/**
 * A simplified Observable class that immediately notifies 
 * its Observers when its notifyAll() method is called. The 
 * changed state of the Dispatcher does not need to be 
 * separately set.
 * @author ls53@rice.edu
 */
public class Dispatcher extends Observable {
    
    /**
     * The default constructor for dispatcher
     */
    public Dispatcher() {}
    
    /**
     * Immediately notifies all the Observers held.
     * @param arg An input parameter that is passed on to all the Observers.
     */
    public void notifyAll(Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}