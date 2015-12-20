package util;

/**
 * The object loader for reflection
 * @author ls53@rice.edu
 *
 */
public class ObjectLoader {
    
    /**
     * Load an object
     * @param className The name of class
     * @return The concrete object
     */
    @SuppressWarnings("unchecked")
    public static <T> T load(String className) {
        try {
            Object[] args = new Object[0];
            java.lang.reflect.Constructor<?> cs[] = Class.forName(className).getConstructors();  // get all the constructors
            java.lang.reflect.Constructor<?> c = null;
            for(int i=0;i < cs.length; i++) {  // find the first constructor with the right number of input parameters
                if(args.length == (cs[i]).getParameterTypes().length) {
                    c = cs[i];
                    break;
                }
            }
            
            return (T)c.newInstance(args);   // Call the constructor.   Will throw a null ptr exception if no constructor with the right number of input parameters was found.
        }
        catch(Exception ex) {
            System.err.println("Class "+className+" failed to load. \nException = \n"+ ex);
            ex.printStackTrace();  // print the stack trace to help in debugging.
            return null;    // Is this really a useful thing to return here?  Is there something better that could be returned?
        }
    }
}
