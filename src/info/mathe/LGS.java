package info.mathe;

import java.util.Scanner;

public class LGS {
    int size;
    double[][] val;
    double[] sol;

    public LGS(int size) {
        this.size = size;
        this.val = new double[size][size + 1];
        this.sol = new double[size];
    }

    public void initialize() {
        Scanner s = new Scanner(System.in);
        System.out.println("Geben Sie bitte die Koeffizienten ein");
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < val[i].length; j++)
                val[i][j] = s.nextInt();
        }
    }

    public void printLGS() {
        int j = val[0].length;
        switch (this.size) {
            case 2 -> {
                for (double[] doubles : val) {
                    System.out.println((int) doubles[j - 3] + "x + " + (int) doubles[j - 2] + "y = " + (int) doubles[j - 1]);
                }
            }
            case 3 -> {
                for (double[] doubles : val) {
                    System.out.println((int) doubles[j - 4] + "x + " + (int) doubles[j - 3] + "y + " + (int) doubles[j - 2] + "z = " + (int) doubles[j - 1]);
                }
            }

        }
        System.out.println("------------------------------------");
    }

    public void solve() {
        sol[1] = (val[0][0] * val[1][2] - val[0][2] * val[1][0]) / (val[0][0] * val[1][1] - val[0][1] * val[1][0]);
        sol[0] = (val[0][2] - val[0][1] * sol[1]) / val[0][0];

        System.out.println("Die Lösungen des LGS sind x = " + sol[0] + " und y = " + sol[1]);
    }

    public static void main(String[] args) {
        LGS meinLGS = new LGS(2);
        meinLGS.initialize();
        meinLGS.printLGS();
        meinLGS.solve();
    }

}

