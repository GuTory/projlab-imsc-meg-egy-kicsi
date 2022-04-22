package agens;

import util.Anyagok;
import util.Taska;
import virologus.BenultViselkedes;
import virologus.Virologus;

public class Benito extends Kod{
    /**
     * Létrehoz egy bénító kódot, beállítja az azonosítóját, a költségét, az élettartamát
     * és a szavatosságát.
     * @param id
     * @param koltseg
     * @param elettartam
     * @param szavatossag
     */
    public Benito(int id, Anyagok koltseg, int elettartam, int szavatossag){
        super(id, koltseg, elettartam, szavatossag);
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
}
