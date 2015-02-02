
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
import laivanupotus.domain.Suunta;

public class TietokoneTest {
    
    Pelilauta testilauta; 
    
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
        testilauta = new Pelilauta(10, 10);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
   
}
