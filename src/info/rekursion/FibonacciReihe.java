package info.rekursion;

import java.util.Scanner;

public class FibonacciReihe {
    public static int nFib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return nFib(n - 1) + nFib(n - 2);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println(nFib(n));
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }
}