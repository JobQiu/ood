package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PlayerGui<TInstrument> extends JFrame {
    
    private IModelCtrlAdapter<TInstrument> modelCtrlAdapter;

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = -3510837985614065652L;
    /**
     * the panel that holds everything in
     */
    private JPanel contentPane;
    
    private final JSplitPane splitPane = new JSplitPane();
    private final JPanel panel = new JPanel();
    private final JLabel lblFile = new JLabel("File:");
    private final JTextField txtFile = new JTextField();
    private final JScrollPane scrollPaneContent = new JScrollPane();
    private final JScrollPane scrollPaneStructure = new JScrollPane();
    private final JTextArea textAreaContent = new JTextArea();
    private final JTextArea textAreaStructure = new JTextArea();
    private final JButton btnLoad = new JButton("Load");
    private final JButton btnParse = new JButton("Parse");
    
    /**
     * A droplist of instruments
     */
    private final JComboBox<TInstrument> cbxInstruments = new JComboBox<>();
    
    /**
     * Buttons to paly and stop the music.
     */
    private final JButton btnPlay = new JButton("Play");
    private final JButton btnStop = new JButton("Stop");

    /**
     * Create the frame.
     */
    public PlayerGui(IModelCtrlAdapter<TInstrument> modelCtrlAdapter) {
        this.modelCtrlAdapter = modelCtrlAdapter;
        initGui();
    }
    
    private void initGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        splitPane.setResizeWeight(0.5);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        
        contentPane.add(splitPane, BorderLayout.CENTER);
        scrollPaneContent.setViewportBorder(new TitledBorder(null, "File Contents", 
        		TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        splitPane.setLeftComponent(scrollPaneContent);
        textAreaContent.setLineWrap(true);
        
        scrollPaneContent.setViewportView(textAreaContent);
        scrollPaneStructure.setViewportBorder(new TitledBorder(null, "Parsed IPhrase Structure", 
        		TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        splitPane.setRightComponent(scrollPaneStructure);
        textAreaStructure.setLineWrap(true);
        
        scrollPaneStructure.setViewportView(textAreaStructure);
        
        contentPane.add(panel, BorderLayout.NORTH);
        
        panel.add(lblFile);
        
        txtFile.setToolTipText("The file to load.");
        txtFile.setColumns(10);
        panel.add(txtFile);
        
        btnLoad.setToolTipText("Load the file to create the ABCParser.");
        panel.add(btnLoad);

        btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String content = modelCtrlAdapter.loadFile(txtFile.getText());
				if (null == content){ 
					return; // just in case
				}

				textAreaContent.setText(content);
				btnParse.setEnabled(true);
				textAreaStructure.setText("");
			}
		});
        
        btnParse.setToolTipText("Parse the file and create the IPhrase structure.");
        btnParse.setEnabled(false);
        panel.add(btnParse);
        btnParse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String structure = modelCtrlAdapter.parseFile();
				if (null == structure)
					return; // just in case

				textAreaStructure.setText(structure);
			}
		});
        
        cbxInstruments.setToolTipText("Select an instrument to use when playing.");
        panel.add(cbxInstruments);
        
        
        btnPlay.setToolTipText("Play the parsed IPhrase data structure.");
        panel.add(btnPlay);
        btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modelCtrlAdapter.playMusic(cbxInstruments.getItemAt(cbxInstruments.getSelectedIndex()));
			}
		});
        
        btnStop.setToolTipText("Stop playing the parsed IPhrase data structure.");
        panel.add(btnStop);
        btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modelCtrlAdapter.stopMusic();
			}
		});
        
    }
    
    public void start() {
        setVisible(true);
    }
    
    public void addInstrument(TInstrument instrument) {
        cbxInstruments.addItem(instrument);
    }
}
