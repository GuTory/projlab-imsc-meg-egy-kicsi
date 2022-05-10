package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;

import java.awt.event.ActionEvent;

public class TamadFrame extends ActionFrame{

    public TamadFrame(JatekFrame f){
        super(f, "Támadás");
        OKButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Controller.GetInstance().TamadCallback(KIT);
        Publisher.getInstance().updateAction();
        setVisible(false);
    }

}
