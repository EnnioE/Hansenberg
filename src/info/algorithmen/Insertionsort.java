package info.algorithmen;

import info.sonstiges.Zufallszahlen;

public class Insertionsort {
    public static void main(String[] args) {
        int[] unsortiert = Zufallszahlen.generate(10,0,100);
        for (int i : unsortiert) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : insertionsort(unsortiert)) {
            System.out.println(i);
        }
    }

    public static int[] insertionsort(int[] unsortiert) {
        for (int i = 0; i < unsortiert.length - 1; i++) {
            int b = i + 1;
            while (b > 0 && unsortiert[b] < unsortiert[b - 1]) {
                int temp = unsortiert[b];
                unsortiert[b] = unsortiert[b - 1];
                unsortiert[b-1] = temp;
                b--;
            }
        }
        return unsortiert;
    }
}