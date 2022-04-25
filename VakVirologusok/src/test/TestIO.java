package test;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * teszteléshez használt bemenetet és kimenetet összekötő osztály
 */
public class TestIO {
    /**
     * bemeneti scanner
     */
    private static Scanner inputScanner;

    /**
     * kimeneti folyam
     */
    private static PrintStream outputStream;

    /**
     * akutálisan kiadott parancs
     */
    public static String parancs[];

    /**
     * static konstruktor
     */
    static {
        try {
            //inputScanner = new Scanner(new File("tests/asd.txt"));
            inputScanner = new Scanner(System.in);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            inputScanner = new Scanner(System.in);
        }

        try {
            //outputStream = new PrintStream(new File("out.txt"));
            outputStream = new PrintStream(System.out);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            outputStream = new PrintStream(System.out);
        }
    }

    /**
     * kimenet küldése a kimeneti streamre
     * @param szoveg kimeneti string
     */
    public static void output(String szoveg) {
        outputStream.println(szoveg);
    }

    /**
     * bemenet beolvasása a bemeneti streamről
     * @return bemeneti folyam egy sora
     */
    public static String input() {
        String bemenet = inputScanner.nextLine();
        parancs = bemenet.split(" ");
        return bemenet;
    }

    /**
     * kombinált beolvasás és kiíratás
     * @param szoveg kiírandó szöveg
     * @return bemenetről érkező szöveg
     */
    public static String input(String szoveg) {
        outputStream.println(szoveg);
        return inputScanner.nextLine();
    }

    /**
     * megnézi, hogy a bemeneti folyamnak van-e még új sora
     * @return van még tobábbi sor?
     */
    public static boolean hasNext() {
        return inputScanner.hasNext();
    }

    /**
     * bemeneti folyam settere
     * @param inputScanner bemeneti folyam
     */
    public static void setInputScanner(Scanner inputScanner) {
        TestIO.inputScanner = inputScanner;
    }

    /**
     * kimeneti folyam settere
     * @param outputStream kimeneti folyam
     */
    public static void setOutputStream(PrintStream outputStream) {
        TestIO.outputStream = outputStream;
    }
}
