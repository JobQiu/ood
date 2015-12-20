package ls53_yh36.server.game.gmodel;

import java.awt.Color;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Stack;
import java.util.UUID;

import javax.swing.Timer;

import common.IChatUser;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.ShapeAttributes;
import gov.nasa.worldwind.render.SurfaceCircle;
import gov.nasa.worldwind.util.WWUtil;
import ls53_yh36.server.game.gmodel.message.ReportServer;
import map.MapLayer;

/**
 * The run model
 * @author ls53@rice.edu
 */
public class RunModel implements Serializable {

    /**
     * The generated serial version UID
     */
	private static final long serialVersionUID = 8788613805162366689L;

	/**
	 * RunModel to RunView Adapter
	 */
	private RunModelAdpt rmAdpt;
	
	/**
	 * Command to RunGame adapter
	 */
	private Cmd2RunGameAdpt cgAdpt;
	
	/**
	 * Timer used for timing and detection
	 */
	private int tickLen = 400;
	
	/**
	 * The timer
	 */
	private Timer timer = new Timer(tickLen, (e) -> rmAdpt.updateTime());
	
	/**
	 * Server stub used by game to send data back
	 */
	private IChatUser svrStub;
	
	/**
	 * ID used to identify the game
	 */
	private UUID gameID; 
	
	/**
	 * Player stub used for identification
	 */
	private IChatUser plyStub;
	
	/**
	 * Annotation layer for the map
	 */
	private MapLayer annoLayer = new MapLayer();
	
	/**
	 * Layer where shape can be dragged to move
	 */
	private RenderableLayer dragLayer = new RenderableLayer();
	
	/**
	 * Define the attributes of a shape
	 */
	private ShapeAttributes attrs;
	
	/**
	 * Hold a circle shape
	 */
	private SurfaceCircle shape;
	
	/**
	 * Start time of the game
	 */
	private long startT;
	
	/**
	 * End time of the game
	 */
	private long endT;
	
	/**
	 * Record the place information of the game
	 */
	private Stack<AnnoTag> plcs = new Stack<>();
	
	/**
	 * Make sure the game can only be played for one time
	 */
	private boolean played;
	
	/**
	 * Make sure only one copy of the target annotation to be added when found
	 */
	private boolean showed;
	
	/**
	 * Random generator: 0 ~ 1
	 */
	private Random rdm; 
	
	/**
	 * Constructor of the game
	 * @param adpt The adapter
	 */
	public RunModel(RunModelAdpt adpt) {
		rmAdpt = adpt;
		cgAdpt = new Cmd2RunGameAdpt() {

			private static final long serialVersionUID = -7823106041975338787L;

			@Override
			public void post(String msg) {
				RunModel.this.rmAdpt.stopBtn();
				RunModel.this.rmAdpt.showRank(msg);
			}
			
		};
		
		played = false;
		showed = false;
		
		rdm = new Random();
	}	
	
	/**
	 * Setter of the server stub
	 * @param stub Server's stub
	 */
	public void setSvrStub(IChatUser stub) {
		svrStub = stub;
	}
	
	/**
	 * Setter of player's IChatUser stub
	 * @param stub Player's IChatUser stub
	 */
	public void setPlyStub(IChatUser stub) {
		plyStub = stub;
	}
	
	/**
	 * Setter of game ID
	 * @param id ID of team
	 */
	public void setGameID(UUID id) {
		gameID = id;
	}
	
	/**
	 * Initialize the game model and load game data
	 */
	public void start() {
		load();
		rmAdpt.showLayer(annoLayer);
		rmAdpt.showLayer(dragLayer);
		rmAdpt.showInfo("INSTRUCTIONS:\nTo start the game, please click \"Play\" button at the bottom."
				+ "When the game has started, you will be guided to a search area. If you lose the"
				+ "search area, click \"Relocate\" button to go back. Try to find the radar which"
				+ "is a green pie. Drag the radar to find targets within the search area. When the"
				+ "target is found, an annotation is shown. Highlight the annotation and input the"
				+ "latitude and longitude shown on the annotation.");
	}
	
