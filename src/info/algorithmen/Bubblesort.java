package info.algorithmen;

import info.sonstiges.Zufallszahlen;

public class Bubblesort {
    public static void main(String[] args) {
        int[] unsortiert = Zufallszahlen.generate(10,0,100);
        for (int i : unsortiert) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : bubblesort(unsortiert)) {
            System.out.println(i);
        }
    }

    public static int[] bubblesort(int[] unsortiert) {
        for (int a = unsortiert.length; a > 0; a--) {
            for (int b = 0; b < a - 1; b++) {
                if (unsortiert[b] > unsortiert[b + 1]) {
                    int temp = unsortiert[b];
                    unsortiert[b] = unsortiert[b + 1];
                    unsortiert[b + 1] = temp;
                }
            }

        }
        return unsortiert;
    }
}
