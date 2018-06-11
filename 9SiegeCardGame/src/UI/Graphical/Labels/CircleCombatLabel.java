package UI.Graphical.Labels;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CircleCombatLabel extends JLabel implements Constants{
    ObservableGame game;

    static private BufferedImage circleCombatImage = null;

    public static BufferedImage getCircleCombatImage() { return circleCombatImage; }

    static {
        try {
            circleCombatImage = ImageIO.read(Resources.getResourceFile("Tracker/EmptyBoilZone.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    public CircleCombatLabel() {
        Dimension d = new Dimension(DIM_X_CIRCLE_COMBAT_LABEL,DIM_Y_CIRCLE_COMBAT_LABEL);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
    }
}
