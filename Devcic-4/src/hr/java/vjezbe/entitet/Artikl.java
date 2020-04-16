package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja entitet artikla koji je definiran naslovom artikla, opisom
 * artikla i njegovom cijenom
 * 
 * @author deva
 * @version Devcic-3
 */
public abstract class Artikl {
    private String naslov;
    private String opis;
    protected BigDecimal cijena;

    /**
     * Inicijalizira podatak o naslovu, opisu i cijeni artikla
     * 
     * @param naslov - podatak o naslovu artikla
     * @param opis   - podatak o opisu artikla
     * @param cijena - podatak o cijeni artikla
     */
    public Artikl(String naslov, String opis, BigDecimal cijena) {
	super();
	this.naslov = naslov;
	this.opis = opis;
	this.cijena = cijena;
    }

    public String getNaslov() {
	return naslov;
    }

    public void setNaslov(String naslov) {
	this.naslov = naslov;
    }

    public String getOpis() {
	return opis;
    }

    public void setOpis(String opis) {
	this.opis = opis;
    }

    public BigDecimal getCijena() {
	return cijena;
    }

    public void setCijena(BigDecimal cijena) {
	this.cijena = cijena;
    }

    /**
     * @return sve klase koje nasljeðuju entitet Artikl moraju implementirati
     *         vraæanje podatka teksta oglasa
     */
    public abstract String tekstOglasa();
}
