package agens;

import test.TestIO;
import util.Anyagok;
import virologus.Virologus;


public class Agens {

    private static int AgensekSzama = 1;
    public String TestID;
    /**
     * Az ágens hátralévő élettartama, kiinduló értéke a szavatosság, ha 0 lesz akkor megszűnik.
     */
    int ttl;

    /**
     * Tárolja, hogy melyik kódból lett létrehozva az ágens.
     */
    Kod kod;

    /**
     * Konstruktorban megkapja, majd eltárolja, hogy melyik kódból lett létrehozva az adott ágens.
     * Beállítja az ágens szavatosságát, az adott kód által.
     * @param kod A kód, ami alapján az ágenst léterhozták
     */
    public Agens(Kod kod){

        TestID = kod.id +  ": agens" + AgensekSzama;
        AgensekSzama++;

        this.kod = kod;
        ttl = kod.getSzavatossag();
    }

    /**
     * Meghívja a tartalmazó kódnak a hatás metódusát, és az alapján hat a virológusra, akit attribútumként kap.
     * @param virologus, ezen a virológuson fejti ki a hatását az ágens.
     */
    public void hatas(Virologus virologus){
        kod.hatas(virologus);
    }

    /**
     * Beállítja az élettartamát a kód
     * @param ttl A beállítani kívánt élettartam
     */
    public void setTtl(int ttl){
        this.ttl = ttl;
    }

    /**
     * Csökkenti a ttl-t 1-gyel, minden körben.
     * @return Az ágens továbbra is életbenmarad-e.
     */
    public boolean ttlCsokkent() {
        ttl--;
        return ttl > 0;
    }

    public Anyagok koltseg() {
        return kod.getKoltseg();
    }

    @Override
    public String toString(){
        return TestID;
    }

    public Kod getKod() {
        return kod;
    }
}
