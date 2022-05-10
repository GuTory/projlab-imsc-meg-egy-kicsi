package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EldobFrame extends ActionFrame {

    public EldobFrame(JatekFrame f){
        super(f, "Eldobás");
        OKButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Controller.GetInstance().EldobCallback(FELSZERELES);
        setVisible(false);
    }

}
