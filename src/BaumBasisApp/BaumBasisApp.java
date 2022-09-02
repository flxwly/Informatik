package BaumBasisApp;

import org.extraterrestrial.adt.BinTree;
import org.extraterrestrial.adt.Queue;
import org.extraterrestrial.adt.Stack;

import java.util.Arrays;

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

        inOrder(baum);

        levelOrder(baum);
        antiLevelOrder(baum);

        System.out.println("Nearest neighbours: " + Arrays.toString(nearestNeighbour(baum)));
        System.out.println("Includes 34: " + baum.includes(17));
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

    public static int[] nearestNeighbour(BinTree b) {
        int[] neighbour = new int[2];
        if (b.hasLeft()) {
            BinTree t = b.getLeft();
            while (t.hasRight()) {
                t = t.getRight();
            }
            if (t.hasItem()) {
                neighbour[0] = (int) t.getItem();
            }
        }

        if (b.hasRight()) {
            BinTree t = b.getRight();
            while (t.hasLeft()) {
                t = t.getLeft();
            }
            if (t.hasItem()) {
                neighbour[1] = (int) t.getItem();
            }
        }
        return neighbour;
    }
    public static void antiLevelOrder(BinTree b) {
        Stack q = new Stack();
        q.push(b);
        System.out.println("Anti LevelOrder: ");
        while(!q.isEmpty()) {
            BinTree t = (BinTree) q.pop();
            System.out.println(t.getItem());
            if (t.hasLeft()) {
                q.push(t.getLeft());
                //System.out.println("2: " + q);
            }

            if (t.hasRight()) {
                q.push(t.getRight());
                //System.out.println("3: " + q);
            }
        }
    }

    public static void levelOrder(BinTree b) {
        Queue q = new Queue();
        q.enqueue(b);
        System.out.println("LevelOrder: ");
        while(!q.isEmpty()) {
            BinTree t = (BinTree) q.head();
            System.out.println(t.getItem());
            if (t.hasLeft()) {
                q.enqueue(t.getLeft());
                System.out.println("2: " + q);
            }

            if (t.hasRight()) {
                q.enqueue(t.getRight());
                System.out.println("3: " + q);
            }
            q.dequeue();
        }


    }

    // getMin


    public static int getMaxRec(BinTree b) {
        return b.hasRight() ? getMaxRec(b.getRight()) : (int) b.getItem();
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

    public static void inOrder(BinTree b) {
        if (b.hasLeft()) {
            inOrder(b.getLeft());
        } // end of if
        System.out.println("" + (int) b.getItem());
        if (b.hasRight()) {
            inOrder(b.getRight());
        } // end of if
    }

} // end of class BaumBasisApp
