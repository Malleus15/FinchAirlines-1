package finchAirlines;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPosto {

	@Test
	void testCalcolaPrezzo() {
		String numero = "25A";
		Posto posto1 = new Posto(numero, "base");
		Posto posto2 = new Posto(numero, "premium");
		Posto posto3 = new Posto(numero, "optimum");
		Posto posto4 = new Posto(numero, "aaaa");
		
		//caso base
		assertEquals(posto1.calcolaPrezzo(), 1, "Caso base");
		
		//caso premium
		assertEquals(posto2.calcolaPrezzo(), 4, "Caso premium");
		
		//caso optimum
		assertEquals(posto3.calcolaPrezzo(), 10, "Caso optimum");
		
		//caso alternativo 
		assertEquals(posto4.calcolaPrezzo(), 0, "Caso alternativo");

	}

}
