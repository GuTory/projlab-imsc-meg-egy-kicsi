package skeleton;

import java.util.Scanner;

public class Skeleton {

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

}
