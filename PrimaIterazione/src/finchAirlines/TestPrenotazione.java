package finchAirlines;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import org.junit.jupiter.api.Test;

class TestPrenotazione {

	@Test
	void testCalcolaTotaleVoli() {
		//VoloPrenotato[] listaVoliPrenotati = new VoloPrenotato[3];
	}		
		/*Aeroporto aeroporto1 = new Aeroporto("Aeroporto Internazionale di Catania Vincenzo Bellini", "Catania", "CTA");
		Aeroporto aeroporto2 = new Aeroporto("Aeroporto Intercontinentale di Roma Leonardo da Vinci", "Roma", "FCO");
		Aeroporto aeroporto3 = new Aeroporto("Aeroporto Intercontinetale di Milano Malpensa", "Milano", "MXP");
		
		/*Volo volo1 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 19, 00), LocalDateTime.of(2020, Month.MARCH, 15, 20, 00), new DescrizioneVolo("FA0001", 30, aeroporto1, aeroporto2));
		VoloPrenotato voloPrenotato = new VoloPrenotato(new Posto("25A", "base"),new Bagaglio("10kg"),volo1);
		listaVoliPrenotati[0] = voloPrenotato;
		
		Volo volo2 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 15, 00), LocalDateTime.of(2020, Month.MARCH, 15, 16, 00), new DescrizioneVolo("FA0002", 15, aeroporto1, aeroporto2));
		VoloPrenotato voloPrenotato1 = new VoloPrenotato(new Posto("25A", "base"),new Bagaglio("10kg"),volo2);
		listaVoliPrenotati[1] = voloPrenotato1;
		
		Volo volo3 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 12, 00), LocalDateTime.of(2020, Month.MARCH, 15, 13, 00), new DescrizioneVolo("FA0003", 45, aeroporto1, aeroporto2));
		VoloPrenotato voloPrenotato2 = new VoloPrenotato(new Posto("25A", "base"),new Bagaglio("10kg"),volo3);
		listaVoliPrenotati[2] = voloPrenotato2;	
		
		Prenotazione prenotazione = new Prenotazione(0, new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", LocalDateTime.of(2010, Month.MAY, 30, 0, 0), LocalDateTime.of(2023, Month.SEPTEMBER, 21, 0, 0), "CI")), listaVoliPrenotati);
		
		//caso standard 30 + 15 + 45 + 3 * 1 + 3 * 5
		assertEquals(108, prenotazione.getTotale(), "Totale per il volo prenotato");
		/**********************************************************************
		Volo volo4 = new Volo(LocalDateTime.of(2020, Month.MARCH, 22, 15, 00), LocalDateTime.of(2020, Month.MARCH, 22, 16, 00), new DescrizioneVolo("FA0011", 0, aeroporto2, aeroporto3));
		VoloPrenotato voloPrenotato3 = new VoloPrenotato(new Posto("25A", "premium"),new Bagaglio("10kg"),volo4);
		listaVoliPrenotati[0] = voloPrenotato3;
		
		Volo volo5 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 15, 00), LocalDateTime.of(2020, Month.MARCH, 15, 16, 00), new DescrizioneVolo("FA0002", -15, aeroporto1, aeroporto2));
		VoloPrenotato voloPrenotato4 = new VoloPrenotato(new Posto("25A", "base"),new Bagaglio("20kg"),volo5);
		listaVoliPrenotati[1] = voloPrenotato4;
		
		Volo volo6 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 12, 00), LocalDateTime.of(2020, Month.MARCH, 15, 13, 00), new DescrizioneVolo("FA0003", 45, aeroporto1, aeroporto2));
		VoloPrenotato voloPrenotato5 = new VoloPrenotato(new Posto("25A", "optimum"),new Bagaglio("mano"),volo6);
		listaVoliPrenotati[2] = voloPrenotato5;	
		
		Prenotazione prenotazione1 = new Prenotazione(0, new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", LocalDateTime.of(2010, Month.MAY, 30, 0, 0), LocalDateTime.of(2023, Month.SEPTEMBER, 21, 0, 0), "CI")), listaVoliPrenotati);

		
		//caso alternativo 0 -15 45 (volo) 4 1 10 (posto) 5 15 2.50
		assertEquals(82.50, prenotazione1.getTotale(), "Totale per il volo prenotato");
		
	}
	
	@Test
	void testRicercaVolo() {
		Aeroporto aeroporto1 = new Aeroporto("Aeroporto Internazionale di Catania Vincenzo Bellini", "Catania", "CTA");
		Aeroporto aeroporto2 = new Aeroporto("Aeroporto Intercontinentale di Roma Leonardo da Vinci", "Roma", "FCO");
		Aeroporto aeroporto3 = new Aeroporto("Aeroporto Intercontinetale di Milano Malpensa", "Milano", "MXP");
		
		VoloPrenotato[] listaVoliPrenotati = new VoloPrenotato[3];
		//la data in volo 4 è stat inserita appositamente per permettere il checkin (tra 7 e 0 giorni dalla partenza)
		Volo volo4 = new Volo(LocalDateTime.of(2020, Month.JUNE, 8, 15, 00), LocalDateTime.of(2020, Month.JUNE, 8, 16, 00), new DescrizioneVolo("FA0011", 0, aeroporto2, aeroporto3));
		VoloPrenotato voloPrenotato3 = new VoloPrenotato(new Posto("25A", "premium"),new Bagaglio("10kg"),volo4);
		listaVoliPrenotati[0] = voloPrenotato3;
		
		Volo volo5 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 15, 00), LocalDateTime.of(2020, Month.MARCH, 15, 16, 00), new DescrizioneVolo("FA0002", -15, aeroporto1, aeroporto2));
		VoloPrenotato voloPrenotato4 = new VoloPrenotato(new Posto("25A", "base"),new Bagaglio("20kg"),volo5);
		listaVoliPrenotati[1] = voloPrenotato4;
		
		Volo volo6 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 12, 00), LocalDateTime.of(2020, Month.MARCH, 15, 13, 00), new DescrizioneVolo("FA0003", 45, aeroporto1, aeroporto2));
		VoloPrenotato voloPrenotato5 = new VoloPrenotato(new Posto("25A", "optimum"),new Bagaglio("mano"),volo6);
		listaVoliPrenotati[2] = voloPrenotato5;	
		
		Prenotazione prenotazione1 = new Prenotazione(0, new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", LocalDateTime.of(2010, Month.MAY, 30, 0, 0), LocalDateTime.of(2023, Month.SEPTEMBER, 21, 0, 0), "CI")), listaVoliPrenotati);
		
		assertEquals(voloPrenotato3, prenotazione1.ricercaVolo(0), "Ricerca del volo per il checkin");
	}*/
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
		
		assertEquals(0, prenotazione1.accreditaPunti() , "Calcolo dei punti accreditati senza programma fedelta");
		
		ProgrammaFedelta programmaFedelta1 = new ProgrammaFedelta("programma base", 0.1);
		ProgrammaFedelta programmaFedelta2 = new ProgrammaFedelta("programma premium", 0.5);
		
		volo1.getDescrizioneVolo().assegnaProgrammaFedelta(programmaFedelta1);
		volo2.getDescrizioneVolo().assegnaProgrammaFedelta(programmaFedelta2);
		volo3.getDescrizioneVolo().assegnaProgrammaFedelta(programmaFedelta1);
		volo4.getDescrizioneVolo().assegnaProgrammaFedelta(programmaFedelta2);
		
		
		assertEquals(76, prenotazione1.accreditaPunti() , "Calcolo dei punti accreditati con programma fedelta");
		
		
	}
}
