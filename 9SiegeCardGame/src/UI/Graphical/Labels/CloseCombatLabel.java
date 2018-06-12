package UI.Graphical.Labels;

import Assets.Resources;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CloseCombatLabel extends JLabel implements Constants{
    static private BufferedImage closeCombatImage = null;

    public static BufferedImage getCloseCombatImage() { return closeCombatImage; }

    static {
        try {
            closeCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/EmptyCloseCombatZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    public CloseCombatLabel() {
        Dimension d = new Dimension(DIM_X_CLOSE_COMBAT_LABEL,DIM_Y_CLOSE_COMBAT_LABEL);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
    }
}
