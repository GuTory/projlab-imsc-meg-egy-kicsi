package agens;

import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import util.Anyagok;
import util.Taska;
import virologus.Virologus;

public class Vedelem extends Kod{
    /**
     * Létrehoz egy védelem kódot, beállítja az azonosítóját, a költségét, az élettartamát
     * és a szavatosságát.
     * @param id
     * @param koltseg
     * @param elettartam
     * @param szavatossag
     */
    public Vedelem(int id, Anyagok koltseg, int elettartam, int szavatossag){
        super(id, koltseg, elettartam, szavatossag);
    }

    /**
     * Létrehoz egy ágenst, aminek a hatása védelem lesz.
     * @param taska, levonja belőle a költség anyagát.
     * @return Agens, visszaadja a létrejött ágenst.
     */
    public Agens agensLetrehoz(Taska taska) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if(this.koltsegLevon(taska)) {
            Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
            return new Agens(this);
        }
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return null;
    }

    /**
     * A virológusnak beállítja a védelmét egy bizonyos számú körig.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus){
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        virologus.setEllenallasErvenyesseg(virologus.TeljesSzazalekos, elettartam);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
