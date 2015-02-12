
package laivanupotus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaivojenAlustajaTest {
    
    private Pelilauta lauta;
    private LaivojenAlustaja alustaja;
    
    public LaivojenAlustajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lauta = new Pelilauta(10, 10);
        alustaja = new LaivojenAlustaja();
        alustaja.alustaLaivat(lauta);
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
    public void alustajaAlustaaLaivatLaudalle() {
        assertEquals(6, lauta.getLaivojenMaara());
    }
}
