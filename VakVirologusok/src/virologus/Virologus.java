package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import lombok.Setter;
import lombok.Getter;
import terkep.Mezo;
import util.Anyagok;
import util.Taska;

import java.util.*;

/**
 * A játékos által irányított osztály, melynek meg kell tanulnia az összes kódot, hogy véget érjen a játék.
 * Van a virológusnak táskája, cselekménye és védelme. Ez az osztály hajtja/hajtatja végre a játékos által indított cselekvéseket.
 */
public class Virologus {
    public int Visszadob = 0;
    public int TeljesSzazalekos = 1;
    public int ReszlegesSzazalekos = 2;

    private List<Kod> kodok;

    /**Alap viselkedés: így viselkedik a virológus, amikor üres az alternatív viselkedések sor.**/
    private Viselkedes alapViselkedes;
    /**Alternativ viselkedések, amikor a lista nem üres, a virológus az elejéről levesz egy viselkedést és a szerint cselekszik a körben.<br>
    PriorityQueue
     <li>add(elem) hozzáad a sor végéhez</li>
     <li>poll() visszaadja és le is veszi az első elemet a sorból</li>**/
    @Getter
    private LinkedList<Viselkedes> alternativViselkedesek;
    Viselkedes jelenlegiViselkedes;

    private Ellenallas[] ellenallasok;

    @Getter
    private Taska taska;

    @Getter
    private Mezo hely;

    public Virologus() {

        kodok = new ArrayList<>();

        alapViselkedes = new Viselkedes(this);
        alternativViselkedesek = new LinkedList<>();

        ellenallasok = new Ellenallas[3];
        ellenallasok[Visszadob] = new Visszadob();
        ellenallasok[TeljesSzazalekos] = new Szazalekos(100);
        ellenallasok[ReszlegesSzazalekos] = new Szazalekos(82.3);

        taska = new Taska(this);

    }

    public void setHely(Mezo mezo) {
        hely = mezo;
     }

    /**
     * Elkezdi a virológus körét, meghívja a Cselekmenynek az összes metódusát amivel a
     * játékos irányíthatja a virológust (mozog, lop, ken, stb.) és amit a játékos tenni is szeretne vele.
     */
    public void kor() {
        Viselkedes jelenlegi = alternativViselkedesek.pollFirst();
        jelenlegiViselkedes = jelenlegi == null ? alapViselkedes : jelenlegi;
        //TODO: miket szeretne tenni a virológus
    }

    /**
     * Megtanulja azt a kódot, amit paraméterként kap.
     * @param kod a megtanulni kívánt kód.
     */
    public void kodMegtanul(Kod kod) {
        kodok.add(kod);
     }

    /**
     * Elfelejti az összes eddig megtanult kódot.
     */
    public void kodFelejt() {
        kodok = new ArrayList<>();
     }

    /**
     * Megken egy másik virológust, a nála
     * lévő ágensek valamelyikével.
     * @param keno a kenést végző virológus.
     * @param mivel a virológusra kent ágens
     */
    public void megkent(Virologus keno, Agens mivel) {
        if (keno == this) {
            mivel.hatas(this);
            return;
        }

        boolean siker = true;
        for (Ellenallas ellenallas : ellenallasok) {
            siker = ellenallas.megkent(keno, this, mivel);
            if (!siker) break;
        }

        if (siker) {
            mivel.hatas(this);
        }
     }

    /**
     * Kiveszi a felszerelést a táskából.
     * @param felszereles a kivenni kívánt felszerelés
     */
    public void kiFelszereles(Felszereles felszereles) {
        felszereles.le(this, taska);
     }

    /**
     * Beteszi a felszerelést a táskába.
     * @param felszereles a betenni kívánt felszerelés
     */
    public void beFelszereles(Felszereles felszereles) {
        felszereles.fel(this, taska);
     }

    /**
     * Meghívja a Viselkedes taskaElvesz(Virologus v) metódusát, és
     * ha a virológus bénult állapotban van, akkor visszaadja a virológus táskáját.
     * @return taska, ha a virológus bénult, egyébként null
     */
    public Taska taskaElvesz() {
        return jelenlegiViselkedes.taskaElvehetoE() ? taska : null;
    }

    /**
     * A kapott viselkedést beteszi az alternatív viselkedések sorába és összefésüli a prioritásuk szerint.
     * @param korok hányszor tegye be a kapott viselkedést a sorba.
     * @param uj a viselkedés, ami szerint viselkedni fog a virológus a következő körökben.
     */
    public void addViselkedes(int korok, Viselkedes uj) {
        for (int i = 0; i < korok; i++) {
            try {
                Viselkedes iter = alternativViselkedesek.get(i);
                if (iter.getPrior() > uj.getPrior()) {
                    alternativViselkedesek.remove(i);
                    alternativViselkedesek.add(i, uj);
                }
            }
            catch (Exception e) {
                alternativViselkedesek.add(uj);
            }
        }
     }

    /**
     * Beállítja az adott id-jú ellenállás érvényességét egy megfelelő szintre.
     * <li>-1: végtelen körig érvényes az ellenállás</li>
     * <li>0: nem érvényes az ellenállás</li>
     * <li>>0: csak ennyi körig érvényes az ellenállás</li>
     * @param id az ellenállás id-ja. Kódolhataó a Virologus osztály publikus integerjeivel.
     * @param szint a védelmi szint.
     */
    public void setEllenallasErvenyesseg(int id, int szint) {
        if (id != Visszadob && id != TeljesSzazalekos && id != ReszlegesSzazalekos) throw new IndexOutOfBoundsException("Használd a publikus int-eket az indexelésre!");
        ellenallasok[id].setErvenyesseg(szint);
     }

    public void meghal() {
        addViselkedes(1, new HalottViselkedes(this));
    }

    /**
     * A virológus által kiválasztott mezőre lép.
     */
    public void mozog() {
        jelenlegiViselkedes.mozog();
     }

    /**
     * Visszaadja az attribútumban szereplő virológustól
     * ellopható anyagokat.
     * @param kitol az a virológus akitől lopni akar
     */
    public void anyagLop(Virologus kitol) {
        Anyagok lopott = jelenlegiViselkedes.anyagLop(kitol);
        if (lopott != null) taska.anyagBerak(lopott);
     }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     */
    public void felszerelesLop(Virologus kitol) {
        Felszereles lopott = jelenlegiViselkedes.felszerelesLop(kitol);
        if (lopott != null) {
            kitol.kiFelszereles(lopott);
            beFelszereles(lopott);
        }
     }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     */
    public void agensLop(Virologus kitol) {
        Agens lopott = jelenlegiViselkedes.agensLop(kitol);
        if (lopott != null) taska.agensBerak(lopott);
     }

    /**
     * A virológus meg tud kenni valakit, aki egy mezőn áll vele.
     * @param ki a kenő virológus
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     */
    public void ken(Virologus ki, Virologus kit, Agens mivel) {
        jelenlegiViselkedes.ken(kit, mivel);
     }

    /**
     * Létrehoz egy ágenst, majd visszaadja azt.
     * @param kod a kód ami alapján az ágenst létre akarja hozni
     */
    public void agensEbbol(Kod kod) {
        Agens keszitett = jelenlegiViselkedes.agensEbbol(kod, taska);
        if (keszitett != null) taska.agensBerak(keszitett);
     }

    public void tamad(Virologus kit) {
        jelenlegiViselkedes.tamad(kit);
    }

}
