
package laivanupotus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import laivanupotus.logiikka.Pelilauta;
import laivanupotus.domain.Laiva;
import laivanupotus.domain.LaivaTyyppi;
import laivanupotus.domain.Piste;
import laivanupotus.domain.Suunta;

public class TietokoneTest {
    
    Pelilauta testilauta;
    Pelilauta testilautaPieni;
    Tietokone kone;
    Tietokone kone2;
    
    public TietokoneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testilauta = new Pelilauta(5, 5);
        testilautaPieni = new Pelilauta(2,2);
        testilauta.luoLauta();
        testilautaPieni.luoLauta();
        kone = new Tietokone(testilauta);
        kone2 = new Tietokone(testilautaPieni);
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
    public void tietokoneOsaaAmpuaSatunnaisesti() {
        Laiva testilaiva = new Laiva(LaivaTyyppi.TUKIALUS);
        testilaiva.setLaivanPisteet(0, 0, Suunta.VAAKA);
        
        testilauta.asetaLaivaLaudalle(testilaiva);
        boolean osuikoLaivaan = kone.ammu();
        Piste p = kone.edellinenKohde();
        if (testilaiva.getPisteet().contains(p)) {
            assertTrue(osuikoLaivaan);
        } else {
            assertFalse(osuikoLaivaan);
        }
    }
    
    @Test
    public void tietokoneEiSaaAmpuaUlosPelilaudaltaYliArvojen() {
        assertFalse(kone.ammuKoordinaatteihin(6, 6));
    }
    
    @Test
    public void tietokoneEiSaaAmpuaUlosPelilaudaltaAliArvojen() {
        assertFalse(kone.ammuKoordinaatteihin(-1, -1));
    }
    
    @Test
    public void tietokoneenTekoalyOsaaAmpuaLahelleEdellista() {
        Laiva l = new Laiva(LaivaTyyppi.PARTIOVENE);
        l.setLaivanPisteet(3, 3, Suunta.VAAKA);
        testilauta.asetaLaivaLaudalle(l);
        assertTrue(kone.ammuKoordinaatteihin(3, 3));
        testilauta.tulostaLauta();
        boolean osui = kone.ammu();
        testilauta.tulostaLauta();
        Piste p = kone.edellinenKohde();
        int kohdeX = p.getX();
        int kohdeY = p.getY();

        if (kohdeX == 4 && kohdeY == 3) {
            assertTrue(testilauta.onkoKaikkiLaivatUpotettu());
            assertTrue(osui);
        }
        if (kohdeX == 3 && kohdeY == 4) {
            assertFalse(osui);
        }
        if (kohdeX == 3 && kohdeY == 2) {
            assertFalse(osui);
        }
        if (kohdeX == 2 && kohdeY == 3) {
            assertFalse(osui);
        }
        if (kohdeX == 2 && kohdeY == 2) {
            assertFalse(osui);
        }

    }
    
    @Test
    public void neljanLaukauksenJalkeenPieniLautaOnPelkkiaAmmuttujaPisteita() {
        kone2.ammu();
        kone2.ammu();
        kone2.ammu();
        kone2.ammu();
        assertTrue(testilautaPieni.getLauta()[0][0].onkoAmmuttuJo());
        assertTrue(testilautaPieni.getLauta()[0][1].onkoAmmuttuJo());
        assertTrue(testilautaPieni.getLauta()[1][0].onkoAmmuttuJo());
        assertTrue(testilautaPieni.getLauta()[1][1].onkoAmmuttuJo());
    }
}
