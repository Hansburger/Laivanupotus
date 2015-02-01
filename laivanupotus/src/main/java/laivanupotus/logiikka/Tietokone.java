
package laivanupotus.logiikka;

import java.util.Random;
import laivanupotus.domain.Piste;

public class Tietokone {
    
    private Pelilauta lauta;
    private Random random = new Random();
    private Piste edellinenOsuma;
    private Piste edellinenKohde;
    
    public Tietokone(Pelilauta lauta) {
        this.lauta = lauta;
    }
    
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
    
    private Piste arvoKohde() {
        int x = random.nextInt(lauta.getLeveys());
        int y = random.nextInt(lauta.getKorkeus());
        return new Piste(x,y);
    }
    
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
