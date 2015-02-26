
package laivanupotus.domain;

/**
 * Laivatyyppi määrittää laivan pituuden
 * @author Mikael
 */

public enum LaivaTyyppi {

        TUKIALUS(5), KRUISERI(4), SUKELLUSVENE(3), PARTIOVENE(2), DEBUGPELASTUSVENE(1);
        private int tyyppi;

        LaivaTyyppi(int tyyppi) {
            this.tyyppi = tyyppi;
        }

        public int getTyyppi() {
            return this.tyyppi;
        }
    }
