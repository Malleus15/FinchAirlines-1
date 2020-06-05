package finchAirlines;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestFinchAirlines {

	@Test
	void testSelezionaPunti() {
		FinchAirlines finchAirlines = new FinchAirlines();
		assertEquals(99.5 , finchAirlines.selezionaPunti(50, 100), "Calcolo nuovo totale");
	}
	

}