	/**
	 * Load annotation information to the stack
	 */
	private void load() {
		plcs.add(new AnnoTag(Position.fromDegrees(51.477, 0.0, 3000), 
				"End!", 
				"Congrulations!"));		
		plcs.add(new AnnoTag(Position.fromDegrees(32.281, 35.891, 6000000),
				"Artemis Temple",
				"Next position:\nlatitude: 51.477\nlongitude: 0.000"));
		plcs.add(new AnnoTag(Position.fromDegrees(29.650, 91.116, 6000000),
				"Lhasa",
				"Next position:\nlatitude: 32.281\nlongitude: 35.891"));
		plcs.add(new AnnoTag(Position.fromDegrees(36.451, 28.228, 6000000),
				"Colossus Rhodes",
				"Next position:\nlatitude: 29.650\nlongitude: 91.116"));
		plcs.add(new AnnoTag(Position.fromDegrees(36.100, -112.100, 6000000),
				"Grand Canyon",
				"Next position:\nlatitude: 36.451\nlongitude: 28.228"));
		plcs.add(new AnnoTag(Position.fromDegrees(30.114, 35.440, 6000000),
				"Ma'an Governorate",
				"Next position:\nlatitude: 36.100\nlongitude: -112.100"));
		plcs.add(new AnnoTag(Position.fromDegrees(-13.163, -72.545, 6000000),
				"Machu Picchu",
				"Next position:\nlatitude: 30.114\nlongitude: 35.440"));
		plcs.add(new AnnoTag(Position.fromDegrees(29.979, 31.134, 6000000),
				"Giza Pyramid",
				"Next position:\nlatitude: -13.163\nlongitude: -72.545"));
		plcs.add(new AnnoTag(Position.fromDegrees(-21.773, -46.569, 6000000),
				"Christ Redeemer",
				"Next position:\nlatitude: 29.979\nlongitude: 31.134"));
		plcs.add(new AnnoTag(Position.fromDegrees(41.890, 12.492, 6000000),
				"Colosseum",
				"Next position:\nlatitude: -21.773\nlongitude: -46.569"));
		plcs.add(new AnnoTag(Position.fromDegrees(20.678, -88.568, 6000000),
				"Chichen Itza",
				"Next position:\nlatitude: 41.890\nlongitude: 12.492"));
		plcs.add(new AnnoTag(Position.fromDegrees(37.037, 27.424, 6000000),
				"Mausoleum at Halicarnassus Bodrum",
				"Next position:\nlatitude: 20.678\nlongitude: -88.568"));		
		plcs.add(new AnnoTag(Position.fromDegrees(27.175, 78.041, 6000000),
				"Taj Mahal", 
				"Next position:\nlatitude: 37.037\nlongitude: 27.424"));
		plcs.add(new AnnoTag(Position.fromDegrees(37.971, 23.726, 6000000),
				"Parthenon",
				"Next position:\nlatitude: 27.175\nlongitude: 78.041"));
		plcs.add(new AnnoTag(Position.fromDegrees(40.359, 116.020, 6000000),
				"Great Wall of Badaling", 
				"Next position:\nlatitude: 37.971\nlongitude: 23.726"));
		plcs.add(new AnnoTag(Position.fromDegrees(32.476, 44.431, 6000000),
				"Hanging Gardens of Babylon",
				"Next position:\nlatitude: 40.359\nlongitude: 116.020"));
		
		
		// Load the draggable shape to the dragLayer
		dragLayer.setName("Circle Shape");
		attrs = new BasicShapeAttributes();
        attrs.setInteriorMaterial(Material.GREEN);
        attrs.setOutlineMaterial(new Material(WWUtil.makeColorBrighter(Color.GREEN)));
        attrs.setInteriorOpacity(0.3);
        attrs.setOutlineOpacity(0.8);
        attrs.setOutlineWidth(3);        
        
        shape = new SurfaceCircle(LatLon.fromDegrees(30, 40), 0.5e6);
        shape.setAttributes(attrs);
        dragLayer.addRenderable(shape);

	}
	
