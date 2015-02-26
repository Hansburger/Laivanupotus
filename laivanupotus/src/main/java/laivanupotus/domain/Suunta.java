
package laivanupotus.domain;

/**
 * Suunta määrittää laivalle suunnan jonka perusteella sen asetuksessa tiedetään
 * kuinka päin sen pitää olla.
 * @author Mikael
 */

public enum Suunta {

        VAAKA(0), PYSTY(1);
        private int suunta;

        private Suunta(int suunta) {
            this.suunta = suunta;
        }

        public int getSuunta() {
            return this.suunta;
        }

    }
