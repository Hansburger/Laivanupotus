- Ti 13.1.2015 - 2h - Gitin s��t�minen kuntoon ja aiheen valitseminen  

- Ke 14.1.2015 - 2h - Ohjeiden tutkiminen ja aiheen pohtiminen tarkemmin, aihem��rittelyn kirjoittaminen

- Ti 20.1.2015 - 3h - Projektin luominen uudelleen, luokkien tekeminen ja projektin ideoiminen tarkemmin.

- Ke 21.1.2015 - 2h - Luokkien Laiva, Pelilauta, Piste ja Peli tekeminen. Ongelmia tietorakenteen valitsemisessa ja kuinka toteuttaa laivojen varsinainen sijoittelu laudalle. Testej� kirjoitettu Pelilaudalle, Laivalle ja Pisteelle.

- To 22.1.2015 - 1h - Piste ja Pelilauta -luokkien muokkaamista, luokkakaavion tekeminen, muutama testi lis��.

- Ti 27.1.2015 - 5h - Ongelma ilmeni laivan k��nt�misess� ja varsinaisten pisteiden asettamisessa, TreeSetin l�pik�ynti onnistui Iterator-rajapintaa k�ytt�en. Tein laivan iteraattorille my�s muutaman testin. Piste- ja Laiva -luokille tehty toString()-toiminnallisuus testaamista varten.

- To 29.1.2015 - 4.5h - Laajennettiin luokkaa Pelilauta luomalla sille metodeja laivojen k�sittelyyn. Testauksessa k�vi ilmi ett� aiemmin tehty metodi laivan k��nt�miseen ei toiminut oikein, joten sit� piti korjata. Korjauksessa hy�dynnettiin jo tehty� Laivan metodia jossa laivan pisteet asetetaan. Luokille Pelilauta ja Laiva laajennuksiin lis�ttiin testej�. Piti kerrata hieman OhPen ja OhJan materiaaleja, aikaa k�ytetty niihin noin tunti.

- Su 1.2.2015 - 3.5h - Laivan enumeraattorien jakaminen omiin luokkiin, teko�lyluokan ensimm�inen versio. Alustavan javadoc-dokumentoinnin tekeminen.

- Ma 2.2.2015 - 3.5h - Luokalle Pelilauta luotiin tulosta-metodi. Ohessa selvisi, ett� osa metodien parametreista asettui v��rin. Vaikka virhe ilmeni, mit��n ongelmaa ei varsinaisesti ollut, sill� sama virhe oli tehty johdonmukaisesti kaikkialle. Tehtiin pieni� muutoksia joita koodikatselmointi kehotti tekem��n. Tehtiin metodi joka tarkistaa onko kaikki laivat uponneet, jolloin peli pit�� p��tt�� (luotiin my�s testit metodille).

- Ti 3.2.2015 - 3h - Testauksessa ilmeni ettei tietokonepelaajan teko�ly toiminut ollenkaan joten sit� piti korjata. Kohteenetsinn�n korjaaminen onnistui. Tietokoneen teko�ly saattaa nyt toimia oikein. Luettiin graafisen k�ytt�liittym�n tekemisest�.

- To 5.2.2015  - 4h - Kokeiltiin k�ytt�liittym�n tekemist� ja yksinkertaisen ikkunan piirt�mist� ruudulle. Luokkakaavio p�ivitettiin. Toteutettiin luokat Pelaaja ja Tulostaulu ja niille testit. Tehtiin erillinen luokka joka alustaa annetulle pelilauta-oliolle laivat, silt� puuttuu viel� testit.

- Ti 10.2.2015 - 2h - Testien kirjoittamista logiikkaluokille. Testit tehty LaivojenAsettelijalle ja pelilogiikalle. Tarpeettomien metodien poistamista jotka pudottivat testikattavuutta.

- Ke 11.2.2015 - 3h - K�ytt�liittym�n muotoilua ja OhJan k�ytt�liittym�materiaalin kertausta. Alustusikkuna valmis, Pelin ikkunan aloitettu.

- To 12.2.2015 - 6.5h - Pelin logiikan simulointia varten tehty PeliIkkuna-k�ytt�liittym�luokka, tapahtumakuuntelija tehty pelilaudan klikkailemista varten. Sekvenssikaaviot tehty Ammu- ja Aloita Peli -k�ytt�tapauksista. Peli on t�ss� vaiheessa jokseenkin pelattavassa tilassa. Muutama testi lis��.

- Ke 18.2.2015 - 3.5h - Koska k�ytt�liittym�n piirt�m� pelialusta ei toimi oikein ep�symmetrisill� pelilaudoilla niin mahdollisuus luoda sellaisia poistettiin. Tehty alkeellinen ikkuna ohjeille ja yhdistetty se aloitusikkunan menuun.

- To 19.2.2015 - 6h - Ohjen�ytt� ja viimeinen sekvenssikaavio tehty. Yritetty pohtia miten laivat saisi alustettua siten ettei kaksi laivaa olisi kiinni toisissaan ja siten luotu uusi metodi tarkistamaan laivojen asettelu pelilaudalle. Metodin testaaminen tapahtuu yht�-aikaa laivojen asettelun yhteydess�. Laivoihin osuminen lis�� pelaajan pisteit�, mutta ei tallenna niit� viel� mihink��n. Pelin p��tytty� ei pysty en�� klikkailemaan tietokoneen pelilautaa. Muutettu pelilaudan kielletyt pisteet ArrayListiksi, nyt laivat eiv�t mene vierekk�in. Toiminnallisuus on my�s testattu ja todettu toimivaksi.

- To 26.2.2015 - 1.5h - Uusi sekvenssikaavio tehty tietokoneen ampumisesta. Luokkakaavioon lis�tty Main. Kirjoitettu rakennekuvaus ja k�ytt�ohje. Annettu .jar kavereille testattavaksi. Varmistettu ett� javadocit ovat olemassa ja muita yleisi� tarkistuksia tehty.

