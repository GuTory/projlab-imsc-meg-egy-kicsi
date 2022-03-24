package agens;

import jdk.jshell.spi.ExecutionControl;
import util.Taska;
import virologus.Virologus;

public class Vitustanc {

    /**
     * Létrehoz egy ágenst, aminek a hatása vítustánc lesz.
     * @param taska, levonja belőle a költség anyagát.
     * @return Agens, visszaadja a létrejött ágenst.
     */
    public Agens agensLetrehoz(Taska taska) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * A virológusnak meghívja a vitustancol(int) függvényét, és betesz viselkedésként
     * paraméterben kapott számú vitustancViselkedést.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }
}
