
package laivanupotus.domain;

/**
 * Luokkaa käytetään pelilaudan ja laivojen alustamiseen.
 * Piste-olioon tallennetaan tiedot siitä onko siihen ammuttu, onko siinä laiva
 * ja onko siinä olevaan laivaan osuttu.
 */

public class Piste implements Comparable<Piste>{
    private int x;
    private int y;
    private boolean onkoLaiva = false;
    private boolean onkoAmmuttu = false;
    private boolean onkoOsuttu = false;
    
    public Piste(int inputX, int inputY) {
        this.x = inputX;
        this.y = inputY;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setX(int uusiX) {
        this.x = uusiX;
    }
    
    public void setY(int uusiY) {
        this.y = uusiY;
    }
    
    public boolean onkoOsaLaivaa() {
        return onkoLaiva;
    }
    
    public void setOnLaiva() {
        this.onkoLaiva = true;
    }
    
    public boolean onkoAmmuttuJo() {
        return onkoAmmuttu;
    }
    
    public void setAmmuttu() {
        this.onkoAmmuttu = true;
    }
    
    public boolean onkoOsuttu() {
        return onkoOsuttu;
    }
    
    public void setOsuttu() {
        this.onkoOsuttu = true;
    }
    
    /**
     * Metodilla verrataan kahta piste-oliota.
     * @param t verrattava piste
     * @return Metodi palauttaa -1 jos verrattavan pisteen koordinaatit ovat pienemmät
     * kuin verrattavan, 0 jos pisteet ovat samat ja 1 jos verrattava on isompi.
     */

    @Override
    public int compareTo(Piste t) {
//        compareto jos pienempi palauta -1, jos isompi palauta 1, jos sama palauta 0
        int x = t.getX();
        int y = t.getY();
        
        if (this.x == x && this.y < y) {
            return -1;
        }

        if (this.x < x && this.y == y) {
            return -1;
        }
        
        if (this.x < x && this.y < y) {
            return -1;
        }

        if (this.x == x && this.y == y) {
            return 0;
        }

        return 1;
    }
    
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "); " + "kuuluu laivaan: " + onkoLaiva + "; ammuttu: " + onkoAmmuttu;
    }
}
