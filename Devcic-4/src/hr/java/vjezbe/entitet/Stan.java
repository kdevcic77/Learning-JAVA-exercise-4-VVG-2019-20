package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

/**
 * Predstavlja entitet stan koji je definiran naslovom , opisom, kvadraturom i
 * cijenom konjskim satima i cijenom
 * 
 * @author deva
 * @version Devcic-3
 */
public class Stan extends Artikl implements Nekretnina {

    public static final Logger logger = (Logger) LoggerFactory.getLogger(Stan.class);

    private int kvadratura;

    /**
     * @param naslov     podatak o naslovu stana koji se prodaje
     * @param opis       podatak opisa stan
     * @param kvadratura podatak o kvadratnim metrima stana
     * @param cijena     podatak o cijeni stana
     */
    public Stan(String naslov, String opis, int kvadratura, BigDecimal cijena) {
	super(naslov, opis, cijena);
	this.kvadratura = kvadratura;
    }

    public int getKvadratura() {
	return kvadratura;
    }

    public void setKvadratura(int kvadratura) {
	this.kvadratura = kvadratura;
    }

    /**
     * Pretvaranje pojedinaènih podataka o naslovu, opisu, kvadraturi, izraèunatom
     * porezu i cijeni stana u znakovni niz za lakše predstavljanje oglasa
     * automobila; u sluèaju premale cijene nekretnine, lovi se neoznaèena iznimka
     */
    @Override
    public String tekstOglasa() {
	String izracunatPorez = "";
	try {
	    izracunatPorez = ("" + izracunajPorez(getCijena()));
	} catch (CijenaJePreniskaException e) {
	    izracunatPorez = ("Cijena ne smije biti manja od 10000kn");
	    logger.error(e.getMessage(), e);
	}
	String tekstOglasa = ("Naslov nekretnine: " + getNaslov() + "\nOpis nekretnine: " + getOpis()
		+ "\nKvadratura Nekretnine: " + getKvadratura() + "\nPorez na nekretnine: " + izracunatPorez
		+ "\nCijena nekretnine " + getCijena());
	return tekstOglasa;
    }

}
