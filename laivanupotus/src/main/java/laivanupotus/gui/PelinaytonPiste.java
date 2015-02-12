package laivanupotus.gui;

import javax.swing.JButton;
import laivanupotus.domain.Piste;

public class PelinaytonPiste extends JButton {

    Piste p = null;

    public PelinaytonPiste(Piste p) {
        super();
        this.p = p;
    }

    public Piste getPiste() {
        return p;
    }
}
