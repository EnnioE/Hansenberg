package info.mathe;

import java.util.Scanner;

public class Primzahlen {

    public static boolean istPrimzahl(int p) throws RuntimeException {
        try {
            return istPrimzahl(p, p / 2);
        } catch (StackOverflowError e) {
            throw new RuntimeException("Deine Zahl war zu groß :)");
        }
    }

    public static boolean istPrimzahl(int p, int n) {
        if (n == 1) {
            return true;
        }
        if (p % n == 0) {
            return false;
        }
        return istPrimzahl(p, n - 1);
    }

    public static void main(String[] args) {
        int b = 199997;
        System.out.println(istPrimzahl(b));

        /*int a = (int)(Math.random()*9+2);
        System.out.println(a);
        System.out.println(istPrimzahl(a));*/

    }

}
