package terkep;

import lombok.Getter;
import lombok.Setter;
import virologus.Virologus;

import java.util.ArrayList;

/**
 * A várost alkotó elemek egy fajtája, egy egység, amin virológusok lehetnek.
 * Konstruktorhívás után fel kell tölteni mindegyiket.
 */
public class Mezo {

    /**
     * A mezőben lévő virológusok.
     */
    @Setter
    @Getter
    protected ArrayList<Virologus> virologusok;

    /**
     * A mezővel szomszédos mezők
     */
    @Setter
    @Getter
    protected ArrayList<Mezo> szomszedok;


    /**
     * Virológus beléptetése a mezőre
     */
    final public void virologusBe(Virologus virologus){
        virologusok.add(virologus);
    }

    /**
     * Virológus kiléptetése a mezőről
     */
    final public void virologusKi(Virologus virologus){
        virologusok.remove(virologus);
    }

    /**
     * A mezőben elvégezhető akció (a mezőben ez éppen semmi, de a leszármazottak felüldefiniálják)
     */
    public void akcio(Virologus virologus){
        return;
    }

    public void tombol() {
        return;
    }
}
