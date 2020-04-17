package hr.java.vjezbe.entitet;

import java.util.Set;

/**
 * Predstavlja entitet kategorija koji je definiran nazivom kategorije i
 * artiklima koje spadaju u tu kategoriju
 * 
 * @author deva
 * @version Devcic-4
 */
public class Kategorija {
    private String naziv;
    private Set<Artikl> artikli;

    /**
     * Inicijalizira podatak o nazivu i artiklima kategorije
     * 
     * @param naziv   - podatak o nazivu kategorije
     * @param artikli - podatak o artiklima koji se nalaze u kateogoriji
     */
    public Kategorija(String naziv, Set<Artikl> artikli) {
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

    public Set<Artikl> getArtikli() {
	return artikli;
    }

    public void setArtikli(Set<Artikl> artikli) {
	this.artikli = artikli;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Kategorija other = (Kategorija) obj;
	if (naziv == null) {
	    if (other.naziv != null)
		return false;
	} else if (!naziv.equals(other.naziv))
	    return false;
	return true;
    }
    

}
