package jatek;


import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;
import virologus.Virologus;

public class Jatek {
    /**
     * A játékban eltert köröket méri az időbélyeg.
     */
    private static int idobelyeg = 0;

    private static Jatek instance = null;

    private Jatek(){}

    public static Jatek GetInstance(){
        if(instance == null)
            instance = new Jatek();
        return instance;
    }

    /**
     * Véget vet a játéknak, és a paraméterben kapott virológust kihirdeti győztesnek.
     * @param virologus A győztes
     */
    public static void jatekVege(Virologus virologus){
        Publisher.getInstance().updateNyer();
    }

    /**
     * Létrehozza a várost, és elindítja a játékot.
     */
    public static void jatekIndit(){
        Varos.getInstance();
    }

    /**
     * Visszaadja a játék időbélyegét.
     * @return A játék időbélyege.
     */
    public static int getIdobelyeg(){
        return idobelyeg;
    }

    public static void idoTelt(){
        idobelyeg++;
    }
}
