package felszereles;

import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import util.Taska;
import virologus.Virologus;

public class Kesztyu extends Felszereles{

    public Kesztyu() {
        elettartam = 3;
    }

    /**
     * A paraméterben kapott virológusnak a visszadobó ellenállását beállítja végtelenre,
     * és a táskájába teszi a felszerelést.
     * @param virologus
     * @param taska
     */
    public void fel(Virologus virologus, Taska taska){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        virologus.setEllenallasErvenyesseg(virologus.Visszadob, -1);
        taska.felszerelesBerak(this);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * A paraméterben kapott virológusnak a visszadobó ellenállását beállítja 0-ra,
     * és a táskájából kiveszi a felszerelést.
     * @param virologus
     * @param taska
     */
    public  void le(Virologus virologus, Taska taska){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        virologus.setEllenallasErvenyesseg(virologus.Visszadob, 0);
        taska.felszerelesKivesz(this);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Visszaadja az adott felszereléstípusnak az azonosítóját.
     * @return kesztyu_ID - kesztyű azonosítója.
     */
    public int getID(){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return Felszereles_ID.kesztyu_ID;
    }
}
