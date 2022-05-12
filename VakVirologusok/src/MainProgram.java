import Graphics.ActionFrames.*;
import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;
import jatek.Varos;

public class MainProgram {

    public static void main(String[] args){
        Publisher.getInstance();
        Controller.GetInstance().JatekIndit();

        ActionFrame teszt = new MozogFrame(new JatekFrame());
    }
}
