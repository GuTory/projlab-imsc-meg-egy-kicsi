import agens.*;
import felszereles.Kopeny;
import jatek.Jatek;
import skeleton.Skeleton;
import terkep.Mezo;
import util.Anyagok;
import virologus.Virologus;

import java.util.ArrayList;

public class SkeletonProgram {

    public static void clrscr(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void main(String[] args){
        Jatek.jatekIndit();
        if (true) return;
        int teszt = Integer.parseInt(Skeleton.dontes("Mit tesztelsz? (csak szám)\n" +
                "0: jatekIndit\n" +
                "1: testAgensEbbol\n" +
                "2: testKen\n" +
                "3: testMozog\n" +
                "4: testAgensLep\n" +
                "5: testLop"));
        switch (teszt) {
            case 0:
                testJatekIndit();
                break;
            case 1:
                testAgensEbbol();
                break;
            case 2:
                testKen();
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

    private static void testJatekIndit() {
        Jatek.jatekIndit();
    }

    private static void testAgensEbbol() {
        Virologus v1 = new Virologus();
        Kod k;
        clrscr();
        String mit = Skeleton.dontes("Mit készítesz el? (b: BENITO/f: felejto/i: vitustanc/e: vedelem");
        switch (mit) {
            case "f":
                k = new Felejto( new Anyagok(1,1), 1, 1);
                break;
            case "i":
                k = new Vitustanc( new Anyagok(1,1), 1, 1);
                break;
            case "e":
                k = new Vedelem( new Anyagok(1,1), 1, 1);
                break;
            default:
                k = new Benito( new Anyagok(1,1), 1, 1);
                break;
        }
        clrscr();
        v1.agensEbbol(k);
    }

    private static void testKen() {
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Kod k = new Benito( new Anyagok(1,1), 1, 1);
        Agens agens = new Agens(k);
        clrscr();
        v1.ken(v2, agens);
    }

    private static void testMozog() {
        Virologus v1 = new Virologus();
        Mezo m1 = new Mezo();
        Mezo m2 = new Mezo();
        m1.setSzomszedok(new ArrayList<>());
        m1.getSzomszedok().add(m2);
        v1.setHely(m1);
        clrscr();
        v1.mozog();
    }

    private static void testAgensLep() {
        Virologus v1 = new Virologus();
        Kod k = new Benito( new Anyagok(1, 1), 1, 1);
        Agens agens = new Agens(k);
        clrscr();
        v1.getTaska().agensBerak(agens);
        v1.getTaska().agensLep();
    }

    private static void testLop() {
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        clrscr();
        String mit = Skeleton.dontes("Mit lopsz? (g: AGENS/n: anyag/f: felszereles)");
        switch (mit) {
            case "n":
                v1.anyagLop(v2);
                break;
            case "f":
                v2.getTaska().getFelszerelesek().add(new Kopeny());
                clrscr();
                v1.felszerelesLop(v2);
                break;
            default:
                v2.getTaska().getAgensek().add(new Agens(new Benito( new Anyagok(1, 1), 1, 1)));
                clrscr();
                v1.agensLop(v2);
                break;
        }
    }

}
