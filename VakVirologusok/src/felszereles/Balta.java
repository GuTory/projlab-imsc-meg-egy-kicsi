package felszereles;

import util.Taska;
import virologus.Virologus;

/**
 * Egy balta tárgy, amivel le lehet ütni egy virológust.
 * Ha a virológus megtámad valakit a baltával, akkor CsorbultBaltára cserélik az objektumot.
 */
public class Balta extends Felszereles{

    /**
     * Meghívja a paraméterként kapott táskán a felszerelesBerak(this) függvényt, saját magát átadva.
     * @param virologus, akin kifejti a hatását.
     * @param taska, ahova berakja a tárgyat.
     */
    @Override
    public void fel(Virologus virologus, Taska taska) {
        taska.felszerelesBerak(this);
    }

    /**
     * Meghívja a paraméterként kapott táskán a felszerelesKivesz(this) függvényt, saját magát átadva.
     * @param virologus, akitől elveszi a hatását.
     * @param taska, ahonnan kiveszi a tárgyat.
     */
    @Override
    public void le(Virologus virologus, Taska taska) {
        taska.felszerelesKivesz(this);
    }

    /**
     * A balta ID-jának gettere
     * @return balta ID
     */
    @Override
    public int getID() {
        return Felszereles_ID.balta_ID;
    }

    @Override
    public String toString(){
        return "balta";
    }
}
