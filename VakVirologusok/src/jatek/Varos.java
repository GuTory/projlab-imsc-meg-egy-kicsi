package jatek;

import agens.Kod;
import jatek.Jatek;
import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import terkep.Mezo;
import virologus.Virologus;

public class Varos {
    /**
     * A városban található kódok összessége.
     */
    private static Kod[] kodok;

    /**
     * A városban található virológusok összessége.
     */
    private static Virologus[] virologusok;

    /**
     * A városban található mezők összessége.
     */
    private static Mezo[] mezok;

    /**
     * Ellenőrzi, hogy a paraméterben kapott virológus minden kódot megtanult-e, ha igen,
     * akkor véget vet a játéknak, és kihirdeti a győztest.
     * @param virologus
     */
    public static void vegeEllenoriz(Virologus virologus){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if(Skeleton.igenNem("Megtanult minden kódot a virológus?"))
            Jatek.jatekVege(virologus);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
