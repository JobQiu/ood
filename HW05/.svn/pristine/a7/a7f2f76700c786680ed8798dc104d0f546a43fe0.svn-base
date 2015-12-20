package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * The ball world view
 * @author ls53@rice.edu
 * @param <TStrategyDropListItem> The generic type for update strategy
 * @param <TPaintDropListItem> The generic type for paint strategy
 */
public class BallWorldGUI<TStrategyDropListItem, TPaintDropListItem> extends JFrame {
    
    /**
     * The serial version uid
     */
	private static final long serialVersionUID = 5545354999257563085L;
	
	/**
	 * The content panel
	 */
	private final JPanel contentPane = new JPanel();
	
	/**
	 * The canvas
	 */
	private JPanel centerPanel;
	
    /**
     * Adapter back to the model for control tasks.
     */
	private IModelCtrlAdapter<TStrategyDropListItem, TPaintDropListItem> _modelCtrlAdapter;
    /**
     * Adapter back to the model for update tasks.
     */
    private IModelUpdateAdapter _modelUpdateAdapter = IModelUpdateAdapter.NULL_OBJECT;
    
    /**
     * The input field for moving strategy
     */
    private JTextField movingStrategy;
    /**
     * Bottom drop list, used for combining with the top list selection.
     */
    private JComboBox<TStrategyDropListItem> _list1DL;
    /**
     * Bottom drop list, used for combining with the top list selection.
     */
    private JComboBox<TStrategyDropListItem> _list2DL; 
    /**
     * Bottom drop list, used for adding paint strategy.
     */
    private JComboBox<TPaintDropListItem> _list3DL; 
    
    /**
     * The input field for paint strategy
     */
    private JTextField paintStrategy;
    
 
    /**
     * A subclass of JFrame containing the various GUI components specified in the program behavior specification.
     * Provides a Component area where the drawing object is to be drawn.
     * @param _modelCtrlAdapter The model control adapter
     * @param _modelUpdateAdapter The model update adapter
     */
	public BallWorldGUI(IModelCtrlAdapter<TStrategyDropListItem, TPaintDropListItem> _modelCtrlAdapter, IModelUpdateAdapter _modelUpdateAdapter) {
		this._modelCtrlAdapter = _modelCtrlAdapter;
		this._modelUpdateAdapter = _modelUpdateAdapter;
		
		initGUI();
	}
	
