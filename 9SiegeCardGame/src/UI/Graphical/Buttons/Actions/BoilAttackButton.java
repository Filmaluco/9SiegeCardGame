package UI.Graphical.Buttons.Actions;

import Assets.Resources;
import Controllers.ObservableGame;
import Controllers.states.ActionArchersAttack;
import Controllers.states.ActionBoilingAttack;
import Controllers.states.ActionPhase;
import UI.Graphical.Buttons.IconsBaseButton;
import UI.Graphical.Buttons.Listeners.ActionBoilAttackListener;
import UI.Graphical.Buttons.Listeners.NextTurnListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class BoilAttackButton extends IconsBaseButton {
    static private BufferedImage boilAttackButtonImage = null, disableBoilAttackButtonImage = null;

    public static BufferedImage getBoilAttackButtonImage() { return boilAttackButtonImage; }
    public static BufferedImage getDisableBoilAttackButtonImage() { return disableBoilAttackButtonImage; }

    static {
        try {
            boilAttackButtonImage = ImageIO.read(Resources.getResourceFile("Icons/BoillingAttackIcon.jpg"));
            disableBoilAttackButtonImage = ImageIO.read(Resources.getResourceFile("Icons/DisableBoillingAttackIcon.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;

    public BoilAttackButton(ObservableGame game) {
        this.game = game;
        addActionListener(new ActionBoilAttackListener(game));
        setToolTipText("Boil Attack");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.canBoilAttack() && game.getActionPoints()>0) {
            g.drawImage(getBoilAttackButtonImage(), 0,0, this);
            setEnabled(true);
        } else {
            g.drawImage(getDisableBoilAttackButtonImage(),0,0,this);
            setEnabled(false);
        }
    }
}
