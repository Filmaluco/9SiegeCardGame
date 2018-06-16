package UI.Graphical.DialogBox;

import UI.Graphical.Util.Constants;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;

public class DialogBoxText extends JLabel implements Miscellaneous{
    String text;

    public DialogBoxText(String text) {
        this.text = text;
        setMinimumSize(new Dimension(100,100));
        setFont(DIALOG_BOX_FONT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(text, 0, 0);
    }
}
