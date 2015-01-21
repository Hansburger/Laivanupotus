
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
        testilauta = new Pelilauta(10,10);
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
    
    @Test
    public void pelilaudanKonstruktoiToimii() {
        assertArrayEquals(new int[10][10], testilauta.getLauta());
    }
    
    @Test
    public void pelilautaOnTyhjaAlustuksenJalkeen() {
        testilauta.createLauta();
        assertEquals(0, testilauta.getSektoriTyyppi(2, 2));
    }
}
