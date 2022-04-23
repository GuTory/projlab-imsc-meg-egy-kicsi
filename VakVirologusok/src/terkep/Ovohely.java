package terkep;

import felszereles.Felszereles;
import virologus.Virologus;

import java.util.Scanner;

public class Ovohely extends Mezo {

    /**
     * Az óvóhelyen lévő felszerelés
     */
    private Felszereles felszereles;

    public void setFelszereles(Felszereles f){ felszereles = f; }

    public Felszereles getFelszereles(){ return felszereles; }

    /**
     * Az óvóhelyen elvégezhető akció (felszerelés felvétel)
     */
    public void akcio(Virologus virologus){
        if(felszereles != null){
            virologus.beFelszereles(felszereles);
            felszereles = null;
        }
    }

    @Override
    public String toString(){
        return "Ovohely: " /*+ name*/;
    }
}
