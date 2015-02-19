package laivanupotus.logiikka;

import java.util.*;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.Piste;
import laivanupotus.domain.Suunta;

/**
 * Luokka tarjoaa toiminnallisuudet laivojen käsittelyyn pelissä Pelilaudan koko
 * perustuu käyttäjän antamiin parametreihin laudan koosta. Tärkeä huomio,
 * koordinaatit menevät 0...X-1 ja 0...Y-1. Eli korkeuden ollessa 10, se menee
 * 0...9
 */
public class Pelilauta {

    private Piste[][] lauta;
    private int leveys;
    private int korkeus;
    private ArrayList<Laiva> laudanLaivat = new ArrayList<Laiva>();
    private ArrayList<Piste> kielletytPisteet = new ArrayList<Piste>();

    public Pelilauta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.lauta = new Piste[leveys][korkeus];
        luoLauta();
    }

    /**
     * Metodi alustaa pelilaudan perustuen laudalle annettujen oliomuuttujien
     * mukaan
     */
    private void luoLauta() {

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
     * Asettaa parametrina annetun laivan pelilaudalle. Pitää myös huolen, että
     * annettu laiva on mahdollista sijoittaa laudalle.
     *
     * @param laiva annettu laiva joka halutaan sijoittaa laudalle
     * @return palauttaa true jos laivan asettaminen onnistui
     */
    public boolean asetaLaivaLaudalle(Laiva laiva) {
        if (laivaOnLaudanSisalla(laiva) && laivaEiMeneToisenLaivanPaalle(laiva)) {
            laudanLaivat.add(laiva);
            paivitaLaivojenYmparoivatPisteet(laiva);
            for (Piste p : laiva.getPisteet()) {
                int tempX = p.getX();
                int tempY = p.getY();
                lauta[tempX][tempY].setOnLaiva();
            }
            return true;
        }
        return false;
    }

    /**
     * Metodi huolehtii että parametrina annetun laivan pisteet menevät laudan
     * sisäpuolelle.
     *
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

        if (alkuPiste.getX() >= leveys || alkuPiste.getY() >= korkeus) {
            return false;
        }

        if (loppuPiste.getX() >= leveys || loppuPiste.getY() >= korkeus) {
            return false;
        }

        return true;
    }

    /**
     * Metodi tarkistaa ettei haluttu laiva mene toisen laivan päälle päälle
     *
     * @param laiva Laiva joka halutaan asettaa
     * @return palauttaa false jos laiva menee toisen laivan päälle laudalla,
     * muulloin true
     */
    private boolean laivaEiMeneToisenLaivanPaalle(Laiva laiva) {
        
        TreeSet<Piste> laivaPisteet = laiva.getPisteet();

        // nyt toimii
        for (Piste piste : laivaPisteet) {
            int tempX = piste.getX();
            int tempY = piste.getY();
            
            if (lauta[tempX][tempY].onkoOsaLaivaa()) {
                return false;
            }

            if (kielletytPisteet.contains(lauta[tempX][tempY])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metodi tarkistaa onko mahdollista ampua annettuun pisteeseen
     *
     * @param p annettu piste-olio
     * @return palauttaa true jos onnistui
     */
    public boolean ammu(Piste p) {
        return ammu(p.getX(), p.getY());
    }

    /**
     * Metodi tarjoaa pelilaudalle ampumistoiminallisuuden ja tarkistaa jos on
     * mahdollista ampua annettuihin koordinaatteihin
     *
     * @param x ammuttavan pisteen x-koordinaatti
     * @param y ammuttavan pisteen y-koordinaatti
     * @return palauttaa true jos ammuttavaan pisteeseen ei ole ammuttu tai
     * siinä on laiva
     */
    public boolean ammu(int x, int y) {

        if (x >= leveys || y >= korkeus) {
            return false;
        } else if (x < 0 || y < 0) {
            return false;
        } else if (lauta[x][y].onkoAmmuttuJo()) {
            return false;
        } else if (lauta[x][y].onkoOsaLaivaa()) {
            lauta[x][y].setOsuttu();
            lauta[x][y].setAmmuttu();
            return true;
        } else {
            lauta[x][y].setAmmuttu();
            return false;
        }

    }

    /**
     * Metodi tarkistaa onko laudan kaikki laivat upotettu. Metodi on
     * olennainen, kun pitää tarkistaa pitääkö peli päättää
     *
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

    public int getLaivojenMaara() {
        return laudanLaivat.size();
    }

    /**
     * Metodi tulostaa laudan tilanteen. Jos pisteessä laivaan on osuttu,
     * piirretään @, jos Pisteessä on osa laivaa piirretään #, jos Pisteeseen on
     * ammuttu piirretään ¤ ja jos siinä on vain tyhjää merta piirretään ~
     * Metodi ainoastaan debuggausta varten ja siksi poissa käytöstä
     */
//    public void tulostaLauta() {
//        for (int y = 0; y < korkeus; y++) {
//            for (int x = 0; x < leveys; x++) {
//                if (lauta[x][y].onkoOsuttu()) {
//                    System.out.print("@ ");
//                } else if (lauta[x][y].onkoOsaLaivaa()) {
//                    System.out.print("# ");
//                } else if (lauta[x][y].onkoAmmuttuJo()) {
//                    System.out.print("¤ ");
//                } else {
//                    System.out.print("~ ");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
    /**
     * Metodi tarkistaa onko parametrina annetuissa koordinaateissa laivaa
     *
     * @param x annettu laudan x-koordinaatti
     * @param y annettu laudan y-koordinaatti
     * @return palauttaa true jos pisteessä on laiva
     */
    public boolean onkoPisteessaLaiva(int x, int y) {
        if (lauta[x][y] != null && x > -1 && x < leveys && y > -1 && y < korkeus) {
            return lauta[x][y].onkoOsaLaivaa();
        } else {
            return false;
        }
    }

    /**
     * Metodi tarkista onko parametrina annettuihin koordinaatteihin jo ammuttu.
     *
     * @param x annettu laudan x-koordinaatti
     * @param y annettu laudan y-koordinaatti
     * @return palauttaa true jos pisteeseen on ammuttu
     */
    public boolean onkoPisteeseenAmmuttu(int x, int y) {
        if (lauta[x][y] != null && x > -1 && x < leveys && y > -1 && y < korkeus) {
            return lauta[x][y].onkoAmmuttuJo();
        } else {
            return false;
        }
    }

    /**
     * Metodi lisaa parametrina annetun laivan pisteet ja ymparoivat pisteet
     * kielletytPisteet settiin, jonka avulla määritetään minne voidaan asettaa
     * laiva ja minne ei.
     *
     * @param laiva parametrina annettu Laiva-olio
     */
    private void paivitaLaivojenYmparoivatPisteet(Laiva laiva) {
        TreeSet<Piste> laivanPisteet = laiva.getPisteet();

        for (Piste p : laivanPisteet) {
            int x = p.getX();
            int y = p.getY();

//            kielletytPisteet.add(lauta[x][y]);
            
            if (x + 1 < leveys) {
                kielletytPisteet.add(lauta[x + 1][y]);
            }
            if (x - 1 >= 0) {
                kielletytPisteet.add(lauta[x - 1][y]);
            }
            if (y - 1 >= 0) {
                kielletytPisteet.add(lauta[x][y - 1]);
            }
            if (y + 1 < korkeus) {
                kielletytPisteet.add(lauta[x][y + 1]);
            }

        }
    }

}
