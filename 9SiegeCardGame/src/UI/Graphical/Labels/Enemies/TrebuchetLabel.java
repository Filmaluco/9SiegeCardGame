package UI.Graphical.Labels.Enemies;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static UI.Graphical.Labels.CombatLabel.getCombatImage;

public class TrebuchetLabel extends JLabel implements Constants{
    ObservableGame game;
    int id;

    static private BufferedImage emptyTrebuchetImage = null, trebuchetImage = null;

    public static BufferedImage getEmptyTrebuchetImage() { return emptyTrebuchetImage; }
    public static BufferedImage getTrebuchetImage() { return trebuchetImage; }

    static {
        try {
            emptyTrebuchetImage = ImageIO.read(Resources.getResourceFile("Tracker/EmptyTrebuchetZone.png"));
            trebuchetImage = ImageIO.read(Resources.getResourceFile("Tracker/TrebuchetZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Trebuchet Label Images");
        }
    }

    public TrebuchetLabel(ObservableGame game, int id) {
        this.game = game;
        this.id = id;

        Dimension d = new Dimension(DIM_X_TREBUCHET_LABEL, DIM_Y_TREBUCHET_LABEL);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (id <= game.getTrebuchetCount()){
            g.drawImage(getTrebuchetImage(),0,0,this);
        } else {
            g.drawImage(getEmptyTrebuchetImage(),0,0,this);
        }

    }
}
