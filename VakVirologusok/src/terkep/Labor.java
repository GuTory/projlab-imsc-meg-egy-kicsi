package terkep;

import jatek.Varos;
import agens.Kod;
import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import lombok.Setter;
import skeleton.Skeleton;
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
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        virologus.kodMegtanul(kod);
        Varos.vegeEllenoriz(virologus);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
