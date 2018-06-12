package UI.Graphical.Buttons.Actions;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.NextTurnListener;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NextTurnButton extends IconsBaseButton implements Constants{
    static private BufferedImage nextTurnButtonImage = null;

    public static BufferedImage getNextTurnButtonImage() { return nextTurnButtonImage; }

    static {
        try {
            nextTurnButtonImage = ImageIO.read(Resources.getResourceFile("Icons/NextTurnIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public NextTurnButton(ObservableGame game) {
        this.game = game;
        super.setToolTipText("Next Turn");
        addActionListener(new NextTurnListener(game));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getNextTurnButtonImage(), 0,0, this);
    }
}
