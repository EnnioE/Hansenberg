package info.testing;

import java.util.Scanner;

public class EinmalX {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wählen Sie bitte ihr 'x' im Bereich von 1 bis 200.");
        int x;
        do {
            x = scanner.nextInt();
        } while (x < 1 || x > 200);
        for (int i = 1; i < 11; i++) {
            System.out.println(i + " x " + x + " = " + i * x);
        }
    }

}
