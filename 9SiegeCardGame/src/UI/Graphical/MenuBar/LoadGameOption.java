package UI.Graphical.MenuBar;

import Controllers.GameController;
import Controllers.ObservableGame;
import Controllers.SavesController;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class LoadGameOption extends JMenuItem implements ActionListener ,Miscellaneous {
    ObservableGame game;
    Container c;

    public LoadGameOption(Container c, ObservableGame game) {
        super(MENU_LOAD_GAME);
        this.game = game;
        this.c = c;

        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser("./data");
        int returnVal = fc.showOpenDialog(c);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try{
                game.setGameController((GameController) SavesController.loadGameFromFile(file));
            }catch(IOException | ClassNotFoundException ex){
                JOptionPane.showMessageDialog(c, "Operation failed: \r\n\r\n" + e);
            }

        } else {
            System.out.println("Operation canceled ");
        }
    }
}
