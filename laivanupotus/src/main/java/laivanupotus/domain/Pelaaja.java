package laivanupotus.domain;

/**
 * Luokka sisältää pelaajan nimen ja pisteet ja tarjoaa toiminallisuudet niiden
 * käsittelyyn
 */
public class Pelaaja implements Comparable<Pelaaja>{

    private String nimi;
    private int pisteet;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
    }

    public Pelaaja() {
    }

    public int getPisteet() {
        return pisteet;
    }

    /**
     * Metodi mahdollistaa pisteiden lisäyksen pelaajalle parametrina annetun
     * kokonaislukuarvon verran
     *
     * @param paljonko lisättävien pisteiden määrä
     */
    public void lisaaPisteita(int paljonko) {
        pisteet += paljonko;
    }

    public void setPisteet(int uusiMaara) {
        this.pisteet = uusiMaara;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    /**
     * Vertausmetodi jonka avulla pelaajia voidaan verrata heidän pisteidensä
     * perusteella. Suurimmat pisteet menevät ensimmäiseksi
     * @param p verrattava pelaaja
     * @return 
     */

    @Override
    public int compareTo(Pelaaja p) {
        int c = 0;
        if (pisteet == p.getPisteet()) {
            c = 0;
        }

        if (pisteet > p.getPisteet()) {
            c = -1;
        }

        if (pisteet < p.getPisteet()) {
            c = 1;
        }
        return c;
    }
    
//    @Override
//    public String toString() {
//        return nimi + ": " + pisteet;
//    }
}
