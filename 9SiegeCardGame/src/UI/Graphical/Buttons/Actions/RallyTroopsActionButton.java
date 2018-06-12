package UI.Graphical.Buttons.Actions;

import Assets.Resources;
import Controllers.ObservableGame;
import Controllers.states.ActionArchersAttack;
import Controllers.states.ActionPhase;
import Controllers.states.ActionRallyTroops;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.ActionRallyTroopsListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import static UI.Graphical.Util.Miscellaneous.RALLY_TROOPS_ACTION;

public class RallyTroopsActionButton extends IconsBaseButton implements Observer{
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
        addActionListener(new ActionRallyTroopsListener(game));
        setToolTipText(RALLY_TROOPS_ACTION);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canRallyTroops() && game.getActionPoints()>0) {
            g.drawImage(getRallyTroopsActionButtonImage(), 0,0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableRallyTroopsActionButtonImage(),0,0,this);
            setEnabled(false);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof ActionPhase || game.getState()instanceof ActionRallyTroops);
    }
}
