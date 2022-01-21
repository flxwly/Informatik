package org.extraterrestrial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 17.12.2021
 * @author flxwly
 */

public class Farben extends JFrame {
    // Anfang Attribute
    private JButton doSomething = new JButton();
    private JTextField textInputField = new JTextField();
    private JTextField charInputField = new JTextField();
    private JTextField numberInputField = new JTextField();
    // Ende Attribute

    public Farben() {
        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Farben");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        doSomething.setText("Mach was!");
        doSomething.setMargin(new Insets(2, 2, 2, 2));

        textInputField.setBounds(10, 10, 200, 40);
        doSomething.setBounds(10, 60, 80, 40);
        charInputField.setBounds(110, 60, 60, 40);
        numberInputField.setBounds(10, 110, 100, 40);

        doSomething.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String text = textInputField.getText();
                String chars = charInputField.getText();

                int counter = 0;
                for(int i = 0; i < text.length(); i++) {
                    for (int j = 0; j < chars.length(); j++) {
                        if (text.charAt(i) == chars.charAt(j)) {
                            counter++;
                            break;
                        }
                    }
                }

                numberInputField.setText("" + counter);
            }
        });



        cp.add(doSomething);
        cp.add(charInputField);
        cp.add(numberInputField);
        cp.add(textInputField);
        setVisible(true);
    }
    // Anfang Methoden

    public static void main(String[] args) {
        new Farben();
    }
} // end of class JFramesEinfuehrung
