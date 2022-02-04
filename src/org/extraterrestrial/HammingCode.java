package org.extraterrestrial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class HammingCode extends JFrame {

    private JTextField textInput = new JTextField("Text eingeben");
    private JButton calculateHammingCode = new JButton("Erzeugen");
    private JLabel textAsBitsDisplay = new JLabel("0000");

    private JTextField hammingInput = new JTextField("Hamming Code eingeben");
    private JButton checkHammingCode = new JButton("Prüfen");
    private JLabel correctedHammingCode = new JLabel("0000000");

    private int charBitLength = 8;

    HammingCode() {

        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1920, 1080);
        setTitle("Quersumme");
        setResizable(true);
        Container cp = getContentPane();
        cp.setLayout(null);


        // left side
        textInput.setBounds(10, 10, 200, 60);
        calculateHammingCode.setBounds(10, 70, 200, 60);
        textAsBitsDisplay.setBounds(10, 130, 200, 60);

        hammingInput.setBounds(400, 10, 200, 60);
        checkHammingCode.setBounds(400, 70, 200, 60);
        correctedHammingCode.setBounds(400, 130, 200, 60);

        calculateHammingCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] bits = textInput.getText().split(" ");

                StringBuilder displayText = new StringBuilder();
                StringBuilder displayHamming = new StringBuilder();
                for (String bitCode : bits) {

                    int exponent = 0;
                    StringBuilder hammingString = new StringBuilder();
                    int i = 0;
                    for (char b : bitCode.toCharArray()) {

                        while (Math.pow(2, exponent) - 1 == i) {
                            hammingString.append('H');
                            exponent += 1;
                            i += 1;
                        }

                        hammingString.append(b);
                        displayText.append(b);
                        i += 1;
                    }

                    for (int n = 0; n < exponent; n++) {
                        int k = (int) Math.pow(2, n);
                        StringBuilder parityString = new StringBuilder();

                        while (k < hammingString.length() + 1) {
                            for (int m = k; m < Math.min(k + (int) Math.pow(2, n), hammingString.length() + 1); m++) {
                                System.out.println(m - 1);
                                parityString.append(hammingString.charAt(m - 1));
                            }

                            k += 2 * (int) Math.pow(2, n);
                        }
                        for (int j = 0; j < hammingString.length(); j++) {
                            if (hammingString.charAt(j) == 'H') {
                                hammingString.replace(j, j + 1, parityBit(parityString.toString()) ? "1" : "0");
                                break;
                            }
                        }
                    }

                    displayHamming.append(hammingString);
                    displayHamming.append(' ');


                    displayText.append(' ');
                }
                textAsBitsDisplay.setText(displayText.toString());
                correctedHammingCode.setText(displayHamming.toString());
            }
        });

        checkHammingCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        cp.add(textInput);
        cp.add(calculateHammingCode);
        cp.add(textAsBitsDisplay);

        cp.add(hammingInput);
        cp.add(checkHammingCode);
        cp.add(correctedHammingCode);
        setVisible(true);
    }

    public static boolean parityBit(String str) {
        boolean bit = false;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                bit = !bit;
            }
        }
        return bit;
    }


    public static void main(String[] args) {
        new HammingCode();
    }


}
