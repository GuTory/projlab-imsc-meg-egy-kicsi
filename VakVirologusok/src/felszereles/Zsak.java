package felszereles;

import util.Taska;
import virologus.Virologus;

public class Zsak extends Felszereles{
    /**
     * Ennyivel növeli a táska méretét a zsák.
     */
    int novel;

    /**
     * A paraméterben kapott virológusnak a táska kapacitását növeli, majd belerakja
     * a táskájába a tárgyat.
     * @param virologus
     * @param taska
     */
    public  void fel(Virologus virologus, Taska taska){
        taska.kapacitasNovel(novel);
        taska.felszerelesBerak(this);
    }

    /**
     * A paraméterben kapott virológusnak a táska kapacitását csökkenti, majd kiveszi
     * a táskájából a tárgyat.
     * @param virologus
     * @param taska
     */
    public  void le(Virologus virologus, Taska taska){
        taska.kapacitasNovel(-novel);
        taska.felszerelesKivesz(this);
    }

    /**
     * Visszaadja az adott felszereléstípusnak az azonosítóját.
     * @return zsak_ID - zsák azonosítója.
     */
    public int getID(){
        return Felszereles_ID.zsak_ID;
    }
}
