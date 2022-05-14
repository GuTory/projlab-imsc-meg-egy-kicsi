package Graphics;

import Graphics.ActionFrames.*;
import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import jatek.Jatek;
import jatek.Varos;
import terkep.Mezo;
import virologus.Virologus;

import javax.swing.*;

public class Controller {
    private JatekFrame MainFrame;

    private static Controller instance = null;

    private Controller(){
        MainFrame = new JatekFrame();
    }

    public static Controller GetInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public void JatekIndit(){
        Jatek.jatekIndit(4);
        MainFrame = new JatekFrame();
        MainFrame.setVisible(true);
    }

    public void MozogEvent(){
        JFrame frame = new MozogFrame(MainFrame);
        frame.setVisible(true);
    }

    public void TamadEvent(){
        JFrame frame = new TamadFrame(MainFrame);
        frame.setVisible(true);
    }

    public void KeszitEvent(){
        JFrame frame = new AgensKeszitFrame(MainFrame);
        frame.setVisible(true);
    }

    public void LopasEvent(){
        JFrame frame = new LopasFrame(MainFrame);
        frame.setVisible(true);
    }

    public void MegkenEvent(){
        JFrame frame = new KenesFrame(MainFrame);
        frame.setVisible(true);
    }

    public void NyerEvent(){
        JFrame frame = new NyertFrame(MainFrame);
        frame.setVisible(true);
    }

    public void EldobEvent(){
        JFrame frame = new EldobFrame(MainFrame);
        frame.setVisible(true);
    }

    public boolean MozogCallback(Mezo m){
        boolean siker =  Varos.getInstance().getActivVirologus().mozog(m);
        if(siker){
            Varos.getInstance().kovetkezoVirologus();
            Publisher.getInstance().updateKovetkezo();
        }

        return siker;
    }

    public boolean KeszitCallback(Kod k){
        boolean siker =  Varos.getInstance().getActivVirologus().agensEbbol(k);
        Publisher.getInstance().updateAction();
        return siker;
    }

    public boolean LopFelszerelesCallback(Virologus kitol){
        boolean siker =  Varos.getInstance().getActivVirologus().felszerelesLop(kitol);
        Publisher.getInstance().updateAction();
        return siker;
    }

    public boolean LopAnyagotCallback(Virologus kitol){
        boolean siker =  Varos.getInstance().getActivVirologus().anyagLop(kitol);
        Publisher.getInstance().updateAction();
        return siker;
    }

    public boolean LopAgenstCallback(Virologus kitol){
        boolean siker = Varos.getInstance().getActivVirologus().agensLop(kitol);
        Publisher.getInstance().updateAction();
        return siker;
    }

    public boolean MegkenCallback(Virologus kit, Agens mivel){
        boolean siker =  Varos.getInstance().getActivVirologus().ken(kit, mivel);
        Publisher.getInstance().updateAction();
        return siker;
    }

    public boolean TamadCallback(Virologus kit){
        boolean siker = Varos.getInstance().getActivVirologus().tamad(kit);
        Publisher.getInstance().updateAction();
        return siker;
    }

    public boolean EldobCallback(Felszereles f){
        boolean siker = Varos.getInstance().getActivVirologus().getTaska().felszerelesKivesz(f);
        Publisher.getInstance().updateAction();
        return siker;
    }

    public void KovetkezoVirologusCallback(){
        Varos.getInstance().kovetkezoVirologus();
        Publisher.getInstance().updateKovetkezo();
    }
}
