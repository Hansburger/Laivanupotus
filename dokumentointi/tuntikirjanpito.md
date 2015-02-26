- Ti 13.1.2015 - 2h - Gitin säätäminen kuntoon ja aiheen valitseminen  

- Ke 14.1.2015 - 2h - Ohjeiden tutkiminen ja aiheen pohtiminen tarkemmin, aihemäärittelyn kirjoittaminen

- Ti 20.1.2015 - 3h - Projektin luominen uudelleen, luokkien tekeminen ja projektin ideoiminen tarkemmin.

- Ke 21.1.2015 - 2h - Luokkien Laiva, Pelilauta, Piste ja Peli tekeminen. Ongelmia tietorakenteen valitsemisessa ja kuinka toteuttaa laivojen varsinainen sijoittelu laudalle. Testejä kirjoitettu Pelilaudalle, Laivalle ja Pisteelle.

- To 22.1.2015 - 1h - Piste ja Pelilauta -luokkien muokkaamista, luokkakaavion tekeminen, muutama testi lisää.

- Ti 27.1.2015 - 5h - Ongelma ilmeni laivan kääntämisessä ja varsinaisten pisteiden asettamisessa, TreeSetin läpikäynti onnistui Iterator-rajapintaa käyttäen. Tein laivan iteraattorille myös muutaman testin. Piste- ja Laiva -luokille tehty toString()-toiminnallisuus testaamista varten.

- To 29.1.2015 - 4.5h - Laajennettiin luokkaa Pelilauta luomalla sille metodeja laivojen käsittelyyn. Testauksessa kävi ilmi että aiemmin tehty metodi laivan kääntämiseen ei toiminut oikein, joten sitä piti korjata. Korjauksessa hyödynnettiin jo tehtyä Laivan metodia jossa laivan pisteet asetetaan. Luokille Pelilauta ja Laiva laajennuksiin lisättiin testejä. Piti kerrata hieman OhPen ja OhJan materiaaleja, aikaa käytetty niihin noin tunti.

- Su 1.2.2015 - 3.5h - Laivan enumeraattorien jakaminen omiin luokkiin, tekoälyluokan ensimmäinen versio. Alustavan javadoc-dokumentoinnin tekeminen.

- Ma 2.2.2015 - 3.5h - Luokalle Pelilauta luotiin tulosta-metodi. Ohessa selvisi, että osa metodien parametreista asettui väärin. Vaikka virhe ilmeni, mitään ongelmaa ei varsinaisesti ollut, sillä sama virhe oli tehty johdonmukaisesti kaikkialle. Tehtiin pieniä muutoksia joita koodikatselmointi kehotti tekemään. Tehtiin metodi joka tarkistaa onko kaikki laivat uponneet, jolloin peli pitää päättää (luotiin myös testit metodille).

- Ti 3.2.2015 - 3h - Testauksessa ilmeni ettei tietokonepelaajan tekoäly toiminut ollenkaan joten sitä piti korjata. Kohteenetsinnän korjaaminen onnistui. Tietokoneen tekoäly saattaa nyt toimia oikein. Luettiin graafisen käyttöliittymän tekemisestä.

- To 5.2.2015  - 4h - Kokeiltiin käyttöliittymän tekemistä ja yksinkertaisen ikkunan piirtämistä ruudulle. Luokkakaavio päivitettiin. Toteutettiin luokat Pelaaja ja Tulostaulu ja niille testit. Tehtiin erillinen luokka joka alustaa annetulle pelilauta-oliolle laivat, siltä puuttuu vielä testit.

- Ti 10.2.2015 - 2h - Testien kirjoittamista logiikkaluokille. Testit tehty LaivojenAsettelijalle ja pelilogiikalle. Tarpeettomien metodien poistamista jotka pudottivat testikattavuutta.

- Ke 11.2.2015 - 3h - Käyttöliittymän muotoilua ja OhJan käyttöliittymämateriaalin kertausta. Alustusikkuna valmis, Pelin ikkunan aloitettu.

- To 12.2.2015 - 6.5h - Pelin logiikan simulointia varten tehty PeliIkkuna-käyttöliittymäluokka, tapahtumakuuntelija tehty pelilaudan klikkailemista varten. Sekvenssikaaviot tehty Ammu- ja Aloita Peli -käyttötapauksista. Peli on tässä vaiheessa jokseenkin pelattavassa tilassa. Muutama testi lisää.

- Ke 18.2.2015 - 3.5h - Koska käyttöliittymän piirtämä pelialusta ei toimi oikein epäsymmetrisillä pelilaudoilla niin mahdollisuus luoda sellaisia poistettiin. Tehty alkeellinen ikkuna ohjeille ja yhdistetty se aloitusikkunan menuun.

- To 19.2.2015 - 6h - Ohjenäyttö ja viimeinen sekvenssikaavio tehty. Yritetty pohtia miten laivat saisi alustettua siten ettei kaksi laivaa olisi kiinni toisissaan ja siten luotu uusi metodi tarkistamaan laivojen asettelu pelilaudalle. Metodin testaaminen tapahtuu yhtä-aikaa laivojen asettelun yhteydessä. Laivoihin osuminen lisää pelaajan pisteitä, mutta ei tallenna niitä vielä mihinkään. Pelin päätyttyä ei pysty enää klikkailemaan tietokoneen pelilautaa. Muutettu pelilaudan kielletyt pisteet ArrayListiksi, nyt laivat eivät mene vierekkäin. Toiminnallisuus on myös testattu ja todettu toimivaksi.

- To 26.2.2015 - 1.5h - Uusi sekvenssikaavio tehty tietokoneen ampumisesta. Luokkakaavioon lisätty Main. Kirjoitettu rakennekuvaus ja käyttöohje. Annettu .jar kavereille testattavaksi. Varmistettu että javadocit ovat olemassa ja muita yleisiä tarkistuksia tehty.

