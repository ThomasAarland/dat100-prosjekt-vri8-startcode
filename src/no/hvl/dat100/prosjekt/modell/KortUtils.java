package no.hvl.dat100.prosjekt.modell;

import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
	    // TODO - START
	    Arrays.sort(samling.samling, 0, samling.antall);
	    // TODO - END
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
	    // TODO - START
	    List<Kort> kortListe = Arrays.asList(samling.getAllekort());
	    Collections.shuffle(kortListe);
	    for (int i = 0; i < samling.getAntalKort(); i++) {
	        samling.samling[i] = kortListe.get(i);
	    }
	    // TODO - END
	}
	
}
