package jkl1.client.model.task;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

/**
 * Simple chat window GUI that sends and displays received text messages.
 * @author luej
 *
 */
public class ChatWindow extends JFrame implements Remote {

	private static final long serialVersionUID = 5588704012387217319L;
	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextField inputField = new JTextField();
	private final JPanel panel = new JPanel();
	private final JButton btnSend = new JButton("Send");
	private final TextArea textArea = new TextArea();

	/**
	 * Adapter used to send outgoing messages. Default noop.
	 */
	private ChatWindowAdapter adapter = (s) -> {};

	/**
	 * Start the chat window.
	 */
	public void start() {
		setVisible(true);
		inputField.requestFocusInWindow();
	}

	/**
	 * Create the frame.
	 */
	public ChatWindow() {
		initGUI();
	}
	
	/**
	 * Create the chatwindow and initialize it to a specified adapter.
	 * @param adapter	Adapter used to send outgoing messages.
	 */
	public ChatWindow(ChatWindowAdapter adapter) {
		this.adapter = adapter;
		initGUI();
	}
	
	/**
	 * Initialize GUI elements.
	 */
	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		panel.setLayout(new BorderLayout(0, 0));
		inputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSend.doClick();
				inputField.setText("");
			}
		});
		panel.add(inputField, BorderLayout.CENTER);
		inputField.setColumns(10);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append(">> [" + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) + "] ");
				textArea.append(inputField.getText() + "\n");
				try {
					adapter.send(inputField.getText());
				} catch (RemoteException e1) {
					textArea.append("Failed to send message: RemoteException occurred\n");
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(btnSend, BorderLayout.EAST);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(panel, BorderLayout.SOUTH);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		textArea.setEditable(false);
		
		scrollPane.setViewportView(textArea);
	}
	
	/**
	 * Display the incoming chat message.
	 * @param msg	Incoming chat message.
	 */
	public void receive(String msg) {
		textArea.append("[" + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) + "] ");
		textArea.append(msg + "\n");
	}
	
	/**
	 * Set the adapter used to send outgoing messages.
	 * @param adapter	Adapter used to send outgoing messages.
	 */
	public void setAdapter(ChatWindowAdapter adapter) {
		this.adapter = adapter;
	}

}
