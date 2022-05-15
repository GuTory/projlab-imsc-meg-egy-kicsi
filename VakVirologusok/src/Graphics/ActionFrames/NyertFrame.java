package Graphics.ActionFrames;

import Graphics.JatekFrame;
import virologus.Virologus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NyertFrame extends ActionFrame{

    /**
     * NyertFrame konstruktora.
     * Értesíti a játékosokat, hogy valaki nyert
     * @param f az ős JátékFrame ablak
     */
    public NyertFrame(JatekFrame f){
        super(f, "Győzelem");
        OKButton.addActionListener(this);

        String m = "Gratulálunk! " + aktiv.Nev + " nyert.";
        JLabel message = new JLabel(m);

        contentPane.add(message);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, message,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, message,15,SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.NORTH, OKButton,15,SpringLayout.SOUTH, message);
        layout.putConstraint(SpringLayout.EAST, OKButton,-15,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, OKButton,15,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,15,SpringLayout.SOUTH, OKButton);

        pack();
    }

    /**
     * Ha megnyomta az OK gombot kilép az alkalmazásból.
     * @param e az event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
