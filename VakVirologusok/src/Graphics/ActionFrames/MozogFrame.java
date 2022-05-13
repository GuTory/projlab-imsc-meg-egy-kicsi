package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;
import terkep.Mezo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

public class MozogFrame extends ActionFrame {
    JComboBox<Mezo> szomszedok;

    public MozogFrame(JatekFrame f){
        super(f, "Mozgás");
        OKButton.addActionListener(this);

        Vector<Mezo> mezok = new Vector<>(aktiv.getHely().getSzomszedok());

        JLabel label = new JLabel("Melyik mezőre lépsz?");
        szomszedok = new JComboBox<>(mezok);
        contentPane.add(label);
        contentPane.add(szomszedok);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, szomszedok,0,SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, label,15,SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, szomszedok,10,SpringLayout.SOUTH, label);

        layout.putConstraint(SpringLayout.NORTH, OKButton,15,SpringLayout.SOUTH, szomszedok);
        layout.putConstraint(SpringLayout.EAST, OKButton,-15,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, OKButton,15,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,15,SpringLayout.SOUTH, OKButton);

        setResizable(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean siker = Controller.GetInstance().MozogCallback((Mezo)szomszedok.getSelectedItem());
        if(siker){
            ActionFrame message = new SikerFrame(szulo, "Sikeres lépés.");
        }else{
            ActionFrame message = new SikerFrame(szulo, "Sikertelen lépés.");
        }
        Publisher.getInstance().updateKovetkezo();
        dispose();
    }
}
