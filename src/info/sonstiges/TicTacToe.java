package info.sonstiges;

import java.util.Scanner;

public class TicTacToe {
    String player1;
    String player2;
    String winner;
    int round;
    char[] values;

    public static void main(String[] args) {
        TicTacToe meinSpiel = new TicTacToe();
        meinSpiel.loop();
    }

    public TicTacToe(){
        this.loop();
    }

    public void displayFeld() {
        System.out.println("");
        System.out.println(" " + values[0] + " | " + values[1] + " | " + values[2]);
        System.out.println("--- " + "--- " + "--- ");
        System.out.println(" " + values[3] + " | " + values[4] + " | " + values[5]);
        System.out.println("--- " + "--- " + "--- ");
        System.out.println(" " + values[6] + " | " + values[7] + " | " + values[8]);
        System.out.println("");
    }

    public void initialize() {
        this.winner = "";
        this.round = 1;
        this.values = new char[9];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name von Spieler 1: ");
        player1 = scanner.next();
        System.out.println("Name von Spieler 2: ");
        player2 = scanner.next();

        for (int i = 0; i < 9; i++) {
            values[i] = ' ';
        }

        System.out.println("Das Spiel beginnt!");
        System.out.println("Es treten an: \t Spieler 1 - " + player1 + " \t Spieler 2 - " + player2);
        displayFeld();
        System.out.println("Hinweis: Mit den Zahlen von 1-9 wählst du die Felder (beginnend links oben & endend rechts unten).");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int i;
        while (!check()) {
            do {
                i = scanner.nextInt();
            } while (i < 1 || i > 9 || values[i - 1] != ' ');
            if (round % 2 == 1) {
                values[i - 1] = 'X';
            } else {
                values[i - 1] = 'O';
            }
            displayFeld();
            round++;
            if (round == 10) {
                break;
            }
        }
        System.out.println("Das Spiel ist zu Ende!");
        if (winner.equals("")) {
            System.out.println("Unentschieden: Es gibt keinen Gewinner");
        } else {
            System.out.println("Der Gewinner ist: " + winner);
        }
    }

    public boolean checkFields(int i1, int i2, int i3) {
        if (values[i1] != ' ' && values[i1] == values[i2] && values[i2] == values[i3]) {
            if (values[i1] == 'X') {
                winner = player1;
            } else {
                winner = player2;
            }
            return true;
        }
        return false;
    }

    public boolean check() {
        boolean win = false;
        if (round < 5) {
            return false;
        }

        win = checkFields(0, 1, 2) || win;
        win = checkFields(3, 4, 5) || win;
        win = checkFields(6, 7, 8) || win;
        win = checkFields(0, 3, 6) || win;
        win = checkFields(1, 4, 7) || win;


        if (checkFields(2, 5, 8)) {
            win = true;
        }
        if (checkFields(0, 4, 8)) {
            win = true;
        }
        if (checkFields(2, 4, 6)) {
            win = true;
        }

        return win;
    }

    public void loop() {
        Scanner scanner = new Scanner(System.in);
        boolean play = false;
        while (!play) {
            initialize();
            start();
            System.out.println("Möchtest du nochmal spielen? (ja/nein)");
            if (scanner.next().equals("nein")) {
                play = true;
                System.out.println("Danke fürs Spielen :)");
            }
        }
    }
}
