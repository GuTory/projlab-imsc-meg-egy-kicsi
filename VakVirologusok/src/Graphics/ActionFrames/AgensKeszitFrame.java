package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;
import agens.Kod;
import felszereles.Felszereles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;

public class AgensKeszitFrame extends ActionFrame {
    JComboBox<Kod> tanultKodok;

    /**
     * AgensKeszitFrame konstruktora, itt lehet kiválasztani miből szeretne
     * a játékos ágenst készíteni, majd OK gombbal elfogadni.
     * @param f az ős JátékFrame ablak
     */
    public AgensKeszitFrame(JatekFrame f){
        super(f, "Ágens készítés");
        OKButton.addActionListener(this);

        Vector<Kod> kodok = new Vector<>(aktiv.getKodok());

        JLabel label = new JLabel("Milyen ágenst készítesz?");
        tanultKodok = new JComboBox<>(kodok);
        contentPane.add(label);
        contentPane.add(tanultKodok);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tanultKodok,0,SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, label,15,SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, tanultKodok,10,SpringLayout.SOUTH, label);

        layout.putConstraint(SpringLayout.NORTH, OKButton,15,SpringLayout.SOUTH, tanultKodok);
        layout.putConstraint(SpringLayout.EAST, OKButton,-15,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, OKButton,15,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,15,SpringLayout.SOUTH, OKButton);

        setResizable(true);
        pack();
    }

    /**
     * Ha megnyomta az OK gombot meghívja az KeszitCallback-et a kiválasztott kóddal amiből ágens lesz.
     * @param e az event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(tanultKodok.getSelectedItem() == null) {
            dispose();
            return;
        }
        boolean siker = Controller.GetInstance().KeszitCallback((Kod)tanultKodok.getSelectedItem());
        if(siker){
            ActionFrame message = new SikerFrame(szulo, "Sikeres ágens készítés.");
        }else{
            ActionFrame message = new SikerFrame(szulo, "Sikertelen ágens készítés.");
        }
        dispose();
    }

}
