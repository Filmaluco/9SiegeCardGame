package UI.Graphical.Buttons;

import Assets.Resources;
import Controllers.ObservableGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CoupureActionButton extends ActionBaseButton {
    static private BufferedImage coupureActionButtonImage = null, disableCoupureActionButtonImage = null;

    public static BufferedImage getCoupureActionButtonImage() { return coupureActionButtonImage; }
    public static BufferedImage getDisableCoupureActionAttackButtonImage() { return disableCoupureActionButtonImage; }

    static {
        try {
            coupureActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/CoupureIcon.jpg"));
            disableCoupureActionButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableCoupureIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public CoupureActionButton(ObservableGame game) {
        this.game = game;
        setToolTipText("Coupure Action");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canCoupure() && game.getActionPoints()>0) {
            g.drawImage(getCoupureActionButtonImage(), 0,0, this);
        } else {
            g.drawImage(getDisableCoupureActionAttackButtonImage(),0,0,this);
        }
    }
}
