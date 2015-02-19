package laivanupotus.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import laivanupotus.domain.Pelaaja;
import laivanupotus.domain.Piste;
import laivanupotus.domain.Tulostaulu;
import laivanupotus.logiikka.Peli;
import laivanupotus.logiikka.Pelilauta;

public class PeliIkkuna extends JFrame {

    // Pelin luokat
    private Peli pelilogiikka;
    private Pelaaja pelaaja;
    private Tulostaulu tulokset;
    private ArrayList<PelinaytonPiste> kuuntelijaKokoelma = new ArrayList<>();

    // Panel
    private JPanel PelaajanPelilautaPanel;

    public PeliIkkuna(int x, int y, Pelaaja p) {
        pelilogiikka = new Peli(x, y);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        this.pelaaja = p;
    }

    public JPanel luoPelilautaPanel(boolean pelaajalle) {
        GridLayout leiska = new GridLayout(pelilogiikka.getPelaajanLauta().getLeveys(), pelilogiikka.getPelaajanLauta().getKorkeus());
        JPanel PelilautaPanel = new JPanel(leiska);

        if (pelaajalle) {
            pelilogiikka.alustaLaivatPelaajalle();
        } else {
            pelilogiikka.alustaLaivatTietokoneelle();
        }

        for (int y = 0; y < pelilogiikka.getPelaajanLauta().getKorkeus(); y++) {
            for (int x = 0; x < pelilogiikka.getPelaajanLauta().getLeveys(); x++) {
                Piste p = new Piste(x, y);
                PelinaytonPiste pp = new PelinaytonPiste(p);
                pp.setPreferredSize(new Dimension(30, 30));
                pp.setFont(new Font("Arial", Font.BOLD, 15));
                pp.setMargin(new Insets(0, 0, 0, 0));
//                pp.setName(x + "," + y);

                if (pelaajalle) {
                    if (pelilogiikka.getPelaajanLauta().onkoPisteessaLaiva(x, y)) {
                        pp.setText("#");
                    }
                }

                if (!pelaajalle) {
                    pp.addActionListener(new AmmuKuuntelija(this, pelilogiikka, x, y, pp, pelaaja));
                    kuuntelijaKokoelma.add(pp);
                }
                PelilautaPanel.add(pp);
            }
        }

        return PelilautaPanel;
    }

    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    public void setPelaajanPelilautaPanel(JPanel pelaajanRuudukkoPanel) {
        this.PelaajanPelilautaPanel = pelaajanRuudukkoPanel;
    }

    public JPanel getPelaajanPelilautaPanel() {
        return PelaajanPelilautaPanel;
    }

    public Peli getPelilogiikka() {
        return pelilogiikka;
    }
    
    public void lopetaPeli() {
        for (PelinaytonPiste pp : kuuntelijaKokoelma) {
            for (ActionListener ak : pp.getActionListeners()) {
                pp.removeActionListener(ak);
            }
        }
    }

}
