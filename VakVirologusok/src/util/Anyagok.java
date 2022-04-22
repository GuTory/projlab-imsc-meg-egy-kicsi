package util;

import lombok.Getter;
import java.util.Dictionary;
import java.util.Hashtable;

public class Anyagok {

    /**
     * Szótár, melyben tárolja, hogy aminosavból és nukleotidból mennyi
     * van. A szótárban a szó az anyag neve, a hozzá csatolt megjegyzés pedig a számossága.
     */
    @Getter
    private Dictionary<String, Integer> anyagok;

    public Anyagok(int nukleotid, int aminosav) {
        anyagok = new Hashtable<>();
        anyagok.put("nukleotid", nukleotid);
        anyagok.put("aminosav", aminosav);
    }

    /**
     * Hozzáad annyi anyag mennyiséget a Dictionary-hez,
     * amennyit paraméterben kap.
     * @param anyagok Az anyagok, amelyet be akar rakni
     * @return Fel tud-e venni ennyi anyagot
     */
    public boolean betesz(Anyagok anyagok) {

        //TODO: betenni az anyagot

 
        return false;
    }

    /**
     * Kivesz annyi anyag mennyiséget a Dictionary-hez,
     * amennyit paraméterben kap.
     * @param anyagok Az anyagok, amelyet be akar rakni
     * @return Ki tud-e venni ennyi anyagot
     */
    public boolean kivesz(Anyagok anyagok) {

        //TODO: kivenni az anyagot

 
        return false;
    }

    /**
     * Visszaadja, hogy mennyi az anyagok össz darabszáma.
     * @return az anyagok össz darabszáma
     */
    public int meret() {
        return anyagok.get("nukleotid") + anyagok.get("aminosav");
    }
}
