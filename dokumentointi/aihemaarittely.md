# Aihe: Laivanupotus

Tarkoitus on tehdä laivanupotuspeli. Peliin tulee mahdollisuus pelata yksin tietokonetta vastaan. Pelikentän kokoa pystyy vaihtamaan ennen kuin peli aloitetaan.

**Käyttäjät:** 
* Pelaaja

**Käyttäjän toiminnot:**

* voi ilmoittaa nimensä
* voi valita pelikentän koon
* voi aloittaa pelin
* voi pelin sisällä yrittää arvata missä vastustajan laivat ovat
* voi tarkastella ohjeita




# Rakennekuvaus

Main-luokka aloittaa ohjelman luomalla uuden Käyttöliittymän. Käyttöliittymässä on valikot ja pelin aloitukseen tarvittavat toiminnallisuudet. Käyttöliittymä luo uuden Peli-luokan kun pelaaja aloittaa pelin painamalla 'aloita peli' -nappulaa. Samalla luodaan Pelaaja, jolle annetaan nimi.
Pelilogiikkaa ohjaava Peli-luokka luo uuden LaivojenAlustaja-luokan, tietokoneen tekoälyn, pelaajalle ja tietokoneelle pelilaudat. LaivojenAlustajaa käytetään Laiva-olioiden asettelemiseen pelilaudoille. LaivojenAlustaja itse luo tarvittavat laivat.

Pelilauta koostuu Piste-luokan olioista. Pisteiden määrä riippuu siitä kuinka suuri lauta alustetaan. Pisteet ovat tallennettuna Pelilaudalla kaksiulotteiseen taulukkoon. Myös laivat koostuvat piste-olioista. Kun laiva asetetaan laudalle, laivan pisteet käydään läpi ja ne laitetaan pelilaudalle.
Laivaa luodessa sille määritetään suunta ja tyyppi. Ohjelman laajennettavuuden kannalta laivalla on toiminnallisuus kääntämiseen ja siirtelyyn, jos halutaan luoda ominaisuus itse asettaa laivat ilman satunnaista sijoittelua.


# Käyttöohje

Kun peli käynnistetään aukeaa aloitusvalikko. Aloitusvalikosta voi myös avata pelin ohjeet. Aloitusvalikossa pelaaja antaa nimensä ja päättää minkä kokoisilla pelilaudoilla pelataan.
Tämän jälkeen pelaaja painaa 'aloita peli' -nappulaa jolloin aukeaa uusi ikkuna joka sisältää kaksi reunustettua aluetta. Punaisella reunuksella oleva alue on tietokoneen lauta ja vihreällä reunustettu on pelaajan lauta. Pelaajan laudalla on merkattu laivojen sijainnit '#'-merkillä. Luonnollisesti tietokoneen laudalle ei ole merkattu mitään.
Pelaaja saa ensimmäisen vuoron ja aloittaa pelin kulun painamalla jotain nappulaa tietokoneen laudalta. Mikäli pelaajan klikkaamassa ruudussa oli tietokoneen laiva, ilmestyy ruutuun '@'-merkki ja väri vaihtuu punaiseksi. Osuman jälkeen saa arvata uuden pisteen laudalta. Ohiammuttuihin pisteisiin vaihdetaan väriksi vaalean sininen ja ne merkataan '~'-merkillä.
Pelaajan ammuttua ohi, tietokone saa vuoronsa ja yrittää vastaavasti arvata laivan sijaintia pelaajan laudalta. Pelaajan lautaa merkataan samalla tavalla kuin tietokoneen lautaa osumien ja ohiampumisten kannalta.
Peli päättyy kun toiselta laudalta on upotettu jokainen laiva ja sen perusteella määrittyy voittajaksi se, kenen laivat selvisivät.

Pelilaudalla on yhteensä 6 laivaa:
- Lentotukialus, 1 kpl, Pituus: 5
- Risteilijä, 1 kpl, Pituus: 4
- Sukellusvene, 2 kpl, Pituus: 3
- Partiovene, 2 kpl, Pituus: 2
