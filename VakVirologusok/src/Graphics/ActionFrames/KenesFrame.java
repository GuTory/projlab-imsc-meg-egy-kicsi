package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;

import java.awt.event.ActionEvent;

public class KenesFrame extends ActionFrame{

    public KenesFrame(JatekFrame f){
        super(f);
        OKButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Controller.GetInstance().MegkenCallback(VIROLOGUS, MIVEL);
        Publisher.getInstance().updateAction();
        setVisible(false);
    }

}
