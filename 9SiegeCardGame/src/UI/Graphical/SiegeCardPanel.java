package UI.Graphical;

import Controllers.ObservableGame;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class SiegeCardPanel extends JPanel implements Observer {
    private ObservableGame game;

    public SiegeCardPanel(ObservableGame game) {
        this.game = game;

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
