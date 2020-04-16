package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja entitet Usluga koji je definiran naslovom usluge, opisom usluge i
 * cijenom usluge
 * 
 * @author deva
 * @version Devcic-3
 */
public class Usluga extends Artikl {

    /**
     * Inicijalizira entitet Usluga koji je definiran naslovom, opisom i cijenom
     * usluge
     * 
     * @param naslov - podatak o naslovu usluge
     * @param opis   - podatak o opisu usluge
     * @param cijena - podatak o cijeni usluge
     */
    public Usluga(String naslov, String opis, BigDecimal cijena) {
	super(naslov, opis, cijena);

    }

    /**
     * Pretvaranje pojedinaènih podataka o naslovu, opisu i cijeni usluge u znakovni
     * niz za lakše predstavljanje oglasa usluge
     */
    @Override
    public String tekstOglasa() {
	String tekstOglasa = ("Naslov usluge: " + getNaslov() + "\nOpis usluge: " + getOpis() + "\nCijena usluge: "
		+ getCijena());
	return tekstOglasa;
    }

}
