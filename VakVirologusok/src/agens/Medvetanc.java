package agens;

import util.Taska;
import virologus.MedvetancViselkedes;
import virologus.Virologus;

/**
 * Medvetancot okozó ágens genetikai kódja.
 * A medvetanc ágenst létrehozni nem lehet, csak fertőzött laborokban lehet elkapni,
 * és medvetánccal rendelkező virológusok tudnak vele megfertőzni.
 */
public class Medvetanc extends Kod{

    /**
     * Konstruktor, meghívja az ősének a konstruktorát.
     */
    public Medvetanc() {
        super("Medvetanc", null, 1, -1);
    }

    /**
     * Returnnel visszatér, ilyen módon nem létrehozható az ágens.
     * @param taska, kiveszi a paraméterben kapott táskából a szükséges költséget.
     * @return új ágens
     */
    @Override
    public Agens agensLetrehoz(Taska taska) {
        if(this.koltsegLevon(taska)) {
            return new Agens(this);
        }
        return null;
    }

    /**
     * A paraméterként kapott virológusnak meghívja a
     * v.addViselkkedes(elettartam, new MedvetancViselkedes(v)) függvényét,
     * ami hozzáad élettartamnyi medvetánc viselkedést a paraméterben szereplő virológushoz.
     * @param virologus, akire a hatás fejtődik
     */
    @Override
    public void hatas(Virologus virologus) {
        virologus.addViselkedes(elettartam, new MedvetancViselkedes(virologus));
    }

    @Override
    public String toString(){
        return "medvetanc";
    }
}
