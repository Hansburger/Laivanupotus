package laivanupotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PisteTest {

    Piste testipiste;
    Piste testipisteIsompi;
    Piste testiXIsompi;
    Piste testiYIsompi;
    Piste testiXPienempi;
    Piste testiYPienempi;

    public PisteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testipiste = new Piste(1, 1);
        testipisteIsompi = new Piste(2, 2);
        testiXIsompi = new Piste(2, 1);
        testiXPienempi = new Piste(0, 1);
        testiYIsompi = new Piste(1, 2);
        testiYPienempi = new Piste (1, 0);
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
    public void pisteenKonstruktoriToimiiXnSuhteen() {
        assertEquals(1, testipiste.getX());
    }
    
    @Test
    public void pisteenKonstruktoriToimiiYnSuhteen() {
        assertEquals(1, testipiste.getY());
    }
    
    @Test
    public void pisteelleVoiAsettaaUudenXArvon() {
        testipiste.setX(2);
        assertEquals(2, testipiste.getX());
    }
    
    @Test
    public void pisteelleVoiAsettaaUudenYArvon() {
        testipiste.setY(2);
        assertEquals(2, testipiste.getY());
    }
    
    @Test
    public void laivapisteAsettuuOikein() {
        testipiste.setOnLaiva();
        assertEquals(true, testipiste.onkoOsaLaivaa());
    }
    
    @Test
    public void pisteeseenAmpuminenToimii() {
        testipiste.setAmmuttu();
        assertEquals(true, testipiste.onkoAmmuttuJo());
    }
    
    @Test
    public void pisteenKomparaattoriToimiiKunVerrataanIsompaan() {
        assertEquals(-1, testipiste.compareTo(testipisteIsompi));
    }
    
    @Test
    public void pisteenKomparaattoriToimiiKunVerrataanSamankokoiseen() {
        Piste lisapiste = new Piste(1,1);
        assertEquals(0, testipiste.compareTo(lisapiste));
    }
    
    @Test
    public void pisteenKomparaattoriToimiiKunVerrataanPienempaan() {
        assertEquals(1, testipisteIsompi.compareTo(testipiste));
    }
    
    @Test
    public void pisteenKomparaattoriToimiiKunXIsompi() {
        assertEquals(-1, testipiste.compareTo(testiXIsompi));
    }
    @Test
    public void pisteenKomparaattoriToimiiKunXPienempi() {
        assertEquals(1, testipiste.compareTo(testiXPienempi));
    }
    
    @Test
    public void pisteenKomparaattoriToimiiKunYPienempi() {
        assertEquals(1, testipiste.compareTo(testiYPienempi));
    }
    
    @Test
    public void pisteenKomparaattoritoimiiKunYIsompi() {
        assertEquals(-1, testipiste.compareTo(testiYIsompi));
    }
    
    @Test
    public void pisteenToStringToimiiAlustetullaPisteella() {
        assertEquals("(1,1); kuuluu laivaan: false; ammuttu: false", testipiste.toString());
    }
}
