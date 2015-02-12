
package laivanupotus.domain;

//import java.util.Iterator;
import java.util.TreeSet;

/**
 * Luokka pitää kirjaa Pelaajista ja niiden pisteistä
 */
public class Tulostaulu {
    
    TreeSet<Pelaaja> pelaajat;
    
    public Tulostaulu() {
        pelaajat = new TreeSet<Pelaaja>();
    }
    
    public TreeSet<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    
    /**
     * Metodi lisää parametrina annetun pelaajan taulukkoon
     * @param p Pelaaja-olio
     */
    
    public void lisaaPelaajaTaulukkoon(Pelaaja p) {
        pelaajat.add(p);
    }
    
    public int getHuonoinPistetulos() {
        return pelaajat.last().getPisteet();
    }
    
    public int getParasPistetulos() {
        return pelaajat.first().getPisteet();
    }
    
    /**
     * Metodi kokoaa taulukon luettavaksi String-olioksi, joka näyttää pelaajat
     * ja heidän pisteensä.
     * @return String-olio
     */
    
//    @Override
//    public String toString() {
//        Iterator<Pelaaja> iter = pelaajat.iterator();
//        Pelaaja p = null;
//        StringBuffer b = new StringBuffer();
//        while (iter.hasNext()) {
//            p = iter.next();
//            b.append(p.getNimi());
//            b.append(": ");
//            b.append(p.getPisteet());
//            b.append("\n");
//        }
//        return b.toString();
//    }
}
