package info.rekursion;

import java.util.Scanner;

public class Fakultaet {
    public static int nFakultaet(int n) {
        if (n > 1) {
        return n*nFakultaet(n-1);
        }
        return 1;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println(nFakultaet(n));
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }
}
