import Graphics.ActionFrames.*;
import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;
import agens.Felejto;
import jatek.Varos;
import util.Anyagok;

public class MainProgram {

    public static void main(String[] args){
        Publisher.getInstance();
        Controller.GetInstance().JatekIndit();
        ActionFrame teszt = new AgensKeszitFrame(new JatekFrame());
    }
}
