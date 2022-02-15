package info.sonstiges;

public class Zufallszahlen {

    /**
     * Method to create an {@code array} of {@code n} random numbers.
     *
     * @param n   Amount of random numbers
     * @param min Lowest  possible random number
     * @param max Highest  possible random number
     * @return created Array of n integers
     */
    public static int[] generate(int n, int min, int max) {
        int[] zahl = new int[n];
        for (int i = 0; i < n; i++) {
            zahl[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return zahl;
    }

}
