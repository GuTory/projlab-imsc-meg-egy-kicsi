package jatek;

import agens.Kod;
import jatek.Jatek;
import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import terkep.Mezo;
import virologus.Virologus;

public class Varos {
    private static Kod kodok;
    private static Virologus virologusok;
    private static Mezo mezok;

    public static void vegeEllenoriz(Virologus virologus) throws ExecutionControl.NotImplementedException {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if(Skeleton.igenNem("Megtanult minden kódot a virológus?"))
            Jatek.jatekVege(virologus);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
