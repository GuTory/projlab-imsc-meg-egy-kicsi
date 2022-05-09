package Graphics;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import jatek.Varos;
import terkep.Mezo;
import virologus.Virologus;

public class Controller {

    private static Controller instance = null;

    private Controller(){

    }

    public static Controller GetInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public void JatekIndit(){

    }

    public void MozogEvent(){

    }

    public void KeszitEvent(){

    }

    public void LopasEvent(){

    }

    public void MegkenEvent(){

    }

    public void NyerEvent(){

    }

    public void EldobEvent(){

    }

    public boolean MozogCallback(Mezo m){
        return Varos.getInstance().getActivVirologus().mozog();
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
        return Varos.getInstance().getActivVirologus().getTaska().felszerelesKivesz(f);
    }

    public void KovetkezoVirologusCallback(){
        Varos.getInstance().kovetkezoVirologus();
    }
}
