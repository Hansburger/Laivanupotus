package laivanupotus.domain;

import java.util.*;

import laivanupotus.domain.LaivaTyyppi;
import laivanupotus.domain.Suunta;


/**
 * Luokka joka sisältää pelin laivojen toiminnaliisuudet
 */

public class Laiva {

    private int pituus;
    private Suunta suunta;
    private TreeSet<Piste> laivanPisteet;
    private Iterator<Piste> iterator;

    public Laiva(LaivaTyyppi tyyppi) {
        this.pituus = tyyppi.getTyyppi();
        this.suunta = suunta.VAAKA;
        laivanPisteet = new TreeSet<Piste>();
        alustaLaiva();

    }

    
    /**
     * Metodi alustaa laivalle sen pituuden verran pisteitä laivan omaan TreeSet tietorakenteeseen.
     */
    private void alustaLaiva() {
//        alustetaan laiva vaakatasoon, luodaan laivalle pisteet alkaen koordinaateista (1,1):
//        selkeyttÃ¤Ã¤ testaamista.
        for (int i = 0; i < this.pituus; ++i) {
            Piste p = new Piste(1, 1);
            p.setX(i + 1);
            p.setOnLaiva();
            laivanPisteet.add(p);
        }
    }

    public int getPituus() {
        return pituus;
    }

    public TreeSet<Piste> getPisteet() {
        return laivanPisteet;
    }

    public Suunta getSuunta() {
        return suunta;
    }
    
    /**
     * Metodi iteroi laivan pisteet läpi ja vaihtaa niiden X- ja Y-arvoja perustuen 
     * siihen mihin suuntaan laiva käännetään.
     */

    public void kaannaLaivanSuunta() {

        if (this.suunta.equals(Suunta.VAAKA)) {
            this.suunta = Suunta.PYSTY;
        } else {
            this.suunta = Suunta.VAAKA;
        }
        Piste alkupiste = laivanPisteet.first();
        setLaivanPisteet(alkupiste.getX(), alkupiste.getY(), suunta);
    }
    
    /**
     * 
     * @param x laivan uuden aloituspisteen x-koordinaatti
     * @param y laivan uuden aloituspisteen y-koordinaatti
     * @param suunta laivan suunta
     */

    public void setLaivanPisteet(int x, int y, Suunta suunta) {
        iterator = laivanPisteet.iterator();
        this.suunta = suunta;

        int i = 0;
        while (iterator.hasNext()) {
            Piste p = iterator.next();
            i++;
            if (i == 1) {
                p.setX(x);
                p.setY(y);
            } else {
                if (suunta.equals(Suunta.PYSTY)) {
                    p.setX(x);
                    p.setY(++y);
                } else {
                    p.setX(++x);
                    p.setY(y);
                }
            }
        }
    }
    
    /**
     * Metodi tarkistaa onko laiva uponnut.
     * 
     * @return palauttaa true, jos laivan jokaiseen pisteeseen on osunut.
     */
    
    public boolean upposiko() {
        boolean upposiko = true;
        Iterator<Piste> iter = laivanPisteet.iterator();
        while (iter.hasNext()) {
            Piste p = iter.next();
            if (!p.onkoOsuttu()) {
                return false;
            }
        }
        return upposiko;
    }

    @Override
    public String toString() {
        return "Laivan pituus: " + pituus + "; Pisteet: [" + laivanPisteet.toString() + "]; Suunta: " + suunta;
    }
}
