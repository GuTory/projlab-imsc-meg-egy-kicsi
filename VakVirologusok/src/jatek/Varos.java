package jatek;

import Graphics.Publisher;
import agens.*;
import felszereles.*;
import terkep.*;
import test.TestIO;
import util.Anyagok;
import virologus.Virologus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Varos {
    /**
     * A városban található kódok összessége.
     */
    private List<Kod> kodok;

    /**
     * Beallitja a kodlistat
     * @param value az uj kodlista
     */
    public void setKodok(List<Kod> value){
        kodok = value;
    }

    /**
     * A városban található virológusok összessége.
     */
    private List<Virologus> virologusok;

    private Virologus aktivVirologus;

    /**
     * Beallitja a virologusok listajat
     * @param value az uj virologus lista
     */
    public void setVirologusok(List<Virologus> value){
        virologusok = value;
    }

    /**
     * A városban található mezők összessége.
     */
    private List<Mezo> mezok;

    /**
     * Beallitja a mezoket
     * @param value az uj mezo lista
     */
    public void setMezok(List<Mezo> value){
        mezok = value;
    }

    /**
     * A singleton peldanya az osztalynak
     */
    private static Varos instance = null;

    /**
     * Privat konstruktor.
     * @param placeholder Csak hogy meg lehessen kulonboztetni a publikus konstruktortol.
     */
     private Varos(Object placeholder){
        mezok = new ArrayList<>();
        virologusok = new ArrayList<>();
        kodok = new ArrayList<>();
        mezok.add(new Mezo());

        Labor l1 = new Labor(), l2 = new Labor(), l3 = new Labor(), l4 = new FertozoLabor();
        l1.setKod(new Benito(new Anyagok(4, 4), 3, 3));
        l2.setKod(new Felejto(new Anyagok(5, 5), 2, 2));
        l3.setKod(new Vedelem(new Anyagok(2, 2), 5, 3));
        l4.setKod(new Vitustanc(new Anyagok(3, 3), 3, 3));

        Ovohely o1 = new Ovohely(), o2 = new Ovohely(), o3 = new Ovohely(), o4 = new Ovohely();
        o1.setFelszereles(new Kesztyu());
        o1.setFelszereles(new Balta());
        o3.setFelszereles(new Kopeny());
        o4.setFelszereles(new Zsak());

        Raktar r1 = new Raktar(), r2 = new Raktar(), r3 = new Raktar();
        r1.setAnyagok(new Anyagok(4, 2));
        r2.setAnyagok(new Anyagok(7, 3));
        r3.setAnyagok(new Anyagok(1, 7));

        mezok.add(l1);
        mezok.add(l2);
        mezok.add(l3);
        mezok.add(l4);
        mezok.add(o1);
        mezok.add(o2);
        mezok.add(o3);
        mezok.add(o4);
        mezok.add(r1);
        mezok.add(r2);
        mezok.add(r3);

        mezok.get(0).setSzomszedok(new ArrayList<>(List.of(mezok.get(9), mezok.get(11), mezok.get(10))));
        mezok.get(1).setSzomszedok(new ArrayList<>(List.of(mezok.get(2), mezok.get(3), mezok.get(8), mezok.get(9))));
        mezok.get(2).setSzomszedok(new ArrayList<>(List.of(mezok.get(1), mezok.get(3), mezok.get(4), mezok.get(9), mezok.get(10))));
        mezok.get(3).setSzomszedok(new ArrayList<>(List.of(mezok.get(1), mezok.get(2), mezok.get(4), mezok.get(7), mezok.get(8))));
        mezok.get(4).setSzomszedok(new ArrayList<>(List.of(mezok.get(2), mezok.get(3), mezok.get(5), mezok.get(6), mezok.get(7), mezok.get(10), mezok.get(11))));
        mezok.get(5).setSzomszedok(new ArrayList<>(List.of(mezok.get(4), mezok.get(6), mezok.get(11))));
        mezok.get(6).setSzomszedok(new ArrayList<>(List.of(mezok.get(4), mezok.get(5), mezok.get(7))));
        mezok.get(7).setSzomszedok(new ArrayList<>(List.of(mezok.get(3), mezok.get(4), mezok.get(6), mezok.get(8))));
        mezok.get(8).setSzomszedok(new ArrayList<>(List.of(mezok.get(1), mezok.get(3), mezok.get(7))));
        mezok.get(9).setSzomszedok(new ArrayList<>(List.of(mezok.get(0), mezok.get(1), mezok.get(2), mezok.get(10))));
        mezok.get(10).setSzomszedok(new ArrayList<>(List.of(mezok.get(0), mezok.get(2), mezok.get(4), mezok.get(9), mezok.get(11))));
        mezok.get(11).setSzomszedok(new ArrayList<>(List.of(mezok.get(0), mezok.get(4), mezok.get(5), mezok.get(10))));

        /*virologusok.get(0).setHely(mezok.get(0));
        mezok.get(0).virologusBe(virologusok.get(0));
        virologusok.get(1).setHely(mezok.get(0));
        mezok.get(0).virologusBe(virologusok.get(1));
        virologusok.get(2).setHely(mezok.get(0));
        mezok.get(0).virologusBe(virologusok.get(2));
        mezok.get(0).virologusBe(virologusok.get(3));
        virologusok.get(3).setHely(mezok.get(0));

        virologusok.get(1).beFelszereles(new Kopeny());
        virologusok.get(0).beFelszereles(new Balta());
        virologusok.get(3).getTaska().anyagBerak(new Anyagok(5,5));
        virologusok.get(0).getTaska().agensBerak(new Agens(new Benito(new Anyagok(1,1),10,10)));*/

         virologusHozzad();
         aktivVirologus = virologusok.get(0);
    }

    /**
     * Publikus konstruktor, szerializaciohoz szukseges.
     */
    public Varos()
    {
        //Maradjon uresen, ez csak az XML serializaciohoz kell
    }

    public static Varos getInstance()
    {
        if(instance == null)
            instance = new Varos(null);
        return instance;
    }

    /**
     * Ellenőrzi, hogy a paraméterben kapott virológus minden kódot megtanult-e, ha igen,
     * akkor véget vet a játéknak, és kihirdeti a győztest.
     * @param virologus Vége lett-e a játéknak
     */
    public void vegeEllenoriz(Virologus virologus){
        if(kodok.size() == 0) return;
        for (Kod kod: kodok) {
            if (!virologus.getKodok().contains(kod)) {
                return;
            }
        }
        Jatek.jatekVege(virologus);
        TestIO.output("jatek vege: " + virologus.Nev + " nyert");
    }

    /**
     * Lemasolja a parameterkent megadott varost
     * @param v A Varos objektum, amit lemasol
     */
    public void copy(Varos v){
        setKodok(v.getKodok());
        setMezok(v.getMezok());
        setVirologusok(v.getVirologusok());
    }

    public void kor() {
        /*
        for (Virologus v : virologusok) {
            TestIO.output(v.TestNev);
            v.kor();
        }*/
    }

    /**
     * mezők gettere
     * @return mezők lista
     */
    public List<Mezo> getMezok() {
        return mezok;
    }

    /**
     * virológusok gettere
     * @return virológusok listája
     */
    public List<Virologus> getVirologusok() {
        return virologusok;
    }

    /**
     * kódok gettere
     * @return kódok lista
     */
    public List<Kod> getKodok() {
        return kodok;
    }

    public Virologus getActivVirologus(){ return aktivVirologus; }

    public void virologusHozzad() {
        Random random = new Random();

        Virologus virologus = new Virologus();
        virologusok.add(virologus);
        Mezo hely = mezok.get(random.nextInt(mezok.size()));
        virologus.setHely(hely);
        hely.virologusBe(virologus);
    }

    public void kovetkezoVirologus(){
        Virologus kovi = kovetkezoVirologusAllapottolFuggetlenul();
        while (kovi.getJelenlegiViselkedes().getPrior() == 2 ||
                kovi.getJelenlegiViselkedes().getPrior() == 0){
            aktivVirologus=kovi;
            kovi = kovetkezoVirologusAllapottolFuggetlenul();
        }
        aktivVirologus = kovi;
    }

    private Virologus kovetkezoVirologusAllapottolFuggetlenul(){
        int x = virologusok.indexOf(aktivVirologus);
        if(x + 1 >= virologusok.size()){
            x = 0;
            Jatek.idoTelt();
        } else x += 1;
        return virologusok.get(x);
    }
}
