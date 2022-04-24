package jatek;

import agens.Benito;
import agens.Kod;
import felszereles.Balta;
import terkep.Mezo;
import test.TestIO;
import util.Anyagok;
import virologus.Virologus;

import java.util.ArrayList;
import java.util.Arrays;
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
    public static Varos instance = null;

    /**
     * Privat konstruktor.
     * @param placeholder Csak hogy meg lehessen kulonboztetni a publikus konstruktortol.
     */
     private Varos(Object placeholder){
        mezok = new ArrayList<>();
        virologusok = new ArrayList<>();
        kodok = new ArrayList<>();
        /*mezok.add(new Mezo());
        mezok.add(new Mezo());
        mezok.add(new Mezo());

        virologusok.add(new Virologus());
        virologusok.add(new Virologus());

        mezok.get(0).setSzomszedok(new ArrayList<>(List.of(mezok.get(1))));
        mezok.get(1).setSzomszedok(new ArrayList<>(List.of(mezok.get(0))));
        mezok.get(1).setSzomszedok(new ArrayList<>(List.of(mezok.get(2))));
        mezok.get(2).setSzomszedok(new ArrayList<>(List.of(mezok.get(1))));

        virologusok.get(0).setHely(mezok.get(0));
        mezok.get(0).virologusBe(virologusok.get(0));
        virologusok.get(1).setHely(mezok.get(2));
        mezok.get(2).virologusBe(virologusok.get(1));

        virologusok.get(1).beFelszereles(new Balta());*/
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
        TestIO.output("jatek vege: " + virologus.TestNev + " nyert");
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
/*        for (Virologus v : virologusok) {
            TestIO.output(v.TestNev);
            v.kor();
        }*/
    }

    public List<Mezo> getMezok() {
        return mezok;
    }

    public List<Virologus> getVirologusok() {
        return virologusok;
    }

    public List<Kod> getKodok() {
        return kodok;
    }
}
