package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.GameSetup;
import UI.Graphical.Constants;
import UI.Graphical.Rectangles.MenuGUI;
import Assets.Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class MenuDisplay extends JPanel implements Observer, Constants{

    static private BufferedImage mainMenuBackgroundImage = null;

    public static BufferedImage getMainMenuBackgroundImage() { return mainMenuBackgroundImage; }

    static {
        try {
            mainMenuBackgroundImage = ImageIO.read(Resources.getResourceFile("Background/MainMenuBackground.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading Main Background Image");
        }
    }

    ObservableGame game;
    MenuGUI menu;

    public MenuDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setSize(new Dimension(DIM_X_FRAME, DIM_Y_FRAME));
        //this.setVisible(game.getState() instanceof GameSetup);
        setupComponents();
        layoutComponents();
    }

    private void setupComponents() {
        menu = new MenuGUI(game);
    }

    private void layoutComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(menu);
    }


    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof GameSetup);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getMainMenuBackgroundImage(), 0,0, DIM_X_FRAME,DIM_Y_FRAME,this);
    }
}
