package Graphics.ActionFrames;

import Graphics.JatekFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class ActionFrame extends JFrame implements ActionListener {

    protected JButton OKButton;

    protected JatekFrame szulo;

    public ActionFrame(JatekFrame f, String text){
        szulo = f;
        setTitle(text);
        OKButton = new JButton("OK");
        //setLayout(new BorderLayout());
        //add(OKButton, BorderLayout.SOUTH);
        //setMinimumSize(new Dimension(300,400));
    }
}
