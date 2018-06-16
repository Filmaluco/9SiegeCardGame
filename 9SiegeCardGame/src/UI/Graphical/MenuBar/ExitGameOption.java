package UI.Graphical.MenuBar;

import Controllers.ObservableGame;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ExitGameOption extends JMenuItem implements ActionListener, Miscellaneous {

    public ExitGameOption() {
        super(MENU_EXIT);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { System.exit(0); }
}
