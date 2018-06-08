package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.GameSetup;
import UI.Graphical.Buttons.Listeners.PlayMenuListener;
import UI.Graphical.Buttons.MenuButton;
import UI.Graphical.Constants;
import UI.Graphical.Rectangles.MenuGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MenuDisplay extends JPanel implements Observer, Constants{
    ObservableGame game;
    MenuGUI menu;
    Container cp;

    public MenuDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setSize(new Dimension(DIM_X_FRAME, DIM_Y_FRAME));

        setupComponents();
        layoutComponents();

        add(menu);

    }

    private void setupComponents() {
        menu = new MenuGUI(game);

    }

    private void layoutComponents() {

    }


    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof GameSetup);
    }
}
