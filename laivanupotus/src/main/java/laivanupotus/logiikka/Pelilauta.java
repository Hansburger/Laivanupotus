package laivanupotus.logiikka;

import java.util.*;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.Piste;

public class Pelilauta {

    private Piste[][] lauta;
    private int leveys;
    private int korkeus;
    private ArrayList<Laiva> laudanLaivat = new ArrayList<Laiva>();

    // sektorityypit
//    ei taideta tarvita
//    final static int tyhjaaMerta = 0;
//    final static int laiva = 1;
//    final static int ammuttuOsu = 2;
//    final static int ammuttuOhi = 3;

    public Pelilauta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.lauta = new Piste[leveys][korkeus];
    }

    public void createLauta() {

        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                Piste p = new Piste(0, 0);
                p.setX(j);
                p.setY(i);

                lauta[i][j] = p;
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

    public boolean asetaLaivaLaudalle(Laiva laiva) {
        if (laivaOnLaudanSisalla(laiva) && LaivaEiMeneToisenLaivanPaalle(laiva)) {
            laudanLaivat.add(laiva);
            for (Piste p : laiva.getPisteet()) {
                int tempX = p.getX();
                int tempY = p.getY();
                lauta[tempX][tempY].setOnLaiva();
            }
            return true;
        }
        return false;
    }

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
    
    public boolean ammu(int x, int y) {
        if (x > leveys || y > leveys) {
//            System.out.println("ei pysty");
            return false;
        }
        if (x < 0 || y < 0) {
//            System.out.println("ei pysty");
            return false;
        }
        
        if (lauta[x][y].onkoOsaLaivaa() && !(lauta[x][y].onkoAmmuttuJo())) {
            lauta[x][y].setAmmuttu();
            return true;
        }
        
        return false;
    }
    
    public String getLaivojenMaara() {
        return "Laivoja pelikentalla: " + laudanLaivat.size();
    }

}
