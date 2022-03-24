package agens;

import jdk.jshell.spi.ExecutionControl;
import util.Taska;
import virologus.Virologus;

public class Vedelem extends Kod{

    /**
     * Létrehoz egy ágenst, aminek a hatása védelem lesz.
     * @param taska, levonja belőle a költség anyagát.
     * @return Agens, visszaadja a létrejött ágenst.
     */
    public Agens agensLetrehoz(Taska taska) throws ExecutionControl.NotImplementedException {
        if(this.koltsegLevon(taska))
            return new Agens(this);
        else return null;
    }

    /**
     * A virológusnak beállítja a védelmét egy bizonyos számú körig.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus) throws ExecutionControl.NotImplementedException {
        virologus.setEllenallasErvenyesseg(virologus.TeljesSzazalekos, elettartam);
    }
}
