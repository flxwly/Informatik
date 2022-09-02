package org.extraterrestrial.qp12;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Beschreibung
 *
 * @author flxwly
 * @version 1.0 vom 17.12.2021
 */

public class Rechenfuchs extends JFrame {

    private JButton resetButton = new JButton();
    private ArrayList<JButton> numberButtons = new ArrayList<>();
    private JLabel computerPointsDisplay = new JLabel("Computer:");
    private JLabel humanPointsDisplay = new JLabel("Mensch:");
    private int playerPoints = 0;
    private int computerPoints = 0;

    public Rechenfuchs() {

        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1920, 1080);
        setTitle("Farben");
        setResizable(true);
        Container cp = getContentPane();
        cp.setLayout(null);

        int buttonsX = 5;
        int buttonsY = 4;

        int scale = 120;

        computerPointsDisplay.setBounds((buttonsX + 2) * scale + scale / 2, scale / 2, scale, scale * buttonsY / 2);
        humanPointsDisplay.setBounds((buttonsX + 2) * scale + scale / 2, scale / 2 + scale * (buttonsY / 2), scale, scale * buttonsY / 2);

        resetButton.setBackground(Color.YELLOW);
        resetButton.setText("Neustart");
        resetButton.setBounds((buttonsX + 1) * scale + scale / 2, scale / 2, scale, scale * buttonsY);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton button : numberButtons) {
                    button.setBackground(Color.GREEN);
                }
                playerPoints = 0;
                computerPoints = 0;
            }
        });

        for (int j = 0; j < buttonsY; j++) {
            for (int i = 0; i < buttonsX; i++) {
                int index = j * buttonsX + i;
                numberButtons.add(new JButton());
                JButton curButton = numberButtons.get(index);
                curButton.setBackground(Color.GREEN);
                curButton.setText("" + (index + 1));
                curButton.setBounds(i * scale + scale / 2, j * scale + scale / 2, scale, scale);
                curButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean computerGotPoints = false;
                        JButton clickedButton = (JButton) e.getSource();
                        if (clickedButton.getBackground() == Color.RED) {
                            return;
                        }

                        int clickedNumber = Integer.parseInt(clickedButton.getText());
                        clickedButton.setBackground(Color.RED);

                        for (JButton button : numberButtons) {
                            int number = Integer.parseInt(button.getText());
                            if (number >= clickedNumber) {
                                break;
                            }

                            if (clickedNumber % number == 0 && button.getBackground() == Color.GREEN) {
                                button.setBackground(Color.RED);
                                computerPoints += number;
                                computerGotPoints = true;
                            }
                        }
                        if (computerGotPoints) {
                            playerPoints += clickedNumber;
                        } else {
                            computerPoints += clickedNumber;
                        }

                        humanPointsDisplay.setText("Mensch: " + playerPoints);
                        computerPointsDisplay.setText("Computer: " + computerPoints);

                    }
                });

                cp.add(curButton);
            }
        }
        cp.add(resetButton);
        cp.add(humanPointsDisplay);
        cp.add(computerPointsDisplay);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Rechenfuchs();
    }
}
