package terkep;

import felszereles.Felszereles;
import lombok.Getter;
import lombok.Setter;
import virologus.Virologus;

import java.util.Scanner;

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
        if(felszereles != null){ //TODO: esetleg kérdezni?
            virologus.beFelszereles(felszereles);
            felszereles = null;
        }
    }
}
