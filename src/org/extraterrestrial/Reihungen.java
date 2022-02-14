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


        // Andere Aufgaben
        // Aufgabe 1)
        int reihung[] = new int[]{1, 3, 5, 7, 9, 11, 13, 15};

        // Aufgabe 2)
        for (int elem :
                reihung) {
            elem *= 4;
        }

        // Aufgabe 3)
        if (reihung[7] > reihung[6]) {
            System.out.println("Das 8. Element ist größer als das 7.");
        }

        // Aufgabe 4)
        // 1, 2, 3, 4, 5, 6, 7, 8

        // Aufgabe 5)
        reihung = new int[10];
        for (int i = 0; i < 10; i++) {
            reihung[i] = (i + 1) * 4;
        }

        // Aufgabe 6)
        reihung = new int[]{77, 13, 112, 88, 11, 49, 48, 69, 41, 111};
        int kleinerAls70 = 0;
        for (int zahl :
                reihung) {
            if (zahl < 70)
                kleinerAls70 += 1;
        }

        // Aufgabe 7)

        // Hypothetisch:
        // Als globale Variable:
        //      JTextField textField = new JTextField;
        // String text = new String();
        // for (int zahl : reihung) {
        //      if (zahl > 40)
        //          text += "" + zahl
        // }
        // textField.setText(text);
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
