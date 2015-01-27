
package laivanupotus.domain;

public class Piste implements Comparable<Piste>{
    private int x;
    private int y;
    private boolean osaLaivaa = false;
    private boolean ammuttuJo = false;
    
//    public Piste() {
//    }
    
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
        return osaLaivaa;
    }
    
    public void setOsaLaivaa() {
        this.osaLaivaa = true;
    }
    
    public boolean onkoAmmuttuJo() {
        return ammuttuJo;
    }
    
    public void setAmmuttu() {
        this.ammuttuJo = true;
    }

    @Override
    public int compareTo(Piste t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "(" + this.x + "," + this.y + "); " + "kuuluu laivaan: " + osaLaivaa + "; ammuttu: " + ammuttuJo;
    }
}
