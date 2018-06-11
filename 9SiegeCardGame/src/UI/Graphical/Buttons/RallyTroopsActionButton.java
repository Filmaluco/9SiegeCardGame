package UI.Graphical.Buttons;

import Assets.Resources;
import Controllers.ObservableGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RallyTroopsActionButton extends ActionBaseButton {
    static private BufferedImage rallyTroopsActionButtonImage = null, disableRallyTroopsActionButtonImage = null;

    public static BufferedImage getRallyTroopsActionButtonImage() { return rallyTroopsActionButtonImage; }
    public static BufferedImage getDisableRallyTroopsActionButtonImage() { return disableRallyTroopsActionButtonImage; }

    static {
        try {
            rallyTroopsActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/RallyTroopsIcon.jpg"));
            disableRallyTroopsActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableRallyTroopsIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public RallyTroopsActionButton(ObservableGame game) {
        this.game = game;
        setToolTipText("Rally Troops Action");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canRallyTroops() && game.getActionPoints()>0) {
            g.drawImage(getRallyTroopsActionButtonImage(), 0,0, this);
        } else {
            g.drawImage(getDisableRallyTroopsActionButtonImage(),0,0,this);
        }
    }
}
