package Graphics;

import agens.Kod;
import jatek.Varos;
import terkep.Mezo;
import virologus.Virologus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

    private JLabel LabelVirologus;

    private JLabel LabelVirologusok;

    private JLabel LabelObjektumok;

    private JLabel LabelSzomszedosMezok;

    private JLabel LabelAllapot;

    private JLabel LabelTaskaTartalma;

    private JLabel LabelmegtanultKodok;

    private Virologus aktiv;
    private Rajzolo rajzolo;

    public JatekFrame(){
        super("Vak virologusok");
        JPanel SouthPanel = new JPanel(new FlowLayout());
        EmptyBorder b = new EmptyBorder(10,10,10,10);
        JPanel WestPanel = new JPanel(); WestPanel.setBorder(b);
        JPanel EastPanel = new JPanel(); EastPanel.setBorder(b);

        /// Gombok és alap panel állítása

        aktiv = Varos.getInstance().getActivVirologus();
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800,600));
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
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

        /// Nyugati Panel beállítása

        LabelVirologus = new JLabel();
        LabelVirologusok= new JLabel();
        LabelObjektumok= new JLabel();
        LabelSzomszedosMezok= new JLabel();
        adatAllitasNyugat();
        WestPanel.setLayout(new BoxLayout(WestPanel, BoxLayout.Y_AXIS));
        WestPanel.add(LabelVirologus);
        WestPanel.add(LabelVirologusok);
        WestPanel.add(LabelObjektumok);
        WestPanel.add(LabelSzomszedosMezok);
        this.add(WestPanel, BorderLayout.WEST);

        /// Keleti panel állítása

        LabelmegtanultKodok = new JLabel();
        LabelTaskaTartalma = new JLabel();
        LabelAllapot = new JLabel();
        adatallitasKelet();
        EastPanel.setLayout(new BoxLayout(EastPanel, BoxLayout.Y_AXIS));
        EastPanel.add(LabelAllapot);
        EastPanel.add(LabelTaskaTartalma);
        EastPanel.add(LabelmegtanultKodok);
        this.add(EastPanel, BorderLayout.EAST);

        //Középső panel beállítása

        Publisher.getInstance().sub(this);
        rajzolo = new Rajzolo();
        add(rajzolo);
        rajzolo.frissit(aktiv);
    }

    /**
     * Nyugati panel adatainak állítása
     * Ezt hívd ha frissíteni kell
     */
    private void adatAllitasNyugat(){
        StringBuilder s = new StringBuilder("<html><h2>Ki vagy:</h2><br/>" + getAktivVirologus().Nev + "<br/><html/>");
        LabelVirologus.setText(s.toString());

        s = new StringBuilder("<html><h2>Virológusok a mezőn:</h2><br/>");
        for(Virologus v : aktiv.getHely().getVirologusok()){
            if(aktiv == v) continue;
            s.append(v.toString()).append("<br/>");
        }
        s.append("<html/>");
        LabelVirologusok.setText(s.toString());

        s = new StringBuilder("<html><h2>Objektumok a mezőn:</h2><br/>");
        String mezoadat = aktiv.getHely().objektumok().replace("\n","<br/>");
        s.append(mezoadat).append("<html/>");
        LabelObjektumok.setText(s.toString());

        s = new StringBuilder("<html><h2>Szomszédos mezők:</h2><br/>");
        for(Mezo m : aktiv.getHely().getSzomszedok()){
            s.append(m.toString()).append("<br>");
        }
         s.append("<html/>");
        LabelSzomszedosMezok.setText(s.toString());
     }

    /**
     * Keleti panel adatainak állítása
     * Ezt hívd ha frissíteni kell
     */
    private void adatallitasKelet(){
        StringBuilder s = new StringBuilder("<html><h2>Állapot:</h2><br>");
        s.append(aktiv.getJelenlegiViselkedes().toString()).append("<br/><html/>");
        LabelAllapot.setText(s.toString());

        s = new StringBuilder("<html><h2>Táska tartalma:</h2><br/>");
        s.append(aktiv.getTaska().toString().replace("\n", "<br/>")).append("<br/><html/>");
        LabelTaskaTartalma.setText(s.toString());

         s = new StringBuilder("<html><h2>Megtanult kódok:</h2><br/>");
         for(Kod k : aktiv.getKodok()){
             s.append(k.toString()).append("<br/>");
         }
         s.append("<html/>");
        LabelmegtanultKodok.setText(s.toString());
     }

    public void subNyer(){
        Controller.GetInstance().NyerEvent();
    }

    public void subAction(){
        rajzolo.frissit(aktiv);
        adatallitasKelet();
        adatAllitasNyugat();

    }

    public void subKovetkezo(){
        Controller.GetInstance().KovetkezoVirologusCallback();
        aktiv = Varos.getInstance().getActivVirologus();
    }

    /**
     * Mozgás gomb hallgatását megvalósító ActionListener osztály
     */
    private static class MozogActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().MozogEvent();
        }
    }

    /**
     * Maradás gomb hallgatását megvalósító ActionListener osztály
     */
    private static class MaradActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: kéne MaradEvent?
            //Controller.GetInstance()...;
        }
    }

    /**
     * Támadás gomb hallgatását megvalósító ActionListener osztály
     */
    private static class TamadActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().TamadEvent();
        }
    }

    /**
     * Lopás gomb hallgatását megvalósító ActionListener osztály
     */
    private static class LopActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().LopasEvent();
        }
    }

    /**
     * Kenés gomb hallgatását megvalósító ActionListener osztály
     */
    private static class KenActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().MegkenEvent();
        }
    }

    /**
     * Ágens készítés gomb hallgatását megvalósító ActionListener osztály
     */
    private static class KeszitActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().KeszitEvent();
        }
    }

    /**
     * Eldobás gomb hallgatását megvalósító ActionListener osztály
     */
    private static class EldobActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.GetInstance().EldobEvent();
        }
    }

    /**
     * Aktív virológus gettere
     * @return aktív virológus
     */
    public Virologus getAktivVirologus(){ return aktiv; }
}
