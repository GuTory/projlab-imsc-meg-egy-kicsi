import Graphics.ActionFrames.ActionFrame;
import Graphics.ActionFrames.NyertFrame;
import Graphics.ActionFrames.SikerFrame;
import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;
import jatek.Varos;

public class MainProgram {

    public static void main(String[] args){
        Publisher.getInstance();
        Controller.GetInstance().JatekIndit();

        ActionFrame teszt = new NyertFrame(new JatekFrame());
    }
}
