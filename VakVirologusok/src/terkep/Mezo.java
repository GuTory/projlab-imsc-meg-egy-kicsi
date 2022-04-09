package terkep;

import jatek.Varos;
import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import lombok.Setter;
import skeleton.Skeleton;
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

    public Mezo() {
        Skeleton.metodusEleje("Mezo konstruktor");

        Skeleton.metodusVege("Mezo konstruktor");
    }

    /**
     * Virológus beléptetése a mezőre
     */
    final public void virologusBe(Virologus virologus){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());


        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Virológus kiléptetése a mezőről
     */
    final public void virologusKi(Virologus virologus){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());


        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * A mezőben elvégezhető akció (a mezőben ez éppen semmi, de a leszármazottak felüldefiniálják)
     */
    public void akcio(Virologus virologus){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return;
    }

    public void tombol() {
        ;
    }
}
