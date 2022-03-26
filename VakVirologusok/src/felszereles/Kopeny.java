package felszereles;

import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import util.Taska;
import virologus.Virologus;

public class Kopeny extends Felszereles{

    /**
     * A paraméterben kapott virológusnak a részleges százalékos ellenállását beállítja végtelenre,
     * és a táskájába teszi a felszerelést.
     * @param virologus
     * @param taska
     */
    public  void fel(Virologus virologus, Taska taska){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        virologus.setEllenallasErvenyesseg(virologus.ReszlegesSzazalekos, -1);
        taska.felszerelesBerak(this);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * A paraméterben kapott virológusnak a részleges százalékos ellenállását beállítja 0-ra,
     * és a táskájából kiveszi a felszerelést.
     * @param virologus
     * @param taska
     */
    public  void le(Virologus virologus, Taska taska){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        virologus.setEllenallasErvenyesseg(virologus.ReszlegesSzazalekos, 0);
        taska.felszerelesKivesz(this);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Visszaadja az adott felszereléstípusnak az azonosítóját.
     * @return kopeny_ID - köpeny azonosítója.
     */
    public int getID(){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return Felszereles_ID.kopeny_ID;
    }
}
