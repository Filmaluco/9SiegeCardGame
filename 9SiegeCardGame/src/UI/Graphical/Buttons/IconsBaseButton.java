package UI.Graphical.Buttons;

import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.awt.*;

public class IconsBaseButton extends JButton implements Constants {

    public IconsBaseButton() {
        Dimension d = new Dimension(DIM_X_ICONS,DIM_Y_ICONS);
        super.setMinimumSize(d);
        super.setPreferredSize(d);
        super.setMaximumSize(d);
        super.setOpaque(false);
    }

}
