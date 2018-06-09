package UI.Graphical.Labels;

import Controllers.ObservableGame;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoLabel extends JLabel {
    ObservableGame game;

    public PlayerInfoLabel(ObservableGame game) {
        this.game = game;

        setBackground(Color.BLACK);
    }
}
