package UI.Graphical.MenuBar;

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

public class SaveGameOption extends JMenuItem implements ActionListener,Miscellaneous {
    Container c;
    ObservableGame game;

    public SaveGameOption(Container c, ObservableGame game) {
        super(MENU_SAVE_GAME);
        this.game = game;
        this.c = c;

        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser("./data");
        int returnVal = fc.showSaveDialog(c);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try{
                SavesController.saveGameToFile(game.getGameController(), file);
            }catch(IOException ex){
                JOptionPane.showMessageDialog(c, "Operation failed: \r\n\r\n" + e);
            }
        } else {
            System.out.println("Operation canceled ");
        }
    }
}
