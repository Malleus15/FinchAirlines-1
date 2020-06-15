package finchAirlines;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

class TestCliente {

	@Test
	void incrementaPunti() {
		Cliente cliente = new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", LocalDateTime.of(2010, Month.MAY, 30, 0, 0), LocalDateTime.of(2023, Month.SEPTEMBER, 21, 0, 0), "CI"));
		
		//caso coefficiente e prezzo positivi
		assertEquals(50, cliente.incrementaPunti(0.5, 100));
		
		//caso coefficiente e/o prezzo negativi
		assertEquals(0, cliente.incrementaPunti(-0.5, 100));		

	}
	
	@Test
	void decrementaPunti() {
		Cliente cliente = new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", LocalDateTime.of(2010, Month.MAY, 30, 0, 0), LocalDateTime.of(2023, Month.SEPTEMBER, 21, 0, 0), "CI"));

		//caso punti positivi e punti correnti minori dei punti da decrementare
		cliente.setPunti(0);
		cliente.decrementaPunti(50);
		assertEquals(0, cliente.getPunti());
		
		//caso punti positivi e punti correnti maggiori o uguali dei punti da decrementare
		cliente.setPunti(100);
		cliente.decrementaPunti(50);
		assertEquals(50, cliente.getPunti());
		
		//caso punti negativi e punti correnti maggiori o uguali dei punti da decrementare
		cliente.setPunti(100);
		cliente.decrementaPunti(-50);
		assertEquals(100, cliente.getPunti());
		
	}
}
