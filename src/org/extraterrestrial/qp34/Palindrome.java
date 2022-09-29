package org.extraterrestrial.qp34;

import org.extraterrestrial.adt.Queue;
import org.extraterrestrial.adt.Stack;
import template.JFrameTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Palindrome extends JFrameTemplate {

    private JTextField inputField;
    private JButton confirmInput;
    private JButton checkPalindrom;

    private Queue q1;

    public Palindrome() {
        super();
    }

    public void addComponents(Container cp) {
        inputField = new JTextField();
        inputField.setBounds(10, 10, 280, 40);
        cp.add(inputField);

        confirmInput = new JButton();
        confirmInput.setText("Eingabe bestätigen");
        confirmInput.setBounds(50, 60, 200, 40);
        confirmInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                q1 = new Queue();
                for (char c : inputField.getText().toCharArray()) {
                    q1.enqueue(c);
                }
                System.out.println("Eingabe ist: " + inputField.getText());
            }
        });
        cp.add(confirmInput);

        checkPalindrom = new JButton();
        checkPalindrom.setText("Palindromtest!");
        checkPalindrom.setBounds(50, 110, 200, 40);
        checkPalindrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stack s1 = new Stack();
                int count = 0;
                while (!q1.isEmpty()) {
                    s1.push(q1.dequeue());
                    count++;
                }
                Stack s2 = new Stack();
                for (int i = 0; i < count / 2; i++) {
                    s2.push(s1.pop());
                }
                if (count % 2 == 1) s1.pop();

                while (!s1.isEmpty()) {
                    if (s1.pop() != s2.pop()) {
                        System.out.println("Das ist kein Palindrom!");
                        return;
                    }
                }

                System.out.println("Palindrom gefunden");


            }
        });
        cp.add(checkPalindrom);
    }


    public static void main(String[] args) {
        new Palindrome();
    }
}
