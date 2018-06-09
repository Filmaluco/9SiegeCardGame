package UI.Graphical.Buttons;

import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton{
    Dimension d;
    public MenuButton(String text) {
        super(text);
        d = new Dimension(150,50);
        super.setMinimumSize(d);
        super.setPreferredSize(d);
        super.setBackground(Color.WHITE);
        super.setForeground(Color.ORANGE);
    }


}
