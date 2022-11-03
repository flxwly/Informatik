package org.extraterrestrial.qp34.MaulwurfReloadedApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.extraterrestrial.adt.BinTree;
import org.extraterrestrial.qp34.MaulwurfReloadedApp.Tier;

/**
 * Beschreibung
 *
 * @author
 * @version 1.0 vom 12.10.2022
 */

public class MaulwurfReloadedApp extends JFrame {
    // Anfang Attribute
    Tier taube = new Tier("Taube", "wei�", true, 'K', 3);       // 'K' = Klecks,  'R' = Rund
    Tier pferd = new Tier("Pferd", "braun", false, 'R', 5);     // 'B' = Bohne,   'W' = Wurst
    Tier hase = new Tier("Hase", "braun", false, 'B', 1);       // 'H' Haufen
    Tier ziege = new Tier("Ziege", "braun", false, 'R', 2);
    Tier kuh = new Tier("Kuh", "braungruen", true, 'K', 5);
    Tier schwein = new Tier("Schwein", "braun", false, 'H', 4);
    Tier hund = new Tier("Hund", "braun", false, 'W', 4);
    Tier maulwurf = new Tier("Maulwurf", "schwarz", false, 'W', 1);

    Tier fuchs = new Tier("Fuchs", "braun", false, 'H', 3);

    BinTree b = new BinTree();


    private JButton jButton1 = new JButton();
    // Ende Attribute

    public MaulwurfReloadedApp(String title) {
        // Frame-Initialisierung
        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        // Baum f�llen (umst�ndlich, dies macht man normal �ber eine Einf�geOperation....)
        b.setItem(taube);
        BinTree hilf = new BinTree();
        BinTree l = new BinTree();
        l.setItem(hase);
        b.setLeft(l);
        BinTree lr = new BinTree();
        lr.setItem(ziege);
        b.getLeft().setRight(lr);
        BinTree lrl = new BinTree();
        lrl.setItem(maulwurf);
        b.getLeft().getRight().setLeft(lrl);
        // rechte Seite
        BinTree r = new BinTree();
        r.setItem(kuh);
        b.setRight(r);
        BinTree rr = new BinTree();
        rr.setItem(pferd);
        b.getRight().setRight(rr);
        BinTree rl = new BinTree();
        rl.setItem(schwein);
        b.getRight().setLeft(rl);
        BinTree rll = new BinTree();
        rll.setItem(hund);
        b.getRight().getLeft().setLeft(rll);

        // Primärschlüssel zur Sortierung ist die Größe
        // Sekundärschlüssel Name alphabetisch

        insert(b, fuchs);

        jButton1.setBounds(24, 32, 193, 25);
        jButton1.setText("InOrder-Ausgabe");
        jButton1.setMargin(new Insets(2, 2, 2, 2));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1_ActionPerformed(evt);
            }
        });
        cp.add(jButton1);
        // Ende Komponenten

        printAllAnimalsWithPoopTypeInTree(b, true, 0);
        printAllAnimalsWithPoopTypeInTree(b, false, 2);

        System.out.println("Anzahl Elemente: " + countElements(b));

        setVisible(true);
    } // end of public MaulwurfReloadedApp

    // Anfang Methoden
    public void jButton1_ActionPerformed(ActionEvent evt) {
        inOrder(b);
    } // end of jButton1_ActionPerformed

    public int countElements(BinTree tree) {
        return (tree.hasLeft() ? countElements(tree.getLeft()) : 0) + (tree.hasRight() ? countElements(tree.getRight()) : 0) + (tree.hasItem() ? 1 : 0);
    }
    public void printAllAnimalsWithPoopTypeInTree(BinTree baum, boolean fluid, int minSize) {
        if (baum.hasLeft()) {
            printAllAnimalsWithPoopTypeInTree(baum.getLeft(), fluid, minSize);
        }
        if (baum.hasItem() && ((Tier) baum.getItem()).fluessig == fluid && ((Tier) baum.getItem()).groesse >= minSize ) {
            System.out.println(baum.getItem());
        }
        if (baum.hasRight()) {
            printAllAnimalsWithPoopTypeInTree(baum.getRight(), fluid, minSize);
        }
    }
    public void insert(BinTree t, Tier tier) {
        if (t.hasItem()) {
            if (!((Tier) t.getItem()).compare(tier)) {
                if (t.hasLeft()) {
                    insert(t.getLeft(), tier);
                } else {
                    t.setLeft(new BinTree(tier));
                }
            } else {
                if (t.hasRight()) {
                    insert(t.getRight(), tier);
                } else {
                    t.setRight(new BinTree(tier));
                }
            }
        } else {
            t.setItem(tier);
        }
    }
    public void inOrder(BinTree baum) {
        if (baum.hasLeft()) {
            inOrder(baum.getLeft());
        }
        if (baum.hasItem()) {
            Tier t = (Tier) baum.getItem();
            System.out.println(t);
        }
        if (baum.hasRight()) {
            inOrder(baum.getRight());
        }
    }
    // Ende Methoden

    public static void main(String[] args) {
        new MaulwurfReloadedApp("MaulwurfReloadedApp");
    } // end of main

} // end of class MaulwurfReloadedApp