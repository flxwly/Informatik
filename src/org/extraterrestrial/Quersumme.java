package org.extraterrestrial;

import java.awt.*;
import javax.swing.*;

/**
 * Beschreibung
 *
 * @author flxwly
 * @version 1.0 vom 17.12.2021
 */

public class Quersumme extends JFrame {

    private JTextField inputField = new JTextField("");
    private JLabel diplay = new JLabel("");

    public Quersumme() {

        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1920, 1080);
        setTitle("Quersumme");
        setResizable(true);
        Container cp = getContentPane();
        cp.setLayout(null);

        diplay.setBounds(10, 10, 800, 80);
        diplay.setBackground(Color.GREEN);
        inputField.setBounds(10, 100, 400, 80);
        inputField.setBackground(Color.YELLOW);
        inputField.addActionListener(e -> {
            String text = inputField.getText();
            int sum = 0;

            for (int i = 0; i < text.length(); i++) {
                try {
                    sum += Integer.parseInt(String.valueOf(text.charAt(i)));
                } catch (java.lang.NumberFormatException exception) {
                    System.out.println("" + exception);
                    diplay.setText("bitte nur zahlen eingeben");
                    return;
                }
            }

            diplay.setText("Die Quersumme von " + text + " ist " + sum + ".");

        });



        cp.add(inputField);
        cp.add(diplay);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Quersumme();
    }
}
