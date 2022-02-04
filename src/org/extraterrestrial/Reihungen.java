package org.extraterrestrial;

import java.util.Arrays;
import java.util.Random;

public class Reihungen {


    public static void main(String[] args) {

        // Aufgabe vorweg zum Paritätsbit
        boolean[] arr = {false, true, false, false, false, false, false};
        System.out.println(Arrays.toString(arr));
        // Das letzte Element des Arrays soll nach ausführen der paritaetsBit Methode "true" sein.
        paritaetsBit(arr);
        System.out.println(Arrays.toString(arr));


        // Aufgabe 1) a)
        // Index:   0 | 1 | 2 | 3 | 4 | 5
        // Wert:    1 | 2 | 3 | 4 | 5 | 6

        // Aufgabe 1) b)
        int[] wuerfelergebnisse = {1, 2, 3, 4, 5, 6};

        // Aufgabe 1) c)
        wuerfelergebnisse = new int[6];
        for (int i = 0; i < 6; i++) {
            wuerfelergebnisse[i] = i + 1;
        }

        // Aufgabe 1) d + e)
        wuerfelergebnisse = new int[30];
        Random random = new Random();
        for (int i = 0; i < wuerfelergebnisse.length; i++) {
            wuerfelergebnisse[i] = random.nextInt(6) + 1;
            System.out.println("Wurf " + i + " war: " + wuerfelergebnisse[i]);
        }

        // Aufgabe 1) f)
        System.out.println("Die Summe aller Würfe ist: " + summe(wuerfelergebnisse));

        // Aufgabe 1) g)
        // Die Methode berechnet den durchschnittlichen Wert für die ersten n Elemente eines Arrays
        // Hierbei ist der Übergabewert "pWert" n. Das Array zufallsergebnisse befindet sich außerhalb der Methode.
        // Für die Berechnung wird erst eine Variable "Ergebnis" vom Typ double mit dem Wert 0 initialisiert.
        // Dann werden mit einer For-Schleife die ersten n Elemente des Arrays "zufallsergebnisse" zusammen gerechnet.
        // Als Letztes wird diese Summe durch n geteilt und zurückgegeben.

        // Aufgabe 2) a)
        // Im Fall iii) und v) wird das array vollständig durchlaufen.
    }

    public static int summe(int[] arr) {
        int summe = 0;
        for (int n :
                arr) {
            summe += n;
        }

        return summe;
    }

    public static void paritaetsBit(boolean[] arr) {
        boolean parity = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i]) {
                parity = !parity;
            }
        }
        arr[arr.length - 1] = parity;
    }
}
