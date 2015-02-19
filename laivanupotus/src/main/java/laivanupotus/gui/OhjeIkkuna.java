package laivanupotus.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OhjeIkkuna extends JFrame {

    private final javax.swing.JLabel teksti = new JLabel();
//    private javax.swing.JPanel ohjePanel = new JPanel();

    public OhjeIkkuna() {
        luoKomponentit();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Dimension d = new Dimension(400, 400);
        this.setPreferredSize(d);

        setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public void luoKomponentit() {
        this.setTitle("Ohjeet");

        Container cont = getContentPane();
        luoTeksti(cont);
    }

    private void luoTeksti(Container cont) {
        BoxLayout leiska = new BoxLayout(cont, BoxLayout.Y_AXIS);
        cont.setLayout(leiska);
        
        String text = "<html><h1 align='center'>Laivanupotus</h1>";
        text += "Peli koostuu pelilaudasta jonka koon (8-15) voit määritellä aloitusikkunassa.<br/>Tarkoituksenasi on upottaa tietokoneen laivat.<br/>";
        text += "Sinulla ja tietokoneella kummallakin on yhtä paljon laivoja jotka ovat<br/>satunnaisesti aseteltu pelilaudalle.<br/>";
        text += "Tietokoneen laudalla on punainen reunus ja sinun laudallasi on <br/>vihreä. Sinun laudallesi on merkitty #-merkillä laivojesi sijainnit.<br/>";
        text += "Jokaisen osuman jälkeen saat ampua uudelleen ja peli päättyy kun toisen laudan jokainen laiva on uponnut.<br/>";
        text += "<br/>Laivat ovat:<br/>";
        text += "<tr><td align='left'>Laivatyyppi</td><td align='center'>Lukumäärä</td><td align='right'>Pituus</td></tr>";
        text += "<tr><td align='left'>Lentotukialus</td><td align='right'>1</td><td align='right'>5</td></tr>";
        text += "<tr><td align='left'>Risteilijä</td><td align='right'>1</td><td align='right'>4</td></tr>";
        text += "<tr><td align='left'>Sukellusvene</td><td align='right'>2</td><td align='right'>3</td></tr>";
        text += "<tr><td align='left'>Partiovene</td><td align='right'>2</td><td align='right'>2</td></tr>";
        
        teksti.setText(text);
        cont.add(teksti);
    }

}
