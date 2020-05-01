package finchAirlines;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBagaglio {

	@Test
	void testCalcolaPrezzo() {
		Bagaglio bagaglio1 = new Bagaglio("Mano");
		Bagaglio bagaglio2 = new Bagaglio("10kg");
		Bagaglio bagaglio3 = new Bagaglio("20kg");
		Bagaglio bagaglio4 = new Bagaglio("aaaa");
		
		//caso A mano
		assertEquals(bagaglio1.calcolaPrezzo(), 2.50, "Caso a mano");
		
		//caso 10kg
		assertEquals(bagaglio2.calcolaPrezzo(), 5, "Caso 10kg");
		
		//caso 20kg
		assertEquals(bagaglio3.calcolaPrezzo(), 15, "Caso 20kg");
		
		//caso alternativo 
		assertEquals(bagaglio4.calcolaPrezzo(), 0, "Caso alternativo");

	}
}
