package agens;

import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import virologus.Virologus;

import virologus.Virologus;

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
     * @param kod A kód, ami alapján az ágenst léterhozták
     */
    public Agens(Kod kod){
        Skeleton.metodusEleje("Agens konstruktor");

        this.kod = kod;
        ttl = kod.getSzavatossag();

        Skeleton.metodusVege("Agens konstruktor");
    }

    /**
     * Meghívja a tartalmazó kódnak a hatás metódusát, és az alapján hat a virológusra, akit attribútumként kap.
     * @param virologus, ezen a virológuson fejti ki a hatását az ágens.
     */
    public void hatas(Virologus virologus){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        kod.hatas(virologus);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Beállítja az élettartamát a kód
     * @param ttl A beállítani kívánt élettartam
     */
    public void setTtl(int ttl){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        this.ttl = ttl;

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Csökkenti a ttl-t 1-gyel, minden körben.
     * @return Az ágens továbbra is életbenmarad-e.
     */
    public boolean ttlCsokkent(){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean megszunik = Skeleton.igenNem("Megszunik az agens?");

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return !megszunik;
    }
}
