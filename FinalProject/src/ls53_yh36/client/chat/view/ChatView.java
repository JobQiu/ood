package ls53_yh36.client.chat.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * The Chat View
 * @author ls53@rice.edu
 * @param <TUser> The generic type for user
 */
public class ChatView<TUser> extends JFrame {
    
    /**
     * The generated serial version UID
     */
    private static final long serialVersionUID = -8285110863406330628L;

    /**
     * The view to model adapter
     */
    private IChatModelAdapter modelAdapter;

    /**
     * The main panel
     */
    private JPanel contentPane;
    
    /**
     * The control panel
     */
    private final JPanel panelCtrl = new JPanel();
    
    /**
     * The split panel
     */
    private final JSplitPane splitPaneInfo = new JSplitPane();
    
    /**
     * The left scroll panel
     */
    private final JScrollPane scrollPaneDialog = new JScrollPane();
    
    /**
     * The button for sending message
     */
    private final JButton btnSend = new JButton("Send");
    
    /**
     * The text are for showing dialog
     */
    private final JTextArea txtrDialog = new JTextArea();
    
    /**
     * The right scroll panel
     */
    private final JScrollPane scrollPaneUser = new JScrollPane();
    
    /**
     * The list model
     */
    private final DefaultListModel<TUser> listModel = new DefaultListModel<>();
    
    /**
     * The list for showing users
     */
    private final JList<TUser> listUsers = new JList<>(listModel);
    
    /**
     * The message scroll panel
     */
    private final JScrollPane scrollPaneMsg = new JScrollPane();
    
    /**
     * The text area for inputing message
     */
    private final JTextArea txtrMsg = new JTextArea();

    /**
     * Create the frame.
     * @param modelAdapter The view to model adapter
     */
    public ChatView(IChatModelAdapter modelAdapter) {
        this.modelAdapter = modelAdapter;
        initGUI();
    }
    
    /**
     * Initialize GUI
     */
    private void initGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        contentPane.add(panelCtrl, BorderLayout.SOUTH);
        panelCtrl.setLayout(new BoxLayout(panelCtrl, BoxLayout.X_AXIS));
        btnSend.addActionListener(e -> {
            String input = txtrMsg.getText();
            if (!input.isEmpty()) {
                modelAdapter.sendMessage(input);
                txtrMsg.setText("");
            }
        });
        
        panelCtrl.add(scrollPaneMsg);
        
        scrollPaneMsg.setViewportView(txtrMsg);
        
        panelCtrl.add(btnSend);
        splitPaneInfo.setResizeWeight(0.7);
        
        contentPane.add(splitPaneInfo, BorderLayout.CENTER);
        scrollPaneDialog.setViewportBorder(new TitledBorder(null, "Dialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        splitPaneInfo.setLeftComponent(scrollPaneDialog);
        txtrDialog.setEditable(false);
        
        scrollPaneDialog.setViewportView(txtrDialog);
        scrollPaneUser.setViewportBorder(new TitledBorder(null, "Teammates:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        splitPaneInfo.setRightComponent(scrollPaneUser);
        listUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        scrollPaneUser.setViewportView(listUsers);
        
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                modelAdapter.quiteChatroom();
            }
        });
    }
    
    /**
     * Start the view
     */
    public void start() {
        setVisible(true);
    }
    
    /**
     * Append the message
     * @param str The message to append
     */
    public void append(String str) {
        txtrDialog.append(str);
        txtrDialog.setCaretPosition(txtrDialog.getText().length());
    }
    
    /**
     * Add a user
     * @param user The user to add
     */
    public void addUser(TUser user) {
        listModel.addElement(user);
    }
    
    /**
     * Remove a user
     * @param user The user to remove
     */
    public void removeUser(TUser user) {
        listModel.removeElement(user);
    }
    
    /**
     * Send a waring message
     * @param message The waring message to send
     */
    public void warn(String message) {
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
