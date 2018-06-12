package UI.Graphical;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Buttons.Actions.NextTurnButton;
import UI.Graphical.Containers.*;
import UI.Graphical.Util.Constants;

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
    private ActionsDisplay actionsDisplay;
    private DeckDisplay deckDisplay;

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
        actionsDisplay = new ActionsDisplay(game);
        deckDisplay = new DeckDisplay(game);

        nextTurnButton = new NextTurnButton(game);
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

        //Status Display Section
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        gbc.weighty = 1;
        add(suppliesDisplay, gbc);

        //Enemy tracker //TODO: CardLayout switch with tunel
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.7;
        gbc.weighty = 0.7;
        gbc.gridwidth = 7;

        add(enemyTrackDisplay, gbc);

        //TODO:Menu section
        gbc = new GridBagConstraints();
        //gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 7;
        add(actionsDisplay, gbc);

        //TODO:Card section
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        add(deckDisplay, gbc);

        //Next Turn
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 2;
        gbc.gridy = 3;
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