	/**
	 * Initialize GUI
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.GREEN);
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JPanel leftpanel = new JPanel();
		northPanel.add(leftpanel);
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));
		
		movingStrategy = new JTextField();
		movingStrategy.setText("Straight");
		leftpanel.add(movingStrategy);
		movingStrategy.setColumns(10);
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Moving Strategy");		
		movingStrategy.setBorder(title);
		
		
		JButton btnAdd = new JButton("   Add to lists  ");
		btnAdd.setToolTipText("Click this button to add a new moving strategy to the droplist.");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TStrategyDropListItem o = _modelCtrlAdapter.addUpdateStrategy(movingStrategy.getText());
				if (null == o) return; 
				_list1DL.insertItemAt(o, 0);
				_list1DL.setSelectedItem(o);
				_list2DL.insertItemAt(o, 0);
				_list2DL.setSelectedItem(o);

			}
		});
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftpanel.add(btnAdd);
		
		JPanel middlepanel = new JPanel();
		northPanel.add(middlepanel);
		middlepanel.setLayout(new BoxLayout(middlepanel, BoxLayout.Y_AXIS));
		
		JButton btnMake = new JButton("Make selected ball!");
		btnMake.setToolTipText("Click this button to make the ball with specified strategy.");
		btnMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    TStrategyDropListItem updateStrategyFac = _list1DL.getItemAt(_list1DL.getSelectedIndex());
			    TPaintDropListItem paintStrategyFac = _list3DL.getItemAt(_list3DL.getSelectedIndex());
			    if (updateStrategyFac != null && paintStrategyFac != null ) {
			        _modelCtrlAdapter.makeBall(updateStrategyFac, paintStrategyFac);			        
			    }
			}
		});
		btnMake.setAlignmentX(Component.CENTER_ALIGNMENT);
		middlepanel.add(btnMake);
		
		_list1DL = new JComboBox<TStrategyDropListItem>();
		middlepanel.add(_list1DL);
		
		_list2DL= new JComboBox<TStrategyDropListItem>();
		middlepanel.add(_list2DL);
		
		
		JButton btnCombine = new JButton("          Combine          ");
		btnCombine.setToolTipText("Click this button to combine the two strategies as a compound strategy.");
		btnCombine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TStrategyDropListItem o = _modelCtrlAdapter.combineUpdateStrategies(_list1DL.getItemAt(_list1DL.getSelectedIndex()), 
				                                                                    _list2DL.getItemAt(_list2DL.getSelectedIndex()));
				_list1DL.insertItemAt(o, 0);
				_list2DL.insertItemAt(o, 0);
			}
		});
		btnCombine.setAlignmentX(Component.CENTER_ALIGNMENT);
		middlepanel.add(btnCombine);
		
		JPanel rightpanel = new JPanel();
		northPanel.add(rightpanel);
		rightpanel.setLayout(new BoxLayout(rightpanel, BoxLayout.Y_AXIS));
		
		JButton btnMakeSwicher = new JButton("Make Switcher!");
		btnMakeSwicher.setToolTipText("Click this button to make a ball with switcher strategy.");
		btnMakeSwicher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    TPaintDropListItem paintStrategyFac = _list3DL.getItemAt(_list3DL.getSelectedIndex());
			    if (paintStrategyFac != null) {
			        _modelCtrlAdapter.makeSwitcher(paintStrategyFac);
			    }
			}
			
		});		
		btnMakeSwicher.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightpanel.add(btnMakeSwicher);
		
		JButton btnSwitch = new JButton("        Switch        ");
		btnSwitch.setToolTipText("Click this button to switch the strategy of the switcher balls.");
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_modelCtrlAdapter.switchUpdateStrategy(_list1DL.getItemAt(_list1DL.getSelectedIndex()));
			}
		});
		btnSwitch.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightpanel.add(btnSwitch);
		
		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.setToolTipText("Click this button to remove all balls from screen.");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_modelCtrlAdapter.clearAllBalls();
			}
		});
		northPanel.add(btnClearAll);
		
		JPanel rightmostpanel = new JPanel();
		northPanel.add(rightmostpanel);
		rightmostpanel.setLayout(new BoxLayout(rightmostpanel, BoxLayout.Y_AXIS));
		
		paintStrategy = new JTextField();
		paintStrategy.setText("Ball");
		paintStrategy.setHorizontalAlignment(SwingConstants.LEFT);
		rightmostpanel.add(paintStrategy);
		paintStrategy.setColumns(10);
		TitledBorder title2;
		title2 = BorderFactory.createTitledBorder("Paint Strategy");		
		paintStrategy.setBorder(title2);
		
		JButton btnAddPaint = new JButton("          Add         ");
		btnAddPaint.setToolTipText("Click this button to add a paint strategy.");
		btnAddPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    if (paintStrategy.getText() != null) {
			        TPaintDropListItem o = _modelCtrlAdapter.addPaintStrategy(paintStrategy.getText());
			        _list3DL.insertItemAt(o, 0);
			        _list3DL.setSelectedItem(o);
			    }
			}
		});
		btnAddPaint.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAddPaint.setHorizontalAlignment(SwingConstants.LEFT);
		rightmostpanel.add(btnAddPaint);
		
		_list3DL = new JComboBox<>();
		rightmostpanel.add(_list3DL);
		

		centerPanel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				
				super.paintComponent(g); // Do everything normally done first, e.g. clear the screen.
					_modelUpdateAdapter.updatePaint(g);
				
			}
		};

		centerPanel.setBackground(Color.yellow);
		contentPane.add(centerPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Start the GUI
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Updates the view by repainting the canvas
	 */
	public void updatePaint() {
		centerPanel.repaint();
	}
	
	/**
	 * get the painting panel 
	 * @return the painting panel
	 */
	public JPanel getCenterPanel() {
		return centerPanel;
	}
}
