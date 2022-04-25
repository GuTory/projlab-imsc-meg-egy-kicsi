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

    /**
     * metódus eleje, nem használjuk ezt az osztályt
     * @param metodusNev metódus neve
     */
    public static void metodusEleje(String metodusNev) {
        System.out.println(tabs + metodusNev + " metodus eleje");
        tabs += "   ";
    }

    /**
     * metódus vége, nem használjuk ezt az osztályt
     * @param metodusNev metódus neve
     */
    public static void metodusVege(String metodusNev) {
        tabs = tabs.substring(0, tabs.length()-3);
        System.out.println(tabs + metodusNev + " metodus vege");
    }

    /**
     * Döntés, nem használjuk
     * @param kerdes
     * @return
     */
    public static String dontes(String kerdes) {
        System.out.println(tabs + kerdes);
        System.out.print(tabs);
        Scanner sc = new Scanner(System.in);
        String valasz = sc.nextLine();
        return valasz;
    }

    /**
     * igen-nem döntés
     * @param kerdes kérdés
     * @return igen?
     */
    public static boolean igenNem(String kerdes){
        System.out.println(tabs + kerdes + " (i: IGEN/n: nem)");
        System.out.print(tabs);
        Scanner sc = new Scanner(System.in);
        String valasz = sc.nextLine();
        if (valasz.equals("i") || valasz.equals("")) return true;
        return false;
    }
}
