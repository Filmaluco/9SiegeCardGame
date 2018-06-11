package UI.Graphical.Buttons;

import Assets.Resources;
import UI.Graphical.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NextTurnButton extends JButton implements Constants{
    static private BufferedImage nextTurnButtonImage = null;

    public static BufferedImage getNextTurnButtonImage() { return nextTurnButtonImage; }

    static {
        try {
            nextTurnButtonImage = ImageIO.read(Resources.getResourceFile("Icons/NextTurnIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    public NextTurnButton() {
        super.setToolTipText("Next Turn");
        Dimension d = new Dimension(DIM_X_ICONS,DIM_Y_ICONS);
        super.setMinimumSize(d);
        super.setPreferredSize(d);
        super.setMaximumSize(d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getNextTurnButtonImage(), 0,0, this);
    }
}
