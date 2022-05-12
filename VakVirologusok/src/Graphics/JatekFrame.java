package Graphics;

import jatek.Varos;
import virologus.Virologus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class JatekFrame extends JFrame implements Observer {
    private JButton mozogButton;
    private JButton maradButton;
    private JButton tamadButton;
    private JButton lopButton;
    private JButton kenButton;
    private JButton keszitButton;
    private JButton eldobButton;

    private Virologus aktiv;
    private Rajzolo rajzolo;

    public JatekFrame(){
        super("Vak virologusok");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(800,600));
        JPanel SouthPanel = new JPanel(new FlowLayout());
        mozogButton = new JButton("Mozog");
        mozogButton.addActionListener(new MozogActionListener());
        SouthPanel.add(mozogButton,BorderLayout.SOUTH);
        maradButton = new JButton("Marad");
        maradButton.addActionListener(new MaradActionListener());
        SouthPanel.add(maradButton,BorderLayout.SOUTH);
        tamadButton = new JButton("Támad");
        tamadButton.addActionListener(new TamadActionListener());
        SouthPanel.add(tamadButton,BorderLayout.SOUTH);
        lopButton = new JButton("Lop");
        lopButton.addActionListener(new LopActionListener());
        SouthPanel.add(lopButton,BorderLayout.SOUTH);
        kenButton = new JButton("Ken");
        kenButton.addActionListener(new KenActionListener());
        SouthPanel.add(kenButton,BorderLayout.SOUTH);
        keszitButton = new JButton("Készít");
        keszitButton.addActionListener(new KeszitActionListener());
        SouthPanel.add(keszitButton,BorderLayout.SOUTH);
        eldobButton = new JButton("Eldob");
        eldobButton.addActionListener(new EldobActionListener());
        SouthPanel.add(eldobButton,BorderLayout.SOUTH);
        this.add(SouthPanel, BorderLayout.SOUTH);

        aktiv = Varos.getInstance().getActivVirologus();
        Publisher.getInstance().sub(this);
        rajzolo = new Rajzolo();
        rajzolo.frissit();
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public void subNyer(){
        Controller.GetInstance().NyerEvent();
    }

    public void subAction(){
        rajzolo.frissit();
    }

    public void subKovetkezo(){
        Controller.GetInstance().KovetkezoVirologusCallback();
        aktiv = Varos.getInstance().getActivVirologus();
    }

    private static class MozogActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().MozogEvent();
        }
    }

    private static class MaradActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: kéne MaradEvent?
            //Controller.GetInstance()...;
        }
    }

    private static class TamadActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().TamadEvent();
        }
    }

    private static class LopActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().LopasEvent();
        }
    }

    private static class KenActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().MegkenEvent();
        }
    }

    private static class KeszitActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().KeszitEvent();
        }
    }

    private static class EldobActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().EldobEvent();
        }
    }

    public Virologus getAktivVirologus(){ return aktiv; }
}
