package felszereles;

import skeleton.Skeleton;
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
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if (taska.felszerelesBerak(this)) {
            taska.kapacitasNovel(novel);
        }


        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * A paraméterben kapott virológusnak a táska kapacitását csökkenti, majd kiveszi
     * a táskájából a tárgyat.
     * @param virologus
     * @param taska
     */
    public  void le(Virologus virologus, Taska taska){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if (taska.felszerelesKivesz(this)) {
            taska.kapacitasNovel(-novel);
        }


        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Visszaadja az adott felszereléstípusnak az azonosítóját.
     * @return zsak_ID - zsák azonosítója.
     */
    public int getID(){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return Felszereles_ID.zsak_ID;
    }
}
