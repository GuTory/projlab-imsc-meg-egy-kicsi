package Graphics.ActionFrames;

import Graphics.JatekFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SikerFrame extends ActionFrame{

    /**
     * SikerFrame konstruktoraértesít egy akció sikerességéről.
     * @param f az ős JátékFrame ablak
     * @param s a kiírandó szöveg
     */
    public SikerFrame(JatekFrame f, String s){
        super(f, "Siker");
        OKButton.addActionListener(this);

        JLabel message = new JLabel(s);
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
     * Ha megnyomta az OK gomboteltűnik az ablak.
     * @param e az event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

}
