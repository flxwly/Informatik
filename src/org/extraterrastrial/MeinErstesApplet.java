package org.extraterrastrial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* TopLevelDemo.java requires no other files. */
public class MeinErstesApplet {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Test");

        JButton buttonGreen = new JButton();
        buttonGreen.setBackground(Color.GREEN);
        buttonGreen.setOpaque(true);
        buttonGreen.setPreferredSize(new Dimension(100, 100));

        JButton buttonYellow = new JButton();
        buttonYellow.setBackground(Color.YELLOW);
        buttonYellow.setOpaque(true);
        buttonYellow.setPreferredSize(new Dimension(100, 100));

        JButton buttonRed = new JButton();
        buttonRed.setBackground(Color.RED);
        buttonRed.setOpaque(true);
        buttonRed.setPreferredSize(new Dimension(100, 100));

        buttonGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGreen.getBackground().equals(Color.GREEN)) {
                    buttonGreen.setBackground(Color.RED);
                } else {
                    buttonGreen.setBackground(new Color(100,100,100));
                }
            }
        });

        buttonRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Set the menu bar and add the label to the content pane.
        frame.getContentPane().add(buttonGreen, BorderLayout.EAST);
        frame.getContentPane().add(buttonRed, BorderLayout.WEST);
        frame.getContentPane().add(buttonYellow, BorderLayout.SOUTH);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}