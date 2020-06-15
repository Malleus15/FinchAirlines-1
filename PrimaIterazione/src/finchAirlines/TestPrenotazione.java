package finchAirlines;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import org.junit.jupiter.api.Test;

class TestPrenotazione {
	
	

	@Test
	void testCalcolaTotaleVoli() {
		
		Aeroporto[] tratta = {new Aeroporto("Aeroporto Internazionale di Catania Vincenzo Bellini", "Catania", "CTA"), new Aeroporto("Aeroporto Intercontinentale di Roma Leonardo da Vinci", "Roma", "FCO")};	
		VoloPrenotato[] listaVoliPrenotati = new VoloPrenotato[1];		
		Volo volo1 = new Volo();
		Prenotazione prenotazione1;
			
		volo1.riempiDettagliVolo(new DescrizioneVolo("FA0011", tratta), 30.5, LocalDateTime.of(2020, Month.JUNE, 14, 15, 00), LocalDateTime.of(2020, Month.JUNE, 14, 16, 00));
		listaVoliPrenotati[0] = new VoloPrenotato(new Posto("25A", "base"),new Bagaglio("mano"),volo1);	
		prenotazione1 = new Prenotazione(0, new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", LocalDateTime.of(2010, Month.MAY, 30, 0, 0), LocalDateTime.of(2023, Month.SEPTEMBER, 21, 0, 0), "CI")), listaVoliPrenotati);
		
		//caso con presente un volo con prezzo positivo, bagaglio e posto corretti
		assertEquals(34, prenotazione1.getTotale(), "Totale della prenotazione:");
		
		volo1.riempiDettagliVolo(new DescrizioneVolo("FA0011", tratta), -30.5, LocalDateTime.of(2020, Month.JUNE, 14, 15, 00), LocalDateTime.of(2020, Month.JUNE, 14, 16, 00));
		listaVoliPrenotati[0] = new VoloPrenotato(new Posto("25A", "hdhdh"),new Bagaglio("hhdd"),volo1);	
		prenotazione1 = new Prenotazione(0, new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", LocalDateTime.of(2010, Month.MAY, 30, 0, 0), LocalDateTime.of(2023, Month.SEPTEMBER, 21, 0, 0), "CI")), listaVoliPrenotati);
		
		//caso con presente un volo con prezzo negativo, bagaglio e posto errati
		assertEquals(0, prenotazione1.getTotale(), "Totale della prenotazione:");
		
	}
	
	@Test
	void testAccreditaPunti() {
		Aeroporto aeroporto1 = new Aeroporto("Aeroporto Internazionale di Catania Vincenzo Bellini", "Catania", "CTA");
		Aeroporto aeroporto2 = new Aeroporto("Aeroporto Intercontinentale di Roma Leonardo da Vinci", "Roma", "FCO");
		Aeroporto aeroporto3 = new Aeroporto("Aeroporto Intercontinetale di Milano Malpensa", "Milano", "MXP");
		VoloPrenotato[] listaVoliPrenotati = new VoloPrenotato[5];
		
		Volo volo1 = new Volo();
		Volo volo2 = new Volo();
		Volo volo3 = new Volo();
		Volo volo4 = new Volo();
		Volo volo5 = new Volo();
		Aeroporto[] tratta = {aeroporto1, aeroporto2};
		Aeroporto[] tratta2 = {aeroporto2, aeroporto3};
		Aeroporto[] tratta3 = {aeroporto1, aeroporto3};
		volo1.riempiDettagliVolo(new DescrizioneVolo("FA0011", tratta), 30.5, LocalDateTime.of(2020, Month.JUNE, 14, 15, 00), LocalDateTime.of(2020, Month.JUNE, 14, 16, 00));
		volo2.riempiDettagliVolo(new DescrizioneVolo("FA0021", tratta2), 40, LocalDateTime.of(2020, Month.MARCH, 15, 15, 00), LocalDateTime.of(2020, Month.MARCH, 15, 16, 00));
		volo3.riempiDettagliVolo(new DescrizioneVolo("FA0031", tratta3), 30.5, LocalDateTime.of(2020, Month.MARCH, 16, 15, 00), LocalDateTime.of(2020, Month.MARCH, 16, 16, 00));
		volo4.riempiDettagliVolo(new DescrizioneVolo("FA0022", tratta2), 100, LocalDateTime.of(2020, Month.MARCH, 16, 8, 00), LocalDateTime.of(2020, Month.MARCH, 16, 9, 00));
		volo5.riempiDettagliVolo(new DescrizioneVolo("FA0032", tratta3), 50, LocalDateTime.of(2020, Month.MARCH, 17, 15, 00), LocalDateTime.of(2020, Month.MARCH, 17, 16, 00));
		
		VoloPrenotato voloPrenotato1 = new VoloPrenotato(new Posto("25A", "base"),new Bagaglio("mano"),volo1);
		VoloPrenotato voloPrenotato2 = new VoloPrenotato(new Posto("10B", "premium"),new Bagaglio("10kg"),volo2);
		VoloPrenotato voloPrenotato3 = new VoloPrenotato(new Posto("25A", "optimum"),new Bagaglio("20kg"),volo3);
		VoloPrenotato voloPrenotato4 = new VoloPrenotato(new Posto("25A", "base"),new Bagaglio("20kg"),volo4);
		VoloPrenotato voloPrenotato5 = new VoloPrenotato(new Posto("25A", "optimum"),new Bagaglio("mano"),volo5);
		listaVoliPrenotati[0] = voloPrenotato1;
		listaVoliPrenotati[1] = voloPrenotato2;
		listaVoliPrenotati[2] = voloPrenotato3;
		listaVoliPrenotati[3] = voloPrenotato4;
		listaVoliPrenotati[4] = voloPrenotato5;
		
		Prenotazione prenotazione1 = new Prenotazione(0, new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", LocalDateTime.of(2010, Month.MAY, 30, 0, 0), LocalDateTime.of(2023, Month.SEPTEMBER, 21, 0, 0), "CI")), listaVoliPrenotati);

		
		//caso assegnazione punti nulla perchè assente programma fedeltà
		assertEquals(0, prenotazione1.accreditaPunti() , "Calcolo dei punti accreditati senza programma fedelta");
		
		ProgrammaFedelta programmaFedelta1 = new ProgrammaFedelta("programma base", 0.1);
		ProgrammaFedelta programmaFedelta2 = new ProgrammaFedelta("programma premium", 0.5);
		
		volo1.getDescrizioneVolo().assegnaProgrammaFedelta(programmaFedelta1);
		volo2.getDescrizioneVolo().assegnaProgrammaFedelta(programmaFedelta2);
		volo3.getDescrizioneVolo().assegnaProgrammaFedelta(programmaFedelta1);
		volo4.getDescrizioneVolo().assegnaProgrammaFedelta(programmaFedelta2);
		
		//caso assegnazione punti perchè presente programma fedeltà
		assertEquals(76, prenotazione1.accreditaPunti() , "Calcolo dei punti accreditati con programma fedelta");
		
	}
}
