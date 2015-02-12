import javax.swing.SwingUtilities;
import laivanupotus.gui.Kayttoliittyma;
import laivanupotus.logiikka.Pelilauta;
import laivanupotus.logiikka.Peli;
        
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kayttoliittyma().setVisible(true);
            }
        });
    }
}
