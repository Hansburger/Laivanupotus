package laivanupotus.domain;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.Laiva.Suunta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaivaTest {

    Laiva tukialus;
    Laiva kruiseri;
    Laiva subi;
    Laiva partio;

    public LaivaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tukialus = new Laiva(Laiva.LaivaTyyppi.TUKIALUS);
        kruiseri = new Laiva(Laiva.LaivaTyyppi.KRUISERI);
        subi = new Laiva(Laiva.LaivaTyyppi.SUKELLUSVENE);
        partio = new Laiva(Laiva.LaivaTyyppi.PARTIOVENE);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void tukialuksellaOikeaPituus() {

        assertEquals(5, tukialus.getPituus());
    }

    @Test
    public void kruiserillaOikeaPituus() {

        assertEquals(4, kruiseri.getPituus());
    }

    @Test
    public void subillaOikeaPituus() {

        assertEquals(3, subi.getPituus());
    }

    @Test
    public void partioBootilOikeaPituus() {

        assertEquals(2, partio.getPituus());
    }

    @Test
    public void laivanSuuntaVaihtuu() {

        tukialus.kaannaLaivanSuunta();

        assertEquals(Laiva.Suunta.PYSTY, tukialus.getSuunta());
    }

    @Test
    public void laivanSuuntaVaihtuuTakaisin() {
        tukialus.kaannaLaivanSuunta();
        tukialus.kaannaLaivanSuunta();
        assertEquals(Laiva.Suunta.VAAKA, tukialus.getSuunta());
    }

}
