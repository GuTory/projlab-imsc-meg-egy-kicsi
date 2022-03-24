import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import virologus.Virologus;

public class Jatek {
    private static int idobelyeg;

    public static void jatekVege(Virologus virologus) throws ExecutionControl.NotImplementedException {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    public static void jatekIndit() throws ExecutionControl.NotImplementedException {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

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
