package agens;

import lombok.Getter;
import util.Anyagok;
import util.Taska;
import virologus.Virologus;

public abstract class Kod {
    /**
     * A kódnak az azonosítója, ezzel lehet beazonosítani a különböző kódokat.
     */
    protected int id;

    /**
     * Ágens létrehozásának a költsége, ennyi anyag szükséges ahhoz, hogy létre tudja hozni az ágenst.
     */
    @Getter
    protected Anyagok koltseg;

    /**
     * A kód hatásának az ideje, miután rákenték valakire, ennyi körig fogja hatását kifejteni.
     */
    protected int elettartam;

    /**
     * Ágens szavatossága, miután létrehozta az ágenst a virológus, ennyi ideig tudja tárolni a táskájában mielőtt megszűnik.
     */
    protected int szavatossag;

    public Kod(int id, Anyagok koltseg, int elettartam, int szavatossag){
        this.id = id;
        this.koltseg = koltseg;
        this.elettartam = elettartam;
        this.szavatossag = szavatossag;
    }

    /**
     * Egy absztrakt metódus, létrehoz egy ágenst a kiválasztott kódból, és visszaadja.
     * @param taska, kiveszi a paraméterben kapott táskából a szükséges költséget.
     * @return Agens, létrehozott ágenst visszaadja.
     */
    public abstract Agens agensLetrehoz(Taska taska);

    /**
     * Egy absztrakt metódus, a paraméterként kapott virológusra az adott kód kifejti hatását, akire rákenték az ágenst.
     * @param virologus, akire a hatás fejtődik
     */
    public abstract void hatas(Virologus virologus);

    /**
     * Kiveszi a költséget a paraméterként kapott táskából.
     * @param taska, ahonnan kiveszi az anyagokat.
     * @return a kivétel sikerességét adja vissza. Ha nem volt elég anyag, akkor sikertelen - false-t ad vissza.
     */
    public boolean koltsegLevon(Taska taska) {
        return taska.anyagKivesz(koltseg);
    }

    /* Getterek */
    /**
     * Visszaadja a kódnak a szavatosságát.
     * @return szavatossag
     */
    public int getSzavatossag() {
        return szavatossag;
    }
}
