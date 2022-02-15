package info.mathe;

public class Vorzeichen {

    /**
     * Method to evaluate whether a given {@code input} is {@code true} or {@code false}.
     *
     * @param input Input to evaluate
     * @return -1, 1 or 0 depending on whether the input is negative, positive or 0
     */
    public static int vorzeichen(int input) {
        return input == 0 ? 0 : input / Math.abs(input);
        // return input == 0 ? 0 : (input < 0 ? -1 : 1);
    }

}
