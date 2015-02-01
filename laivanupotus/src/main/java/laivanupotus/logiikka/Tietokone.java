
package laivanupotus.logiikka;

import java.util.Random;
import laivanupotus.domain.Piste;

/**
 * Tietokoneen tekoäly joka yrittää ampua lähelle edellistä osumaa mikäli
 * mahdollista
 */

public class Tietokone {
    
    private Pelilauta lauta;
    private Random random = new Random();
    private Piste edellinenOsuma;
    private Piste edellinenKohde;
    
    public Tietokone(Pelilauta lauta) {
        this.lauta = lauta;
    }
    
    /**
     * Metodi ampumiseen joka arpoo kohdepisteen
     * Jos aiempi ammus osui, suorittaa toisen metodin joka pyrkii löytämään 
     * pisteen aiemman läheltä
     * @return 
     */
    
    public boolean ammu() {
        
        Piste kohde = null;
        
        if (edellinenOsuma == null) {
            kohde = arvoKohde();
        } else {
            kohde = arvoKohdeEdellisenViereen();
        }
        
        boolean osui = lauta.ammu(kohde.getX(), kohde.getY());
        if (osui) {
            edellinenOsuma = kohde;
        } else {
            edellinenOsuma = null;
        }
        edellinenKohde = kohde;
        return osui;
    }
    
    /**
     * Metodi arpoo X- ja Y-koordinaatit jotka se asettaa pisteelle
     * @return palauttaa Piste-olion
     */
    
    private Piste arvoKohde() {
        int x = random.nextInt(lauta.getLeveys());
        int y = random.nextInt(lauta.getKorkeus());
        return new Piste(x,y);
    }
    
    /**
     * Metodi arpoo koordinaatit jotka se asettaa palautettavalle Piste-oliolle
     * Arpoo suunnan josta aletaan etsiä uutta kohdetta
     * @return palauttaa Piste-olion
     */
    
    private Piste arvoKohdeEdellisenViereen() {
        int x = edellinenOsuma.getX();
        int y = edellinenOsuma.getY();
        
        int s = random.nextInt(2);
        if (s < 1) {
            if (x < lauta.getLeveys() - 1) {
                x++;
            } else {
                x--;
            }
        } else {
            if (y < lauta.getKorkeus() - 1) {
                y++;
            } else {
                y--;
            }
        }
        return new Piste(x, y);
    }
    
}
