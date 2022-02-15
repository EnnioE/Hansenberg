package info.fraktale;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

public class Sierpinskiviereck {

    public static void main(String[] args) {
        int tiefe = 6;
        String dateiname="sierpinski";
        int dimension = (int) Math.pow(3, tiefe);

        // Leinwand
        int draw[][] = new int[dimension][dimension];

        // –––––- Malen –––––-

        viereck(draw, 0, 0, tiefe, dimension);

        // –––––- Bilddatei erzeugen –––––-
        try {
            png(draw, dateiname, dimension);
        } catch(Exception e) {
            System.out.println("Fehler beim Schreiben");
        }

        System.out.print("Das Sierpinski-Viereck wurde erstellt");
    }

    static void viereck(int[][] draw, int x, int y, int t, int dimension) {
        // draw = leinwand, (x,y) obere linke ecke, t : tiefe, dimension : Breite des Fraktals
        if (t == 0) {
            // einen Pixel färben
            draw[y][x] = 255;
            return; // ABBRECHEN
        }
        int change = (int) Math.pow(3, t-1);
        viereck(draw, x, y,t-1,dimension / 3);
        viereck(draw,x + 2 * change, y,t-1,dimension / 3);
        viereck(draw, x, y + 2 * change,t-1,dimension / 3);
        viereck(draw, x + change, y + change,t-1,dimension / 3);
        viereck(draw, x + 2 * change, y + 2 * change,t-1,dimension / 3);
        // 5x rekursiven Aufruf
        // viereck( draw, ... )
        // zu modifizieren Koordination (x', y'), t ~> t-1, und dimension zu kleineren Breite
    }

    static int scaleRel(int v, int max, int base) {
        return (int) (base * ((double) v) / max);
    }

    static void png(int[][] draw, String filename, int dimension)  throws IOException
    {
        // Formatter output = new Formatter(new File(filename));
        BufferedImage img = new BufferedImage(dimension, dimension, BufferedImage.TYPE_INT_RGB);

        // Array schreiben
        for(int y=dimension-1; y>=0; y--) { //umgekehrt steht "es" auf den Fuessen
            for(int x = 0; x < dimension; x++) {
                int tone = draw[y][x];
                int c = tone;
                c = (c << 8) + tone;
                c = (c << 8) + tone;
                img.setRGB(x,y, c);
            }
        }
        ImageIO.write(img, "png", new File(filename + ".png"));
    }

}