package agens;

public class Vedelem {

    /**
     * Létrehoz egy ágenst, aminek a hatása védelem lesz.
     * @param taska, levonja belőle a költség anyagát.
     * @return Agens, visszaadja a létrejött ágenst.
     */
    public Agens agensLetrehoz(Taska taska){
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * A virológusnak beállítja a védelmét egy bizonyos számú körig.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus){
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }
}
