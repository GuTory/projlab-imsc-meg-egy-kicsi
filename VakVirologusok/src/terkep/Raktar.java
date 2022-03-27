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

    public Raktar() {
        Skeleton.metodusEleje("Raktar konstruktor");

        Skeleton.metodusVege("Raktar konstruktor");
    }

    /**
     * A raktárban megtehető extra tevékenység: anyag felvétel.
     */
    public void akcio(Virologus virologus) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Taska taska = virologus.getTaska();
        taska.anyagBerak(anyagok);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
