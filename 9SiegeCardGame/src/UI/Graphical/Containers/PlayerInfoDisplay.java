package UI.Graphical.Containers;

import Assets.Resources;
import Controllers.ObservableGame;
import Controllers.states.CardPhase;
import Controllers.states.GameSetup;
import UI.Graphical.Constants;
import UI.Graphical.Labels.PlayerInfoLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class PlayerInfoDisplay extends JPanel implements Observer, Constants{

    static private BufferedImage navBarImage = null;

    public static BufferedImage getNavBarImage() { return navBarImage; }

    static {
        try {
            navBarImage = ImageIO.read(Resources.getResourceFile("Buttons/NavBar.png"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;
    PlayerInfoLabel playerInfo;

    public PlayerInfoDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(DIM_X_PLAYERINFO, DIM_Y_PLAYERINFO);
        setSize(d);
        setMinimumSize(d);
        setMaximumSize(d);


        playerInfo = new PlayerInfoLabel(this.game);
        add(playerInfo, BorderLayout.CENTER);

        setOpaque(false);

        this.setVisible(!(game.getState() instanceof GameSetup));
    }

    @Override
    public void update(Observable o, Object arg) {
        //Aparece em todos os estados menos no GameSetup
        playerInfo.setInfo(game.getPlayerName(), game.getActionPoints(), game.getCurrentDay(), game.getCurrentTurn());
        setVisible(!(game.getState() instanceof GameSetup));
        if (game.getState() instanceof CardPhase){
            game.StartTurn();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getNavBarImage(), 0,0, DIM_X_PLAYERINFO, DIM_Y_PLAYERINFO, this);
    }
}
