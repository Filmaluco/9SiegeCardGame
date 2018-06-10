package UI.Graphical;

import Assets.Resources;
import Controllers.ObservableGame;
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

public class SiegeCardPanel extends JPanel implements Observer, Constants {

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

    private MenuDisplay menuDisplay;
    private PlayerInfoDisplay playerInfoDisplay;
    private SuppliesDisplay suppliesDisplay;
    private EnemyTrackDisplay enemyTrackDisplay;

    public SiegeCardPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setupComponents();
        setupLayout();

        update(game, null);
    }



    private void setupComponents() {
        menuDisplay = new MenuDisplay(game);

        playerInfoDisplay = new PlayerInfoDisplay(game);
        suppliesDisplay = new SuppliesDisplay(game);
        enemyTrackDisplay = new EnemyTrackDisplay(game);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        add(menuDisplay, BorderLayout.CENTER);
        //add(enemyTrackDisplay, BorderLayout.CENTER);
        add(playerInfoDisplay, BorderLayout.PAGE_START);
        add(suppliesDisplay, BorderLayout.WEST);
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
