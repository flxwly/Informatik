package org.extraterrastrial;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 17.12.2021
 * @author
 */

public class Rechenfuchs extends JFrame {

    private ArrayList<JButton> numberButtons = new ArrayList<>();
    private ArrayList<Integer> openNumbers = new ArrayList<>();
    private int playerPoints = 0;
    private int computerPoints = 0;

    public Rechenfuchs() {
        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(720, 480);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Farben");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);

        int scale = 80;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                int index = i * 4 + j;
                openNumbers.add(index + 1);
                numberButtons.add(new JButton());
                JButton curButton = numberButtons.get(index);
                curButton.setBackground(Color.GREEN);
                curButton.setText("" + (index + 1));

                curButton.setBounds(i * scale + scale / 2, j * scale + scale / 2, scale, scale);

                curButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        int nameAsNumber = Integer.parseInt(button.getText());
                        numberButtons.remove(nameAsNumber);

                        boolean computerGotPoitns = false;
                        for (int num : openNumbers) {
                            if (nameAsNumber % num == 0) {
                                numberButtons.get(num - 1).setBackground(Color.RED);
                                openNumbers.remove(num);
                                computerPoints += num;
                                computerGotPoitns = true;
                            }
                        }
                        if (computerGotPoitns) {
                            playerPoints += nameAsNumber;
                        } else {
                            computerPoints += nameAsNumber;
                        }

                    }
                });


                cp.add(curButton);
            }
        }

        System.out.println(playerPoints);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Rechenfuchs();
    }
} // end of class JFramesEinfuehrung
