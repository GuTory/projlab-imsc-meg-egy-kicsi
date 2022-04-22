package jatek;

import agens.Benito;
import agens.Kod;
import terkep.Mezo;
import util.Anyagok;
import virologus.Virologus;

import java.util.ArrayList;
import java.util.List;

public class Varos {
    /**
     * A városban található kódok összessége.
     */
    private static List<Kod> kodok;

    /**
     * A városban található virológusok összessége.
     */
    private static List<Virologus> virologusok;

    /**
     * A városban található mezők összessége.
     */
    private static List<Mezo> mezok;

    /**
     * Konstruktor, egy tesztesettel.
     */
    public Varos() {
        mezok = new ArrayList<>();
        virologusok = new ArrayList<>();
        kodok = new ArrayList<>();

        mezok.add(new Mezo());

        virologusok.add(new Virologus());
        virologusok.add(new Virologus());

        kodok.add(new Benito(0, new Anyagok(1, 1), 1, 1));
    }

    /**
     * Ellenőrzi, hogy a paraméterben kapott virológus minden kódot megtanult-e, ha igen,
     * akkor véget vet a játéknak, és kihirdeti a győztest.
     * @param virologus Vége lett-e a játéknak
     */
    public static void vegeEllenoriz(Virologus virologus){
        if (kodok.containsAll(virologus.getKodok())) {
            Jatek.jatekVege(virologus);
        }
    }

    public static void kor() {
        for (Virologus v : virologusok) {
            v.kor();
        }
    }

}
