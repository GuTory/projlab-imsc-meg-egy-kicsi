import agens.*;
import util.Anyagok;
import util.Taska;
import virologus.Virologus;

import java.io.IOException;



public class Program {

    public static void clrscr(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void main(String[] args){
        //testAgensEbbol();
        //testKen();
        testKesztyusKenes();
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

    /*private static void test() {

    }

    private static void test() {

    }

    private static void test() {

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
