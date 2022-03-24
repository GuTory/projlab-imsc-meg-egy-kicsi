package felszereles;

import jdk.jshell.spi.ExecutionControl;
import util.Taska;
import virologus.Virologus;

public class Kesztyu extends Felszereles{
    /**
     * A paraméterben kapott virológusnak a visszadobó ellenállását beállítja végtelenre,
     * és a táskájába teszi a felszerelést.
     * @param virologus
     * @param taska
     */
    public void fel(Virologus virologus, Taska taska) {
        virologus.setEllenallasErvenyesseg(virologus.Visszadob, -1);
        taska.felszerelesBerak(this);
    }

    /**
     * A paraméterben kapott virológusnak a visszadobó ellenállását beállítja 0-ra,
     * és a táskájából kiveszi a felszerelést.
     * @param virologus
     * @param taska
     */
    public  void le(Virologus virologus, Taska taska) {
        virologus.setEllenallasErvenyesseg(virologus.Visszadob, 0);
        taska.felszerelesKivesz(this);
    }

    /**
     * Visszaadja az adott felszereléstípusnak az azonosítóját.
     * @return kesztyu_ID - kesztyű azonosítója.
     */
    public int getID(){
        return Felszereles_ID.kesztyu_ID;
    }
}
