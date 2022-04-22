package felszereles;

import util.Taska;
import virologus.Virologus;

public class Zsak extends Felszereles{
    /**
     * Ennyivel növeli a táska méretét a zsák.
     */
    final int novel = 2;

    /**
     * A paraméterben kapott virológusnak a táska kapacitását növeli, majd belerakja
     * a táskájába a tárgyat.
     * @param virologus
     * @param taska
     */
    public  void fel(Virologus virologus, Taska taska){
        if (taska.felszerelesBerak(this)) {
            taska.kapacitasNovel(novel);
        }
    }

    /**
     * A paraméterben kapott virológusnak a táska kapacitását csökkenti, majd kiveszi
     * a táskájából a tárgyat.
     * @param virologus
     * @param taska
     */
    public  void le(Virologus virologus, Taska taska){
        if (taska.felszerelesKivesz(this)) {
            taska.kapacitasNovel(-novel);
        }
    }

    /**
     * Visszaadja az adott felszereléstípusnak az azonosítóját.
     * @return zsak_ID - zsák azonosítója.
     */
    public int getID(){
        return Felszereles_ID.zsak_ID;
    }
}
