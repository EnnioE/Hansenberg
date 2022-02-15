package info.mathe;

import java.util.Scanner;

public class PrimzahlenEinfach {
    public static boolean istPrimzahl(int p) throws RuntimeException {
        return istPrimzahl(p, p / 2);
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
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println(istPrimzahl(n));
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }
}
