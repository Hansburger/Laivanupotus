
package laivanupotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TulostauluTest {
    
    Tulostaulu tulokset;
    
    public TulostauluTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tulokset = new Tulostaulu();
        Pelaaja p1 = new Pelaaja("Taavi");
        Pelaaja p2 = new Pelaaja("Lallis");
        
        p1.setPisteet(3000);
        p2.setPisteet(2);
        
        tulokset.lisaaPelaajaTaulukkoon(p2);
        tulokset.lisaaPelaajaTaulukkoon(p1);
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
    public void pelaajanVoiLisataTulostaululle() {
        tulokset.lisaaPelaajaTaulukkoon(new Pelaaja("Korianteri"));
        assertEquals(3, tulokset.getPelaajat().size());
    }
    
    @Test
    public void tulostauluPitaaKirjaaHuonoimmasta() {
        assertEquals(2, tulokset.getHuonoinPistetulos());
    }
    
    @Test
    public void tulostauluPitaaKirjaaParhaimmasta() {
        assertEquals(3000, tulokset.getParasPistetulos());
    }
    
    
}
