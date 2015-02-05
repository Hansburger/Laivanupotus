import javax.swing.SwingUtilities;
import laivanupotus.gui.Kayttoliittyma;
import laivanupotus.logiikka.Pelilauta;
import laivanupotus.logiikka.Peli;
        
public class Main {
    public static void main(String[] args) {
        Peli p = new Peli(11, 11);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kayttoliittyma().setVisible(true);
            }
        });
    }
}
