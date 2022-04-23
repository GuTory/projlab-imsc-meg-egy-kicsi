package terkep;

import jatek.Varos;
import agens.Kod;
import virologus.Virologus;

/**
 * Labor mező amiben kód van.
 */
public class Labor extends Mezo {

    /**
     * A laborban lévő kód.
     */
    private Kod kod;

    public void setKod(Kod k){ kod = k; }

    public Kod getKod(){ return kod; }

    /**
     * A laborban elvégezhető akció (kódtanulás)
     */
    public void akcio(Virologus virologus) {
        virologus.kodMegtanul(kod);
        Varos.vegeEllenoriz(virologus);
    }

    @Override
    public String toString(){
        return "Labor: " /*+ name*/;
    }
}
