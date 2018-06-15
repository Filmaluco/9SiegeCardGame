package UI.Graphical.Labels.PlayerTracker.Tunnel;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EnemyLabel extends JLabel implements Constants {

    static private BufferedImage enemyImage = null, emptyEnemyImage = null;

    public static BufferedImage getEnemyImage() { return enemyImage; }
    public static BufferedImage getEmptyEnemyImage() { return emptyEnemyImage; }

    static {
        try {
            enemyImage = ImageIO.read(Resources.getResourceFile("Tracker/EnemyTunnel.png"));
            emptyEnemyImage = ImageIO.read(Resources.getResourceFile("Tracker/EmptyEnemyTunnel.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public EnemyLabel(ObservableGame game) {
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
        if (game.isOnEnemyLines()){
            g.drawImage(getEnemyImage(),0,0,this);
        }else{
            g.drawImage(getEmptyEnemyImage(),0,0,this);
        }
    }


}
