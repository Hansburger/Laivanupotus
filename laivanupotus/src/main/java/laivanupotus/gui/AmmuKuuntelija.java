package laivanupotus.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import laivanupotus.domain.Pelaaja;
import laivanupotus.domain.Piste;
import laivanupotus.domain.Tulostaulu;
import laivanupotus.gui.PeliIkkuna;
import laivanupotus.gui.PelinaytonPiste;
import laivanupotus.logiikka.Peli;

public class AmmuKuuntelija implements ActionListener {

    private int x;
    private int y;
    private PeliIkkuna peliIkkuna;
    private Peli pelilogiikka;
    private Pelaaja p;
    private final PelinaytonPiste pp;

    public AmmuKuuntelija(PeliIkkuna ikkuna, Peli logiikka, int x, int y, PelinaytonPiste pp, Pelaaja pelaaja) {
        this.peliIkkuna = ikkuna;
        this.pelilogiikka = logiikka;
        this.x = x;
        this.y = y;
        this.pp = pp;
        this.p = pelaaja;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (peliIkkuna.getPelilogiikka().getTietokoneenLauta().onkoPisteeseenAmmuttu(pp.getPiste().getX(), pp.getPiste().getY())) {
            return;
        }

        if (peliIkkuna.getPelilogiikka().getTietokoneenLauta().ammu(pp.getPiste())) {
            pp.setText("@");
            pp.setBackground(Color.RED);
            p.lisaaPisteita(420);

            if (peliIkkuna.getPelilogiikka().getTietokoneenLauta().onkoKaikkiLaivatUpotettu()) {
                peliIkkuna.setTitle(peliIkkuna.getPelaaja().getNimi()+" Voitti!");
                p.lisaaPisteita(1000);
                peliIkkuna.lopetaPeli();
                return;
            }
        } else {
            pp.setText("~");
            pp.setBackground(Color.CYAN);
            boolean tietokoneOsui = false;
            while (pelilogiikka.getTietokone().ammu()) {
                
                paivitaPelaajanLautaPanel(true);
                if (peliIkkuna.getPelilogiikka().getPelaajanLauta().onkoKaikkiLaivatUpotettu()) {
                    peliIkkuna.setTitle("Tietokone Voitti!");
                    peliIkkuna.lopetaPeli();
                }
                tietokoneOsui = true;
            }
            if (!tietokoneOsui) {
                paivitaPelaajanLautaPanel(false);
            }

        }
    }

    private void paivitaPelaajanLautaPanel(boolean osuiko) {
        Piste p = pelilogiikka.getTietokone().edellinenKohde();
        JPanel pelaajanPanel = peliIkkuna.getPelaajanPelilautaPanel();

        // Haetaan piste ja kerrotaan sitä nappulan koolla ja lisätään sopiva vakio jolla ei tule virheilmoituksia :----D
        PelinaytonPiste pp = (PelinaytonPiste) pelaajanPanel.getComponentAt((p.getX() * 30) + 6, (p.getY() * 30) + 6);
        if (osuiko) {
            pp.setText("@");
            pp.setBackground(Color.RED);
        } else {
            pp.setText("~");
            pp.setBackground(Color.CYAN);
        }
    }

}
