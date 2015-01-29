package laivanupotus.logiikka;

import laivanupotus.domain.Laiva;
import laivanupotus.domain.Piste;
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
        testilauta = new Pelilauta(10, 10);
        testilauta.createLauta();
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
    public void ammuntaToimiiKunAmmutaanJoAmmuttuun() {
        testilauta.ammu(3, 4);
        
        assertEquals(false, testilauta.ammu(3, 4));
    }
    
    @Test
    public void ammuntaToimiiKunAmmutaanLaivaan() {
        Laiva testilaiva = new Laiva(Laiva.LaivaTyyppi.PARTIOVENE);
        testilaiva.setLaivanPisteet(3, 4, Laiva.Suunta.VAAKA);
        testilauta.asetaLaivaLaudalle(testilaiva);
        assertTrue(testilauta.ammu(3,4));
    }
    
    @Test
    public void laivanAsetusToimii() {
        Laiva testilaiva = new Laiva(Laiva.LaivaTyyppi.TUKIALUS);
        System.out.println(testilaiva);
        testilaiva.setLaivanPisteet(3, 4, Laiva.Suunta.VAAKA);
        System.out.println(testilaiva);
        
        testilauta.asetaLaivaLaudalle(testilaiva);
        assertTrue(testilauta.getLauta()[3][4].onkoOsaLaivaa());
        assertTrue(testilauta.getLauta()[4][4].onkoOsaLaivaa());
        assertTrue(testilauta.getLauta()[5][4].onkoOsaLaivaa());
        assertTrue(testilauta.getLauta()[6][4].onkoOsaLaivaa());
        assertTrue(testilauta.getLauta()[7][4].onkoOsaLaivaa());
    }
    
    @Test
    public void laivaaEiVoiAsettaaUlosLaudalta() {
        Laiva testilaiva = new Laiva(Laiva.LaivaTyyppi.TUKIALUS);
        testilaiva.setLaivanPisteet(8, 8, Laiva.Suunta.VAAKA);
        assertFalse(testilauta.asetaLaivaLaudalle(testilaiva));
    }
    
    @Test
    public void laivojenLukumaaraOnOikea() {
        Laiva laiva1 = new Laiva(Laiva.LaivaTyyppi.SUKELLUSVENE);
        Laiva laiva2 = new Laiva(Laiva.LaivaTyyppi.KRUISERI);
        testilauta.asetaLaivaLaudalle(laiva1);
        testilauta.asetaLaivaLaudalle(laiva2);
        
        assertEquals("Laivoja pelikentalla: " + 1, testilauta.getLaivojenMaara());
    }
    
    @Test
    public void eiVoidaAmpuaUlosKentasta() {
        assertFalse(testilauta.ammu(11, 11));
    }
    
    @Test
    public void eiVoidaAmpuaNegatiivisiinKoordinaatteihin() {
        assertFalse(testilauta.ammu(-1, -1));
    }

}
