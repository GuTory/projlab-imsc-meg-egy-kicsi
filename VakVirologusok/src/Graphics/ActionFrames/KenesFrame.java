package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;
import agens.Agens;
import terkep.Mezo;
import virologus.Virologus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class KenesFrame extends ActionFrame{
    JComboBox<Virologus> kitTud;
    JComboBox<Agens> mivelTud;

    /**
     * KenesFrame konstruktora, itt lehet kiválasztani kit mivel szeretne
     * a játékos megkenni, majd OK gombbal elfogadni.
     * @param f az ős JátékFrame ablak
     */
    public KenesFrame(JatekFrame f){
        super(f, "Kenés");
        OKButton.addActionListener(this);


        Vector<Virologus> vir = new Vector<>(aktiv.getHely().getVirologusok());
        vir.remove(aktiv);

        JLabel labelKit = new JLabel("Kit kensz meg?");
        kitTud = new JComboBox<>(vir);
        contentPane.add(labelKit);
        contentPane.add(kitTud);

        List<Agens> a = aktiv.getTaska().getAgensek();
        Vector<Agens> agensek = new Vector<>();
        for(Agens agens : a){
            agensek.add(agens);
        }

        JLabel labelMivel = new JLabel("Mivel kened meg?");
        mivelTud = new JComboBox<>(agensek);
        contentPane.add(labelMivel);
        contentPane.add(mivelTud);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelKit,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, kitTud,0,SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, labelKit,15,SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, kitTud,10,SpringLayout.SOUTH, labelKit);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelMivel,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, mivelTud,0,SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, labelMivel,15,SpringLayout.SOUTH, kitTud);
        layout.putConstraint(SpringLayout.NORTH, mivelTud,10,SpringLayout.SOUTH, labelMivel);

        layout.putConstraint(SpringLayout.NORTH, OKButton,15,SpringLayout.SOUTH, mivelTud);
        layout.putConstraint(SpringLayout.EAST, OKButton,-15,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, OKButton,15,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,15,SpringLayout.SOUTH, OKButton);

        setResizable(true);
        pack();
    }

    /**
     * Ha megnyomta az OK gombot meghívja az MegkenCallback-et a kiválasztott játékossal és ágenssel.
     * @param e az event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(kitTud.getSelectedItem() == null || mivelTud.getSelectedItem() == null) {
            dispose();
            return;
        }
        boolean siker = Controller.GetInstance().MegkenCallback((Virologus)kitTud.getSelectedItem(), (Agens)mivelTud.getSelectedItem());
        if(siker){
            ActionFrame message = new SikerFrame(szulo, "Sikeres kenés.");
        }else{
            ActionFrame message = new SikerFrame(szulo, "Sikertelen kenés.");
        }

        Publisher.getInstance().updateAction();
        dispose();
    }

}
