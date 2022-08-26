import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import org.extraterrestrial.adt.BinTree;

public class Hoehlensuche extends JFrame 
{
  // Anfang Attribute
  BinTree hoehle=new BinTree();

  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JButton jButton1 = new JButton();
  // Ende Attribute
  
  public Hoehlensuche(String title) 
  { 
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
    String s="K";
    // K Links
    hoehle.setItem(s);
    BinTree l1=new BinTree();
    l1.setItem(s);
    hoehle.setLeft(l1);
    BinTree l22=new BinTree();
    l22.setItem(s);
    hoehle.getLeft().setRight(l22);
    // K Rechts
    BinTree r1=new BinTree();
    r1.setItem(s);
    hoehle.setRight(r1);
    BinTree r22=new BinTree();
    r22.setItem(s);
    hoehle.getRight().setRight(r22);
    BinTree r31=new BinTree();
    r31.setItem(s);
    hoehle.getRight().getRight().setLeft(r31);
    
    
    
    s="S";
    // S Links
    BinTree l21=new BinTree();
    l21.setItem(s);
    hoehle.getLeft().setLeft(l21);
    BinTree l31=new BinTree();
    l31.setItem(s);
    hoehle.getLeft().getRight().setLeft(l31);
    BinTree l32=new BinTree();
    l32.setItem(s);
    hoehle.getLeft().getRight().setRight(l32);
    // S Rechts
    BinTree r21=new BinTree();
    r21.setItem(s);
    hoehle.getRight().setLeft(r21);
    BinTree r32=new BinTree();
    r32.setItem(s);
    hoehle.getRight().getRight().setRight(r32);
    BinTree r41=new BinTree();
    r41.setItem(s);
    hoehle.getRight().getRight().getLeft().setLeft(r41);
    // A Rechts
    s="A";
    BinTree r42=new BinTree();
    r42.setItem(s);
    hoehle.getRight().getRight().getLeft().setRight(r42);
    
    
    jLabel1.setBounds(32, 48, 222, 52);
    jLabel1.setText("");
    cp.add(jLabel1);
    jLabel2.setBounds(24, 8, 131, 25);
    jLabel2.setText("Ausgabe:");
    cp.add(jLabel2);
    jButton1.setBounds(32, 168, 233, 41);
    jButton1.setText("Start!");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setBackground(new Color(0xB8CFE5));
    cp.add(jButton1);
    // Ende Komponenten
    
    setVisible(true);

    String string = "";
    System.out.println(inOrder(hoehle, string));
    System.out.println(string);

    // Test
    //jLabel1.setText(""+hoehle.getRight().getRight().getLeft().getRight().getItem());
  } // end of public Hoehlensuche
  
  
  
  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) 
  {
    // hier sollen alle Operationsaufrufe gestartet werden
    String s="";
    wegfinden(hoehle,s);
  } 
  
  public void wegfinden(BinTree b, String weg)
  {
    System.out.println(weg);
    if (((String)b.getItem()).equals("A")==true) 
    {
      weg = weg + "A";
      jLabel1.setText(weg);
    } 
    else
    {
      if (((String)b.getItem()).equals("K")==true) 
      {
        if (b.hasLeft()==true) 
        {
          String akt;
          akt = weg + "R";
          wegfinden(b.getLeft(),akt);
        } // end of if
        
        if (b.hasRight()==true) 
        {
          String akt;
          akt = weg + "L";
          wegfinden(b.getRight(),akt);
        } // end of if   
      } 
    }
  }
  // Ende Methoden
  

  public static String inOrder(BinTree b, String ausgabe) {
    if (b.hasLeft()) {
      inOrder(b.getLeft(), ausgabe);
      System.out.println(ausgabe);
    }
    ausgabe += b.getItem();
    if (b.hasRight()) {
      inOrder(b.getRight(), ausgabe);
      System.out.println(ausgabe);
    }
    System.out.println(ausgabe);
    return ausgabe;
  }
  
  
  
  public static void main(String[] args) {
    new Hoehlensuche("Hoehlensuche");
  } // end of main
  
} // end of class Hoehlensuche