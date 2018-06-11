package UI.Graphical.Buttons;

import Assets.Resources;
import Controllers.ObservableGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SabotageActionIconButton extends ActionBaseButton{
    static private BufferedImage sabotageActionButtonImage = null, disableSabotageActionButtonImage = null;

    public static BufferedImage getSabotageActionButtonImage() { return sabotageActionButtonImage; }
    public static BufferedImage getDisableSabotageActionButtonImage() { return disableSabotageActionButtonImage; }

    static {
        try {
            sabotageActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/SabotageIcon.jpg"));
            disableSabotageActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableSabotageIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public SabotageActionIconButton(ObservableGame game) {
        this.game = game;
        setToolTipText("Sabotage Action");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canSabotage() && game.getActionPoints()>0) {
            g.drawImage(getSabotageActionButtonImage(), 0,0, this);
        } else {
            g.drawImage(getDisableSabotageActionButtonImage(),0,0,this);
        }
    }
}
