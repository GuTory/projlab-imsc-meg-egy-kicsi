package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import jdk.jshell.spi.ExecutionControl;
import lombok.Setter;
import lombok.Getter;
import terkep.Mezo;
import util.Anyagok;
import util.Taska;
import skeleton.Skeleton;

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

    private Ellenallas[] ellenallasok;

    @Getter
    private Taska taska;

    @Setter
    private Mezo hely;

    public Virologus() {
        kodok = new ArrayList<>();

        alapViselkedes = new Viselkedes();
        alternativViselkedesek = new LinkedList<>();

        ellenallasok = new Ellenallas[3];
        ellenallasok[Visszadob] = new Visszadob();
        ellenallasok[TeljesSzazalekos] = new Szazalekos(100);
        ellenallasok[ReszlegesSzazalekos] = new Szazalekos(82.3);

        taska = new Taska(this);
    }

    private Viselkedes jelenlegiViselkedes() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Viselkedes sorbol = alternativViselkedesek.pollFirst();

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return sorbol != null ? sorbol : alapViselkedes;
    }

    /**
     * Elkezdi a virológus körét, meghívja a Cselekmenynek az összes metódusát amivel a
     * játékos irányíthatja a virológust (mozog, lop, ken, stb.) és amit a játékos tenni is szeretne vele.
     */
    public void kor() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");

    }

    /**
     * Megtanulja azt a kódot, amit paraméterként kap.
     * @param kod a megtanulni kívánt kód.
     */
    public void kodMegtanul(Kod kod) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        kodok.add(kod);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Elfelejti az összes eddig megtanult kódot.
     */
    public void kodFelejt() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        kodok = new ArrayList<>();

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Megken egy másik virológust, a nála
     * lévő ágensek valamelyikével.
     * @param keno a kenést végző virológus.
     * @param mivel a virológusra kent ágens
     */
    public void megkent(Virologus keno, Agens mivel) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

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

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Kiveszi a felszerelést a táskából.
     * @param felszereles a kivenni kívánt felszerelés
     */
    public void kiFelszereles(Felszereles felszereles) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        felszereles.le(this, taska);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Beteszi a felszerelést a táskába.
     * @param felszereles a betenni kívánt felszerelés
     */
    public void beFelszereles(Felszereles felszereles) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        felszereles.fel(this, taska);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Meghívja a Viselkedes taskaElvesz(Virologus v) metódusát, és
     * ha a virológus bénult állapotban van, akkor visszaadja a virológus táskáját.
     * @return taska, ha a virológus bénult, egyébként null
     */
    public Taska taskaElvesz() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return jelenlegiViselkedes().taskaElvehetoE() ? taska : null;
    }

    /**
     * A kapott viselkedést beteszi az alternatív viselkedések sorába és összefésüli a prioritásuk szerint.
     * @param korok hányszor tegye be a kapott viselkedést a sorba.
     * @param uj a viselkedés, ami szerint viselkedni fog a virológus a következő körökben.
     */
    public void addViselkedes(int korok, Viselkedes uj) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

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

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
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
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if (id != Visszadob && id != TeljesSzazalekos && id != ReszlegesSzazalekos) throw new IndexOutOfBoundsException("Használd a publikus int-eket az indexelésre!");
        ellenallasok[id].setErvenyesseg(szint);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * A virológus által kiválasztott mezőre lép.
     */
    public void mozog() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        //jelenlegiViselkedes().mozog(this, hely);

        Viselkedes viselkedes;

        String allapot = Skeleton.dontes("Milyen állapotban van a virológus? (a - ALAP, b - bénult, v - vitustánc)");

        if (allapot.equals("b")) {
            viselkedes = new BenultViselkedes();
        } else if (allapot.equals("v")) {
            viselkedes = new VitustancViselkedes();
        } else {
            viselkedes = new Viselkedes();
        }

        viselkedes.mozog(this, hely);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Visszaadja az attribútumban szereplő virológustól
     * ellopható anyagokat.
     * @param kitol az a virológus akitől lopni akar
     */
    public void anyagLop(Virologus kitol) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Anyagok lopott = jelenlegiViselkedes().anyagLop(kitol);
        if (lopott != null) taska.anyagBerak(lopott);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     */
    public void felszerelesLop(Virologus kitol) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Felszereles lopott = jelenlegiViselkedes().felszerelesLop(kitol);
        if (lopott != null) {
            kitol.kiFelszereles(lopott);
            beFelszereles(lopott);
        }

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     */
    public void agensLop(Virologus kitol) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Agens lopott = jelenlegiViselkedes().agensLop(kitol);
        if (lopott != null) taska.agensBerak(lopott);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * A virológus meg tud kenni valakit, aki egy mezőn áll vele.
     * @param ki a kenő virológus
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     */
    public void ken(Virologus ki, Virologus kit, Agens mivel) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        jelenlegiViselkedes().ken(ki, kit, mivel);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Létrehoz egy ágenst, majd visszaadja azt.
     * @param kod a kód ami alapján az ágenst létre akarja hozni
     */
    public void agensEbbol(Kod kod) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Agens keszitett = jelenlegiViselkedes().agensEbbol(kod, taska);
        if (keszitett != null) taska.agensBerak(keszitett);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
