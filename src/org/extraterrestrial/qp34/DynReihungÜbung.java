package org.extraterrestrial.qp34;

import org.extraterrestrial.adt.DynArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynReihungÜbung extends JFrame {

    private DynArray dyn = new DynArray();
    private JButton füllen = new JButton("Dyn. Reihung füllen");
    private JButton sortieren = new JButton("Dyn. Reihung sortieren");

    public DynReihungÜbung() {
        // Frame-Initialisierung
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(false);
        getContentPane().setLayout(null);
        setVisible(true);

        addComponents(getContentPane());
    }

    private void addComponents(Container contentPane) {
        füllen.setBounds(10, 10, 270, 120);
        sortieren.setBounds(10, 140, 270, 120);

        füllen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fill();
            }
        });

        sortieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                properSelectionSort();
                ausgabe();
                ausgabeRev();
            }
        });

        contentPane.add(füllen);
        contentPane.add(sortieren);
    }

    private void fill() {
        dyn.append(60);
        dyn.append(100);
        dyn.append(13);
        dyn.append(17);
        dyn.append(1);
    }

    private void sort() {
        DynArray dyn2 = new DynArray();
        while (!dyn.isEmpty()) {
            int biggest = 0;
            int index = 0;
            for (int i = 0; i < dyn.getLength(); i++) {
                if ((int) dyn.getItem(i) > biggest) {
                    biggest = (int) dyn.getItem(i);
                    index = i;
                }
            }
            dyn.delete(index);
            dyn2.append(biggest);
        }
        dyn = dyn2;
    }

    private void properSelectionSort() {
        for (int i = 0; i < dyn.getLength() - 1; i++) {
            int highest = i;
            for (int j = i + 1; j < dyn.getLength(); j++) {
                if ((int) dyn.getItem(highest) > (int) dyn.getItem(j)) {
                    highest = j;
                }
            }
            int t = (int) dyn.getItem(highest);
            dyn.setItem(highest, dyn.getItem(i));
            dyn.setItem(i, t);
        }
    }

    private void ausgabe() {

        System.out.println("Dyn. Reihung:");
        for (int i = 0; i < dyn.getLength(); i++) {
            System.out.print(dyn.getItem(i) + " ");
        }
        System.out.println();
    }

    private void ausgabeRev() {
        System.out.println("Dyn. Reihung rückwerts:");
        for (int i = dyn.getLength() - 1; i >= 0; i--) {
            System.out.print(dyn.getItem(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new DynReihungÜbung();
    }

}
