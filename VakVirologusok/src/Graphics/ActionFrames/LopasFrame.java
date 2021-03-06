package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;
import agens.Agens;
import virologus.Virologus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LopasFrame extends ActionFrame{
    JComboBox<Virologus> kitolLop;
    JComboBox<String> mitLop;


    /**
     * LopasFrame konstruktora, itt lehet kiválasztani kitől, mit szeretne
     * a játékos ellopni, majd OK gombbal elfogadni.
     * @param f az ős JátékFrame ablak
     */
    public LopasFrame(JatekFrame f){
        super(f, "Lopás");
        OKButton.addActionListener(this);

        Vector<Virologus> vir = new Vector<>(aktiv.getHely().getVirologusok());
        vir.remove(aktiv);

        JLabel labelKit = new JLabel("Kitől lopsz és mit?");
        kitolLop = new JComboBox<>(vir);
        contentPane.add(labelKit);
        contentPane.add(kitolLop);

        Vector<String> mit = new Vector<>();
        mit.add("Felszerelés");
        mit.add("Ágens");
        mit.add("Anyag");

        JLabel labelMivel = new JLabel("Mit lopsz?");
        mitLop = new JComboBox<>(mit);
        contentPane.add(labelMivel);
        contentPane.add(mitLop);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelKit,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, kitolLop,0,SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, labelKit,15,SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, kitolLop,10,SpringLayout.SOUTH, labelKit);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelMivel,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, mitLop,0,SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, labelMivel,15,SpringLayout.SOUTH, kitolLop);
        layout.putConstraint(SpringLayout.NORTH, mitLop,10,SpringLayout.SOUTH, labelMivel);

        layout.putConstraint(SpringLayout.NORTH, OKButton,15,SpringLayout.SOUTH, mitLop);
        layout.putConstraint(SpringLayout.EAST, OKButton,-15,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, OKButton,15,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,15,SpringLayout.SOUTH, OKButton);

        setResizable(true);
        pack();
    }

    /**
     * Ha megnyomta az OK gombot meghívja a megfelelő lopás callback-jét
     * a kiválasztott ellopandó tárggal és virológussal.
     * @param e az event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(kitolLop.getSelectedItem() == null || mitLop.getSelectedItem() == null) {
            dispose();
            return;
        }
        Virologus kitol = (Virologus)kitolLop.getSelectedItem();
        boolean siker = false;
        switch((String)mitLop.getSelectedItem()){
            case "Agens":
                siker = Controller.GetInstance().LopAgenstCallback(kitol);
                break;
            case "Anyag":
                siker = Controller.GetInstance().LopAnyagotCallback(kitol);
                break;
            case "Felszereles":
                siker = Controller.GetInstance().LopFelszerelesCallback(kitol);
                break;
        }

        if(siker){
            ActionFrame message = new SikerFrame(szulo, "Sikeres lopás.");
        }else{
            ActionFrame message = new SikerFrame(szulo, "Sikertelen lopás.");
        }

        Publisher.getInstance().updateAction();
        dispose();
    }

}
