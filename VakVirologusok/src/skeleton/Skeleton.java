package skeleton;

import java.util.Scanner;

public class Skeleton {

    /**
     * <h3>Használat:</h3>
     *
     * Függvény elején:
     * Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
     *
     * Függvény végén:
     * Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
     *
     * Kérdés:
     * String tudFelvenni = Skeleton.dontes("Tud felvenni felszerelest? (i - IGEN/n - Nem)");
     * **/

    private static String tabs = "";

    public static void metodusEleje(String metodusNev) {
        System.out.println(tabs + metodusNev + " metodus eleje");
        tabs += "   ";
    }

    public static void metodusVege(String metodusNev) {
        tabs = tabs.substring(0, tabs.length()-3);
        System.out.println(tabs + metodusNev + " metodus vege");
    }

    public static String dontes(String kerdes) {
        System.out.println(tabs + kerdes);
        System.out.print(tabs);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static boolean igenNem(String kerdes){
        System.out.println(tabs + kerdes + " (i - IGEN/n - Nem)");
        System.out.print(tabs);
        Scanner sc = new Scanner(System.in);
        if(sc.equals("i") || sc.equals("")) return true;
        return false;
    }

}
