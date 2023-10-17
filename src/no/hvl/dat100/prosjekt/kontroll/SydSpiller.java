package no.hvl.dat100.prosjekt.kontroll;

import java.util.ArrayList;
import java.util.Random;

import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortSamling;

/**
 * Klasse som for å representere en vriåtter syd-spiller. Strategien er å lete
 * gjennom kortene man har på hand og spille det første som er lovlig.
 *
 */
public class SydSpiller extends Spiller {

	/**
	 * Konstruktør.
	 * 
	 * @param spiller
	 *            posisjon for spilleren (nord eller syd).
	 */

		public SydSpiller(Spillere spiller) {
			super(spiller);
		}

		/**
		 * Metode for Â implementere strategi. Strategien er Â spille det f¯rste
		 * kortet som er lovlig (ogsÂ en Âtter selv om man har andre kort som ogsÂ
		 * kan spilles). Dersom man ikke har lovlige kort Â spille, trekker man om
		 * man ikke allerede har trukket maks antall ganger. I sÂ fall sier man
		 * forbi.
		 * 
		 * @param topp
		 *            kort som ligg ¯verst pÂ til-bunken.
		 */
		@Override
		public Handling nesteHandling(Kort topp) {
		    Kort[] hand = getHand().getAllekort();
		    KortSamling lovlige = new KortSamling();
		    KortSamling attere = new KortSamling();

		    for (Kort k : hand) {
		        if (Regler.kanLeggeNed(k, topp)) {
		            if (Regler.atter(k)) {
		                attere.leggTil(k);
		            } else {
		                lovlige.leggTil(k);
		            }
		        }
		    }

		    Kort spill = null;
		    Kort[] spillFra = lovlige.erTom() ? attere.getAllekort() : lovlige.getAllekort();

		    Handling handling;

		    if (spillFra != null && spillFra.length > 0) {
		        spill = spillFra[0];
		        handling = new Handling(HandlingsType.LEGGNED, spill);
		    } else if (getAntallTrekk() < Regler.maksTrekk()) {
		        handling = new Handling(HandlingsType.TREKK, null);
		    } else {
		        handling = new Handling(HandlingsType.FORBI, null);
		        setAntallTrekk(0);
		    }

		    return handling;
		}
	}

	
