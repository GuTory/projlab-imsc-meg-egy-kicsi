package Graphics.ActionFrames;

import Graphics.JatekFrame;

import java.awt.event.ActionEvent;

public class SikerFrame extends ActionFrame{

    private String message;

    public SikerFrame(JatekFrame f, String s){
        super(f);
        OKButton.addActionListener(this);
        message = s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

}
