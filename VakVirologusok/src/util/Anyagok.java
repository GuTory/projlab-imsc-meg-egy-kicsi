package util;

import skeleton.Skeleton;

import java.util.Dictionary;

public class Anyagok {

    /**
     * Szótár, melyben tárolja, hogy aminosavból és nukleotidból mennyi
     * van. A szótárban a szó az anyag neve, a hozzá csatolt megjegyzés pedig a számossága.
     */
    private Dictionary<String, Integer> anyagok;

    /**
     * Hozzáad annyi anyag mennyiséget a Dictionary-hez,
     * amennyit paraméterben kap.
     * @param anyagok Az anyagok, amelyet be akar rakni
     * @return Fel tud-e venni ennyi anyagot
     */
    public boolean betesz(Anyagok anyagok) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean siker = Skeleton.igenNem("Fel tud venni ennyi anyagot?");

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return siker;
    }

    /**
     * Kivesz annyi anyag mennyiséget a Dictionary-hez,
     * amennyit paraméterben kap.
     * @param anyagok Az anyagok, amelyet be akar rakni
     * @return Ki tud-e venni ennyi anyagot
     */
    public boolean kivesz(Anyagok anyagok) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean siker = Skeleton.igenNem("Ki tud venni ennyi anyagot?");

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return siker;
    }

}
