
package laivanupotus.domain;

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
