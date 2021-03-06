package terkep;

import agens.Kod;
import virologus.Virologus;

import java.awt.*;

/**
 * Labor mező amiben kód van.
 */
public class Labor extends Mezo {

    /**
     * A laborban lévő kód.
     */
    private Kod kod;

    /**
     * jód beállítása
     * @param k kód
     */
    public void setKod(Kod k){ kod = k; }

    /**
     * kód gettere
     * @return kód
     */
    public Kod getKod(){ return kod; }

    /**
     * A laborban elvégezhető akció (kódtanulás)
     */
    public void akcio(Virologus virologus) {
        if(kod != null)
            virologus.kodMegtanul(kod);
    }

    /**
     * szöveggé alakított labor
     * @return Labor: ID
     */
    @Override
    public String toString(){
        return "Labor: " + TestNev;
    }

    @Override
    public String objektumok(){
        return kod.toString();
    }

    @Override
    public Color color(){
        return new Color(128, 128, 255);
    }
}
