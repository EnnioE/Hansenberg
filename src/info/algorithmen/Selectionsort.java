package info.algorithmen;

import info.sonstiges.Zufallszahlen;

public class Selectionsort {
    public static void main(String[] args) {
        int[] unsortiert = Zufallszahlen.generate(100000,0,1000000);
        for (int i : unsortiert) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : selectionsort(unsortiert)) {
            System.out.println(i);
        }
    }

    public static int[] selectionsort(int[] unsortiert) {
        for (int i = 0; i < unsortiert.length - 1; i++) {
            for (int j = i + 1; j < unsortiert.length; j++) {
                if (unsortiert[j] < unsortiert[i]) {
                    int temp = unsortiert[i];
                    unsortiert[i] = unsortiert[j];
                    unsortiert[j] = temp;
                }
            }
        }
        return unsortiert;
    }
}
