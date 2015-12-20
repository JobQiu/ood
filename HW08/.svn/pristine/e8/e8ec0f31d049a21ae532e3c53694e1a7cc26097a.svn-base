package chatapp.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import chatroom.view.ChatroomView;
import chatroom.view.IChatroomModelAdapter;

/**
 * The UI for chat app
 * @author ls53@rice.edu
 * @param <TUser> The generic type for user
 * @param <TChatroom> The generatic type for chat room
 */
public class ChatAppView<TUser, TChatroom> extends JFrame {
    
    /**
     * The view to model adapter
     */
    private IChatAppModelAdapter<TUser, TChatroom> modelAdapter;

    /**
     * The generate serial version UID
     */
    private static final long serialVersionUID = -1259336758548704871L;
    
    /**
     * The main panel
     */
    private JPanel contentPane;
    
    /**
     * The text area for showing infomation
     */
    private final JTextArea textArea = new JTextArea();
    
    /**
     * The text field for inputing IP address
     */
    private final JTextField txtIp = new JTextField();
    
    /**
     * The connect button
     */
    private final JButton btnConnect = new JButton("Connect");
    
    /**
     * The users label
     */
    private final JLabel lblUsers = new JLabel("Users:");
    
    /**
     * The combo box for selecing user
     */
    private final JComboBox<TUser> cbxUsers = new JComboBox<>();
    
    /**
     * The invite button
     */
    private final JButton btnInvite = new JButton("Invite");
    
    /**
     * The scroll panel
     */
    private final JScrollPane scrollPane = new JScrollPane();
    
    /**
     * The button for creating a new chat room
     */
    private final JButton btnNewChatroom = new JButton("New Chatroom");
    
    /**
     * The IP label
     */
    private final JLabel lblIp = new JLabel("IP Address:");
    
    /**
     * The chat rooms label
     */
    private final JLabel lblChatrooms = new JLabel("Chatrooms:");
    
    /**
     * The combo box for selecting a chatroom
     */
    private final JComboBox<TChatroom> cbxChatrooms = new JComboBox<>();
    
    /**
     * The panel containing panelUP and panelDown
     */
    private final JPanel panel = new JPanel();
    
    /**
     * The upper panel
     */
    private final JPanel panelUp = new JPanel();
    
    /**
     * The lower panel
     */
    private final JPanel panelDown = new JPanel();

    /**
     * Create the frame.
     */
    public ChatAppView(IChatAppModelAdapter<TUser, TChatroom> modelAdapter) {        
        this.modelAdapter = modelAdapter;
        initGui();
    }
    
    /**
     * Initialize the GUI
     */
    private void initGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportBorder(new TitledBorder(null, "Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        textArea.setToolTipText("Show information");
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
        
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(2, 1, 0, 0));
        
        panel.add(panelUp);
        panelUp.add(lblIp);
        txtIp.setToolTipText("Input IP address");
        panelUp.add(txtIp);
        txtIp.setColumns(10);
        btnConnect.setToolTipText("Connect to a IP address");
        panelUp.add(btnConnect);
        btnNewChatroom.setToolTipText("Create a new chat room");
        panelUp.add(btnNewChatroom);
        btnNewChatroom.addActionListener(e -> {
            modelAdapter.createNewChatroom();
        });
        btnConnect.addActionListener(e -> {
            String ip = txtIp.getText().trim();
            if (!ip.isEmpty()) {
                modelAdapter.connectTo(ip);
            }
        });
        
        panel.add(panelDown);
        panelDown.add(lblUsers);
        cbxUsers.setToolTipText("Select a user");
        panelDown.add(cbxUsers);
        panelDown.add(lblChatrooms);
        cbxChatrooms.setToolTipText("Select a chat room");
        panelDown.add(cbxChatrooms);
        btnInvite.setToolTipText("Invite a user");
        panelDown.add(btnInvite);
        btnInvite.addActionListener(e -> {
            if (cbxUsers.getSelectedIndex() == -1 || cbxChatrooms.getSelectedIndex() == -1) {
                return;
            }
            
            TUser user = cbxUsers.getItemAt(cbxUsers.getSelectedIndex());
            TChatroom chatroom = cbxChatrooms.getItemAt(cbxChatrooms.getSelectedIndex());
            modelAdapter.inviteUserToChatroom(user, chatroom);
        });
        
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                modelAdapter.quitAllChatrooms();
            }
        });
    }
    
    /**
     * Start the UI
     */
    public void start() {
        String username = JOptionPane.showInputDialog(null, "Please input your username:", "Login", JOptionPane.INFORMATION_MESSAGE);
        if (username == null) {
            System.exit(0);
        } else if (username.trim().isEmpty()) {
            username = "COMP 504 user";
        }
        
        setVisible(true);
        modelAdapter.initUsername(username);
    }
    
    /**
     * Append a message
     * @param str The message
     */
    public void append(String str) {
        textArea.append(str);
        textArea.setCaretPosition(textArea.getText().length());
    }
    
    /**
     * Get a new chat room name
     * @return The new chat room name
     */
    public String getNewChatroomName() {
        String chatroomName = null;
        do {
            chatroomName = JOptionPane.showInputDialog(null, "Please input new chatroom's name:", "Chatroom Name", JOptionPane.INFORMATION_MESSAGE);
            if (chatroomName == null) {
                return null;
            }
            
            chatroomName = chatroomName.trim();                
        } while (chatroomName.isEmpty());
        
        return chatroomName;
    }
    
    /**
     * Make a chat room view
     * @param chatroomModelAdapter The chat room view to model adapter
     * @return The chat room view
     */
    public ChatroomView<TUser> makeChatroomView(IChatroomModelAdapter chatroomModelAdapter) {
        return new ChatroomView<TUser>(chatroomModelAdapter);
    }
    
    /**
     * Ask a user if he will join this chat room
     * @param username The user name of the user who sends the invitation
     * @param chatroom The chat room
     * @return True if accepting invitation, false otherwise
     */
    public boolean willJoinChatroom(String username, String chatroom) {
        String message = String.format("Will you join the chatroom %s invited by %s", chatroom, username);
        int result = JOptionPane.showConfirmDialog(null, message, "Invitation", JOptionPane.OK_CANCEL_OPTION);
        
        return result == JOptionPane.OK_OPTION;
    }
    
    /**
     * Add a user
     * @param user The user to add
     */
    public void addUser(TUser user) {
        cbxUsers.insertItemAt(user, 0);
        cbxUsers.setSelectedIndex(0);
    }
    
    /**
     * Add a chat room
     * @param chatroom The chat room to add
     */
    public void addChatroom(TChatroom chatroom) {
        cbxChatrooms.insertItemAt(chatroom, 0);
        cbxChatrooms.setSelectedIndex(0);
    }
    
    /**
     * Remove a chat room
     * @param chatroom The chat room to remove
     */
    public void removeChatroom(TChatroom chatroom) {
        cbxChatrooms.removeItem(chatroom);
    }
    
    /**
     * Send a warning message
     * @param message The warning message
     */
    public void warn(String message) {
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
}