package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;
import terkep.Mezo;
import virologus.Virologus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

public class TamadFrame extends ActionFrame{
    private JComboBox<Virologus> virologusok;

    public TamadFrame(JatekFrame f){
        super(f, "Támadás");
        OKButton.addActionListener(this);

        Vector<Virologus> vir = new Vector<>(aktiv.getHely().getVirologusok());
        vir.remove(aktiv);

        JLabel label = new JLabel("Kit támadsz meg?");
        virologusok = new JComboBox<>(vir);
        contentPane.add(label);
        contentPane.add(virologusok);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, virologusok,0,SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, label,15,SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.NORTH, virologusok,10,SpringLayout.SOUTH, label);

        layout.putConstraint(SpringLayout.NORTH, OKButton,15,SpringLayout.SOUTH, virologusok);
        layout.putConstraint(SpringLayout.EAST, OKButton,-15,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, OKButton,15,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,15,SpringLayout.SOUTH, OKButton);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(virologusok.getSelectedItem() == null) {
            dispose();
            return;
        }
        boolean siker = Controller.GetInstance().TamadCallback((Virologus)virologusok.getSelectedItem());
        if(siker){
            ActionFrame message = new SikerFrame(szulo, "Sikeres támadás.");
        }else{
            ActionFrame message = new SikerFrame(szulo, "Sikertelen támadás.");
        }
        Publisher.getInstance().updateAction();
        dispose();
    }

}
