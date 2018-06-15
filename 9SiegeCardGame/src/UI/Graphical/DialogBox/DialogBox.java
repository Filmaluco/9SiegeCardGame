package UI.Graphical.DialogBox;

import Assets.Resources;
import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DialogBox extends JDialog implements Constants{

    ObservableGame game;
    DialogBoxBackground dialogBoxBackground;
    DialogBoxButton button1;
    DialogBoxButton button2;
    DialogBoxText backgroundText;


    public DialogBox(Frame parent,ObservableGame game, String backgroundText,String text1, String text2) {
        super(parent);
        setLocationRelativeTo(null);
        this.game = game;

        Dimension d = new Dimension(DIM_X_DIALOG_BOX,DIM_Y_DIALOG_BOX);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setupComponents(backgroundText,text1, text2);
        layoutComponents();

        setModalityType(ModalityType.APPLICATION_MODAL);

        //setTitle("About Notes");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    private void setupComponents(String backgroundText,String text1, String text2) {
        dialogBoxBackground = new DialogBoxBackground();
        this.backgroundText = new DialogBoxText(backgroundText);
        button1 = new DialogBoxButton(text1);
        button2 = new DialogBoxButton(text2);
    }

    private void layoutComponents() {
        dialogBoxBackground.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        dialogBoxBackground.add(backgroundText,gbc);
        gbc.gridy = 2;
        dialogBoxBackground.add(button1,gbc);
        gbc.gridx = 1;
        dialogBoxBackground.add(button2,gbc);
        add(dialogBoxBackground);

    }

}
