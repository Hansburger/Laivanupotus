/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import laivanupotus.domain.Laiva;
import laivanupotus.domain.LaivaTyyppi;
import laivanupotus.domain.Suunta;

/**
 * Luokka alustaa annetulle pelilaudalle laivat satunnaisesti
 */
public class LaivojenAlustaja {

    private Random random;

    public LaivojenAlustaja() {
        this.random = new Random();
    }

    /**
     * Suorittaa metodit laivojen luomista varten ja arpoo niille sopivat paikat
     * parametrina annetulle Pelilauta-oliolle
     * @param lauta Pelilauta-olio, jolle laivojen paikat arvotaan
     */
    
    public void alustaLaivat(Pelilauta lauta) {
        ArrayList<Laiva> laivat = luoAsetettavatLaivat();
        Iterator<Laiva> iterator = laivat.iterator();

        while (iterator.hasNext()) {
            Laiva laiva = iterator.next();

            arvoLaivalleAlkuPisteetJaSuunta(laiva, lauta);

            while (!lauta.asetaLaivaLaudalle(laiva)) {
                arvoLaivalleAlkuPisteetJaSuunta(laiva, lauta);
            }
            
        }
    }

    /**
     * Metodi luo listan Laiva-olioita
     * @return palauttaa ArrayListin jossa on Laiva-olioita
     */
    
    private ArrayList luoAsetettavatLaivat() {
        ArrayList<Laiva> laivat = new ArrayList<>();

        laivat.add(new Laiva(LaivaTyyppi.TUKIALUS));
        laivat.add(new Laiva(LaivaTyyppi.KRUISERI));
        laivat.add(new Laiva(LaivaTyyppi.SUKELLUSVENE));
        laivat.add(new Laiva(LaivaTyyppi.SUKELLUSVENE));
        laivat.add(new Laiva(LaivaTyyppi.PARTIOVENE));
        laivat.add(new Laiva(LaivaTyyppi.PARTIOVENE));

        return laivat;
    }

    /**
     * Metodi arpoo annetulle Laiva-oliolle aloituspisteen x- ja y-koordinaatit
     * ja suunnan. Laiva yritetään sitten asettaa parametrina annetulle laudalle
     * @param l annettu Laiva-olio
     * @param p annettu Pelilauta-olio
     */
    
    private void arvoLaivalleAlkuPisteetJaSuunta(Laiva l, Pelilauta p) {

        int x = random.nextInt(p.getLeveys());
        int y = random.nextInt(p.getKorkeus());

        boolean suunta = random.nextBoolean();

        if (suunta) {
            l.setLaivanPisteet(x, y, Suunta.VAAKA);
        } else {
            l.setLaivanPisteet(x, y, Suunta.PYSTY);
        }
    }
}
