package laivanupotus.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import laivanupotus.domain.Pelaaja;
import laivanupotus.logiikka.Peli;

public class Kayttoliittyma extends JFrame {

    private Peli peliLogiikka;
    private Pelaaja pelaaja;

    private JPanel panel = new JPanel();

    // Menu
    private JMenu aloitusMenu;
    private javax.swing.JMenuBar menuBar;
    // MenuItems
    private javax.swing.JMenuItem uusiPeli;
    private javax.swing.JMenuItem lopetaPeli;

    // Label
    private javax.swing.JLabel kentanKokoLabel;
    private javax.swing.JLabel nimiLabel;

    // TextField
    private javax.swing.JTextField nimiKentta;
    private javax.swing.JTextField XKentta;
    private javax.swing.JTextField YKentta;

    public Kayttoliittyma() {
        luoKomponentit();
    }

    private void luoKomponentit() {

        this.setTitle("Laivanupotus");

        luoIkkunanMenu();

        menuBar.add(aloitusMenu);

        this.setJMenuBar(menuBar);
        
        Container cont = getContentPane();
        luoIkkunanSisalto(cont);

        setPreferredSize(new Dimension(300, 300));
        pack();
        setVisible(true);
    }

    private void luoIkkunanMenu() {
        menuBar = new javax.swing.JMenuBar();
        aloitusMenu = new javax.swing.JMenu();
        lopetaPeli = new javax.swing.JMenuItem();

        uusiPeli = new javax.swing.JMenuItem();

        aloitusMenu.setText("Menu");
        uusiPeli.setText("Uusi Peli");
        lopetaPeli.setText("Lopeta");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.add(aloitusMenu);

        uusiPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        lopetaPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        aloitusMenu.add(uusiPeli);
        aloitusMenu.add(lopetaPeli);
    }

    private void luoIkkunanSisalto(Container cont) {
        
        BoxLayout leiska = new BoxLayout(cont, BoxLayout.Y_AXIS);
        cont.setLayout(leiska);

        nimiLabel = new javax.swing.JLabel();
        nimiLabel.setText("Kuka olet: ");
        
        kentanKokoLabel = new javax.swing.JLabel();
        kentanKokoLabel.setText("Kentän koko(X, Y): ");

        nimiKentta = new javax.swing.JTextField();
        
        XKentta = new javax.swing.JTextField();
        XKentta.setText("10");
        YKentta = new javax.swing.JTextField();
        YKentta.setText("10");
        
        cont.add(nimiLabel);
        cont.add(nimiKentta);
        cont.add(kentanKokoLabel);
        cont.add(XKentta);
        cont.add(YKentta);
    }

//    public static void main(String[] args) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Kayttoliittyma().setVisible(true);
//            }
//        });
//    }
}
