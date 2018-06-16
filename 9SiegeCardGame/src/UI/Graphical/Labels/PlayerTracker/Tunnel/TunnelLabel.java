package UI.Graphical.Labels.PlayerTracker.Tunnel;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TunnelLabel extends JLabel implements Constants {

    static private BufferedImage tunnelImage = null, emptyTunnelImage = null;

    public static BufferedImage getTunnelImage() { return tunnelImage; }
    public static BufferedImage getEmptyTunnelImage() { return emptyTunnelImage; }

    static {
        try {
            tunnelImage = ImageIO.read(Resources.getResourceFile("Tracker/Tunnel.png"));
            emptyTunnelImage = ImageIO.read(Resources.getResourceFile("Tracker/EmptyTunnel.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;
    int id;

    public TunnelLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;

        Dimension d = new Dimension(DIM_X_TUNNEL_ICON, DIM_Y_TUNNEL_ICON);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getTunnelPosition() == id){
            g.drawImage(getTunnelImage(),0,0,this);
        }else{
            g.drawImage(getEmptyTunnelImage(),0,0,this);
        }
    }

}
