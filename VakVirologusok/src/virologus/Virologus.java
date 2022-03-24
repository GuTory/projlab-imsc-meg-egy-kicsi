package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import jdk.jshell.spi.ExecutionControl;
import lombok.Setter;
import lombok.Getter;
import terkep.Mezo;
import util.Taska;
import skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
    private Queue<Viselkedes> alternativViselkedesek;

    private Ellenallas[] ellenallasok;

    @Getter
    private Taska taska;

    @Setter
    private Mezo hely;

    public Virologus() {
        kodok = new ArrayList<>();

        alapViselkedes = new Viselkedes();
        alternativViselkedesek = new PriorityQueue<>();

        ellenallasok = new Ellenallas[3];   //TODO: ezeknek a kostruktorának helyes beállítása
        /*ellenallasok[Visszadob] = new Visszadob();
        ellenallasok[TeljesSzazalekos] = new Szazalekos();
        ellenallasok[ReszlegesSzazalekos] = new Szazalekos();*/

        taska = new Taska();
    }

    /**
     * Elkezdi a virológus körét, meghívja a Cselekmenynek az összes metódusát amivel a játékos irányíthatja a virológust (mozog, lop, ken, stb.) és amit a játékos tenni is szeretne vele.
     */
    public void kor() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * Megtanulja azt a kódot, amit paraméterként kap.
     * @param kod a megtanulni kívánt kód.
     */
    public void kodMegtanul(Kod kod) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");

    }

    /**
     * Elfelejti az összes eddig megtanult kódot.
     */
    public void kodFelejt() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");

    }

    /**
     * Megken egy másik virológust, a nála
     * lévő ágensek valamelyikével.
     * @param keno a kenést végző virológus.
     * @param mivel a virológusra kent ágens
     */
    public void megkent(Virologus keno, Agens mivel) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * Kiveszi a felszerelést a táskából.
     * @param felszereles a kivenni kívánt felszerelés
     */
    public void kiFelszereles(Felszereles felszereles) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");

    }

    /**
     * Beteszi a felszerelést a táskába.
     * @param felszereles a betenni kívánt felszerelés
     */
    public void beFelszereles(Felszereles felszereles) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");

    }

    /**
     * Meghívja a Viselkedes taskaElvesz(Virologus v) metódusát, és
     * ha a virológus bénult állapotban van, akkor visszaadja a virológus táskáját.
     * @return taska, ha a virológus bénult, egyébként null
     */
    public Taska taskaElvesz() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * A kapott viselkedést beteszi az alternatív viselkedések sorába és összefésüli a prioritásuk szerint.
     * @param korok hányszor tegye be a kapott viselkedést a sorba.
     * @param uj a viselkedés, ami szerint viselkedni fog a virológus a következő körökben.
     */
    public void addViselkedes(int korok, Viselkedes uj) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * Beállítja az adott id-jú ellenállás érvényességét egy megfelelő szintre.
     * <li>-1: végtelen körig érvényes az ellenállás</li>
     * <li>0: nem érvényes az ellenállás</li>
     * <li>>0: csak ennyi körig érvényes az ellenállás</li>
     * @param id az ellenállás id-ja. Kódolhataó a Virologus osztály publikus integerjeivel.
     * @param szint a védelmi szint.
     */
    public void setEllenallasErvenyesseg(int id, int szint) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * A virológus által kiválasztott mezőre lép.
     */
    public void mozog() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * Visszaadja az attribútumban szereplő virológustól
     * ellopható anyagokat.
     * @param kitol az a virológus akitől lopni akar
     */
    public void anyagLop(Virologus kitol) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     */
    public void felszerelesLop(Virologus kitol) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     */
    public void agensLop(Virologus kitol) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * A virológus meg tud kenni valakit, aki egy mezőn áll vele.
     * @param ki a kenő virológus
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     */
    public void ken(Virologus ki, Virologus kit, Agens mivel) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * Létrehoz egy ágenst, majd visszaadja azt.
     * @param kod a kód ami alapján az ágenst létre akarja hozni
     */
    public void agensEbbol(Kod kod) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }
}
