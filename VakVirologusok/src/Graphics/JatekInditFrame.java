package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class JatekInditFrame extends JFrame implements ActionListener {
    private Container contentPane;
    private SpringLayout layout;
    private JButton OKButton;

    JComboBox<Integer> CBoxVirologusokSzama;

    /**
     * Itt lehet kiválasztani, hogy hány virológussal indítjus el a játékot.
     * Ez jeleník meg játékindítás előtt.
     * Egy menüben kiváasztható a számuk és Ok-gombbal a játék elindítható.
     */
    public JatekInditFrame() {
        setTitle("Vak virologusok");
        OKButton = new JButton("OK");

        contentPane = this.getContentPane();
        layout = new SpringLayout();
        contentPane.setLayout(layout);
        contentPane.add(OKButton);

        setMinimumSize(new Dimension(250,75));
        setResizable(false);
        setVisible(true);

        OKButton.addActionListener(this);

        JLabel label = new JLabel("Hány virológus játszik?");

        Vector<Integer> virologusokSzama = new Vector<>();
        for (int i = 2; i <= 8; i++) virologusokSzama.add(i);

        CBoxVirologusokSzama = new JComboBox<>(virologusokSzama);

        contentPane.add(label);
        contentPane.add(CBoxVirologusokSzama);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, CBoxVirologusokSzama,0,SpringLayout.HORIZONTAL_CENTER, contentPane);

        layout.putConstraint(SpringLayout.NORTH, label,15,SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, CBoxVirologusokSzama,10,SpringLayout.SOUTH, label);

        layout.putConstraint(SpringLayout.NORTH, OKButton,15,SpringLayout.SOUTH, CBoxVirologusokSzama);
        layout.putConstraint(SpringLayout.EAST, OKButton,-15,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, OKButton,15,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, contentPane,15,SpringLayout.SOUTH, OKButton);

        setResizable(true);
        pack();
    }

    /**
     * Ha megnyomták az OK gombot, akkor elindítja a játékot a megaaott számú virológussal.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Publisher.getInstance();
        int virologusokSzama = CBoxVirologusokSzama.getSelectedItem() != null ? (Integer) CBoxVirologusokSzama.getSelectedItem() : -1;
        Controller.GetInstance().JatekIndit(virologusokSzama);
    }
}
