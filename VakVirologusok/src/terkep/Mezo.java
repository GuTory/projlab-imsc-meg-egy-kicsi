package terkep;

import lombok.Getter;
import virologus.Virologus;

import java.util.ArrayList;

public class Mezo {

    /**
     * A mezőben lévő virológusok.
     */
    @Getter
    protected ArrayList<Virologus> virologusok;

    /**
     * A mezővel szomszédos mezők
     */
    @Getter
    protected ArrayList<Mezo> szomszedok;

    /**
     * Virológus beléptetése a mezőre
     */
    final public void virologusbe(Virologus virologus){

    }

    /**
     * Virológus kiléptetése a mezőről
     */
    final public void virologusKi(Virologus virologus){

    }

    /**
     * A mezőben elvégezhető akció (a mezőben ez éppen semmi, de a leszármazottak felüldefiniálják)
     */
    public void akcio(Virologus virologus){

    }
}
