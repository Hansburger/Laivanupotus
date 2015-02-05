package laivanupotus.logiikka;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.LaivaTyyppi;
import laivanupotus.domain.Suunta;

/**
 * Luokka hoitaa pelilautojen käsittelyn
 * @author Mikael
 */

public class Peli {

    private Pelilauta pelaajanLauta;
    private Pelilauta tietokoneenLauta;
    private LaivojenAlustaja alustaja = new LaivojenAlustaja();

    public Peli(int leveys, int korkeus) {

        this.pelaajanLauta = new Pelilauta(leveys, korkeus);
        
        this.tietokoneenLauta = new Pelilauta(leveys, korkeus);
        
        alustaLaivatPelaajalle();
        alustaLaivatTietokoneelle();
        
        pelaajanLauta.tulostaLauta();
        tietokoneenLauta.tulostaLauta();
        
        System.out.println(pelaajanLauta.getLaivojenMaara()); // tulostaa 1
    }
    
    public void alustaLaivatTietokoneelle() {
        alustaja.alustaLaivat(tietokoneenLauta);
    }
    
    public void alustaLaivatPelaajalle() {
        alustaja.alustaLaivat(pelaajanLauta);
    }
    
    public boolean lisaaLaiva(Laiva laiva) {
        return pelaajanLauta.asetaLaivaLaudalle(laiva);
    }
    
    public Pelilauta getTietokoneenLauta() {
        return tietokoneenLauta;
    }
    
    public Pelilauta getPelaajanLauta() {
        return pelaajanLauta;
    }

}
