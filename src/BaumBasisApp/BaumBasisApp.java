package BaumBasisApp;

import org.extraterrestrial.adt.BinTree;

/**
 * Beschreibung
 *
 * @author Gernot + flxwly
 * @version 1.0 vom 24.08.2022
 */

public class BaumBasisApp {
    // Anfang Attribute
    public static BinTree baum = new BinTree();
    // Ende Attribute

    public static void main(String[] args) {
        // Anfang Komponenten
        baumEinfuegen(baum, 40);
        baumEinfuegen(baum, 20);
        baumEinfuegen(baum, 10);
        baumEinfuegen(baum, 15);
        baumEinfuegen(baum, 17);
        baumEinfuegen(baum, 80);
        baumEinfuegen(baum, 100);
        baumEinfuegen(baum, 67);

        // Struktur des Baumes
        //          40
        //         /  \
        //       20   80
        //      /    /  \
        //    10    67  100
        //     \
        //      15
        //       \
        //        17

        anzeige(baum);

        System.out.println("Kleinstes: " + getMin(baum));
        System.out.println("Größtes: " + getMax(baum));

    } // end of public BaumBasisApp

    public static int getMin(BinTree b) {
        while (b.hasLeft()) {
            b = b.getLeft();
        }
        return (int) b.getItem();
    }

    public static int getMinRec(BinTree b) {
        return b.hasLeft() ? getMinRec(b.getLeft()) : (int) b.getItem();
    }

    public static int getMax(BinTree b) {
        while (b.hasRight()) {
            b = b.getRight();
        }
        return (int) b.getItem();
    }

    // Anfang Methoden
    public static void baumEinfuegen(BinTree b, int wert) {
        if (!b.hasItem()) {
            b.setItem(wert);
        } else {
            if (wert <= (int) b.getItem()) {
                if (!b.hasLeft()) {
                    BinTree akt = new BinTree();
                    akt.setItem(wert);
                    b.setLeft(akt);
                } else {
                    baumEinfuegen(b.getLeft(), wert);
                }
            } else {
                if (!b.hasRight()) {
                    BinTree akt = new BinTree();
                    akt.setItem(wert);
                    b.setRight(akt);
                } else {
                    baumEinfuegen(b.getRight(), wert);
                }
            }
        }
    }

    public static void anzeige(BinTree b) {
        if (b.hasLeft()) {
            anzeige(b.getLeft());
        } // end of if
        System.out.println("" + (int) b.getItem());
        if (b.hasRight()) {
            anzeige(b.getRight());
        } // end of if
    }

} // end of class BaumBasisApp
