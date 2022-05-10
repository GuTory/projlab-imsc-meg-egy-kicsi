package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;

import java.awt.event.ActionEvent;

public class EldobFrame extends ActionFrame{

    public EldobFrame(JatekFrame f){
        super(f);
        OKButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Controller.GetInstance().EldobCallback(FELSZERELES);
        setVisible(false);
    }

}
