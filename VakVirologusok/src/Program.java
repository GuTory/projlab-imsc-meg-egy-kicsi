import agens.*;
import felszereles.Felszereles;
import felszereles.Kesztyu;
import felszereles.Kopeny;
import felszereles.Zsak;
import skeleton.Skeleton;
import terkep.Labor;
import terkep.Mezo;
import util.Anyagok;
import virologus.Virologus;
import virologus.Viselkedes;
import virologus.VitustancViselkedes;

import java.util.ArrayList;




public class Program {

    public static void clrscr(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void main(String[] args){
        int teszt = Integer.parseInt(Skeleton.dontes("Mit tesztelsz? (csak szám)\n" +
                "0: testAgensEbbol\n" +
                "1: testKen\n" +
                "2: testKesztyusKenes\n" +
                "3: testMozog\n" +
                "4: testAgensLep\n" +
                "5: testLop"));
        switch (teszt) {
            case 0:
                testAgensEbbol();
                break;
            case 1:
                testKen();
                break;
            case 2:
                testKesztyusKenes();
                break;
            case 3:
                testMozog();
                break;
            case 4:
                testAgensLep();
                break;
            case 5:
                testLop();
                break;
            default:
                break;
        }
    }

    private static void testAgensEbbol() {
        Virologus v1 = new Virologus();
        Kod k;
        String mit = Skeleton.dontes("Mit készítesz fel? f - felejto, i - vitustanc, e - vedelem, b - benito");
        switch (mit) {
            case "f":
                k = new Felejto(1, new Anyagok(1,1), 1, 1);
                break;
            case "i":
                k = new Vitustanc(1, new Anyagok(1,1), 1, 1);
                break;
            case "e":
                k = new Vedelem(1, new Anyagok(1,1), 1, 1);
                break;
            default:
                k = new Benito(1, new Anyagok(1,1), 1, 1);
                break;
        }
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
        String mit = Skeleton.dontes("Mit lopsz? g - agens, n - anyag, f - felszereles");
        switch (mit) {
            case "g":
                v2.getTaska().getAgensek().add(new Agens(new Benito(1, new Anyagok(1, 1), 1, 1)));
                clrscr();
                v1.agensLop(v2);
                break;
            case "n":
                v1.anyagLop(v2);
                break;
            case "f":
                v2.getTaska().getFelszerelesek().add(new Kopeny());
                clrscr();
                v1.felszerelesLop(v2);
                break;
            default:
                System.out.println("Hiba");
                break;
        }
    }

    /*private static void test() {

    }

    private static void test() {

    }

    private static void test() {

    }

    private static void test() {

    }*/


}
