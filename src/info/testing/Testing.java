package info.testing;

import info.algorithmen.Quicksort;
import info.datenstrukturen.LinkedList.*;
import info.sonstiges.Zufallszahlen;

import java.util.LinkedList;

public class Testing {

    public static void main(String[] args) {
        Quicksort arr1 = new Quicksort();
        int[] arr = arr1.quicksort(0, 6);
        for (int i : arr) {
            System.out.println(i);
        }
        int[] z = Zufallszahlen.generate(10000, 5, 20);
        boolean zahl = false;
        for (int i : z) {
            System.out.println(i);
            if (i == 20) {
                zahl = true;
            }
        }
        System.out.println(zahl);
    }
}
