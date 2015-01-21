
package laivanupotus.logiikka;


public class Peli {
    private Pelilauta pelaajanLauta;
    private Pelilauta vihuLauta;

    
    public Peli(int leveys, int korkeus) {
        this.pelaajanLauta = new Pelilauta(leveys, korkeus);
        pelaajanLauta.createLauta();
        
        this.vihuLauta = new Pelilauta(leveys, korkeus);
        vihuLauta.createLauta();
        
        
    }
    
}
