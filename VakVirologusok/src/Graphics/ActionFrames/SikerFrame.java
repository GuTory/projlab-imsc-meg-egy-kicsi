package Graphics.ActionFrames;

import Graphics.JatekFrame;

import java.awt.event.ActionEvent;

public class SikerFrame extends ActionFrame{

    private String message;

    public SikerFrame(JatekFrame f, String s){
        super(f, "Siker");
        OKButton.addActionListener(this);
        message = s;
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

}
