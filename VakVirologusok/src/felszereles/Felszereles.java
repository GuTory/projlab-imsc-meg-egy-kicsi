package felszereles;

import util.Taska;
import virologus.Virologus;

public abstract class Felszereles{
    public final String TestNev;
    protected static int TestID = 1;

    protected int elettartam = 0;

    public Felszereles() {
        TestNev = "felszereles" + TestID;
        TestID++;
    }

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

    /**
     * használat
     * @return érvényes-e még a felszerelés?
     */
    public final boolean hasznal() {
        elettartam--;
        return elettartam > 0;
    }
}
