package org.extraterrestrial.qp12;

import template.JNumberField;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class DynErstellungFrame extends JFrame {
  // Anfang Attribute
  private JNumberField jNumberField1 = new JNumberField();
  private JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  private JTextArea jTextArea1 = new JTextArea("");
  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  
  private int[] dynIntReihung=new int[0];
  // Ende Attribute
  
  public DynErstellungFrame(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jNumberField1.setBounds(96, 32, 73, 33);
    jNumberField1.setText("1");
    jNumberField1.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jNumberField1);
    jLabel1.setBounds(16, 32, 75, 33);
    jLabel1.setText("Eingabe:");
    cp.add(jLabel1);
    jButton1.setBounds(72, 96, 137, 41);
    jButton1.setText("Hinzufügen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) {
        try {
          jButton1_ActionPerformed(evt);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    cp.add(jButton1);
    jTextArea1ScrollPane.setBounds(32, 184, 217, 49);
    cp.add(jTextArea1ScrollPane);
    // Ende Komponenten



    setVisible(true);
  } // end of public DynErstellungFrame
  
  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) throws InterruptedException {
    dynIntReihung = push_back(dynIntReihung, jNumberField1.getInt());

    if (dynIntReihung.length > 10) {
      dynIntReihung = insert(dynIntReihung, 4, 69);
    }

    if (dynIntReihung.length > 20) {
      dynIntReihung = remove(dynIntReihung, 0);
    }




    jTextArea1.setText(Arrays.toString(dynIntReihung));
  } // end of jButton1_ActionPerformed

  public static int[] push_back(int[] arr, int elem) {
    int[] helper = new int[arr.length + 1];
    for (int i = 0; i < arr.length; i++) {
      helper[i] = arr[i];
    }
    helper[arr.length] = elem;
    return helper;
  };

  public static int[] insert(int[] arr, int index, int elem) {
    int[] helper = new int[arr.length + 1];
    for (int i = 0; i < index; i++) {
      helper[i] = arr[i];
    }
    helper[index] = elem;
    for (int i = index + 1; i < arr.length + 1; i++) {
      helper[i] = arr[i - 1];
    }

    return helper;
  };

  public static int[] remove(int[] arr, int index) {
    int[] helper = new int[arr.length - 1];
    for (int i = 0; i < index - 1; i++) {
      helper[i] = arr[i];
    }
    for (int i = index + 1; i < arr.length; i++) {
      helper[i - 1] = arr[i];
    }

    return helper;
  };

  // Ende Methoden
  
  public static void main(String[] args) {
    new DynErstellungFrame("DynErstellungFrame");
  } // end of main
  
} // end of class DynErstellungFrame