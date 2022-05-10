package Graphics.ActionFrames;

import Graphics.ActionFrames.ActionFrame;
import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;

import java.awt.event.ActionEvent;

public class MozogFrame extends ActionFrame {

    public MozogFrame(JatekFrame f){
        super(f);
        OKButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Controller.GetInstance().MozogCallback(MEZO);
        Publisher.getInstance().updateKovetkezo();
        setVisible(false);
    }
}
