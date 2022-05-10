import Graphics.Controller;
import Graphics.Publisher;
import jatek.Varos;

public class MainProgram {

    public static void main(String[] args){
        Publisher.getInstance();
        Controller.GetInstance().JatekIndit();
    }
}
