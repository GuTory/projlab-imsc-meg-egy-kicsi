package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import terkep.Mezo;
import test.TestIO;
import util.Anyagok;
import util.Taska;

import java.util.*;

/**
 * A játékos által irányított osztály, melynek meg kell tanulnia az összes kódot, hogy véget érjen a játék.
 * Van a virológusnak táskája, cselekménye és védelme. Ez az osztály hajtja/hajtatja végre a játékos által indított cselekvéseket.
 */
public class Virologus {

    public final String TestNev;
    protected static int TestID = 1;

    public int Visszadob = 0;
    public int TeljesSzazalekos = 1;
    public int ReszlegesSzazalekos = 2;

    private List<Kod> kodok;

    public List<Kod> getKodok() { return kodok; }

    /**Alap viselkedés: így viselkedik a virológus, amikor üres az alternatív viselkedések sor.**/
    private Viselkedes alapViselkedes;
    /**Alternativ viselkedések, amikor a lista nem üres, a virológus az elejéről levesz egy viselkedést és a szerint cselekszik a körben.<br>
    PriorityQueue
     <li>add(elem) hozzáad a sor végéhez</li>
     <li>poll() visszaadja és le is veszi az első elemet a sorból</li>**/
    private LinkedList<Viselkedes> alternativViselkedesek;

    public LinkedList<Viselkedes> getAlternativViselkedesek() { return alternativViselkedesek; }

    private Viselkedes jelenlegiViselkedes;

    private Ellenallas[] ellenallasok;

    private Taska taska;

    public Taska getTaska() { return taska; }

    private Mezo hely;

    public Mezo getHely() { return hely; }

