package agens;

public class Agens {
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
     * @param kod
     */
    public Agens(Kod kod){
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
     * @param ttl
     */
    public void setTtl(int ttl){
        this.ttl = ttl;
    }

    /**
     * Csökkenti a ttl-t 1-gyel, minden körben.
     */
    public void ttlCsokkent(){
        ttl--;
    }
}
