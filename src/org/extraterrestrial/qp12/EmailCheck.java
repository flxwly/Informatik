package org.extraterrestrial.qp12;

import java.awt.*;
import javax.swing.*;

/**
 * Beschreibung
 *
 * @author flxwly
 * @version 1.0 vom 17.12.2021
 */

public class EmailCheck extends JFrame {

    private JTextField inputField = new JTextField("Hier E-Mail adresse eingebe");
    private JLabel textDisplay = new JLabel("");
    private JTextField searchInputField = new JTextField("");
    private JTextField replaceInputField = new JTextField("");
    private JButton replaceText = new JButton("Drücken um Text zu ersetzen");
    private JButton pallindromCheckButton = new JButton("Check Pallindrom");
    private JSlider caesarNumber = new JSlider();
    private JButton caesar = new JButton("Caesar");


    public EmailCheck() {

        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1920, 1080);
        setTitle("EmailCheck");
        setResizable(true);
        Container cp = getContentPane();
        cp.setLayout(null);

        textDisplay.setBounds(10, 10, 400, 80);
        inputField.setBounds(10, 100, 400, 80);
        pallindromCheckButton.setBounds(10, 200, 200, 80);
        replaceText.setBounds(10, 300, 200, 80);
        replaceInputField.setBounds(10, 500, 80, 80);
        searchInputField.setBounds(10, 400, 80, 80);
        caesar.setBounds(500, 10, 80, 80);
        caesarNumber.setBounds(500, 100, 200, 80);
        caesarNumber.setMaximum(10);
        caesarNumber.setMinimum(-10);

        inputField.setBackground(Color.YELLOW);
        inputField.addActionListener(e -> {
            String text = inputField.getText();

            if (text.length() >= 3) {
                if (text.charAt(text.length() - 3) == '.' && text.charAt(text.length() - 2) == 'd' && text.charAt(text.length() - 1) == 'e') {
                    textDisplay.setText("Valide");
                    textDisplay.setBackground(Color.GREEN);
                } else {
                    textDisplay.setText("Problematisch");
                    textDisplay.setBackground(Color.RED);
                }
            }
        });

        pallindromCheckButton.addActionListener(e -> {
            String text = inputField.getText();

            for (int i = 0; i < text.length() / 2; i++) {
                if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                    textDisplay.setText("Kein Pallindrom");
                    textDisplay.setBackground(Color.RED);
                    return;
                }
            }
            textDisplay.setText("Woow toll! Ein Pallindrom");
            textDisplay.setBackground(Color.GREEN);
        });

        replaceText.addActionListener(e -> {
            String oldText = inputField.getText();
            StringBuilder newText = new StringBuilder();
            String replaceText = replaceInputField.getText();
            String searchText = searchInputField.getText();

            if (searchText.isEmpty()) {
                return;
            }

            for (int i = 0; i < oldText.length(); i++) {
                boolean foundOccurence = (oldText.length() - i >= replaceText.length());
                for (int j = 0; j < searchText.length(); j++) {
                    if (searchText.charAt(j) != oldText.charAt(i + j)) {
                        foundOccurence = false;
                        break;
                    }
                }

                if (foundOccurence) {
                    newText.append(replaceText);
                    i += searchText.length() - 1;
                } else {
                    newText.append(oldText.charAt(i));
                }
            }

            textDisplay.setText(newText.toString());
            inputField.setText(newText.toString());
        });

        caesar.addActionListener(e -> {
            String text = inputField.getText();
            StringBuilder newText = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                newText.append((char) (((int) text.charAt(i)) + caesarNumber.getValue()));
            }

            inputField.setText(newText.toString());
            textDisplay.setText(newText.toString());

        });

        cp.add(inputField);
        cp.add(textDisplay);
        cp.add(pallindromCheckButton);
        cp.add(searchInputField);
        cp.add(replaceInputField);
        cp.add(replaceText);
        cp.add(caesar);
        cp.add(caesarNumber);

        setVisible(true);
    }

    public static void main(String[] args) {
        new EmailCheck();
    }
}
