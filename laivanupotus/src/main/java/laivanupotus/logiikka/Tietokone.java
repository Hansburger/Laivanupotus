package laivanupotus.logiikka;

import java.util.Random;
import laivanupotus.domain.Piste;

/**
 * Tietokoneen tekoÃ¤ly joka yrittÃ¤Ã¤ ampua lÃ¤helle edellistÃ¤ osumaa mikÃ¤li
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

    public Pelilauta getLauta() {
        return this.lauta;
    }

    /**
     * Metodi ampumiseen joka arpoo kohdepisteen Jos aiempi ammus osui,
     * suorittaa toisen metodin joka pyrkii lÃ¶ytÃ¤mÃ¤Ã¤n pisteen aiemman
     * lÃ¤heltÃ¤
     *
     * @return
     */
    public boolean ammu() {

        Piste kohde = null;

        if (edellinenOsuma == null) {
            kohde = arvoKohde();
        } else {
            kohde = arvoKohdeEdellisenViereen();
        }

        boolean osui = lauta.ammu(kohde);
        if (osui) {
            edellinenOsuma = kohde;
        } else {
            edellinenOsuma = null;
        }
        edellinenKohde = kohde;
        return osui;
    }

    /**
     * Metodi on testausta varten Metodilla voi määrittää mihin tietokone ampuu,
     * joten on mahdollista testata toimiiko tavallinen ampuminen
     *
     * @param x kohteen x-koordinaatti
     * @param y kohteen y-koordinaatti
     * @return palauttaa true jos osui, false jos ei
     */
    public boolean ammuKoordinaatteihin(int x, int y) {
        if (lauta.ammu(x, y)) {
            edellinenOsuma = new Piste(x, y);
            edellinenKohde = edellinenOsuma;
            return true;
        } else {
            edellinenOsuma = null;
            edellinenKohde = new Piste(x, y);
            return false;
        }
    }

    /**
     * Metodi arpoo X- ja Y-koordinaatit tarkistaen onko niihin jo ammuttu jotka
     * se asettaa palautettavalle Piste-oliolle
     * sisältää kamalan do-whilen
     *
     * @return palauttaa Piste-olion
     */
    private Piste arvoKohde() {
        int x;
        int y;
        do {
            x = random.nextInt(lauta.getLeveys());
            y = random.nextInt(lauta.getKorkeus());
        } while (lauta.getLauta()[x][y].onkoAmmuttuJo());
        
        return new Piste(x, y);
    }

    /**
     * Metodi arpoo koordinaatit jotka se asettaa palautettavalle Piste-oliolle
     * Arpoo suunnan josta aletaan etsiÃ¤ uutta kohdetta
     *
     * @return palauttaa Piste-olion
     */
    private Piste arvoKohdeEdellisenViereen() {
        int x = edellinenOsuma.getX();
        int y = edellinenOsuma.getY();

        boolean suunta = random.nextBoolean();
        if (suunta && y < (lauta.getLeveys() - 1)) {
            x++;
        } else if (suunta) {
            x--;
        }
        if (!suunta && y < (lauta.getKorkeus() - 1)) {
            y++;
        } else if (!suunta) {
            y--;
        }
        return new Piste(x, y);
    }

    /**
     * Metodi palauttaa Pisteen johon on viimeksi ammuttu
     *
     * @return Piste-olio edellisestä kohteesta
     */
    public Piste edellinenKohde() {
        return edellinenKohde;
    }

}
