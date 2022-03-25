package jatek;

import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import virologus.Virologus;

public class Jatek {
    private static int idobelyeg;

    public static void jatekVege(Virologus virologus) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static void jatekIndit() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static int getIdobelyeg(){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return idobelyeg;
    }
}
