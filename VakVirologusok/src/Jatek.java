import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import virologus.Virologus;

public class Jatek {
    /**
     * A játékban eltert köröket méri az időbélyeg.
     */
    private static int idobelyeg = 0;

    /**
     * Véget vet a játéknak, és a paraméterben kapott virológust kihirdeti győztesnek.
     * @param virologus
     */
    public static void jatekVege(Virologus virologus) throws ExecutionControl.NotImplementedException {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * Létrehozza a várost, és elindítja a játékot.
     */
    public static void jatekIndit() throws ExecutionControl.NotImplementedException {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * Visszaadja a játék időbélyegét.
     * @return
     */
    public static int getIdobelyeg(){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return idobelyeg;
    }

    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
        Virologus v = new Virologus();
        v.kor();
    }
}
