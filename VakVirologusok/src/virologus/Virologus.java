package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import terkep.Mezo;
import util.Taska;
import skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import lombok.Getter;

public class Virologus {
    public int Visszadob = 0;
    public int TeljesSzazalekos = 1;
    public int ReszlegesSzazalekos = 2;

    private List<Kod> kodok;

    //alap viselkedés: így viselkedik a virológus, amikor üres az alternatív viselkedések sor.
    private Viselkedes alapViselkedes;
    //alternativ viselkedések, amikor a lista nem üres, a virológus az elejéről levesz egy viselkedést és a szerint cselekszik a körben.
    //PriorityQueue: add(elem) hozzáad a sor végéhez, poll() visszaadja és le is veszi az első elemet a sorból.
    private Queue<Viselkedes> alternativViselkedesek;

    private Ellenallas[] ellenallasok;

    @Getter private Taska taska;

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

    public void kor() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        String tudFelvenni = Skeleton.dontes("Tud felvenni felszerelest? (i - IGEN/n - NEM)");

        if (tudFelvenni.equals("")|| tudFelvenni.equals("i")) {
            beFelszereles(null);
            kiFelszereles(null);
        }

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void kodMegtanul(Kod k) {

    }

    public void kodFelejt() {

    }

    public void kiFelszereles(Felszereles f) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void beFelszereles(Felszereles f) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
