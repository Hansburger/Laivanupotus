package laivanupotus.logiikka;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.LaivaTyyppi;
import laivanupotus.domain.Suunta;
import laivanupotus.domain.Tulostaulu;

/**
 * Luokka hoitaa pelilautojen käsittelyn
 * @author Mikael
 */

public class Peli {

    private Pelilauta pelaajanLauta;
    private Pelilauta tietokoneenLauta;
    private LaivojenAlustaja alustaja;
    private Tietokone tekoaly;
    private Tulostaulu tulokset;

    public Peli(int leveys, int korkeus) {
        this.alustaja = new LaivojenAlustaja();
        this.tulokset = new Tulostaulu();
        luoLaudat(leveys, korkeus);
    }
    
    /**
     * Metodi alustaa Pelilauta-olion pelaajalle ja tietokoneelle
     * @param leveys
     * @param korkeus 
     */
    
    private void luoLaudat(int leveys, int korkeus) {
        pelaajanLauta = new Pelilauta(leveys, korkeus);
        tietokoneenLauta = new Pelilauta(leveys, korkeus);
        this.tekoaly = new Tietokone(pelaajanLauta);
    }
    
    
    /**
     * Metodi alustaa laivat Tietokoneen pelilaudalle käyttäen LaivojenAlustaja-
     * oliota
     */
    public void alustaLaivatTietokoneelle() {
        alustaja.alustaLaivat(tietokoneenLauta);
    }
    
    /**
     * Metodi alustaa laivat Pelaajan pelilaudalle käyttäen LaivojenAlustaja-oliota
     */
    public void alustaLaivatPelaajalle() {
        alustaja.alustaLaivat(pelaajanLauta);
    }
    
    /**
     * Metodi tarkistaa onko mahdollista lisata laivaa pelaajan laudalle
     * (ei käytössä toistaiseksi)
     * @param laiva annettu Laiva-olio
     * @return palauttaa false jos Laivaa ei voi lisätä
     */
//    public boolean lisaaLaiva(Laiva laiva) {
//        return pelaajanLauta.asetaLaivaLaudalle(laiva);
//    }
    
    public Pelilauta getTietokoneenLauta() {
        return tietokoneenLauta;
    }
    
    public Pelilauta getPelaajanLauta() {
        return pelaajanLauta;
    }
    
    public Tietokone getTietokone() {
        return tekoaly; 
   }

}
