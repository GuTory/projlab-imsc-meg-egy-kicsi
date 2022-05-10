package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;

import java.awt.event.ActionEvent;

public class AgensKeszitFrame extends ActionFrame {

    public AgensKeszitFrame(JatekFrame f){
        super(f, "Ágens készítés");
        OKButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Controller.GetInstance().KeszitCallback(KOD);
        setVisible(false);
    }

}
