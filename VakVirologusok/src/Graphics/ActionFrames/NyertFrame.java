package Graphics.ActionFrames;

import Graphics.JatekFrame;
import virologus.Virologus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NyertFrame extends ActionFrame{

    public NyertFrame(JatekFrame f){
        super(f, "Győzelem");
        OKButton.addActionListener(this);
        Virologus gyoztes = f.getAktivVirologus();

        String m = "Gratulálunk! " + gyoztes.Nev + " nyert.";
        JLabel message = new JLabel(m);

        Container contentPane = this.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        contentPane.add(message);
        contentPane.add(OKButton);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, message,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, message,15,SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.NORTH, OKButton,15,SpringLayout.SOUTH, message);
        layout.putConstraint(SpringLayout.EAST, OKButton,-15,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, OKButton,15,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,15,SpringLayout.SOUTH, OKButton);

        setMinimumSize(new Dimension(250,75));
        setResizable(false);
        pack();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
