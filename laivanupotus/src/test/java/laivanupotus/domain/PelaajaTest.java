
package laivanupotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelaajaTest {
    
    Pelaaja testipelaaja;
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testipelaaja = new Pelaaja("Teuvo");
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
    public void pelaajanKonstruktoriToimiiOikeinNimenOsalta() {
        assertEquals("Teuvo", testipelaaja.getNimi());
    }
    
    @Test
    public void pelaajanKonstruktoriAsettaaPisteetNollaksi() {
        assertEquals(0, testipelaaja.getPisteet());
    }
    
    @Test
    public void pelaajanNimeaVoidaanVaihtaaSetMetodilla() {
        testipelaaja.setNimi("Uusi");
        assertEquals("Uusi", testipelaaja.getNimi());
    }
    
    @Test
    public void pelaajanPisteidenLisaysToimii() {
        testipelaaja.lisaaPisteita(9001);
        assertEquals(9001, testipelaaja.getPisteet());
    }
    
    @Test
    public void pelaajanPisteidenAsetusToimii() {
        testipelaaja.setPisteet(20);
        assertEquals(20, testipelaaja.getPisteet());
    }
}
