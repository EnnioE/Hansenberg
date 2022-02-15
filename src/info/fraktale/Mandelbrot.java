import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

public class Mandelbrot {
    public static void main(String[] args) {
        double xmin=-2;
        double xmax=1;
        double length=xmax - xmin;
        int dimension=400;
        int maxIt=256;
        String dateiname="mandelbrot";

        // Leinwand
        int draw[][] = new int[dimension][dimension];

        // –––––- Malen –––––-

        // x & y => Imaginärteil in Mandelfeldern (z.B. -2 bis 2)
        // i & j => Realteil in Pixeln (z.B. 0 bis 400)
        double x=xmin;
        for (int i=0 ; i<dimension ; i++) { // Alle Spalten
            double y=-(length/2);
            for (int j=0 ; j<dimension ; j++) { // Alle Zeilen
                draw[j][i] = greytone(x, y, maxIt);
                y += length / dimension;
            }
            x += length / dimension; //Schrittweite = Quotient von Länge(Imaginär) und Bildgröße(Real)
        }

        // –––––- Bilddatei erzeugen –––––-
        try {
            png(draw, dateiname, dimension);
        } catch(Exception e) {
            System.out.println("Fehler beim Schreiben");
        }

        System.out.print("Das Mandelbrot wurde erstellt");
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
                // coole Farben
                // c = tone;
                // c = (c << 7) + tone;
                // c = (c << 7) + tone;
                img.setRGB(x,y, c);
            }
        }
        ImageIO.write(img, "png", new File(filename + ".png"));
    }

    static int greytone(double real, double imag, int maxIt) {
        double old_x = 0, old_y = 0, new_x=real, new_y=imag;

        int greytone = maxIt; //von 0 oder von 1?
        do {
            old_x = new_x;
            old_y = new_y;

            // x_1 = x_0^2 - y_0^2 + x_1 ~> (1)
            new_x = (old_x * old_x) - (old_y * old_y) + real;
            // y_1 = 2 * x_0 * y_0 + y_1 ~> (1)
            new_y = 2 * (old_x * old_y) + imag;

            greytone--;

            // Betrag = sqrt(a_1^2 + b_1^2)
            // Bedingung = Betrag^2 < 4
            if ((new_x*new_x) + (new_y*new_y) >= 4)
                break;
        } while (greytone > 0);

        return (int) (255 * ((double) greytone) / maxIt);
    }
    //Quellen: (1) http://www.mathematische-basteleien.de/apfelmaennchen.htm

}