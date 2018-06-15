package UI.Graphical.Buttons.Actions.TunnelMovement;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.Actions.TunnelListeners.MoveIntoTunnelListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TunnelMovementButton extends IconsBaseButton {
    static private BufferedImage tunelToEnemyMovementButtonImage = null, tunelToCastleMovementButtonImage = null, disableTunelMovementButtonImage = null;

    public static BufferedImage getTunelToEnemyMovementButtonImage() { return tunelToEnemyMovementButtonImage; }
    public static BufferedImage getTunelToCastleMovementButtonImage() { return tunelToCastleMovementButtonImage; }
    public static BufferedImage getDisableTunelToEnemyMovementButtonImage() { return disableTunelMovementButtonImage; }

    static {
        try {
            tunelToEnemyMovementButtonImage = ImageIO.read(Resources.getResourceFile("Icons/LeaveTunneI_to_enemyIcon.jpg"));
            tunelToCastleMovementButtonImage = ImageIO.read(Resources.getResourceFile("Icons/LeaveTunneI_to_castleIcon.jpg"));
            disableTunelMovementButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableTunnelMovementIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public TunnelMovementButton(ObservableGame game) {
        this.game = game;
        addActionListener(new MoveIntoTunnelListener(game));
        setToolTipText("Tunnel Movement Action");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canMoveIntoTunnel() && game.getActionPoints()>0 && game.isOnCastle()) {
            g.drawImage(getTunelToEnemyMovementButtonImage(), 0,0, this);
            setEnabled(true);
        } else if (game.canMoveIntoTunnel() && game.getActionPoints()>0 && game.isOnEnemyLines()) {
            g.drawImage(getTunelToCastleMovementButtonImage(), 0,0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableTunelToEnemyMovementButtonImage(),0,0,this);
            setEnabled(false);
        }
    }
}
