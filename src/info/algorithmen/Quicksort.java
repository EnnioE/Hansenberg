package info.algorithmen;

public class Quicksort {

    public static int[] Liste = {3, 9, 0, 2, 1, 12 ,5};

    public int[] quicksort(int l, int r) {
        if (l < r) {
            int t = teilen(l, r);
            quicksort(l, t);
            quicksort(t + 1, r);
        }
        return Liste;
    }

    public int teilen(int l, int r) {
        int i, j;
        int pivot = Liste[(l + r) / 2];
        i = l - 1;
        j = r + 1;
        while (true) {
            do {
                i++;
            } while (Liste[i] < pivot);
            do {
                j--;
            } while (Liste[j] > pivot);
            if (i < j) {
                int a = Liste[i];
                Liste[i] = Liste[j];
                Liste[j] = a;
            } else {
                return j;
            }
        }
    }

    public static void main(String[] args) {
        Quicksort unsortiert = new Quicksort();
        int[] arr = unsortiert.quicksort(0, Liste.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}