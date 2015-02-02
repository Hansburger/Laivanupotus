package laivanupotus.logiikka;

import java.util.*;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.Piste;

/**
 * Luokka tarjoaa toiminnallisuudet laivojen käsittelyyn pelissä
 * Pelilaudan koko perustuu käyttäjän antamiin parametreihin laudan koosta
 */

public class Pelilauta {

    private Piste[][] lauta;
    private int leveys;
    private int korkeus;
    private ArrayList<Laiva> laudanLaivat = new ArrayList<Laiva>();
    private HashMap<Piste, Laiva> laivojenPisteet = new HashMap<Piste, Laiva>();


    public Pelilauta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.lauta = new Piste[leveys][korkeus];
    }
    
    /**
     * Metodi alustaa pelilaudan perustuen laudalle annettujen oliomuuttujien 
     * mukaan
     */

    public void luoLauta() {

        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                Piste p = new Piste(0, 0);
                p.setX(x);
                p.setY(y);

                lauta[x][y] = p;
            }
        }
    }

    public Piste[][] getLauta() {
        return this.lauta;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

//    public void getSektoriTyyppi(int x, int y) {
//         System.out.println(lauta[x][y]);
//    }

    /**
     * Asettaa parametrina annetun laivan pelilaudalle, suorittaa tarkistusmetodit
     * jotka vaikuttavat palautusarvoon
     * @param laiva annettu laiva joka halutaan sijoittaa laudalle
     * @return palauttaa true jos laivan asettaminen onnistui
     */
    
    public boolean asetaLaivaLaudalle(Laiva laiva) {
        if (laivaOnLaudanSisalla(laiva) && LaivaEiMeneToisenLaivanPaalle(laiva)) {
            laudanLaivat.add(laiva);
            for (Piste p : laiva.getPisteet()) {
                int tempX = p.getX();
                int tempY = p.getY();
                lauta[tempX][tempY].setOnLaiva();
                laivojenPisteet.put(p, laiva);
            }
            return true;
        }
        return false;
    }
    
    /**
     * Metodi huolehtii että parametrina annetun laivan pisteet menevät laudan
     * sisäpuolelle.
     * @param laiva laiva jonka pisteet tarkistetaan
     * @return palauttaa true jos laivan pisteet menevät laudan sisälle,
     * muulloin false
     */

    public boolean laivaOnLaudanSisalla(Laiva laiva) {
        TreeSet<Piste> laivaPisteet = laiva.getPisteet();
        
        Piste alkuPiste = laivaPisteet.first();
        Piste loppuPiste = laivaPisteet.last();

        if (alkuPiste.getX() < 0 || alkuPiste.getY() < 0) {
            return false;
        }

        if (alkuPiste.getX() > leveys || alkuPiste.getY() > korkeus) {
            return false;
        }

        if (loppuPiste.getX() > (leveys - 1) || loppuPiste.getY() > (korkeus - 1)) {
            return false;
        }

        return true;
    }
    
    /**
     * Metodi tarkistaa ettei haluttu laiva mene toisen laivan päälle päälle
     * @param laiva Laiva joka halutaan asettaa
     * @return palauttaa false jos laiva menee toisen laivan päälle laudalla,
     * muulloin true
     */
    
    public boolean LaivaEiMeneToisenLaivanPaalle(Laiva laiva) {
        
        TreeSet<Piste> laivaPisteet = laiva.getPisteet();
        
        for (Piste piste : laivaPisteet) {
            int tempX = piste.getX();
            int tempY = piste.getY();
            
            if (lauta[tempX][tempY].onkoOsaLaivaa()) {
                return false;
            }
        }

        return true;
    }
    
    /**
     * Metodi tarkistaa onko mahdollista ampua annettuun pisteeseen
     * @param p annettu piste-olio
     * @return palauttaa true jos onnistui
     */
    
    public boolean ammu(Piste p) {
        return ammu(p.getX(), p.getY());
    }
    
    /**
     * Metodi tarjoaa pelilaudalle ampumistoiminallisuuden ja tarkistaa jos on
     * mahdollista ampua annettuihin koordinaatteihin
     * @param x ammuttavan pisteen x-koordinaatti
     * @param y ammuttavan pisteen y-koordinaatti
     * @return palauttaa true jos ammuttavaan pisteeseen ei ole ammuttu tai 
     * siinä on laiva
     */
    
    public boolean ammu(int x, int y) {
        if (x > leveys || y > korkeus) {
//            System.out.println("ei pysty");
            return false;
        }
        if (x < 0 || y < 0) {
//            System.out.println("ei pysty");
            return false;
        }
        
        if (lauta[x][y].onkoOsaLaivaa() && !(lauta[x][y].onkoAmmuttuJo())) {
            lauta[x][y].setAmmuttu();
            lauta[x][y].setOsuttu();
            return true;
        }
        
        if (!(lauta[x][y].onkoAmmuttuJo())) {
            lauta[x][y].setAmmuttu();
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Metodi tarkistaa onko laudan kaikki laivat upotettu.
     * Metodi on olennainen, kun pitää tarkistaa pitääkö peli päättää
     * @return palauttaa true jos laudalla ei ole yhtäkään elävää laivaa
     */
    
    public boolean onkoKaikkiLaivatUpotettu() {
        boolean kaikkiUponneet = true;
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                    if (lauta[x][y].onkoOsaLaivaa() && !lauta[x][y].onkoOsuttu()) {
                        kaikkiUponneet = false;
                    }
                }
        }
        return kaikkiUponneet;
    }
    
    public String getLaivojenMaara() {
        return "Laivoja pelikentalla: " + laudanLaivat.size();
    }
    
    public void tulostaLauta() {
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                if (lauta[x][y].onkoOsuttu()) {
                    System.out.print("@ ");
                } else if (lauta[x][y].onkoOsaLaivaa()) {
                    System.out.print("# ");
                } else if (lauta[x][y].onkoAmmuttuJo()) {
                    System.out.print("¤ ");
                } else {
                    System.out.print("~ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
