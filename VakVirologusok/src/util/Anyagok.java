package util;

import java.util.Hashtable;
import java.util.Map;

public class Anyagok {

    /**
     * Szótár, melyben tárolja, hogy aminosavból és nukleotidból mennyi
     * van. A szótárban a szó az anyag neve, a hozzá csatolt megjegyzés pedig a számossága.
     */
    private Map<String, Integer> anyagok;

    /**
     * anyagok gettere
     * @return anyagok
     */
    public Map<String, Integer> getAnyagok() { return anyagok; }

    /**
     * anyagok konstruktora
     * @param nukleotid nukleotid mennyisége
     * @param aminosav aminosav mennyisége
     */
    public Anyagok(int nukleotid, int aminosav) {
        anyagok = new Hashtable<>();
        anyagok.put("nukleotid", nukleotid);
        anyagok.put("aminosav", aminosav);
    }

    /**
     * Hozzáad annyi anyag mennyiséget a Dictionary-hez,
     * amennyit paraméterben kap.
     * @param uj Az anyagok, amelyet be akar rakni
     * @return Fel tud-e venni ennyi anyagot
     */
    public boolean betesz(Anyagok uj) {

        anyagok.replaceAll((k, v) -> anyagok.get(k) + uj.getAnyagok().get(k));
 
        return true;
    }

    /**
     * Kivesz annyi anyag mennyiséget a Dictionary-hez,
     * amennyit paraméterben kap.
     * @param uj Az anyagok, amelyet be akar rakni
     * @return Ki tud-e venni ennyi anyagot
     */
    public boolean kivesz(Anyagok uj) {

        anyagok.replaceAll((k, v) -> v - uj.getAnyagok().get(k));
        for (String key : anyagok.keySet()) {
            if (anyagok.get(key) < 0) {
                anyagok.replaceAll((k, v) -> v + uj.getAnyagok().get(k));
                return false;
            }
        }

        return true;
    }

    /**
     * Visszaadja, hogy mennyi az anyagok össz darabszáma.
     * @return az anyagok össz darabszáma
     */
    public int meret() {
        int meret = 0;
        for (String key : anyagok.keySet()) {
            meret += anyagok.get(key);
        }
        return meret;
    }

    /**
     * szöveggé alakított anyagok, az aminosav és nukleotid mennyiséggel
     * @return az összefűzött szöveg
     */
    @Override
    public String toString(){
        String s = "";
        if(anyagok.get("aminosav") > 0){
            s += "aminosav " + anyagok.get("aminosav");
        }
        if(anyagok.get("aminosav") > 0 && anyagok.get("nukleotid") > 0)  s += "\n";
        if(anyagok.get("nukleotid") > 0){
            s += "nukleotid " + anyagok.get("nukleotid");
        }
        return s;
    }
}
