package org.extraterrestrial.recursion;

import java.awt.*;
  import java.awt.event.*;
  import javax.swing.*;
  import javax.swing.event.*;
  
  /**
   *
   * Beschreibung
   *
   * @version 1.0 vom 24.06.2022
   * @author 
   */
  
  public class rekPot extends JFrame {
    // Anfang Attribute
    private JButton bBerechnen = new JButton();
    private JLabel lErgebnis = new JLabel();
    private JLabel lX = new JLabel();
    private JLabel lY = new JLabel();
    private JLabel l = new JLabel();
    // Ende Attribute
    
    public rekPot() { 
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
      setTitle("rekPot");
      setResizable(false);
      Container cp = getContentPane();
      cp.setLayout(null);
      // Anfang Komponenten
      
      bBerechnen.setBounds(57, 115, 75, 25);
      bBerechnen.setText("Berechnen");
      bBerechnen.setMargin(new Insets(2, 2, 2, 2));
      cp.add(bBerechnen);
      lErgebnis.setBounds(50, 171, 110, 20);
      lErgebnis.setText("Ergebnis:");
      cp.add(lErgebnis);
      lX.setBounds(40, 16, 65, 19);
      lX.setText("x");
      cp.add(lX);
      lY.setBounds(152, 16, 73, 19);
      lY.setText("y");
      cp.add(lY);
      l.setBounds(163, 172, 110, 20);
      l.setText("-");
      cp.add(l);
      // Ende Komponenten
      
      setVisible(true);
    } // end of public rekPot
    
    // Anfang Methoden

    public int rekPot(int x, int y) {
      return 0;
    }

    public static void main(String[] args) {
      new rekPot();
    } // end of main

    private int pot(int x, int y) {
            return (y == 0) ? 1 : pot(x, y - 1) * x;
      }
  
    // Ende Methoden
  } // end of class rekPot