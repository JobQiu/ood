package ls53_yh36.client.chat.view;

/**
 * The chat room view to model adapter
 * @author ls53@rice.edu
 */
public interface IChatModelAdapter {
    
    /**
     * Send a message
     * @param message The message to send
     */
    public void sendMessage(String message);
    
    /**
     * Quit the chat room
     */
    public void quiteChatroom();
}
