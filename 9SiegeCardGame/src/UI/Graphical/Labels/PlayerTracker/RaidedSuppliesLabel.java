package UI.Graphical.Labels.PlayerTracker;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RaidedSuppliesLabel extends JLabel implements Constants {
    ObservableGame game;
    int amount;

    static private BufferedImage emptyRaidedSuppliesImage = null, raidedSuppliesImage = null;

    public static BufferedImage getEmptyRaidedSuppliesImage() { return emptyRaidedSuppliesImage; }
    public static BufferedImage getRaidedSuppliesImage() { return raidedSuppliesImage; }

    static {
        try {
            emptyRaidedSuppliesImage = ImageIO.read(Resources.getResourceFile("Icons/DisableSupplyRaidIcon.jpg"));
            raidedSuppliesImage = ImageIO.read(Resources.getResourceFile("Icons/SupplyRaidIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Trebuchet Label Images");
        }
    }

    public RaidedSuppliesLabel(ObservableGame game, int amount) {
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
        if (amount <= game.getRaidedSupplies()){
            g.drawImage(getRaidedSuppliesImage(),0,0,this);
        } else {
            g.drawImage(getEmptyRaidedSuppliesImage(),0,0,this);
        }
    }
}
