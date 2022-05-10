package Graphics.ActionFrames;

import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;

import java.awt.event.ActionEvent;

public class LopasFrame extends ActionFrame{

    public LopasFrame(JatekFrame f){
        super(f);
        OKButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        switch(){
            case "Agens":
                Controller.GetInstance().LopAgenstCallback(KITOL);
                break;
            case "Anyag":
                Controller.GetInstance().LopAnyagotCallback(KITOL);
                break;
            case "Felszereles":
                Controller.GetInstance().LopFelszerelesCallback(KITOL);
                break;
        }*/
        Publisher.getInstance().updateAction();


        setVisible(false);
    }

}
