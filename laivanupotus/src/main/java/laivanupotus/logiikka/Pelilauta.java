
package laivanupotus.logiikka;

import laivanupotus.domain.Laiva;
import java.util.*;

public class Pelilauta {
    private int[][] lauta;
    private int leveys;
    private int korkeus;
    private ArrayList<Laiva> laudanLaivat = new ArrayList<Laiva>();
    
    // sektorityypit
    final static int tyhjaaMerta = 0;
    final static int laiva = 1;
    final static int ammuttuOsu = 2;
    final static int ammuttuOhi = 3;
    
    public Pelilauta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.lauta = new int[leveys][korkeus];
    }
    
    public void createLauta() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                lauta[i][j] = tyhjaaMerta;
            }
        }
    }
    
    public int[][] getLauta() {
        return this.lauta;
    }
    
    public int getKorkeus() {
        return korkeus;
    }
    
    public int getLeveys() {
        return leveys;
    }
    
    public int getSektoriTyyppi(int x, int y) {
        return lauta[x][y];
    }
    
}
