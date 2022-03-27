import agens.*;
import felszereles.Kesztyu;
import skeleton.Skeleton;
import terkep.Labor;
import terkep.Mezo;
import terkep.Ovohely;
import terkep.Raktar;
import util.Anyagok;
import util.Taska;
import virologus.Virologus;
import virologus.Viselkedes;
import virologus.VitustancViselkedes;

import java.rmi.MarshalledObject;
import java.util.ArrayList;

import java.io.IOException;



public class Program {

    public static void clrscr(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void main(String[] args){
        //testAgensEbbol();
        //testKen();
        //testKesztyusKenes();
        testMozog();
        //testAgensLep();
        //testLop();
    }

    private static void testAgensEbbol() {
        Virologus v1 = new Virologus();
        Kod k = new Vitustanc(1, new Anyagok(1,1), 1, 1);
        v1.agensEbbol(k);
    }

    private static void testKen() {
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Kod k = new Benito(1, new Anyagok(1,1), 1, 1);
        v1.ken(v1, v2, new Agens(k));
    }

    private static void testKesztyusKenes(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Kod k = new Benito(1, new Anyagok(1,1), 1, 1);
        v1.setEllenallasErvenyesseg(v1.Visszadob, -1);
        v2.setEllenallasErvenyesseg(v2.Visszadob, -1);
        Agens agens = new Agens(k);
        clrscr();
        v1.ken(v1, v2, agens);
    }

    private static void testMozog() {
        Virologus v1 = new Virologus();
        Mezo m1 = new Mezo();
        Mezo m2 = new Mezo();
        m1.setSzomszedok(new ArrayList<>());
        m1.getSzomszedok().add(m2);
        v1.setHely(m1);
        v1.mozog();
    }

    private static void testMozogLabor() {
        Virologus v1 = new Virologus();
        Mezo mezo = new Mezo();
        Labor labor = new Labor();
        labor.setKod(new Benito(1, new Anyagok(1, 1), 1, 1));
        mezo.setSzomszedok(new ArrayList<>());
        mezo.getSzomszedok().add(labor);
        v1.setHely(mezo);
        Viselkedes viselkedes = new VitustancViselkedes();
        viselkedes.mozog(v1, mezo);
    }

    private static void testAgensLep() {
        Virologus v1 = new Virologus();
        Kod k = new Benito(1, new Anyagok(1, 1), 1, 1);
        Agens agens = new Agens(k);
        v1.getTaska().agensBerak(agens);
        v1.getTaska().agensLep();
    }

    private static void testLop() {
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        v1.anyagLop(v2);
    }

    /*private static void test() {

    }

    private static void test() {

    }

    private static void test() {

    }

    private static void test() {

    }

    private static void test() {

    }*/


}
