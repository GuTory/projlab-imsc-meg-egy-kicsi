package terkep;

import virologus.Virologus;

import java.util.ArrayList;

/**
 * A várost alkotó elemek egy fajtája, egy egység, amin virológusok lehetnek.
 * Konstruktorhívás után fel kell tölteni mindegyiket.
 */
public class Mezo {

    /**
     * teszteléshez készített ID
     */
    public String TestNev;

    /**
     * létrejött mező objektumok száma
     */
    protected static int TestID = 1;

    /**
     * mező konstruktora, kialakítja a testNevet
     */
    public Mezo() {
        TestNev = "mezo" + TestID;
        TestID++;
    }

    /**
     * A mezőben lévő virológusok.
     */
    protected ArrayList<Virologus> virologusok = new ArrayList<>();

    /**
     * virológusok settere
     * @param v virológus lista
     */
    public void setVirologusok(ArrayList<Virologus> v){ virologusok = v; }

    /**
     * virológusok gettere
     * @return
     */
    public ArrayList<Virologus> getVirologusok(){ return virologusok; }

    /**
     * A mezővel szomszédos mezők
     */
    protected ArrayList<Mezo> szomszedok = new ArrayList<>();

    /**
     * szomszédok settere
     * @param sz szomszédlista
     */
    public void setSzomszedok(ArrayList<Mezo> sz){ szomszedok = sz; }

    /**
     * szomszédok gettere
     * @return szomszédok lista
     */
    public ArrayList<Mezo> getSzomszedok(){ return szomszedok; }


    /**
     * Virológus beléptetése a mezőre
     */
    final public void virologusBe(Virologus virologus){
        virologusok.add(virologus);
        akcio(virologus);
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

    /**
     * medvevírusos tombol az adott mezőn. a sima mezőn ez semmilyen tevékenységet nem von maga után
     */
    public void tombol() {
        return;
    }

    /**
     * szöveggé alakított mező a teszteléshez
     * @return Mezo: ID
     */
    @Override
    public String toString(){
        return "Mezo: " + TestNev;
    }
}
