package terkep;

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
    protected ArrayList<Virologus> virologusok = new ArrayList<>();

    public void setVirologusok(ArrayList<Virologus> v){ virologusok = v; }

    public ArrayList<Virologus> getVirologusok(){ return virologusok; }

    /**
     * A mezővel szomszédos mezők
     */
    protected ArrayList<Mezo> szomszedok = new ArrayList<>();

    public void setSzomszedok(ArrayList<Mezo> sz){ szomszedok = sz; }

    public ArrayList<Mezo> getSzomszedok(){ return szomszedok; }


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
