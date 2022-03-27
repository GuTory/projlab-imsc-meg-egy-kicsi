package jatek;

import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import virologus.Virologus;

public class Jatek {

    /**
     * A játék színtere, a város.
     */
    private static Varos varos;

    /**
     * A játékban eltert köröket méri az időbélyeg.
     */
    private static int idobelyeg = 0;

    /**
     * Véget vet a játéknak, és a paraméterben kapott virológust kihirdeti győztesnek.
     * @param virologus A győztes
     */
    public static void jatekVege(Virologus virologus){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }


    /**
     * Létrehozza a várost, és elindítja a játékot.
     */
    public static void jatekIndit(){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        varos = new Varos();

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Visszaadja a játék időbélyegét.
     * @return A játék időbélyege.
     */
    public static int getIdobelyeg(){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return idobelyeg;
    }
}
