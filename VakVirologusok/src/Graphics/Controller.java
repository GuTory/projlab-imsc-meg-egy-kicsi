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
        Jatek.jatekIndit();
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
        return Varos.getInstance().getActivVirologus().mozog(m);
    }

    public boolean KeszitCallback(Kod k){
        return Varos.getInstance().getActivVirologus().agensEbbol(k);
    }

    public boolean LopFelszerelesCallback(Virologus kitol){
        return Varos.getInstance().getActivVirologus().felszerelesLop(kitol);
    }

    public boolean LopAnyagotCallback(Virologus kitol){
        return Varos.getInstance().getActivVirologus().anyagLop(kitol);
    }

    public boolean LopAgenstCallback(Virologus kitol){
        return Varos.getInstance().getActivVirologus().agensLop(kitol);
    }

    public boolean MegkenCallback(Virologus kit, Agens mivel){
        return Varos.getInstance().getActivVirologus().ken(kit, mivel);
    }

    public boolean TamadCallback(Virologus kit){
        return Varos.getInstance().getActivVirologus().tamad(kit);
    }

    public boolean EldobCallback(Felszereles f){
        boolean siker = Varos.getInstance().getActivVirologus().getTaska().felszerelesKivesz(f);
        Publisher.getInstance().updateAction();
        return siker;
    }

    public void KovetkezoVirologusCallback(){
        Varos.getInstance().kovetkezoVirologus();
    }
}
