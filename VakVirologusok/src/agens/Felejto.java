package agens;

import util.Anyagok;
import util.Taska;
import virologus.Virologus;

public class Felejto extends Kod{
    /**
     * Létrehoz egy felejtő kódot, beállítja az azonosítóját, a költségét, az élettartamát
     * és a szavatosságát.
     * @param koltseg
     * @param elettartam
     * @param szavatossag
     */
    public Felejto(Anyagok koltseg, int elettartam, int szavatossag){
        super("Felejto", koltseg, elettartam, szavatossag);
    }

    /**
     * Létrehoz egy ágenst, aminek a hatása felejtő lesz.
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
     * A virológusnak meghívja a kodFelejt() függvényét, és elfelejti az összes eddig
     * megtanult kódját.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus){
        virologus.kodFelejt();
    }

    @Override
    public String toString(){
        return "felejto";
    }
}
