package laivanupotus.logiikka;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.LaivaTyyppi;

public class Peli {

    private Pelilauta pelaajanLauta;
    private Pelilauta tietokoneenLauta;

    public Peli(int leveys, int korkeus) {

        this.pelaajanLauta = new Pelilauta(leveys, korkeus);
        pelaajanLauta.createLauta();
        
        this.tietokoneenLauta = new Pelilauta(leveys, korkeus);
        tietokoneenLauta.createLauta();

        pelaajanLauta.getLauta();
        Laiva l = new Laiva(LaivaTyyppi.DEBUGPELASTUSVENE);
        Laiva l2 = new Laiva(LaivaTyyppi.DEBUGPELASTUSVENE);

        pelaajanLauta.asetaLaivaLaudalle(l);
        pelaajanLauta.asetaLaivaLaudalle(l2); // lisays ei onnistu!
        
        System.out.println(pelaajanLauta.getLaivojenMaara()); // tulostaa 1
    }

}
