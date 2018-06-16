package UI.Graphical.MenuBar;

import Controllers.ObservableGame;
import Controllers.states.GameSetup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import static UI.Graphical.Util.Miscellaneous.MENU_GAME;

public class MainMenuBar extends JMenuBar implements Observer {
    private JMenu gameMenu;
    private SaveGameOption saveGameOption;
    private LoadGameOption loadGameOption;
    private ExitGameOption exitGameOption;

    private ObservableGame game;
    private Container c;

    public MainMenuBar(ObservableGame game, Container c) {
        super();
        this.game = game;
        this.game.addObserver(this);
        this.c = c;
        setupComponents();
        layoutComponents();
    }

    private void setupComponents() {
        gameMenu = new JMenu(MENU_GAME);
        gameMenu.setMnemonic(KeyEvent.VK_G);

        saveGameOption = new SaveGameOption(c,game);
        loadGameOption = new LoadGameOption(c,game);
        exitGameOption = new ExitGameOption();
    }

    private void layoutComponents() {
        setVisible(false);
        gameMenu.add(saveGameOption);
        gameMenu.add(loadGameOption);
        gameMenu.add(exitGameOption);
        add(gameMenu);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (game.getState() instanceof GameSetup){
            setVisible(false);
        }else{
            setVisible(true);
        }
    }
}
