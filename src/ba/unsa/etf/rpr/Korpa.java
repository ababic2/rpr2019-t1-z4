package ba.unsa.etf.rpr;

public class Korpa {

    private Artikl[] artikli;
    private int broj = 0;

    public Korpa() {
        artikli = new Artikl[50];
    }

    public Artikl[] getArtikli() {
        return artikli;
    }

    public int dajUkupnuCijenuArtikala() {
        int suma = 0;
        for (int i = 0; i < broj; i++) suma = suma + artikli[i].getCijena();
        return suma;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for (int i = 0; i < broj; i += 1) {
            if (artikli[i].getKod().equals(kod)) {
                Artikl a = new Artikl(artikli[i].getNaziv(), artikli[i].getCijena(), artikli[i].getKod());
                for (int j = i; j < artikli.length - 1; j += 1) {
                    artikli[j] = artikli[j + 1];
                }
                broj--;
                return a;
            }
        }
        return null;
    }

    public boolean dodajArtikl(Artikl a) {
        if (broj < 50) {
            artikli[broj] = a;
            broj++;
            return true;
        }
        return false;
    }
}
