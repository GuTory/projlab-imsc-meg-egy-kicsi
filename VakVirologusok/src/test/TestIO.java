package test;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class TestIO {
    private static Scanner inputScanner;
    private static PrintStream outputStream;
    public static String parancs[];

    static {
        try {
            //inputScanner = new Scanner(new File("in.txt"));
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

    public static void output(String szoveg) {
        outputStream.println(szoveg);
    }

    public static String input() {
        String bemenet = inputScanner.nextLine();
        parancs = bemenet.split(" ");
        return bemenet;
    }

    public static String input(String szoveg) {
        outputStream.println(szoveg);
        return inputScanner.nextLine();
    }

    public static boolean hasNext() {
        return inputScanner.hasNext();
    }

    public static void setInputScanner(Scanner inputScanner) {
        TestIO.inputScanner = inputScanner;
    }

    public static void setOutputStream(PrintStream outputStream) {
        TestIO.outputStream = outputStream;
    }
}
