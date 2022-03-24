package agens;

import jdk.jshell.spi.ExecutionControl;
import util.Taska;
import virologus.BenultViselkedes;
import virologus.Virologus;

public class Benito extends Kod{
    /**
     * Létrehoz egy ágenst, aminek a hatása bénító lesz.
     * @param taska, levonja belőle a költség anyagát.
     * @return Agens, visszaadja a létrejött ágenst.
     */
    public Agens agensLetrehoz(Taska taska) throws ExecutionControl.NotImplementedException {
        if(this.koltsegLevon(taska))
            return new Agens(this);
        else return null;
    }

    /**
     * A virológusnak meghívja a megbenul(int) függvényét, és betesz viselkedésként
     * paraméterben kapott számú vitustancViselkedést.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus) throws ExecutionControl.NotImplementedException {
        virologus.addViselkedes(elettartam, new BenultViselkedes());
    }
}
