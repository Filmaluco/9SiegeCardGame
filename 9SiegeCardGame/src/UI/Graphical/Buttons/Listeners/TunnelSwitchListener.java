package UI.Graphical.Buttons.Listeners;

import UI.Graphical.Util.Miscellaneous;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TunnelSwitchListener implements ActionListener, Miscellaneous {
    CardLayout cardLayout1, cardLayout2;
    Container container1, container2;

    public TunnelSwitchListener(CardLayout cardLayout1, CardLayout cardLayout2, Container container1, Container container2) {
        this.cardLayout1 = cardLayout1;
        this.cardLayout2 = cardLayout2;
        this.container1 = container1;
        this.container2 = container2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cardLayout1.show(container1, TUNNEL_TRACKER);
        cardLayout2.show(container2, TUNNEL_TRACKER);
    }
}
