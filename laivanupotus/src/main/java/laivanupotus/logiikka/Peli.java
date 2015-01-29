package laivanupotus.logiikka;

import laivanupotus.domain.Laiva;

public class Peli {

    private Pelilauta pelaajanLauta;

    public Peli(int leveys, int korkeus) {

        this.pelaajanLauta = new Pelilauta(leveys, korkeus);
        pelaajanLauta.createLauta();

        pelaajanLauta.getLauta();
        Laiva l = new Laiva(Laiva.LaivaTyyppi.DEBUGPELASTUSVENE);
        Laiva l2 = new Laiva(Laiva.LaivaTyyppi.DEBUGPELASTUSVENE);

        pelaajanLauta.asetaLaivaLaudalle(l);
        pelaajanLauta.asetaLaivaLaudalle(l2); // lisays ei onnistu!
        
        System.out.println(pelaajanLauta.getLaivojenMaara()); // tulostaa 1
    }

}
