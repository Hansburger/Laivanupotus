package laivanupotus.logiikka;

import laivanupotus.domain.Laiva;
//import laivanupotus.domain.Piste;
import laivanupotus.domain.LaivaTyyppi;
import laivanupotus.domain.Piste;
import laivanupotus.domain.Suunta;
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
    public void ammuntaEiToimiKunAmmutaanJoAmmuttuun() {
        testilauta.ammu(3, 4);
        
        assertFalse(testilauta.ammu(3, 4));
    }
    
    @Test
    public void ammuntaToimiiKunAmmutaanLaivaan() {
        Laiva testilaiva = new Laiva(LaivaTyyppi.PARTIOVENE);
        testilaiva.setLaivanPisteet(3, 4, Suunta.VAAKA);
        testilauta.asetaLaivaLaudalle(testilaiva);
        assertTrue(testilauta.ammu(3,4));
        assertFalse(testilauta.ammu(3,4));
    }

    
    @Test
    public void laivanAsetusToimii() {
        Laiva testilaiva = new Laiva(LaivaTyyppi.TUKIALUS);
        testilaiva.setLaivanPisteet(3, 4, Suunta.VAAKA);
        assertTrue(testilauta.asetaLaivaLaudalle(testilaiva));
    }
            
    @Test
    public void laivanAsetusVaihtaaLaudanPisteetOikein() {
        Laiva testilaiva = new Laiva(LaivaTyyppi.TUKIALUS);
        testilaiva.setLaivanPisteet(3, 4, Suunta.VAAKA);
        
        testilauta.asetaLaivaLaudalle(testilaiva);
        assertTrue(testilauta.getLauta()[3][4].onkoOsaLaivaa());
        assertTrue(testilauta.getLauta()[4][4].onkoOsaLaivaa());
        assertTrue(testilauta.getLauta()[5][4].onkoOsaLaivaa());
        assertTrue(testilauta.getLauta()[6][4].onkoOsaLaivaa());
        assertTrue(testilauta.getLauta()[7][4].onkoOsaLaivaa());
    }
    
    
    @Test
    public void laivaaEiVoiAsettaaUlosLaudalta() {
        Laiva testilaiva = new Laiva(LaivaTyyppi.TUKIALUS);
        testilaiva.setLaivanPisteet(10, 10, Suunta.VAAKA);
        assertFalse(testilauta.asetaLaivaLaudalle(testilaiva));
        assertFalse(testilauta.laivaOnLaudanSisalla(testilaiva));
    }
    
    @Test
    public void laivaaEiVoidaSijoittaaNegatiivisiinKoordinaatteihin() {
        Laiva testilaiva = new Laiva(LaivaTyyppi.TUKIALUS);
        testilaiva.setLaivanPisteet(-1, -1, Suunta.VAAKA);
        assertFalse(testilauta.laivaOnLaudanSisalla(testilaiva));
        assertFalse(testilauta.asetaLaivaLaudalle(testilaiva));
    }
    
    @Test
    public void laivanAsettamisenTarkistusToimii() {
        Laiva testilaiva = new Laiva(LaivaTyyppi.DEBUGPELASTUSVENE);
        testilaiva.setLaivanPisteet(10, 10, Suunta.VAAKA);
        assertFalse(testilauta.laivaOnLaudanSisalla(testilaiva));
    }
    
    @Test
    public void laivanAsettamisenTarkistusToimiiRajatapauksessa() {
        Laiva testilaiva = new Laiva(LaivaTyyppi.PARTIOVENE);
        testilaiva.setLaivanPisteet(9, 9, Suunta.VAAKA);
        assertFalse(testilauta.laivaOnLaudanSisalla(testilaiva));
    }
    
    @Test
    public void laivojenLukumaaraOnOikea() {
        Laiva laiva1 = new Laiva(LaivaTyyppi.SUKELLUSVENE);
        Laiva laiva2 = new Laiva(LaivaTyyppi.KRUISERI);
        testilauta.asetaLaivaLaudalle(laiva1);
        testilauta.asetaLaivaLaudalle(laiva2);
        
        assertEquals(1, testilauta.getLaivojenMaara());
    }
    
    @Test
    public void onkoPisteessaLaivaKunSiinaOnLaiva() {
        Laiva testilaiva = new Laiva(LaivaTyyppi.DEBUGPELASTUSVENE);
        testilaiva.setLaivanPisteet(1, 1, Suunta.VAAKA);
        testilauta.asetaLaivaLaudalle(testilaiva);
        assertTrue(testilauta.onkoPisteessaLaiva(1, 1));
    }
    
    @Test
    public void onkoPisteessaLaivaKunSiinaEiOleLaivaa() {
        assertFalse(testilauta.onkoPisteessaLaiva(1, 1));
    }
    
    @Test
    public void eiVoidaAmpuaUlosKentasta() {
        assertFalse(testilauta.ammu(10, 10));
    }
    
    @Test
    public void eiVoidaAmpuaNegatiivisiinKoordinaatteihin() {
        assertFalse(testilauta.ammu(-1, -1));
    }
    
    @Test
    public void voidaanAmpuaTyhjaanPisteeseen() {
        assertFalse(testilauta.ammu(0,0));
    }
    
    @Test
    public void onkoPisteeseenAmmuttuJosSiihenOnAmmuttu() {
        testilauta.ammu(0, 0);
        assertTrue(testilauta.onkoPisteeseenAmmuttu(0, 0));
    }
    
    @Test
    public void onkoPisteeseenAmmuttuJosSiihenEiOleAmmuttu() {
        assertFalse(testilauta.onkoPisteeseenAmmuttu(0, 0));
    }
    
    @Test
    public void onkoKaikkiLaudanLaivatUponneetKunKaikkiinOnOsuttu() {
        Laiva minilaiva = new Laiva(LaivaTyyppi.DEBUGPELASTUSVENE);
        Laiva minilaiva2 = new Laiva(LaivaTyyppi.DEBUGPELASTUSVENE);
        minilaiva.setLaivanPisteet(1, 1, Suunta.VAAKA);
        minilaiva2.setLaivanPisteet(2, 2, Suunta.VAAKA);
        testilauta.asetaLaivaLaudalle(minilaiva);
        testilauta.asetaLaivaLaudalle(minilaiva2);
        assertTrue(testilauta.ammu(1, 1));
        assertTrue(testilauta.ammu(2, 2));
        
        assertTrue(testilauta.onkoKaikkiLaivatUpotettu());
    }

    @Test
    public void onkoKaikkiLaivatUpotettuKunYhteenkaanEiOleOsuttu() {
        Laiva l = new Laiva(LaivaTyyppi.KRUISERI);
        l.setLaivanPisteet(3, 4, Suunta.VAAKA);
        testilauta.asetaLaivaLaudalle(l);
        assertTrue(testilauta.ammu(4,4));
        assertFalse(testilauta.onkoKaikkiLaivatUpotettu());
    }
}
