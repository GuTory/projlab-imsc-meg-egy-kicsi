package util;

import java.util.Dictionary;
import java.util.Hashtable;

public class Anyagok {

    /**
     * Szótár, melyben tárolja, hogy aminosavból és nukleotidból mennyi
     * van. A szótárban a szó az anyag neve, a hozzá csatolt megjegyzés pedig a számossága.
     */
    private Dictionary<String, Integer> anyagok;

    public Dictionary<String, Integer> getAnyagok() { return anyagok; }

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

    @Override
    public String toString(){
        String s = "";
        if(anyagok.get("aminosav") > 0){
            s += "aminosav" + anyagok.get("aminosav") + "\n";
        }
        if(anyagok.get("nukleotid") > 0){
            s += "nukleotid" + anyagok.get("nukleotid") + "\n";
        }
        return s;
    }
}
