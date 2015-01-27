package laivanupotus.domain;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.Laiva.Suunta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.TreeSet;

public class LaivaTest {

    Laiva tukialus;
    Laiva kruiseri;
    Laiva subi;
    Laiva partio;
    Laiva debugvene;
    
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
        debugvene = new Laiva(Laiva.LaivaTyyppi.DEBUGPELASTUSVENE);
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
    
    @Test
    public void laivanKonstruktoriAsettaaOikeatPisteet() {
        Piste alkupiste = tukialus.getPisteet().first();
        Piste loppupiste = tukialus.getPisteet().last();
        assertEquals(1, alkupiste.getX());
        assertEquals(1, alkupiste.getY());
        assertEquals(5, loppupiste.getX());
        assertEquals(1, loppupiste.getY());
    }
    
    @Test
    public void laivanKonstruktoriAsettaaOikeatPisteetmyosDebugveneella() {
        assertTrue(debugvene.getPisteet().first().equals(debugvene.getPisteet().last()));
    }
    
    @Test
    public void pisteidenAsetusLaivalleToimii() {
        tukialus.setLaivanPisteet(3, 2, Suunta.PYSTY);
        Piste alkupiste = tukialus.getPisteet().first();
        Piste loppupiste = tukialus.getPisteet().last();
        assertEquals(3, alkupiste.getX());
        assertEquals(2, alkupiste.getY());
        assertEquals(3, loppupiste.getX());
        assertEquals(6, loppupiste.getY());
    }
    
    @Test
    public void pisteidenAsetusDebugLaivalleToimii() {
        debugvene.setLaivanPisteet(2, 5, Suunta.VAAKA);
        assertTrue(debugvene.getPisteet().first().equals(debugvene.getPisteet().last()));
    }
    
    @Test
    public void laivanPisteetVaihtuuKaantaessa() {
        tukialus.kaannaLaivanSuunta();
    }
    
    @Test
    public void laivanPisteetOvatOsaLaivaa() {
        for(Piste p : tukialus.getPisteet()) {
            assertEquals(true, p.onkoOsaLaivaa());
        }
    }
    
}
