
package laivanupotus.logiikka;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.LaivaTyyppi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {
    
    Peli testipeli;
    
    public PeliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testipeli = new Peli(10, 10);
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
    public void pelilaudanAlustusToimiiPelaajalle() {
        testipeli.alustaLaivatPelaajalle();
        testipeli.alustaLaivatTietokoneelle();
        Pelilauta testilauta = testipeli.getPelaajanLauta();
        Pelilauta testiTietokoneenLauta = testipeli.getTietokoneenLauta();
        assertEquals(6, testilauta.getLaivojenMaara());
        assertEquals(6, testiTietokoneenLauta.getLaivojenMaara());
    }
    
    @Test
    public void tekoalynHakuMetodiPalauttaaTekoalyOlion() {
        assertEquals(Tietokone.class, testipeli.getTietokone().getClass());
    }
    
}
