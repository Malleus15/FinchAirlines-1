package finchAirlines;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import org.junit.jupiter.api.Test;

class TestPrenotazione {

	@Test
	void testCalcolaTotaleVoli() {
		VoloPrenotato[] listaVoliPrenotati = new VoloPrenotato[3];
		
		Aeroporto aeroporto1 = new Aeroporto("Aeroporto Internazionale di Catania Vincenzo Bellini", "Catania", "CTA");
		Aeroporto aeroporto2 = new Aeroporto("Aeroporto Intercontinentale di Roma Leonardo da Vinci", "Roma", "FCO");
		Aeroporto aeroporto3 = new Aeroporto("Aeroporto Intercontinetale di Milano Malpensa", "Milano", "MXP");
		Aeroporto aeroporto4 = new Aeroporto("Aeroporto Internazione di Verona", "Verona", "VRN");
		
		Volo volo1 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 19, 00), LocalDateTime.of(2020, Month.MARCH, 15, 20, 00), new DescrizioneVolo("FA0001", 30, aeroporto1, aeroporto2));
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
		/**********************************************************************/
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

		
		//caso standard 0 -15 45 (volo) 4 1 10 (posto) 5 15 2.50
		assertEquals(82.50, prenotazione1.getTotale(), "Totale per il volo prenotato");
		

		/*
		Volo volo4 = new Volo(LocalDateTime.of(2020, Month.MARCH, 22, 15, 00), LocalDateTime.of(2020, Month.MARCH, 22, 16, 00), new DescrizioneVolo("FA0011", 15, aeroporto2, aeroporto3));
		listaVoliDisponibili.add(volo4);
		
		Volo volo5 = new Volo(LocalDateTime.of(2020, Month.MARCH, 22, 11, 00), LocalDateTime.of(2020, Month.MARCH, 22, 12, 00), new DescrizioneVolo("FA0012", 50, aeroporto2, aeroporto3));
		listaVoliDisponibili.add(volo5);
		
		Volo volo6 = new Volo(LocalDateTime.of(2020, Month.MARCH, 22, 18, 00), LocalDateTime.of(2020, Month.MARCH, 22, 19, 00), new DescrizioneVolo("FA0013", 15, aeroporto2, aeroporto3));
		listaVoliDisponibili.add(volo6);
		
		Volo volo7 = new Volo(LocalDateTime.of(2020, Month.MARCH, 22, 21, 00), LocalDateTime.of(2020, Month.MARCH, 22, 22, 00), new DescrizioneVolo("FA0014", 40, aeroporto2, aeroporto3));
		listaVoliDisponibili.add(volo7);

		Volo volo8 = new Volo(LocalDateTime.of(2020, Month.MARCH, 21, 11, 00), LocalDateTime.of(2020, Month.MARCH, 21, 10, 00), new DescrizioneVolo("FA1001", 30, aeroporto3, aeroporto4));
		listaVoliDisponibili.add(volo8);
		
		Volo volo9 = new Volo(LocalDateTime.of(2020, Month.MARCH, 22, 10, 00), LocalDateTime.of(2020, Month.MARCH, 22, 11, 00), new DescrizioneVolo("FA1002", 15, aeroporto3, aeroporto4));
		listaVoliDisponibili.add(volo9);
		
		Volo volo10 = new Volo(LocalDateTime.of(2020, Month.MARCH, 29, 15, 00), LocalDateTime.of(2020, Month.MARCH, 29, 16, 00), new DescrizioneVolo("FA0101", 30, aeroporto3, aeroporto1));
		listaVoliDisponibili.add(volo10);
		
		Volo volo11 = new Volo(LocalDateTime.of(2020, Month.MARCH, 29, 18, 00), LocalDateTime.of(2020, Month.MARCH, 29, 19, 00), new DescrizioneVolo("FA0102", 35, aeroporto3, aeroporto1));
		listaVoliDisponibili.add(volo11);*/
	}

	@Test
	void testInviaEmail() {
		fail("Not yet implemented");
	}

}
