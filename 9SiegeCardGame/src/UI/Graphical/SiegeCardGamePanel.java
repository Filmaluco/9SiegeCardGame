package UI.Graphical;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Buttons.Listeners.NextTurnListener;
import UI.Graphical.Buttons.Listeners.PlayMenuListener;
import UI.Graphical.Buttons.NextTurnButton;
import UI.Graphical.Constants;
import UI.Graphical.Containers.EnemyTrackDisplay;
import UI.Graphical.Containers.MenuDisplay;
import UI.Graphical.Containers.PlayerInfoDisplay;
import UI.Graphical.Containers.SuppliesDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class SiegeCardGamePanel extends JPanel implements Observer, Constants {

    static private BufferedImage mainBackgroundImage = null;

    public static BufferedImage getMainBackgroundImage() { return mainBackgroundImage; }

    static {
        try {
            mainBackgroundImage = ImageIO.read(Resources.getResourceFile("Background/Background.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    private ObservableGame game;

    private PlayerInfoDisplay playerInfoDisplay;
    private SuppliesDisplay suppliesDisplay;
    private EnemyTrackDisplay enemyTrackDisplay;

    private NextTurnButton nextTurnButton;

    public SiegeCardGamePanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setupComponents();
        setupLayout();

        update(game, null);
    }



    private void setupComponents() {
        playerInfoDisplay = new PlayerInfoDisplay(game);
        suppliesDisplay = new SuppliesDisplay(game);
        enemyTrackDisplay = new EnemyTrackDisplay(game);

        nextTurnButton = new NextTurnButton();
        nextTurnButton.addActionListener(new NextTurnListener(game));
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        //Top
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.gridwidth = 8;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(playerInfoDisplay, gbc);

        //Display Section
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        add(suppliesDisplay, gbc);

        //Enemy tracker //TODO: CardLayout switch with tunel
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 3;
        add(enemyTrackDisplay, gbc);

        //TODO:Menu section


        //TODO:Card section

        //Next Turn
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 7;
        gbc.gridy = 1;
        add(nextTurnButton, gbc);

    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getMainBackgroundImage(), 0,0, DIM_X_FRAME, DIM_Y_FRAME, this);
    }
}
