package info.mathe;

public class Ggt {

    /**
     * Method to evaluate the greatest common divisor of two integers.
     *
     * @param a,b Two integers
     * @return the GCD of a and b
     */
    public static int ggT(int a, int b) {
        if (b == 0) return a;
        return ggT(b, a % b);
    }

}
