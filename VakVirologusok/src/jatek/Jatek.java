package jatek;


import virologus.Virologus;

public class Jatek {
    /**
     * A játékban eltert köröket méri az időbélyeg.
     */
    private static int idobelyeg = 0;

    private static boolean vege = false;

    /**
     * Véget vet a játéknak, és a paraméterben kapott virológust kihirdeti győztesnek.
     * @param virologus A győztes
     */
    public static void jatekVege(Virologus virologus){
        vege = true;
        //TODO: virologus értesít
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
