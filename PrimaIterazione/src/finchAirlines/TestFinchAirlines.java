package finchAirlines;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestFinchAirlines {

	@Test
	void testCalcolaNuovoTotale() {
		FinchAirlines finchAirlines = new FinchAirlines();
		
		//caso punti nulli o positivi
		assertEquals(99.5 , finchAirlines.calcolaNuovoTotale(50, 100), "Calcolo nuovo totale:");
		
		//caso punti negativi
		assertEquals(100, finchAirlines.calcolaNuovoTotale(-50, 100), "Calcola nuovo totale:");
		
		//caso prezzo negativo o nullo
		assertEquals(0, finchAirlines.calcolaNuovoTotale(50, -20));
	}
	

}
