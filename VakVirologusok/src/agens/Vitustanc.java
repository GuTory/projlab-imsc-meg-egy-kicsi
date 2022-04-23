package agens;

import util.Anyagok;
import util.Taska;
import virologus.Virologus;
import virologus.VitustancViselkedes;

public class Vitustanc extends Kod{
    /**
     * Létrehoz egy vítustánc kódot, beállítja az azonosítóját, a költségét, az élettartamát
     * és a szavatosságát.
     * @param id
     * @param koltseg
     * @param elettartam
     * @param szavatossag
     */
    public Vitustanc(int id, Anyagok koltseg, int elettartam, int szavatossag){
        super(id, koltseg, elettartam, szavatossag);
    }

    /**
     * Létrehoz egy ágenst, aminek a hatása vítustánc lesz.
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
     * A virológusnak meghívja a vitustancol(int) függvényét, és betesz viselkedésként
     * paraméterben kapott számú vitustancViselkedést.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus){
        virologus.addViselkedes(elettartam, new VitustancViselkedes(virologus));
    }

    @Override
    public String toString(){
        return "vitustanc";
    }
}
