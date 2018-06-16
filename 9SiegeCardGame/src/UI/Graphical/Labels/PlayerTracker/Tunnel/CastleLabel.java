package UI.Graphical.Labels.PlayerTracker.Tunnel;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CastleLabel extends JLabel implements Constants {

    static private BufferedImage castleImage = null, emptyCastleImage = null;

    public static BufferedImage getCastleImage() { return castleImage; }
    public static BufferedImage getEmptyCastleImage() { return emptyCastleImage; }

    static {
        try {
            castleImage = ImageIO.read(Resources.getResourceFile("Tracker/Castle.png"));
            emptyCastleImage = ImageIO.read(Resources.getResourceFile("Tracker/EmptyCastle.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public CastleLabel(ObservableGame game) {
        this.game = game;

        Dimension d = new Dimension(DIM_X_TUNNEL_ICON, DIM_Y_TUNNEL_ICON);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.isOnCastle()){
            g.drawImage(getCastleImage(),0,0,this);
        }else{
            g.drawImage(getEmptyCastleImage(),0,0,this);
        }
    }

}
