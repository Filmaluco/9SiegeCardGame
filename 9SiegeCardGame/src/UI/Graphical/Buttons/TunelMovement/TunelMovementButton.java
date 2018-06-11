package UI.Graphical.Buttons.TunelMovement;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Buttons.ActionBaseButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TunelMovementButton extends ActionBaseButton{
    static private BufferedImage tunelMovementButtonImage = null, disableTunelMovementButtonImage = null;

    public static BufferedImage getTunelMovementButtonImage() { return tunelMovementButtonImage; }
    public static BufferedImage getDisableTunelToEnemyMovementButtonImage() { return disableTunelMovementButtonImage; }

    static {
        try {
            tunelMovementButtonImage = ImageIO.read(Resources.getResourceFile("Icons/TunnelMovementIcon.jpg"));
            disableTunelMovementButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableTunnelMovementIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public TunelMovementButton(ObservableGame game) {
        this.game = game;
        setToolTipText("Tunnel Movement Action");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canUseTunnelMovemnt() && game.getActionPoints()>0) {
            g.drawImage(getTunelMovementButtonImage(), 0,0, this);
        } else {
            g.drawImage(getDisableTunelToEnemyMovementButtonImage(),0,0,this);
        }
    }
}
