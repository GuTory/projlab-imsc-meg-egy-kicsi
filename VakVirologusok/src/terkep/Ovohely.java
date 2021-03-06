package terkep;

import felszereles.Felszereles;
import virologus.Virologus;

import java.awt.*;
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

    /**
     * szöveggé alakított oóvhely a teszteléshez
     * @return Ovohely: ID
     */
    @Override
    public String toString(){
        return "Ovohely: " +TestNev;
    }

    public String objektumok(){
        return felszereles!=null ? felszereles.TestNev : "";
    }

    @Override
    public Color color(){
        return new Color(71, 86, 71);
    }
}
