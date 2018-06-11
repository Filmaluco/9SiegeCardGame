package UI.Graphical.Labels;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CombatLabel extends JLabel implements Constants{
    static private BufferedImage combatImage = null;

    public static BufferedImage getCombatImage() { return combatImage; }

    static {
        try {
            combatImage = ImageIO.read(Resources.getResourceFile("Tracker/EmptyNormalAttackZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    public CombatLabel() {
        Dimension d = new Dimension(DIM_X_COMBAT_LABEL,DIM_Y_COMBAT_LABEL);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
    }
}
