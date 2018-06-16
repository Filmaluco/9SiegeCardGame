package UI.Graphical.Buttons.Actions;

import Assets.Resources;
import Controllers.ObservableGame;
import Controllers.states.ActionPhase;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.Actions.NextTurnListener;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NextTurnButton extends IconsBaseButton implements Constants{
    static private BufferedImage nextTurnButtonImage = null, disableNextTurnButtonImage;

    public static BufferedImage getNextTurnButtonImage() { return nextTurnButtonImage; }
    public static BufferedImage getDisableNextTurnButtonImage() { return disableNextTurnButtonImage; }

    static {
        try {
            nextTurnButtonImage = ImageIO.read(Resources.getResourceFile("Icons/NextTurnIcon.jpg"));
            disableNextTurnButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableNextTurnIcon.jpg"));
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
        if (game.getState()instanceof ActionPhase) {
            g.drawImage(getNextTurnButtonImage(), 0, 0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableNextTurnButtonImage(), 0, 0, this);
            setEnabled(false);
        }
    }

}
