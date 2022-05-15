package Graphics.ActionFrames;

import Graphics.JatekFrame;
import virologus.Virologus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class ActionFrame extends JFrame implements ActionListener {
    protected Container contentPane;
    protected SpringLayout layout;
    protected JButton OKButton;

    protected JatekFrame szulo;
    protected Virologus aktiv;

    /**
     * Ősosztály konstruktora
     * @param f a játék frame, az ablak őse
     * @param text Az ablak neve
     */
    public ActionFrame(JatekFrame f, String text){
        szulo = f;
        setTitle(text);
        OKButton = new JButton("OK");
        aktiv = f.getAktivVirologus();

        contentPane = this.getContentPane();
        layout = new SpringLayout();
        contentPane.setLayout(layout);
        contentPane.add(OKButton);

        setMinimumSize(new Dimension(250,75));
        setResizable(false);
        setVisible(true);
    }
}
