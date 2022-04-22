package terkep;

import jatek.Varos;
import agens.Kod;
import lombok.Getter;
import lombok.Setter;
import virologus.Virologus;

/**
 * Labor mező amiben kód van.
 */
public class Labor extends Mezo {

    /**
     * A laborban lévő kód.
     */
    @Setter
    @Getter
    private Kod kod;

    /**
     * A laborban elvégezhető akció (kódtanulás)
     */
    public void akcio(Virologus virologus) {
        virologus.kodMegtanul(kod);
        Varos.vegeEllenoriz(virologus);
    }
}
