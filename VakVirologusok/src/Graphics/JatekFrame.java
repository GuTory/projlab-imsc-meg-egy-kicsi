package Graphics;

import jatek.Varos;
import virologus.Virologus;

import javax.swing.*;

public class JatekFrame extends JFrame implements Observer {
    private JButton lepButton;
    private JButton maradButton;
    private JButton tamadButton;
    private JButton lopButton;
    private JButton kenButton;
    private JButton keszitButton;
    private JButton eldobButton;

    private Virologus aktiv;
    private Rajzolo rajzolo;

    public JatekFrame(){
        super();
        aktiv = Varos.getInstance().getActivVirologus();
        Publisher.getInstance().sub(this);
        rajzolo = new Rajzolo();
        rajzolo.frissit();
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
}
