package chatroom.model;

import java.awt.Container;

import javax.swing.ImageIcon;

import chatroom.view.ImagePanel;
import common.ICmd2ModelAdapter;
import common.IUser;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;

public class ImageDataPacketAlgoCmd extends ADataPacketAlgoCmd<String, ImageIcon, IUser> {
    /**
     * 
     */
    private static final long serialVersionUID = -7098826673563143364L;
    
    private transient ICmd2ModelAdapter cmd2ModelAdapter;

    @Override
    public String apply(Class<?> index, DataPacket<ImageIcon> host, IUser... params) {
        Container container = cmd2ModelAdapter.updateable();
        ImageIcon imageIcon = host.getData();
        ImagePanel panel = new ImagePanel(imageIcon.getImage(), container);
        container.add(panel);
        return null;
    }

    @Override
    public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
        this.cmd2ModelAdapter = cmd2ModelAdpt;
    }
}
