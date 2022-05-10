package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;

import java.awt.event.ActionEvent;

public class NyertFrame extends ActionFrame{

    public NyertFrame(JatekFrame f){
        super(f);
        OKButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
