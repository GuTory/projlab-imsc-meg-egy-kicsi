package agens;

import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import util.Taska;
import virologus.Virologus;

public class Felejto extends Kod{

    /**
     * Létrehoz egy ágenst, aminek a hatása felejtő lesz.
     * @param taska, levonja belőle a költség anyagát.
     * @return Agens, visszaadja a létrejött ágenst.
     */
    public Agens agensLetrehoz(Taska taska) throws ExecutionControl.NotImplementedException {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if(this.koltsegLevon(taska)){
            Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
            return new Agens(this);
        }
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return null;
    }

    /**
     * A virológusnak meghívja a kodFelejt() függvényét, és elfelejti az összes eddig
     * megtanult kódját.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus) throws ExecutionControl.NotImplementedException {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        virologus.kodFelejt();

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
