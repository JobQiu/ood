package ls53_yh36.client.app.model;

import java.util.Set;

import common.IChatroom;
import ls53_yh36.client.chat.model.ChatModel;
import ls53_yh36.client.chat.model.IChatViewAdapter;
import ls53_yh36.user.InitUser;

/**
 * The chat app model to view adapter
 * @author ls53@rice.edu
 */
public interface IAppViewAdapter {
    
    /**
     * Append a message
     * @param message The message to append
     */
    public void append(String message);
    
    /**
     * Add a user
     * @param user The user to add
     */
    public void addUser(InitUser user);
    
    /**
     * Get a new chatroom name
     * @return The new chat room name
     */
    public String getNewChatroomName();
    
    /**
     * Make a chat room model to view adapter
     * @param model The chat room model
     * @return The chat room model to view adapter
     */
    public IChatViewAdapter makeChatroomViewAdapter(ChatModel model);
    
    /**
     * Ask a user if he will join a chat room
     * @param username The user name of the user who send a invitation
     * @param chatroom The chat room
     * @return True if agree, false otherwise
     */
    public boolean willJoinChatroom(String username, String chatroom);
    
    /**
     * Set the UI's title
     * @param title The title
     */
    public void setTitle(String title);
    
    /**
     * Add a chat room
     * @param chatroom The chat room to add
     */
    public void addChatroom(ChatModel chatroom);
    
    /**
     * Remove a chat room
     * @param chatroom The chat room to remove
     */
    public void removeChatroom(ChatModel chatroom);
    
    /**
     * Send a warning message
     * @param message The message
     */
    public void warn(String message);
    
    /**
     * Choose a chatroom
     * @param user The user who owns chat room list
     * @param chatroomList The chat room list
     */
    public void chooseChatroom(InitUser user, Set<IChatroom> chatroomList);
}
