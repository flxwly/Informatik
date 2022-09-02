package org.extraterrestrial.qp34;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ZahlenZählen extends JFrame {

    private JButton generieren = new JButton();
    private JButton zählen = new JButton();
    private JLabel ausgabe = new JLabel();

    private int[][] arr = new int[10][10];

    public ZahlenZählen() {
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

    } // end of public DynErstellungFrame

    private void addComponents(Container cp) {

        generieren.setBounds(10, 10, 200, 50);
        generieren.setText("2D-Reihung generieren");
        generieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generieren(0.5);
            }
        });

        zählen.setBounds(10, 60, 200, 50);
        zählen.setText("Einsen Zählen");
        zählen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zählen();
            }
        });

        ausgabe.setBounds(10, 100, 200, 50);

        cp.add(generieren);
        cp.add(zählen);
        cp.add(ausgabe);
    }

    private void generieren(double grenzwert) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (Math.random() > grenzwert) ? 0 : 1;
            }
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    private void zählen() {
        int zähler = 0;
        for (int[] ints : arr) {
            for (int zahl : ints) {
                if (zahl == 1) {
                    zähler++;
                }
            }
        }
        ausgabe.setText("Es gibt " + zähler + " einsen!");

    }

    public static void main(String[] args) {
        new ZahlenZählen();
    }

}
