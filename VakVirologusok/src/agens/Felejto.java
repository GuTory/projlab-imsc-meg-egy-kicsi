package agens;

public class Felejto {

    /**
     * Létrehoz egy ágenst, aminek a hatása felejtő lesz.
     * @param taska, levonja belőle a költség anyagát.
     * @return Agens, visszaadja a létrejött ágenst.
     */
    public Agens agensLetrehoz(Taska taska){
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * A virológusnak meghívja a kodFelejt() függvényét, és elfelejti az összes eddig
     * megtanult kódját.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus){
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }
}
