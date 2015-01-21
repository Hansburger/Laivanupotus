
package laivanupotus.domain;

public class Piste implements Comparable<Piste>{
    private int x;
    private int y;
    
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

    @Override
    public int compareTo(Piste t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int x = t.getX();
        int y = t.getY();
        
        return 1;
    }
}
