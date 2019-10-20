package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {

    @Test
    void daLiSeIspravnoDodajuArtikli() {
        Supermarket supermarket = new Supermarket();
        supermarket.dodajArtikl(new Artikl("Lopata", 12, "20"));
        Artikl[] artikli = supermarket.getArtikli();
        boolean pronasao = false;
        for (int i = 0; i < artikli.length; i++) {
            if (artikli[i] != null) {
                if (artikli[i].getNaziv().equals("Lopata")) {
                    pronasao = true;
                    break;
                }
            }
        }
        assertTrue(pronasao);
    }

    @Test
    void daLiSeIspravnoIzbacujeArtikl() {
        Supermarket supermarket = new Supermarket();
        supermarket.dodajArtikl(new Artikl("Lopata", 12, "20"));
        supermarket.izbaciArtiklSaKodom("20");
        Artikl[] artikli = supermarket.getArtikli();
        boolean izbacen = true;
        for (int i = 0; i < artikli.length; i++) {
            if (artikli[i] != null) {
                if (artikli[i].getKod().equals("20")) {
                    izbacen = false;
                    break;
                }
            }
        }
        assertTrue(izbacen);
    }
}