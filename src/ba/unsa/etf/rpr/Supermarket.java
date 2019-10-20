package ba.unsa.etf.rpr;

public class Supermarket {
    private Artikl[] supermarket;
    private int broj_artikala = 0;

    public Supermarket() {
        supermarket = new Artikl[1000];
    }

    public void dodajArtikl(Artikl a) {
        if (broj_artikala < 1000) {
            supermarket[broj_artikala] = a;
            broj_artikala++;
        }
    }

    public Artikl[] getArtikli() {
        return supermarket;
    }

    public Artikl izbaciArtiklSaKodom(String kod) {
        for (int i = 0; i < broj_artikala; i ++) {
            if (supermarket[i].getKod().equals(kod)) {
                Artikl a = supermarket[i];
                broj_artikala--;
                if (supermarket.length - 1 - i >= 0)
                    System.arraycopy(supermarket, i + 1, supermarket, i, supermarket.length - 1 - i);
                return a;
            }
        }
        return null;
    }
}