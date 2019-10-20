package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorpaTest {

    @Test
    void dalJeTacnaUkupnaCijenaArtikala() {
        Korpa korpa = new Korpa();
        korpa.dodajArtikl(new Artikl("Lopata", 12, "20"));
        korpa.dodajArtikl(new Artikl("Flasa", 2, "11"));
        korpa.dodajArtikl(new Artikl("Dvojni C", 1, "8"));
        Artikl[] artikli = korpa.getArtikli();
        int suma = 0;
        boolean tacna = false;
        for (int i = 0; i < artikli.length; i++) {
            if (artikli[i] != null) {
                suma = suma + artikli[i].getCijena();
            }
        }
        if (suma == 15) tacna = true;
        assertTrue(tacna);
    }

    @Test
    void daLiSePravilnoIzbacujeArtiklSDatimKodom() {
        Korpa korpa = new Korpa();
        korpa.dodajArtikl(new Artikl("Dvojni C", 1, "8"));
        korpa.dodajArtikl(new Artikl("Rauch", 3, "21"));
        korpa.izbaciArtiklSaKodom("8");
        Artikl[] artikli = korpa.getArtikli();
        boolean izbacen = true;
        for (int i = 0; i < artikli.length; i++) {
            if (artikli[i] != null && artikli[i].getKod().equals("8")) izbacen = false;
            if (izbacen == false) break;
        }
        assertTrue(izbacen);
    }

    @Test
    void daLiSeIspravnoDodajuArtikli() {
        Korpa korpa = new Korpa();
        korpa.dodajArtikl(new Artikl("Dvojni C", 1, "8"));
        korpa.dodajArtikl(new Artikl("Rauch", 3, "21"));
        Artikl[] artikli = korpa.getArtikli();
        boolean dodano = false;
        for (int i = 0; i < artikli.length; i++) {
            if (artikli[i] != null) {
                if (artikli[i].getNaziv().equals("Dvojni C")) {
                    dodano = true;
                    break;
                }
            }
        }
        assertTrue(dodano);
    }
}