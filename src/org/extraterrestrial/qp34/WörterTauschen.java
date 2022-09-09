package org.extraterrestrial.qp34;

import org.extraterrestrial.adt.Queue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WörterTauschen extends JFrame {

    private JTextField eingabe = new JTextField();
    private JButton tauschenButton = new JButton();
    private JLabel ausgabe = new JLabel();


    public WörterTauschen() {
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

        eingabe.setBounds(10, 10, 200, 50);

        tauschenButton.setBounds(10, 60, 200, 50);
        tauschenButton.setText("Wörter durchmischen");
        tauschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mixWithQueue();
            }
        });

        ausgabe.setBounds(10, 100, 200, 50);

        cp.add(eingabe);
        cp.add(tauschenButton);
        cp.add(ausgabe);
    }

    private void mixWithQueue() {
        Queue grade = new Queue();
        Queue ungrade = new Queue();

        boolean useGrade = true;
        for (char c : eingabe.getText().toCharArray()) {
            if (c == ' ')
                useGrade = !useGrade;

            if (useGrade)
                grade.enqueue(c);
            else
                ungrade.enqueue(c);
        }

        StringBuilder newString = new StringBuilder();
        while (!grade.isEmpty()) {
            newString.append(grade.dequeue());
        }
        while (!ungrade.isEmpty()) {
            newString.append(ungrade.dequeue());
        }
        ausgabe.setText(newString.toString());
    }

    private void mix() {
        String[] arr = eingabe.getText().split(" ");
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = i; j < arr.length; j += 2) {
                newString.append(" ").append(arr[j]);
            }
        }
        ausgabe.setText(newString.toString());
    }

    public static void main(String[] args) {
        new WörterTauschen();
    }


}