    public Virologus() {
        TestNev = "virologus" + TestID;
        TestID++;

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

     public void TestViselkedesInit(){
         Viselkedes jelenlegi = alternativViselkedesek.pollFirst();
         jelenlegiViselkedes = jelenlegi == null ? alapViselkedes : jelenlegi;
     }

    /**
     * Elkezdi a virológus körét, meghívja a Cselekmenynek az összes metódusát amivel a
     * játékos irányíthatja a virológust (mozog, lop, ken, stb.) és amit a játékos tenni is szeretne vele.
     */
    public void kor() {
        Viselkedes jelenlegi = alternativViselkedesek.pollFirst();
        jelenlegiViselkedes = jelenlegi == null ? alapViselkedes : jelenlegi;

        TestIO.output("Lépj [0-" + (hely.getSzomszedok().size()-1) + "]");
        mozog();

        List<Virologus> tobbiek = hely.getVirologusok();

        //TODO: kiszervezni a kérdéseket viselkedésbe (felesleges végigkérdezni egy halottat ezekről)
        //TODO: ID-kat kiírni mezőnél és virológusoknál
        if (TestIO.input("Akarsz anyagot lopni? [i/n]").equals("i")) {
            int kitol = Integer.parseInt(TestIO.input("Kitől szeretnél anyagot lopni? [0-" + (tobbiek.size()-1) + "] senkitől: -1"));
            while (kitol != -1) {
                if (tobbiek.get(kitol % tobbiek.size()) != this && anyagLop(tobbiek.get(kitol % tobbiek.size())))
                    TestIO.output("Sikeresen loptál anyagot.");
                else
                    TestIO.output("Nem sikerült anyagot lopni.");
                kitol = Integer.parseInt(TestIO.input("Kitől szeretnél anyagot lopni? [0-" + (tobbiek.size()-1) + "] senkitől: -1"));
            }
        }

        if (TestIO.input("Akarsz felszerelest lopni? [i/n]").equals("i")) {
            int kitol = Integer.parseInt(TestIO.input("Kitől szeretnél felszerelest lopni? [0-" + (tobbiek.size()-1) + "] senkitől: -1"));
            while (kitol != -1) {
                if (tobbiek.get(kitol % tobbiek.size()) != this && felszerelesLop(tobbiek.get(kitol % tobbiek.size())))
                    TestIO.output("Sikeresen loptál felszerelést.");
                else
                    TestIO.output("Nem sikerült felszerelést lopni.");
                kitol = Integer.parseInt(TestIO.input("Kitől szeretnél felszerelest lopni? [0-" + (tobbiek.size()-1) + "] senkitől: -1"));
            }
        }

        if (TestIO.input("Akarsz agenst lopni? [i/n]").equals("i")) {
            int kitol = Integer.parseInt(TestIO.input("Kitől szeretnél agenst lopni? [0-" + (tobbiek.size()-1) + "] senkitől: -1"));
            while (kitol != -1) {
                if (tobbiek.get(kitol % tobbiek.size()) != this && agensLop(tobbiek.get(kitol % tobbiek.size())))
                    TestIO.output("Sikeresen loptál ágenst.");
                else
                    TestIO.output("Nem sikerült ágenst lopni.");
                kitol = Integer.parseInt(TestIO.input("Kitől szeretnél agenst lopni? [0-" + (tobbiek.size()-1) + "] senkitől: -1"));
            }
        }

        if (TestIO.input("Akarsz megkenni valakit? [i/n]").equals("i")) {
            int kitol = Integer.parseInt(TestIO.input("Kit szeretnél megkenni? [0-" + (tobbiek.size()-1) + "] senkit: -1"));
            while (kitol != -1) {
                int mivel = Integer.parseInt(TestIO.input("Mivel szeretnéd megkenni? [0-" + (taska.getAgensek().size()-1) + "]"));
                if (ken(tobbiek.get(kitol % tobbiek.size()), taska.getAgensek().get(mivel % taska.getAgensek().size())))
                    TestIO.output("Sikeresen kentél.");
                else
                    TestIO.output("Nem sikerült kenni.");

                kitol = Integer.parseInt(TestIO.input("Kit szeretnél megkenni? [0-" + (tobbiek.size()-1) + "] senkit: -1"));
            }
        }

        if (TestIO.input("Akarsz ágenst létrehozni? [i/n]").equals("i")) {
            int mibol = Integer.parseInt(TestIO.input("Miből szeretnél ágenst létrehozni? [0-" + (kodok.size()-1) + "] semelyikből: -1"));
            while (mibol != -1) {
                if (agensEbbol(kodok.get(mibol % kodok.size())))
                    TestIO.output("Sikeresen létrehoztál ágenst.");
                else
                    TestIO.output("Nem sikerült ágenst létrehozni.");
                mibol = Integer.parseInt(TestIO.input("Miből szeretnél ágenst létrehozni? [0-" + (kodok.size()-1) + "] semelyikből: -1"));
            }
        }

        if (TestIO.input("Akarsz támadni? [i/n]").equals("i")) {
            int kitol = Integer.parseInt(TestIO.input("Kit szeretnél megtámadni? [0-" + (tobbiek.size()-1) + "] senkit: -1"));
            while (kitol != -1) {
                if (tobbiek.get(kitol % tobbiek.size()) != this && tamad(tobbiek.get(kitol % tobbiek.size())))
                    TestIO.output("Sikeresen támadtál.");
                else
                    TestIO.output("Nem sikerült támadni.");
                kitol = Integer.parseInt(TestIO.input("Kit szeretnél megtámadni? [0-" + (tobbiek.size()-1) + "] senkit: -1"));
            }
        }
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
    public boolean megkent(Virologus keno, Agens mivel) {
        if (keno == this) {
            mivel.hatas(this);
            return true;
        }

        boolean siker = true;
        for (Ellenallas ellenallas : ellenallasok) {
            siker = ellenallas.megkent(keno, this, mivel);
            if (!siker) break;
        }

        if (siker) {
            mivel.hatas(this);
        }
        return siker;
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
                    if (i == 0) {
                        jelenlegiViselkedes = uj;
                    }
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
    public boolean mozog() {
        //TestViselkedesInit();
        return jelenlegiViselkedes.mozog();
     }

    /**
     * Visszaadja az attribútumban szereplő virológustól
     * ellopható anyagokat.
     * @param kitol az a virológus akitől lopni akar
     */
    public boolean anyagLop(Virologus kitol) {
        Anyagok lopott = jelenlegiViselkedes.anyagLop(kitol);
        if (lopott != null) {
            taska.anyagBerak(lopott);
            return true;
        }
        return false;
     }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     */
    public boolean felszerelesLop(Virologus kitol) {
        Felszereles lopott = jelenlegiViselkedes.felszerelesLop(kitol);
        if (lopott != null) {
            kitol.kiFelszereles(lopott);
            beFelszereles(lopott);
            return true;
        }
        return false;
     }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     */
    public boolean agensLop(Virologus kitol) {
        Agens lopott = jelenlegiViselkedes.agensLop(kitol);
        if (lopott != null) {
            taska.agensBerak(lopott);
            return true;
        }
        return false;
     }

    /**
     * A virológus meg tud kenni valakit, aki egy mezőn áll vele.
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     */
    public boolean ken(Virologus kit, Agens mivel) {
        return jelenlegiViselkedes.ken(kit, mivel);
     }

    /**
     * Létrehoz egy ágenst, majd visszaadja azt.
     * @param kod a kód ami alapján az ágenst létre akarja hozni
     */
    public boolean agensEbbol(Kod kod) {
        Agens keszitett = jelenlegiViselkedes.agensEbbol(kod, taska);
        if (keszitett != null) {
            taska.agensBerak(keszitett);
            return true;
        }
        return false;
     }

    public boolean tamad(Virologus kit) {
        return jelenlegiViselkedes.tamad(kit);
    }

    @Override
    public String toString(){
        return "Virologus " + TestNev + ": " + jelenlegiViselkedes.toString() ;
    }
}
