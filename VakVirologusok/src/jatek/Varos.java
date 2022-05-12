package jatek;

import Graphics.Publisher;
import agens.Felejto;
import agens.Kod;
import felszereles.*;
import terkep.Mezo;
import test.TestIO;
import util.Anyagok;
import virologus.Virologus;

import java.util.ArrayList;
import java.util.List;

public class Varos {
    /**
     * A városban található kódok összessége.
     */
    private List<Kod> kodok;

    /**
     * Beallitja a kodlistat
     * @param value az uj kodlista
     */
    public void setKodok(List<Kod> value){
        kodok = value;
    }

    /**
     * A városban található virológusok összessége.
     */
    private List<Virologus> virologusok;

    private Virologus aktivVirologus;

    /**
     * Beallitja a virologusok listajat
     * @param value az uj virologus lista
     */
    public void setVirologusok(List<Virologus> value){
        virologusok = value;
    }

    /**
     * A városban található mezők összessége.
     */
    private List<Mezo> mezok;

    /**
     * Beallitja a mezoket
     * @param value az uj mezo lista
     */
    public void setMezok(List<Mezo> value){
        mezok = value;
    }

    /**
     * A singleton peldanya az osztalynak
     */
    private static Varos instance = null;

    /**
     * Privat konstruktor.
     * @param placeholder Csak hogy meg lehessen kulonboztetni a publikus konstruktortol.
     */
     private Varos(Object placeholder){
        mezok = new ArrayList<>();
        virologusok = new ArrayList<>();
        kodok = new ArrayList<>();
        mezok.add(new Mezo());
        mezok.add(new Mezo());
        mezok.add(new Mezo());

        virologusok.add(new Virologus());
        virologusok.add(new Virologus());
        virologusok.add(new Virologus());
        virologusok.add(new Virologus());

        mezok.get(0).setSzomszedok(new ArrayList<>(List.of(mezok.get(1))));
        mezok.get(1).setSzomszedok(new ArrayList<>(List.of(mezok.get(0))));
        mezok.get(1).setSzomszedok(new ArrayList<>(List.of(mezok.get(2))));
        mezok.get(2).setSzomszedok(new ArrayList<>(List.of(mezok.get(1))));

        virologusok.get(0).setHely(mezok.get(0));
        mezok.get(0).virologusBe(virologusok.get(0));
        virologusok.get(1).setHely(mezok.get(0));
        mezok.get(0).virologusBe(virologusok.get(1));
        virologusok.get(2).setHely(mezok.get(0));
        mezok.get(0).virologusBe(virologusok.get(2));
        mezok.get(0).virologusBe(virologusok.get(3));
         virologusok.get(3).setHely(mezok.get(0));

        virologusok.get(1).beFelszereles(new Kopeny());
        virologusok.get(0).beFelszereles(new Balta());
        aktivVirologus = virologusok.get(0);
    }

    /**
     * Publikus konstruktor, szerializaciohoz szukseges.
     */
    public Varos()
    {
        //Maradjon uresen, ez csak az XML serializaciohoz kell
    }

    public static Varos getInstance()
    {
        if(instance == null)
            instance = new Varos(null);
        return instance;
    }

    /**
     * Ellenőrzi, hogy a paraméterben kapott virológus minden kódot megtanult-e, ha igen,
     * akkor véget vet a játéknak, és kihirdeti a győztest.
     * @param virologus Vége lett-e a játéknak
     */
    public void vegeEllenoriz(Virologus virologus){
        if(kodok.size() == 0) return;
        for (Kod kod: kodok) {
            if (!virologus.getKodok().contains(kod)) {
                return;
            }
        }
        Jatek.jatekVege(virologus);
        TestIO.output("jatek vege: " + virologus.Nev + " nyert");
    }

    /**
     * Lemasolja a parameterkent megadott varost
     * @param v A Varos objektum, amit lemasol
     */
    public void copy(Varos v){
        setKodok(v.getKodok());
        setMezok(v.getMezok());
        setVirologusok(v.getVirologusok());
    }

    public void kor() {
        /*
        for (Virologus v : virologusok) {
            TestIO.output(v.TestNev);
            v.kor();
        }*/
    }

    /**
     * mezők gettere
     * @return mezők lista
     */
    public List<Mezo> getMezok() {
        return mezok;
    }

    /**
     * virológusok gettere
     * @return virológusok listája
     */
    public List<Virologus> getVirologusok() {
        return virologusok;
    }

    /**
     * kódok gettere
     * @return kódok lista
     */
    public List<Kod> getKodok() {
        return kodok;
    }

    public Virologus getActivVirologus(){ return aktivVirologus; }

    public void kovetkezoVirologus(){
        int x = virologusok.indexOf(aktivVirologus);
        if(x + 1 >= virologusok.size()){
            x = 0;
            Jatek.idoTelt();
        }else x += 1;
        aktivVirologus = virologusok.get(x);
    }
}
