package org.extraterrestrial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class EigeneMethodeTeil2 extends JFrame {

    int buttonCount = 10;
    ArrayList<JButton> buttons = new ArrayList<>();
    ArrayList<Boolean> keyPhrase = new ArrayList<>();
    JButton checkButton = new JButton("Check");

    EigeneMethodeTeil2() {
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(getToolkit().getScreenSize());
        setTitle("EigeneMethodeTeil2");
        setResizable(true);
        Container cp = getContentPane();
        cp.setLayout(null);

        int bWidth = (getWidth() - 20) / (buttonCount);

        for (int i = 0; i < buttonCount; i++) {
            JButton button = new JButton("Button" + i);
            button.setBounds(10 + i * bWidth, 10, bWidth, 50);
            button.setBackground(Color.RED);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    if (clickedButton.getBackground() == Color.RED) {
                        clickedButton.setBackground(Color.GREEN);
                    } else {
                        clickedButton.setBackground(Color.RED);
                    }
                }
            });

            cp.add(button);
            buttons.add(button);
            Random random = new Random();

            keyPhrase.add(random.nextInt(10) >= 8);
        }


        checkButton.setBounds(getWidth() / 2 - 60, 80, 120, 80);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < buttonCount; i++) {
                    if ((buttons.get(i).getBackground() == Color.GREEN && keyPhrase.get(i))
                            || (buttons.get(i).getBackground() == Color.RED) && !keyPhrase.get(i)) {
                        checkButton.setBackground(Color.GREEN);
                    } else {
                        checkButton.setBackground(Color.RED);
                        return;
                    }
                }
            }
        });

        System.out.println(keyPhrase);

        cp.add(checkButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EigeneMethodeTeil2();
    }

}
