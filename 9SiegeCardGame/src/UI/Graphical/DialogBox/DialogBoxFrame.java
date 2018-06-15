package UI.Graphical.DialogBox;

import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.awt.*;

public class DialogBoxFrame extends JFrame implements Constants{

    public DialogBoxFrame() throws HeadlessException {
        Dimension d = new Dimension(DIM_X_DIALOG_BOX,DIM_Y_DIALOG_BOX);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

    }
}