	/**
	 * Start the game
	 */
	public void startGame() {
		if (played) return;
		played = true;
		timer.start();
		startT = System.currentTimeMillis();
		AnnoTag tmp = plcs.peek();
		tmp.pos.add(LatLon.fromDegrees((rdm.nextDouble() - 0.5) * 8, (rdm.nextDouble() - 0.5) * 8));
		rmAdpt.goPlace(tmp.pos);		
	}
	
	/**
	 * Check the input and move to the next position
	 * @param lat latitude
	 * @param lng longitude
	 * @return Return the status information
	 */
	public String goNextPlace(double lat, double lng) {
		if (!played)
			return "Please click \"Play\" button to start the game.\n";
		else if (plcs.isEmpty())
			return "You have finished your game.\n";
		else {
			AnnoTag tmp = plcs.peek();
			endT = System.currentTimeMillis();
			long min = (endT - startT) / 60000;
			long sec = (endT - startT - min * 60000) / 1000;
			if (tmp.pos.latitude.degrees != lat || tmp.pos.longitude.degrees != lng)
				return "Wrong input!--" + min + " min " + sec + " sec has passed.";
			else {
				annoLayer.removeAllAnnotations();
				showed = false;
				tmp = plcs.peek();
				tmp.pos.add(LatLon.fromDegrees((rdm.nextDouble() - 0.5) * 8, (rdm.nextDouble() - 0.5) * 8));
				rmAdpt.goPlace(tmp.pos);
				if (plcs.size() == 1) {
					tmp = plcs.pop();
					annoLayer.addToggleAnnotation(tmp.crntPlc, tmp.nxtPlc, tmp.pos);
					timer.stop();
					showed = true;
					rmAdpt.goPlace(tmp.pos);
					rmAdpt.stopBtn();
					try {
						svrStub.receive(plyStub, new ReportServer(gameID, endT - startT, plyStub).getDataPacket());
					} catch (RemoteException e) {
						System.err.println("Exception happened when sending back final result to the server.\n");
						e.printStackTrace();
					}
					return "Game is done. You used " + min + " min " + sec + " sec in this game.";
				}
				return min + " min " + sec + " sec has passed.";
			}
		}
	}
	
	/**
	 * Time is used up and send back information to server
	 */
	public void timeOver() {
		timer.stop();
		rmAdpt.stopBtn();
		try {
			svrStub.receive(plyStub, new ReportServer(gameID, Long.MAX_VALUE, plyStub).getDataPacket());
		} catch (RemoteException e) {
			System.err.println("Exception happened when throwing timeOut report: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Post information on the infoPanel
	 * @param info The information
	 */
	public void Show(String info) {
		rmAdpt.showInfo(info);
	}
	
	/**
	 * Get the adapter to the game model
	 * @return Return the Command to Game Model Adapter
	 */
	public Cmd2RunGameAdpt getCGAdpt() {
		return cgAdpt;
	}
	
	/**
	 * Respond to the timer's event
	 */
	public void update() {
		detect();
	}
	
	/**
	 * Test whether the target within the radar
	 */
	private void detect() {
		if (!showed) {
			AnnoTag target = plcs.peek();
			LatLon diff = target.pos.subtract(shape.getCenter());
			if (Math.abs(diff.latitude.degrees) < 3.0 && Math.abs(diff.longitude.degrees) < 3.0) {
				annoLayer.addToggleAnnotation(target.crntPlc, target.nxtPlc, target.pos);
				plcs.pop();
				showed = true;
			}
		}
	}
	
	/**
	 * Helper inner class
	 * @author Yi
	 *
	 */
	private class AnnoTag implements Serializable {
		
		private static final long serialVersionUID = -6866030515236049645L;

		/**
		 * Position of the current place
		 */
		public Position pos;
		
		/**
		 * Description of the current place
		 */
		public String crntPlc;
		
		/**
		 * Information of next place
		 */
		public String nxtPlc;
		
		public AnnoTag(Position p, String cp, String np) {
			pos = p;
			crntPlc = cp;
			nxtPlc = np;
		}
	}
}
