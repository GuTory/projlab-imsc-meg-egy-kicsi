package terkep;

import felszereles.Felszereles;
import lombok.Getter;
import lombok.Setter;
import skeleton.Skeleton;
import virologus.Virologus;

public class Ovohely extends Mezo {

    /**
     * Az óvóhelyen lévő felszerelés
     */
    @Setter
    @Getter
    private Felszereles felszereles;

    /**
     * Az óvóhelyen elvégezhető akció (felszerelés felvétel)
     */
    public void akcio(Virologus virologus){
        if(Skeleton.igenNem("felveszed a felszerelést?")){
            Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

            virologus.beFelszereles(felszereles);

            Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    }
}
