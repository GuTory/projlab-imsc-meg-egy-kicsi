package util;

import agens.Agens;
import felszereles.Felszereles;
import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import skeleton.Skeleton;
import virologus.Virologus;

import java.util.ArrayList;
import java.util.List;

public class Taska {

    /**
     * A táska tulajdonosa
     */
    private Virologus virologus;

    /**
     * Táskában levő anyagok mennyiségének maximuma
     */
    private int maxAnyagok = 50;

    /**
     * Táskában levő anyagok
     */
    private Anyagok anyagok;

    /**
     * Táskában levő elkészített ágensek
     */
    @Getter
    private List<Agens> agensek;

    /**
     * A táskában levő felszerelések, ezek értelmezés szerint rajta vannak a tulajdonos virológuson
     */
    @Getter
    private List<Felszereles> felszerelesek;

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
     */
    public void felszerelesBerak(Felszereles felszereles) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Kiveszi a paraméterként kapott felszerelést a
     * táskából.
     * @param felszereles Felszerelés, amelyet kivesz a táskából
     */
    public void felszerelesKivesz(Felszereles felszereles) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Berakja a táskába a paraméterként kapott anyagot.
     * @param anyagok Az anyag, amit berak a táskába
     * @return A berakás sikeressége
     */
    public boolean anyagBerak(Anyagok anyagok) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean siker = anyagok.betesz(anyagok);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return siker;
    }

    /**
     * Kiveszi a táskából a paraméterként kapott anyaggal
     * megegyező mennyiségű anyagot, ha lehetséges.
     * @param anyagokKi A kivenni kívánt anyagok.
     * @return A kivétel sikeressége
     */
    public boolean anyagKivesz(Anyagok anyagokKi) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean siker = anyagok.kivesz(anyagokKi);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return siker;
    }

    /**
     * Növeli a táska kapacitását a paraméterként kapott
     * értékkel.
     * @param ertek A növekmény értéke
     */
    public void kapacitasNovel(int ertek) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Belerakja az ágenst a táskába, ha belerakható.
     * @param agens Ágens, amit berak a táskába
     * @return A táskába rakás sikeressége
     */
    public boolean agensBerak(Agens agens) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean siker = Skeleton.igenNem("Be tud rakni ennyi ágenst a táskába?");

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return siker;
    }

    /**
     * Kiveszi a táskából a paraméterként kapott ágenst.
     * @param agens Az ágens, amit kivesz a táskából
     */
    public void agensKivesz(Agens agens) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * A táskában lévő ágensek élettartamát csökkenti eggyel.
     */
    public void agensLep() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        for (Agens agens: agensek) {
            if (!agens.ttlCsokkent()) {
                agensKivesz(agens);
            }
        }

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }


}
