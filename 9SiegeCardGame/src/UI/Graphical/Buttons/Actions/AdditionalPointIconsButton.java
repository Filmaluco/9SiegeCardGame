package UI.Graphical.Buttons.Actions;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Buttons.IconsBaseButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AdditionalPointIconsButton extends IconsBaseButton {
    static private BufferedImage additionalPointActionButtonImage = null, disableAdditionalPointActionButtonImage = null;

    public static BufferedImage getAdditionalPointActionButtonImage() { return additionalPointActionButtonImage; }
    public static BufferedImage getDisableAdditionalPointActionButtonImage() { return disableAdditionalPointActionButtonImage; }

    static {
        try {
            additionalPointActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/AdditionalIcon.jpg"));
            disableAdditionalPointActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableAdditionalIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public AdditionalPointIconsButton(ObservableGame game) {
        this.game = game;
        setToolTipText("Get Additional Point Action");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canGetAdicionalPoint() && game.getActionPoints()>0) {
            g.drawImage(getAdditionalPointActionButtonImage(), 0,0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableAdditionalPointActionButtonImage(),0,0,this);
            setEnabled(false);
        }
    }
}
