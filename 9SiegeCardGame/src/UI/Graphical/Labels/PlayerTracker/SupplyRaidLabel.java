package UI.Graphical.Labels.PlayerTracker;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SupplyRaidLabel extends JLabel implements Constants {
    ObservableGame game;
    int amount;

    static private BufferedImage emptyRaidSupplyImage = null, raidSupplyImage = null;

    public static BufferedImage getRaidSupplyImage() { return raidSupplyImage; }
    public static BufferedImage getEmptyRaidSupplyImage() { return emptyRaidSupplyImage; }

    static {
        try {
            raidSupplyImage = ImageIO.read(Resources.getResourceFile("Icons/SupplyRaidIcon.jpg"));
            emptyRaidSupplyImage = ImageIO.read(Resources.getResourceFile("Icons/DisableSupplyRaidIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Trebuchet Label Images");
        }
    }

    public SupplyRaidLabel(ObservableGame game, int amount) {
        this.game = game;
        this.amount = amount;

        Dimension d = new Dimension(DIM_X_ICONS, DIM_Y_ICONS);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (amount <= game.getTrebuchetCount()){
            g.drawImage(getRaidSupplyImage(),0,0,this);
        } else {
            g.drawImage(getEmptyRaidSupplyImage(),0,0,this);
        }

    }
}
