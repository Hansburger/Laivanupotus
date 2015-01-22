package laivanupotus.domain;

import java.util.*;

public class Laiva {

    public enum LaivaTyyppi {

        TUKIALUS(5), KRUISERI(4), SUKELLUSVENE(3), PARTIOVENE(2);
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
//    private Piste alkuPiste;
//    private Piste loppuPiste;

    public Laiva(LaivaTyyppi tyyppi) {
        this.pituus = tyyppi.getTyyppi();
        this.suunta = suunta.VAAKA;
//        this.alkuPiste = alkuPiste;
//        this.loppuPiste = loppuPiste;
        laivanPisteet = new TreeSet<Piste>();
        
//        alustetaan laiva vaakatasoon, luodaan laivalle pisteet:
        for (int i = 0; i < this.pituus; i++) {
            Piste p = new Piste(1, 1);
            p.setX(i+1);
            p.setOsaLaivaa();
            laivanPisteet.add(p);
        }
    }

    public int getPituus() {
        return pituus;
    }

    public Suunta getSuunta() {
        return suunta;
    }
    
    public void kaannaLaivanSuunta() {
        
        // tonne settiin pitää vaihtaa arvoja.........................
        
        if (this.suunta == Suunta.PYSTY) {
            this.suunta = Suunta.VAAKA;
        } else {
            this.suunta = Suunta.PYSTY;
        }
    }
}
