package util;

import agens.Agens;
import felszereles.Felszereles;
import virologus.Virologus;
import java.util.ArrayList;
import java.util.List;

public class Taska {

    /**
     * A táska tulajdonosa
     */
    private Virologus virologus;

    /**
     * Táskában levő anyagok és ágensek mennyiségének maximuma
     */
    private int kapacitas = 50;

    /**
     * Táskában levő anyagok
     */
    private Anyagok anyagok;

    /**
     * Táskában levő elkészített ágensek
     */
    private List<Agens> agensek;

    public List<Agens> getAgensek() { return agensek; }

    /**
     * A táskában levő felszerelések, ezek értelmezés szerint rajta vannak a tulajdonos virológuson
     */
    private List<Felszereles> felszerelesek;

    public List<Felszereles> getFelszerelesek() { return felszerelesek; }

    public Taska(Virologus virologus) {
        this.virologus = virologus;
        anyagok = new Anyagok(0,0);
        agensek = new ArrayList<>();
        felszerelesek = new ArrayList<>();
    }

    /**
     * Berakja a paraméterként kapott felszerelést a
     * táskába.
     * @param felszereles Flezserelés, amelyet berak a táskába
     * @return sikeresen berakta-e a táskába
     */
    public boolean felszerelesBerak(Felszereles felszereles) {
        if (felszerelesek.size() >= 3) return false;

        felszerelesek.add(felszereles);

         return true;
    }

    /**
     * Kiveszi a paraméterként kapott felszerelést a
     * táskából.
     * @param felszereles Felszerelés, amelyet kivesz a táskából
     * @return sikeresen kivette-e a táskából
     */
    public boolean felszerelesKivesz(Felszereles felszereles) {
        return felszerelesek.remove(felszereles);
    }

    /**
     * Berakja a táskába a paraméterként kapott anyagot.
     * @param anyagok Az anyag, amit berak a táskába
     * @return Van-e még hely
     */
    public boolean anyagBerak(Anyagok anyagok) {
        anyagok.betesz(anyagok);

        if (telitettseg() > kapacitas) {
            tartalomCsokkentes();
        }
        return telitettseg() < kapacitas;
    }

    /**
     * Kiveszi a táskából a paraméterként kapott anyaggal
     * megegyező mennyiségű anyagot, ha lehetséges.
     * @param anyagokKi A kivenni kívánt anyagok.
     * @return A kivétel sikeressége
     */
    public boolean anyagKivesz(Anyagok anyagokKi) {
        return anyagok.kivesz(anyagokKi);
    }

    /**
     * Növeli a táska kapacitását a paraméterként kapott
     * értékkel.
     * @param ertek A növekmény értéke
     */
    public void kapacitasNovel(int ertek) {
        kapacitas += ertek;

        if (telitettseg() > kapacitas) {
            tartalomCsokkentes();
        }
     }

    /**
     * Belerakja az ágenst a táskába, ha belerakható.
     * @param agens Ágens, amit berak a táskába
     * @return A táskába rakás sikeressége
     */
    public boolean agensBerak(Agens agens) {
 
        if (telitettseg() + agens.koltseg().meret() < kapacitas) {
            agensek.add(agens);
            return true;
        }
        return false;
    }

    /**
     * Kiveszi a táskából a paraméterként kapott ágenst.
     * @param agens Az ágens, amit kivesz a táskából
     */
    public boolean agensKivesz(Agens agens) {
        return agensek.remove(agens);
    }

    /**
     * A táskában lévő ágensek élettartamát csökkenti eggyel.
     */
    public void agensLep() {
        for (Agens agens: agensek) {
            if (!agens.ttlCsokkent()) {
                agensKivesz(agens);
            }
        }

     }

    /**
     * Megmondja, hogy a táskában mennyi a jelenleg tárolt dolgok foglalt helye.
     * Összegzi az anyagokat, és ágensek méretét.
     * @return a táskában tárolt dolgok mérete
     */
    private int telitettseg() {
        return agensek.stream().map(a -> a.koltseg().meret()).reduce(0, Integer::sum) + anyagok.meret();
    }

    private void tartalomCsokkentes() {
        //Csak anyag kivétele elég
        if (telitettseg() - kapacitas < anyagok.meret()) {
            boolean ilyen = true;
            do {
                if (ilyen) {
                    anyagok.kivesz(new Anyagok(1,0));
                }
                else {
                    anyagok.kivesz(new Anyagok(0,1));
                }
                ilyen = !ilyen;
            } while (telitettseg() > kapacitas);
        }
        //Minden anyagot ki kell venni és ágenseket is
        else {
            anyagok.kivesz(anyagok);
            do {
                agensek.remove(0);
            } while (telitettseg() > kapacitas);
        }
    }

    public int szabadHely() {
        return kapacitas - telitettseg();
    }
}
