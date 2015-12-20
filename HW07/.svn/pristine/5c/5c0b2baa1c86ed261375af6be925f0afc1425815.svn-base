package jkl1.client.view;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;


/**
* The view of the client MVC system.
* 
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ClientGUI extends JFrame {

	/**
	 * SerialVersionUId for the class.
	 */
	private static final long serialVersionUID = -199099598475124566L;

	/**
	 * The default remote host reference.
	 */
	private static final String DEFAULT_REMOTE_HOST = "localhost"; 

	/**
	 * The adapter to the model.
	 */
	private IModelAdapter model;

	/**
	 * The top control panel
	 */
	private JPanel controlPnl;
	
	/**
	 * The status output text area
	 */
	private JTextArea outputTA;
	
	/**
	 * The connect button
	 */
	private JButton connectBtn;
	
	/**
	 * The quit button
	 */
	private JButton quitBtn;
	
	/**
	 * The button to calculate the remote server's info
	 */
	private JButton calcGetInfoBtn;
	
	/**
	 * An general purpose input text field used to input parameters to send with the 
	 * task executions. 
	 */
	private JTextField inputTF;
	
	/**
	 * The remote server's IP address info input text field.
	 */
	private JTextField remoteHostTF; 
	private JButton btnTestClass;
	private JButton button;
	private JButton btnGetServerTime;

	/**
	 * Constructor of the class
	 * @param ma the ModelAdapter 
	 */
	public ClientGUI(IModelAdapter ma) {
		super("Client GUI");
		model = ma;
		initGUI();
	}

	/**
	 * Initializes the view and its components.
	 */
	protected void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			/**
			 * tell the model to quit if the window is closing, even if very slowly.
			 */
			public void windowClosing(WindowEvent evt) {
				System.out.println("this.windowClosing, event="+evt);
				model.quit();
			}
		});
		setSize(719,449);
		controlPnl = new JPanel();
		outputTA = new JTextArea();
		JScrollPane scroll = new JScrollPane(outputTA);
		Container contentPane = getContentPane();
		contentPane.add(controlPnl, BorderLayout.NORTH);
		controlPnl.setLayout(new MigLayout("", "[][][][][][]", "[29px][]"));
		{
			quitBtn = new JButton();
			controlPnl.add(quitBtn, "cell 0 0,alignx left,aligny top");
			quitBtn.setText("Quit");
			quitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("quitBtn.actionPerformed, event="+evt);
					model.quit();
				}
			});
		}
		contentPane.add(scroll, BorderLayout.CENTER); 

		JLabel remoteHostLbl = new JLabel("Remote Host:");
		controlPnl.add(remoteHostLbl, "cell 1 0,alignx left,aligny center");
		remoteHostTF = new JTextField(DEFAULT_REMOTE_HOST);
		remoteHostTF.setPreferredSize(new Dimension(100,25));
		controlPnl.add(remoteHostTF, "cell 2 0,alignx left,aligny center");
		{
			connectBtn = new JButton();
			controlPnl.add(connectBtn, "cell 3 0,alignx left,aligny top");
			connectBtn.setText("Connect");
			connectBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("connectBtn.actionPerformed, event="+evt);
					connect();
				}
			});
		}
		remoteHostTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		btnGetServerTime = new JButton("Get Server Time");
		btnGetServerTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					append("Current Server Time: ");
					append(model.executeTask("servertime", inputTF.getText()) + "\n");
				} catch (Exception except) {
					append("Server Time exception: " + except + "\n");
				}
			}
		});
		controlPnl.add(btnGetServerTime, "cell 4 0");
		
		btnTestClass = new JButton("Chat");
		btnTestClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					append("Attempting to initialize chat session with server...\n");
					append(model.executeTask("chat", inputTF.getText()) + "\n");
				} catch (Exception except) {
//					except.printStackTrace();
					append("Chat exception occurred: " + except + "\n");
				}
			}
		});
		controlPnl.add(btnTestClass, "cell 5 0,alignx left,aligny top");
		{
			
					JLabel paramsLbl = new JLabel("Parameters:");
					controlPnl.add(paramsLbl, "cell 0 1,alignx left,aligny center");
			inputTF = new JTextField("5");
			inputTF.setPreferredSize(new Dimension(100,25));
			controlPnl.add(inputTF, "cell 1 1,alignx left,aligny center");
			calcGetInfoBtn = new JButton();
			controlPnl.add(calcGetInfoBtn, "cell 2 1,alignx left,aligny top");
			calcGetInfoBtn.setText("Get Info");
			calcGetInfoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						append("Calculate Get Info: ");
						append(model.executeTask("getinfo", inputTF.getText())+"\n");
					}
					catch(Exception excpt) {
						append("Calculate Get Info exception: "+excpt+"\n");
					}
				}				
			});
			JButton calcPiBtn = new JButton("Calculate Pi"); 
			controlPnl.add(calcPiBtn, "cell 3 1,alignx left,aligny top");
			
			button = new JButton("To Lowercase");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						append("Calculate LowerCase on input = " + inputTF.getText() + "\n");
						append(model.executeTask("lowercase", inputTF.getText()) + "\n");
					} catch (Exception except) {
						append("Calculate LowerCase exception: " + except + "\n");
					}
				}
			});
			controlPnl.add(button, "cell 4 1,alignx left,aligny top");
			calcPiBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						append("Calculate Pi: ");
						append(model.calcPi(Integer.parseInt(inputTF.getText()))+"\n");
					}
					catch(Exception excpt) {
						append("Calculate Pi exception: "+excpt+"\n");
					}
				}
			});
		}
	}
	
	/**
	 * Have the model connect to the remote server.
	 */
	private void connect() {
		append("Connecting...\n");
		append(model.connectTo(remoteHostTF.getText())+"\n");
	}
	
	/**
	 * Set the displayed remote host text field to the actual remote system's IP address or host name 
	 * @param host The name of the remote host 
	 */
	public void setRemoteHost(String host){
		remoteHostTF.setText(host);
	}
	
	/**
	 * Append the given string(s) to the view's output text adapter.  
	 * @param s the string to display.
	 */
	public void append(String s) {
		outputTA.append(s);
		//Force the JScrollPane to go to scroll down to the new text
		outputTA.setCaretPosition(outputTA.getText().length());
	}

	/**
	 * Starts the view by making it visible.
	 */
	public void start() {
		setVisible(true);
	}
}