package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Predstavlja entitet vozila koji je definiran naslovom , opisom, snagom u
 * konjskim satima i cijenom
 * 
 * @author deva
 * @version Devcic-3
 */
public class Automobil extends Artikl implements Vozilo {

    public static final Logger logger = (Logger) LoggerFactory.getLogger(Automobil.class);
    BigDecimal snagaKs;

    /**
     * Inicijalizira podatak o naslovu, opisu, snazi u konjskim satima i cijeni
     * automobila
     * 
     * @param naslov  - podatak o naslovu automobila
     * @param opis    - podatak o opisu automobila
     * @param snagaKs - podatak o snazi automobila u konjskim snagama
     * @param cijena  - podatak o cijeni automobila
     */
    public Automobil(String naslov, String opis, BigDecimal snagaKs, BigDecimal cijena) {
	super(naslov, opis, cijena);
	this.snagaKs = snagaKs;
    }

    public BigDecimal getSnagaKs() {
	return snagaKs;
    }

    public void setSnagaKs(BigDecimal snagaKs) {
	this.snagaKs = snagaKs;
    }

    /**
     * Izraèunavanje grupe osiguranja na temelju pretvorbe konjskih snaga u kilovate
     * i rangiranjem automobila u jednu od 5 grupa osiguranja zavisno od broja
     * kilovata snage vozila
     * 
     * @throws NemoguceOdreditiGrupuOsiguranjaException - kada je broj kilovata veæi
     *                                                  od 240 baca se oznaèena
     *                                                  iznimka
     */
    @Override
    public Integer izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
	Integer brojGrupeOsiguranja = 0;
	BigDecimal snagaKw = izracunajKilovate(getSnagaKs());
	Integer snagaCijeliBrojKw = snagaKw.intValue();
	if ((snagaCijeliBrojKw >= 1) && (snagaCijeliBrojKw < 55)) {
	    return 0;
	}
	if ((snagaCijeliBrojKw >= 55) && (snagaCijeliBrojKw < 70)) {
	    return 1;
	}
	if ((snagaCijeliBrojKw >= 70) && (snagaCijeliBrojKw < 100)) {
	    return 2;
	}
	if ((snagaCijeliBrojKw >= 100) && (snagaCijeliBrojKw < 130)) {
	    return 3;
	}
	if (snagaCijeliBrojKw >= 130 && (snagaCijeliBrojKw < 240)) {
	    return 4;
	}
	if (snagaCijeliBrojKw > 240) {
	    throw new NemoguceOdreditiGrupuOsiguranjaException();
	}
	return brojGrupeOsiguranja;
    }

    /**
     * Pretvaranje pojedinaènih podataka o naslovu, opisu, snage, cijene osiguranja
     * i cijene automobila u znakovni niz za lakše predstavljanje oglasa automobila;
     * u sluèaju prevelikog broja kilovata automobila, lovi se oznaèena iznimka
     */
    @Override
    public String tekstOglasa() {

	String izracunCijeneOsiguranja = "";
	try {
	    izracunCijeneOsiguranja = ("" + izracunajCijenuOsiguranja());
	} catch (NemoguceOdreditiGrupuOsiguranjaException e) {
	    izracunCijeneOsiguranja = ("Previše kw, ne mogu odrediti grupu osiguranja.");
	    logger.error(e.getMessage(), e);
	}
	String tekstOglasa = ("Naslov automobila: " + getNaslov() + "\nOpis automobila: " + getOpis()
		+ "\nSnaga automobila: " + getSnagaKs() + "\nCijena osiguranja " + izracunCijeneOsiguranja
		+ "\nCijena automobila: " + getCijena());
	return tekstOglasa;
    }

}
