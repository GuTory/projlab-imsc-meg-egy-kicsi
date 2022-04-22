package terkep;

import lombok.Getter;
import lombok.Setter;
import skeleton.Skeleton;
import util.Anyagok;
import util.Taska;
import virologus.Virologus;

/**
 * Raktár mező amiben anyagok vannak
 */
public class Raktar extends Mezo{

    /**
     * A raktárban lévő anyagok
     */
    @Setter
    @Getter
    private Anyagok anyagok;

    /**
     * A raktárban megtehető extra tevékenység: anyag felvétel.
     */
    public void akcio(Virologus virologus) {
        virologus.getTaska().anyagBerak(anyagok);   //TODO: esetleg kérdezni?
    }

    @Override
    public void tombol() {
        anyagok = null;
    }
}
