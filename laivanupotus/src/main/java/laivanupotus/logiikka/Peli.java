package laivanupotus.logiikka;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.LaivaTyyppi;
import laivanupotus.domain.Suunta;

/**
 * Luokka hoitaa pelilautojen 
 * @author Mikael
 */

public class Peli {

    private Pelilauta pelaajanLauta;
    private Pelilauta tietokoneenLauta;

    public Peli(int leveys, int korkeus) {

        this.pelaajanLauta = new Pelilauta(leveys, korkeus);
        pelaajanLauta.luoLauta();
        
        this.tietokoneenLauta = new Pelilauta(leveys, korkeus);
        tietokoneenLauta.luoLauta();

        pelaajanLauta.getLauta();
        Laiva l = new Laiva(LaivaTyyppi.TUKIALUS);
        Laiva l2 = new Laiva(LaivaTyyppi.KRUISERI);
        Laiva l3 = new Laiva(LaivaTyyppi.DEBUGPELASTUSVENE);
        Laiva l4 = new Laiva(LaivaTyyppi.SUKELLUSVENE);
        
        l.setLaivanPisteet(3, 4, Suunta.VAAKA);
        l2.setLaivanPisteet(1, 1, Suunta.PYSTY);
        l3.setLaivanPisteet(0, 0, Suunta.VAAKA);
        l4.setLaivanPisteet(0, 1, Suunta.VAAKA);
        
        pelaajanLauta.asetaLaivaLaudalle(l);
        pelaajanLauta.asetaLaivaLaudalle(l2);
        pelaajanLauta.asetaLaivaLaudalle(l3);
        pelaajanLauta.asetaLaivaLaudalle(l4);
        
//        System.out.println(pelaajanLauta.getLauta()[4][4].onkoOsaLaivaa());
        pelaajanLauta.ammu(0, 0);
        pelaajanLauta.ammu(0, 3);
        pelaajanLauta.ammu(1, 4);
        
        pelaajanLauta.tulostaLauta();
        
        System.out.println(pelaajanLauta.getLaivojenMaara()); // tulostaa 1
    }

}
