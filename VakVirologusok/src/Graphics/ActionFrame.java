package Graphics;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class ActionFrame extends JFrame implements ActionListener {

    protected JButton OKButton;

    protected JatekFrame szulo;

    public ActionFrame(JatekFrame f){
        szulo = f;
    }
}
