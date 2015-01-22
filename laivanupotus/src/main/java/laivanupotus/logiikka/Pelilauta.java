
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
    final static int tyhjaaMerta = 0;
    final static int laiva = 1;
    final static int ammuttuOsu = 2;
    final static int ammuttuOhi = 3;
    
    public Pelilauta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.lauta = new Piste[leveys][korkeus];
    }
    
    public void createLauta() {
        
        Piste p = null;
                
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                p = new Piste(0,0);
                p.setX(j);
                p.setY(i);
                
                lauta[i][j] = p;
            }
        }
    }
    
    public Piste[][] getLauta() {
        return lauta;
    }
    
    public int getKorkeus() {
        return korkeus;
    }
    
    public int getLeveys() {
        return leveys;
    }
    
    public Piste getSektoriTyyppi(int x, int y) {
        return lauta[x][y];
    }
   
}
