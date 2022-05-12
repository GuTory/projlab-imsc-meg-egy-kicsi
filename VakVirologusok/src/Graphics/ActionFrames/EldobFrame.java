package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;
import felszereles.Felszereles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;

public class EldobFrame extends ActionFrame {
    JComboBox<Felszereles> felszerelesek;

    public EldobFrame(JatekFrame f){
        super(f, "Eldobás");
        OKButton.addActionListener(this);

        List<Felszereles> fe = aktiv.getTaska().getFelszerelesek();
        Vector<Felszereles> felsz = new Vector<>();
        for(Felszereles mezo : fe){
            felsz.add(mezo);
        }

        JLabel label = new JLabel("Mit dobsz el?");
        felszerelesek = new JComboBox<>(felsz);
        contentPane.add(label);
        contentPane.add(felszerelesek);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, felszerelesek,0,SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, label,15,SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, felszerelesek,10,SpringLayout.SOUTH, label);

        layout.putConstraint(SpringLayout.NORTH, OKButton,15,SpringLayout.SOUTH, felszerelesek);
        layout.putConstraint(SpringLayout.EAST, OKButton,-15,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, OKButton,15,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,15,SpringLayout.SOUTH, OKButton);

        setResizable(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Controller.GetInstance().EldobCallback((Felszereles)felszerelesek.getSelectedItem());
        dispose();
    }

}
