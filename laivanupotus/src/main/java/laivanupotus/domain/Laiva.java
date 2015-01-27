package laivanupotus.domain;

import java.util.*;

public class Laiva {

    public enum LaivaTyyppi {

        TUKIALUS(5), KRUISERI(4), SUKELLUSVENE(3), PARTIOVENE(2), DEBUGPELASTUSVENE(1);
        private int tyyppi;

        LaivaTyyppi(int tyyppi) {
            this.tyyppi = tyyppi;
        }

        public int getTyyppi() {
            return this.tyyppi;
        }
    }

    public enum Suunta {

        VAAKA(0), PYSTY(1);
        private int suunta;

        private Suunta(int suunta) {
            this.suunta = suunta;
        }

        public int getSuunta() {
            return this.suunta;
        }

    }

    private int pituus;
    private Suunta suunta;
    private TreeSet<Piste> laivanPisteet;
    private Iterator<Piste> iterator;
//    private Piste alkuPiste;
//    private Piste loppuPiste;

    public Laiva(LaivaTyyppi tyyppi) {
        this.pituus = tyyppi.getTyyppi();
        this.suunta = suunta.VAAKA;
//        this.alkuPiste = alkuPiste;
//        this.loppuPiste = loppuPiste;
        laivanPisteet = new TreeSet<Piste>();

//        alustetaan laiva vaakatasoon, luodaan laivalle pisteet alkaen koordinaateista (1,1):
//        selkeyttÃ¤Ã¤ testaamista.
        for (int i = 0; i < this.pituus; ++i) {
            Piste p = new Piste(1, 1);
            p.setX(i + 1);
            p.setOsaLaivaa();
            laivanPisteet.add(p);
        }
//        System.out.println(laivanPisteet.toString());
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

    public void kaannaLaivanSuunta() {

        int uusiX = 0;
        int uusiY = 0;
        // tonne settiin pitÃ¤Ã¤ vaihtaa arvoja.........................
//        uusiX = piste.getX();
//        uusiY = piste.getY();
//        for(Piste p : laivanPisteet) {
//            // piste kerrallaan lÃ¤pi, 
//             if (suunta.equals(Suunta.VAAKA) {
//                  piste.SetX(uusiX);
//                  piste.SetY(++uusiY);
//             } else {
//                 piste.SetX(++uusiX);
//                 piste.SetX(uusiY);
//             }
//        }
        iterator = laivanPisteet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++; // iteraattori-indeksi
            Piste piste = iterator.next();
//            System.out.println(piste);
            if (i == 0) {
                uusiX = piste.getX();
                uusiY = piste.getY();
            }
            if (suunta.equals(Suunta.VAAKA)) {
                piste.setX(uusiX);
                piste.setY(++uusiY);
            } else {
                piste.setX(++uusiX);
                piste.setY(uusiY);
            }

        }

        if (this.suunta.equals(Suunta.VAAKA)) {
            this.suunta = Suunta.PYSTY;
        } else {
            this.suunta = Suunta.VAAKA;
        }
    }

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

    @Override
    public String toString() {
        return "Laivan pituus: " + pituus + "; Pisteet: [" + laivanPisteet.toString() + "]; Suunta: " + suunta;
    }
}
