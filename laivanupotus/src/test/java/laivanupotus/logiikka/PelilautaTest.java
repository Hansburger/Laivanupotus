package laivanupotus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelilautaTest {

    Pelilauta testilauta;

    public PelilautaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testilauta = new Pelilauta(10, 10);
        testilauta.createLauta();
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
    public void pelilaudanKorkeusToimii() {
        assertEquals(10, testilauta.getKorkeus());
    }

    @Test
    public void pelilaudanLeveysToimii() {
        assertEquals(10, testilauta.getLeveys());
    }

}
