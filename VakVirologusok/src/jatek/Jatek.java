package jatek;


import Graphics.Controller;
import Graphics.JatekFrame;
import Graphics.Publisher;
import terkep.Mezo;
import virologus.Virologus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
     * @param virologusokSzama A játékban szereplő virológusok száma
     */
    public static void jatekIndit(int virologusokSzama) {
        Varos v = Varos.getInstance();
        for(int i = 0; i < virologusokSzama-1; i++) {
            v.virologusHozzad();
        }

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
