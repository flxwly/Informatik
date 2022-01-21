package org.extraterrestrial.mariogame;

import javax.swing.JFrame;
import java.awt.EventQueue;


public class MarioGameEx extends JFrame {
    public MarioGameEx() {

        initUI();
    }

    private void initUI() {

        add(new Plane());

        setTitle("Moving sprite");
        setSize(400, 300);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MarioGameEx ex = new MarioGameEx();
            ex.setVisible(true);
        });
    }


}
