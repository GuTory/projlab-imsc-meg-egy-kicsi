package Graphics;

import java.awt.event.ActionEvent;

public class MozogFrame extends ActionFrame{

    public MozogFrame(JatekFrame f){
        super(f);
        OKButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
