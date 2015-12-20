package ls53_yh36.server.game.smodel.command;

import java.util.UUID;

import javax.swing.SwingUtilities;

import common.IChatUser;
import common.ICmd2ModelAdapter;
import ls53_yh36.server.game.gmodel.Cmd2RunGameAdpt;
import ls53_yh36.server.game.smodel.message.StartGame;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.mixedData.MixedDataKey;

/**
 * The start game command
 * @author ls53@rice.edu
 */
public class StartGameCmd extends ADataPacketAlgoCmd<String, StartGame, IChatUser> {

    /**
     * The generated serial version UID
     */
	private static final long serialVersionUID = -2177811586536199119L;

	/**
	 * Command to chat model adapter
	 */
	private ICmd2ModelAdapter adpt;
	
	/**
	 * UUID used to put the Cmd2RunGameAdpt inside the mixedDictionary
	 */
	private UUID id;
	
	/**
	 * Constructor
	 * @param id UUID
	 */
	public StartGameCmd(UUID id) {
		this.id = id;
	}
	
	/**
     * The apply method
     * @param index The index
     * @param host The data packet
     * @param params The sender
     */
	@Override
	public String apply(Class<?> index, DataPacket<StartGame> host, IChatUser... params) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Cmd2RunGameAdpt cgAdpt = host.getData().getGameFac().makeGame();
				adpt.setMixedDataDictEntry(new MixedDataKey<Cmd2RunGameAdpt>(id, "Cmd2RunGameAdpt", Cmd2RunGameAdpt.class), cgAdpt);
			}
			
		});
		
		return "Game has been launched.\n";
	}

	/**
     * Set command to model adapter
     * @param cmd2ModelAdpt The command to model adapter to set
     */
	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		adpt = cmd2ModelAdpt;
	}
}
