package felszereles;

import jdk.jshell.spi.ExecutionControl;
import util.Taska;
import virologus.Virologus;

public abstract class Felszereles{
    /**
     * Kifejti hatását az adott virológuson a tárgy, és beteszi a virológus táskájába.
     * @param virologus, akin kifejti a hatását.
     * @param taska, ahova berakja a tárgyat.
     */
    public abstract void fel(Virologus virologus, Taska taska);

    /**
     * Elveszi a hatását az adott virológustól, és kiveszi a táskájából.
     * @param virologus, akitől elveszi a hatását.
     * @param taska, ahonnan kiveszi a tárgyat.
     */
    public abstract void le(Virologus virologus, Taska taska);

    /**
     * Visszaadja az adott tárgynak az ID-ját, amit a Felszereles_ID osztályból olvas ki.
     * @return Felszereles_ID
     */
    public abstract int getID();
}
