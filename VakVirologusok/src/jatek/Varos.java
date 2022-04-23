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
     * A városban található virológusok összessége.
     */
    private List<Virologus> virologusok;

    /**
     * A városban található mezők összessége.
     */
    private List<Mezo> mezok;

    private static Varos instance = null;

    /**
     * Konstruktor, egy tesztesettel.
     */
     private Varos(){
        mezok = new ArrayList<>();
        virologusok = new ArrayList<>();
        kodok = new ArrayList<>();

        mezok.add(new Mezo());
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

        virologusok.get(1).beFelszereles(new Balta());
    }

    public static Varos getInstance()
    {
        if(instance == null)
            instance = new Varos();
        return instance;
    }

    /**
     * Ellenőrzi, hogy a paraméterben kapott virológus minden kódot megtanult-e, ha igen,
     * akkor véget vet a játéknak, és kihirdeti a győztest.
     * @param virologus Vége lett-e a játéknak
     */
    public void vegeEllenoriz(Virologus virologus){
        if (kodok.containsAll(virologus.getKodok())) {
            Jatek.jatekVege(virologus);
        }
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
}
