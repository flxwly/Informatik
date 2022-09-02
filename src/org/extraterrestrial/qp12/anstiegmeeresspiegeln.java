package org.extraterrestrial.qp12;

import template.JNumberField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Beschreibung
 *
 * @author
 * @version 1.0 vom 12.02.2022
 */

public class anstiegmeeresspiegeln extends JFrame {

    double[][] hoehenwerte = new double[10][10];
    JNumberField[][] feld = new JNumberField[10][10];

    private JButton jButton1 = new JButton();
    private JTextField tfTemperaturaenderunginC = new JTextField();
    private JNumberField nfEingabe = new JNumberField();
    private JTextField tfCO2AenderungproJahrinppm1 = new JTextField();
    private JNumberField jNumberField1 = new JNumberField();
    private JNumberField nfJahr = new JNumberField();
    private JTextField tfJahr = new JTextField();
    private JTextField jTextField1 = new JTextField();
    private JTextField tfEINGABE = new JTextField();
    private JTextField tfAUSGABE = new JTextField();
    private JTextField tfMomentanerWertca3ppm = new JTextField();

    public anstiegmeeresspiegeln() {

        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 739;
        int frameHeight = 528;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("meeresspiegel");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);


        jButton1.setBounds(545, 170, 120, 75);
        jButton1.setText("Start");
        jButton1.setBackground(Color.GREEN);
        jButton1.setMargin(new Insets(2, 2, 2, 2));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                starteAnimation(evt);
            }
        });
        cp.add(jButton1);

        tfTemperaturaenderunginC.setBounds(540, 380, 158, 20);
        tfTemperaturaenderunginC.setText("Temperatur�nderung in �C");
        tfTemperaturaenderunginC.setBackground(Color.WHITE);
        cp.add(tfTemperaturaenderunginC);

        nfEingabe.setBounds(539, 401, 179, 20);
        nfEingabe.setText("");
        nfEingabe.setBackground(Color.YELLOW);
        cp.add(nfEingabe);

        tfCO2AenderungproJahrinppm1.setBounds(534, 66, 174, 20);
        tfCO2AenderungproJahrinppm1.setText("CO2 �nderung pro Jahr in ppm");
        tfCO2AenderungproJahrinppm1.setBackground(Color.WHITE);
        cp.add(tfCO2AenderungproJahrinppm1);

        jNumberField1.setBounds(532, 88, 59, 20);
        jNumberField1.setText("");
        jNumberField1.setBackground(new Color(0xFFC800));
        cp.add(jNumberField1);

        nfJahr.setBounds(537, 349, 75, 20);
        nfJahr.setText("");
        nfJahr.setBackground(Color.YELLOW);
        cp.add(nfJahr);

        tfJahr.setBounds(536, 331, 54, 20);
        tfJahr.setText("Jahr");
        tfJahr.setBackground(Color.WHITE);
        cp.add(tfJahr);

        jTextField1.setBounds(536, 109, 150, 20);
        jTextField1.setText("Zahl von " + -2 + " bis " + 6 + " eingeben.\nDer momentane Wert liegt\n bei ca." + 3 + "ppn");
        jTextField1.setBackground(new Color(0xC0C0C0));
        cp.add(jTextField1);

        tfEINGABE.setBounds(535, 15, 62, 36);
        tfEINGABE.setText("EINGABE");
        tfEINGABE.setBackground(new Color(0xC0C0C0));
        cp.add(tfEINGABE);

        tfAUSGABE.setBounds(538, 278, 78, 36);
        tfAUSGABE.setText("AUSGABE");
        tfAUSGABE.setBackground(new Color(0xC0C0C0));
        cp.add(tfAUSGABE);

        tfMomentanerWertca3ppm.setBounds(536, 128, 161, 25);
        tfMomentanerWertca3ppm.setBackground(new Color(0xC0C0C0));
        tfMomentanerWertca3ppm.setText("(Momentaner Wert: ca 3ppm)");
        cp.add(tfMomentanerWertca3ppm);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                feld[i][j] = new JNumberField();
                feld[i][j].setBounds(48 * j, 48 * i, 48, 48);
                cp.add(feld[i][j]);

            }
        }

        setVisible(true);
    }

    public void felderEinfaerben() {
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if (feld[i][j].getDouble() > -1) {
                    feld[i][j].setBackground(new Color(0, 0, 153));
                    if (feld[i][j].getDouble() > 0) {
                        feld[i][j].setBackground(new Color(25, 71, 0));
                        if (feld[i][j].getDouble() > 0.5) {
                            feld[i][j].setBackground(new Color(51, 102, 0));
                            if (feld[i][j].getDouble() > 1) {
                                feld[i][j].setBackground(new Color(76, 153, 0));
                                if (feld[i][j].getDouble() > 2) {
                                    feld[i][j].setBackground(new Color(90, 175, 0));
                                    if (feld[i][j].getDouble() > 3) {
                                        feld[i][j].setBackground(new Color(102, 204, 0));
                                        if (feld[i][j].getDouble() > 5) {
                                            feld[i][j].setBackground(new Color(153, 255, 51));
                                            if (feld[i][j].getDouble() > 7) {
                                                feld[i][j].setBackground(new Color(178, 255, 102));
                                                if (feld[i][j].getDouble() > 8) {
                                                    feld[i][j].setBackground(new Color(204, 255, 153));
                                                    if (feld[i][j].getDouble() > 9) {
                                                        feld[i][j].setBackground(new Color(153, 255, 51));
                                                        if (feld[i][j].getDouble() > 10) {
                                                            feld[i][j].setBackground(new Color(178, 255, 102));
                                                            if (feld[i][j].getDouble() > 11) {
                                                                feld[i][j].setBackground(new Color(204, 255, 153));
                                                                if (feld[i][j].getDouble() > 15) {
                                                                    feld[i][j].setBackground(new Color(229, 255, 204));
                                                                } // end of if
                                                            } // end of if
                                                        } // end of if
                                                    } // end of if
                                                } // end of if
                                            } // end of if
                                        } // end of if
                                    } // end of if
                                } // end of if
                            } // end of if
                        } // end of if
                    } // end of if
                }
            }
        }
    }

    public void initialisierung(double[][] hoehenwerte) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                feld[i][j].setDouble(hoehenwerte[i][j]);
            }
        }
    }

    public void warte(long warteZeit) {
        long startZeit = System.currentTimeMillis();
        while (System.currentTimeMillis() < startZeit + warteZeit) {}
    }

    public void starteAnimation(ActionEvent evt) {

        // Die ersten Höhenwerte
        double[][] hoehenwerte = {
                        {0, 0, 0, 0, 0.5, 0.5, 0, 0, 0, 0},
                        {0, 0, 0.5, 1, 1, 2, 2, 2, 1, 0},
                        {0, 0.5, 0.5, 1, 8, 9, 9, 5, 3, 3},
                        {0, 0, 0.5, 2, 15, 17, 15, 5, 3, 3},
                        {0, 0, 1, 2, 2, 10, 11, 5, 1, 0},
                        {0, 0, 2, 5, 3, 2, 1, 0.5, 0, 0},
                        {0, 1, 8, 7, 2, 1, 0.5, 0, 0, 0},
                        {0.5, 1, 10, 8, 2, 0.5, 0.5, 0, 0.5, 0},
                        {0, 0.5, 0.5, 2, 1, 0.5, 0, 0.5, 1, 0},
                        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0}
                };

        int jahresIntervall = 5;
        int jahresZahl = 2000;
        double round = 0;
        double CO2Wert = Math.round(jNumberField1.getDouble() * 10.0) / 10.0;
        double temperaturaenderung = 0;
        double msWert = 0;

        //Einfärbung der Felder in Ausgangsform
        initialisierung(hoehenwerte);
        felderEinfaerben();

        //Programm wird nur ausgeführt, wenn der CO2 Wert realistisch ist
        if (-2 <= CO2Wert && CO2Wert <= 6) {
            jNumberField1.setBackground(Color.YELLOW);
            for (int zaehler = 0; zaehler < 20; zaehler++) {
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            round = Math.round(feld[i][j].getDouble() * 100.0) / 100.0;       //Runden des Wertes aus dem Feld
                            msWert = Math.round((round - (184.609 * temperaturaenderung + 99.14) / 1000) * 100.0) / 100.0;    //Berechnung des neuen Wertes durch: Zsm Ms Anstieg und Temperatur�nerung, Rundung
                            feld[i][j].setDouble(msWert);
                        }
                    }

                    //Einfärbung der Felder
                    felderEinfaerben();

                    nfJahr.setDouble(jahresZahl + 5 * zaehler);
                    temperaturaenderung = Math.round(((314 + zaehler * jahresIntervall * CO2Wert) * 0.0103 - 3.2508) * 100.0) / 100.0; //Berechnung der Temperatur�nderung
                    nfEingabe.setDouble(temperaturaenderung);

                    repaint();
                    warte(200);
                }
        } else {
            jNumberField1.setBackground(Color.RED);
        }


    }

    public static void main(String[] args) {
        anstiegmeeresspiegeln ex = new anstiegmeeresspiegeln();
    }
}