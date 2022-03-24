package agens;

public class Benito extends Kod{

    /**
     * Létrehoz egy ágenst, aminek a hatása bénító lesz.
     * @param taska, levonja belőle a költség anyagát.
     * @return Agens, visszaadja a létrejött ágenst.
     */
    public Agens agensLetrehoz(Taska taska){
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * A virológusnak meghívja a megbenul(int) függvényét, és betesz viselkedésként
     * paraméterben kapott számú vitustancViselkedést.
     * @param virologus, rá fejti ki hatását az ágens.
     */
    public void hatas(Virologus virologus){
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }
}
