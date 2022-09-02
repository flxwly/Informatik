package org.extraterrestrial.qp12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EigeneMethodeTeil1 extends JFrame {

    JLabel label = new JLabel();
    JTextField numberField = new JTextField();
    JButton button = new JButton();

    EigeneMethodeTeil1 () {
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1920, 1080);
        setTitle("EigeneMethodeTeil1");
        setResizable(true);
        Container cp = getContentPane();
        cp.setLayout(null);

        button.setText("Ausführen");

        numberField.setBounds(10, 10, 200, 40);
        button.setBounds(100, 60, 100, 40);
        label.setBounds(10, 110, 200, 40);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("" + cube(Double.parseDouble(numberField.getText())));
                } catch (NumberFormatException exception) {
                    label.setText("Can't calculate cube of String. Only enter numbers!");
                }
            }
        });


        cp.add(label);
        cp.add(numberField);
        cp.add(button);

        setVisible(true);
    }


    public double cube(double number) {
        return number * number * number;
    }

    public static void main(String[] args) {
        new EigeneMethodeTeil1();
    }

}
