package laivanupotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PisteTest {

    Piste testipiste;

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
}
