package terkep;

import lombok.Getter;
import lombok.Setter;
import skeleton.Skeleton;
import util.Anyagok;
import util.Taska;
import virologus.Virologus;

import java.util.Scanner;

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
        if(virologus.getTaska().anyagBerak(anyagok))
            anyagok = null;
    }

    @Override
    public void tombol() {
        anyagok = null;
    }
}
