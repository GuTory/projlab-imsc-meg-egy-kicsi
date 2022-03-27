package jatek;

import agens.Benito;
import agens.Kod;
import jatek.Jatek;
import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import terkep.Labor;
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
        Skeleton.metodusEleje("Varos konstruktor");

        mezok = new ArrayList<>();
        virologusok = new ArrayList<>();
        kodok = new ArrayList<>();

        mezok.add(new Mezo());

        virologusok.add(new Virologus());
        virologusok.add(new Virologus());

        kodok.add(new Benito(0, new Anyagok(1, 1), 1, 1));

        Skeleton.metodusVege("Varos konstruktor");
    }

    /**
     * Ellenőrzi, hogy a paraméterben kapott virológus minden kódot megtanult-e, ha igen,
     * akkor véget vet a játéknak, és kihirdeti a győztest.
     * @param virologus Vége lett-e a játéknak
     */
    public static void vegeEllenoriz(Virologus virologus){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if(Skeleton.igenNem("Megtanult minden kódot a virológus?"))
            Jatek.jatekVege(virologus);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
