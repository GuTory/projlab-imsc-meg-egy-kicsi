package felszereles;

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
        if (taska.felszerelesBerak(this)) {
            virologus.setEllenallasErvenyesseg(virologus.ReszlegesSzazalekos, -1);
        }
    }

    /**
     * A paraméterben kapott virológusnak a részleges százalékos ellenállását beállítja 0-ra,
     * és a táskájából kiveszi a felszerelést.
     * @param virologus
     * @param taska
     */
    public  void le(Virologus virologus, Taska taska){
        if (taska.felszerelesKivesz(this)) {
            virologus.setEllenallasErvenyesseg(virologus.ReszlegesSzazalekos, 0);
        }
    }

    /**
     * Visszaadja az adott felszereléstípusnak az azonosítóját.
     * @return kopeny_ID - köpeny azonosítója.
     */
    public int getID(){
        return Felszereles_ID.kopeny_ID;
    }
}
