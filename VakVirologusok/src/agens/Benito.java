package agens;

import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;
import util.Anyagok;
import util.Taska;
import virologus.BenultViselkedes;
import virologus.Virologus;

public class Benito extends Kod{
    /**
     * Létrehoz egy bénító kódot, beállítja az azonosítóját, a költségét, az élettartamát
     * és a szavatosságát.
     * @param koltseg
     * @param elettartam
     * @param szavatossag
     */
    public Benito(Anyagok koltseg, int elettartam, int szavatossag){
        super("Benito", koltseg, elettartam, szavatossag);
    }

    /**
     * Létrehoz egy ágenst, aminek a hatása bénító lesz.
     * @param taska, levonja belőle a költség anyagát.
     * @return Agens, visszaadja a létrejött ágenst.
     */
    public Agens agensLetrehoz(Taska taska){
        if(this.koltsegLevon(taska)){
            return new Agens(this);
        }
        return null;
    }

    /**
     * A virológusnak meghívja a megbenul(int) függvényét, és betesz viselkedésként
     * paraméterben kapott számú vitustancViselkedést.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus){
        virologus.addViselkedes(elettartam, new BenultViselkedes(virologus));
    }

    @Override
    public String toString(){
        return "benito";
    }
}
