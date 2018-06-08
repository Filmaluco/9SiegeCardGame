package UI.Graphical.Buttons;

import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton{

    public MenuButton(String text) {
        super(text);
        super.setPreferredSize(new Dimension(150,50));
        super.setBackground(Color.WHITE);
        super.setForeground(Color.ORANGE);
    }


}
