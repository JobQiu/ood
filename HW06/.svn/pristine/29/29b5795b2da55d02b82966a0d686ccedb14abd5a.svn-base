package controller;

import java.awt.EventQueue;

import model.PlayerModel;
import provided.util.ABCInstrument;
import view.IModelCtrlAdapter;
import view.PlayerGui;

public class PlayerApp {
    
    private PlayerModel model;
    
    private PlayerGui<ABCInstrument> view;
    
    public PlayerApp() {
        model = new PlayerModel(instrument -> view.addInstrument(instrument));
        
        view = new PlayerGui<>(new IModelCtrlAdapter<ABCInstrument>() {

            @Override
            public String loadFile(String fileName) {
            	return model.loadFile(fileName);
            }

            @Override
            public String parseFile() {
                return model.parseFile();
            }

            @Override
            public void playMusic(ABCInstrument instrument) {
            	model.playMusic(instrument);
            }

            @Override
            public void stopMusic() {
            	model.stopMusic();
            }
        });
    }
    
    /**
     * Launch the player app.
     */
    public void start() {
        model.start();
        view.start();
    }
    
    /**
     * The main method of the player app.
     * @param args Useless arguments.
     */
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            try {
                PlayerApp app = new PlayerApp();
                app.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
