package hr.java.vjezbe.entitet;

/**
 * Predstavlja entitet kategorija koji je definiran nazivom kategorije i
 * artiklima koje spadaju u tu kategoriju
 * 
 * @author deva
 * @version Devcic-3
 */
public class Kategorija {
    private String naziv;
    private Artikl[] artikli;

    /**
     * Inicijalizira podatak o nazivu i artiklima kategorije
     * 
     * @param naziv   - podatak o nazivu kategorije
     * @param artikli - podatak o artiklima koji se nalaze u kateogoriji
     */
    public Kategorija(String naziv, Artikl[] artikli) {
	super();
	this.naziv = naziv;
	this.artikli = artikli;
    }

    public String getNaziv() {
	return naziv;
    }

    public void setNaziv(String naziv) {
	this.naziv = naziv;
    }

    public Artikl[] getArtikli() {
	return artikli;
    }

    public void setArtikli(Artikl[] artikli) {
	this.artikli = artikli;
    }

}
