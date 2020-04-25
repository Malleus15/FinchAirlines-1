package finchAirlines;

import java.util.ArrayList;
import java.util.Date;

public class GUIT {
	@SuppressWarnings("deprecation")
	public static void main() {
		FinchAirlines finchAirlines = new FinchAirlines();		
		
		/*Riempimento listaClienti di FinchAirlines*/
		ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
		listaClienti.add(new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", new Date(2010, 5, 30), new Date(2023, 9, 21), "CI")));
		finchAirlines.setListaClienti(listaClienti);
		
		/*Riempimento listaVoli di FinchAirlines*/
		ArrayList<Volo> listaVoliDisponibili = new ArrayList<Volo>();
		Aeroporto aeroporto1 = new Aeroporto("Aeroporto Internazionale di Catania Vincenzo Bellini", "Catania", "CTA");
		Aeroporto aeroporto2 = new Aeroporto("Aeroporto Intercontinentale di Roma Leonardo da Vinci", "Roma", "FCO");
		Aeroporto aeroporto3 = new Aeroporto("Aeroporto Intercontinetale di Milano Malpensa", "Milano", "MXP");
		Aeroporto aeroporto4 = new Aeroporto("Aeroporto Internazione di Verona", "Verona", "VRN");
		Aeroporto[] aeroporti;
		
		aeroporti[0] = aeroporto1;
		aeroporti[1] = aeroporto2;
		Volo volo1 = new Volo(new Date(2020, 2, 15, 17, 00), new Date(2020, 2, 15, 18, 15), new DescrizioneVolo("FA0001", 30, aeroporti));
		
		
		aeroporti[0] = aeroporto1;
		aeroporti[1] = aeroporto2;
		Volo volo2 = new Volo(new Date(2020, 2, 15, 20, 00), new Date(2020, 2, 15, 21, 15), new DescrizioneVolo("FA0002", 15, aeroporti));
		
		aeroporti[0] = aeroporto1;
		aeroporti[1] = aeroporto2;
		Volo volo3 = new Volo(new Date(2020, 2, 15, 19, 00), new Date(2020, 2, 15, 20, 15), new DescrizioneVolo("FA0003", 45, aeroporti));
		
		aeroporti[0] = aeroporto2;
		aeroporti[1] = aeroporto3;
		Volo volo4 = new Volo(new Date(2020, 2, 22, 20, 00), new Date(2020, 2, 22, 20, 50), new DescrizioneVolo("FA0011", 15, aeroporti));
		
		aeroporti[0] = aeroporto2;
		aeroporti[1] = aeroporto3;
		Volo volo5 = new Volo(new Date(2020, 2, 22, 13, 30), new Date(2020, 2, 22, 14, 20), new DescrizioneVolo("FA0012", 50, aeroporti));
		
		aeroporti[0] = aeroporto2;
		aeroporti[1] = aeroporto3;
		Volo volo6 = new Volo(new Date(2020, 2, 22, 20, 00), new Date(2020, 2, 22, 20, 50), new DescrizioneVolo("FA0013", 15, aeroporti));
		
		aeroporti[0] = aeroporto2;
		aeroporti[1] = aeroporto3;
		Volo volo7 = new Volo(new Date(2020, 2, 15, 13, 30), new Date(2020, 2, 15, 14, 20), new DescrizioneVolo("FA0014", 40, aeroporti));
		
		aeroporti[0] = aeroporto2;
		aeroporti[1] = aeroporto4;
		Volo volo8 = new Volo(new Date(2020, 2, 15, 17, 00), new Date(2020, 2, 15, 18, 15), new DescrizioneVolo("FA1001", 30, aeroporti));
		
		aeroporti[0] = aeroporto2;
		aeroporti[1] = aeroporto4;
		Volo volo9 = new Volo(new Date(2020, 2, 22, 20, 00), new Date(2020, 2, 22, 20, 50), new DescrizioneVolo("FA1002", 15, aeroporti));
		
		aeroporti[0] = aeroporto3;
		aeroporti[1] = aeroporto1;
		Volo volo10 = new Volo(new Date(2020, 2, 29, 21, 00), new Date(2020, 2, 29, 23, 15), new DescrizioneVolo("FA0101", 30, aeroporti));
		
		aeroporti[0] = aeroporto3;
		aeroporti[1] = aeroporto1;
		Volo volo11 = new Volo(new Date(2020, 2, 29, 19, 00), new Date(2020, 2, 29, 21, 15), new DescrizioneVolo("FA0102", 35, aeroporti));
		
		
		
		
		/*variabili temporanee per la ricerca*/
		ArrayList<ArrayList<Volo>> voliTrovati;
		VoloPrenotato[] listaVoli;		
		ArrayList<String> partenza = new ArrayList<String>();
		ArrayList<String> destinazione = new ArrayList<String>();
		ArrayList<Date> date = new ArrayList<Date>();
		
		/*Dati di ricerca*/
		partenza.add("CTA");
		partenza.add("FCO");
		partenza.add("MXP");
		destinazione.add("FCO");
		destinazione.add("MXP");
		destinazione.add("CTA");
		int tipo_viaggio = 3;		
		date.add(new Date(2020, 2, 15));
		date.add(new Date(2020, 2, 22));
		date.add(new Date(2020, 2, 29));
		
													
		
													/*OPERAZIONI GUI*/		
		//Operazione di ricerca
		voliTrovati = finchAirlines.ricercaVolo(partenza, destinazione, tipo_viaggio, date); 
		
		//messaggi di richiesta di prenotazione (pulsante acquista)
		for(int i = 0; i < tipo_viaggio; i++) {		//i seleziona la tratta
			//messaggio: Seleziona il volo per la tratta i-esima
			//voloScelto -> variabile per il volo scelto dall'utente per la tratta i-esima
			listaVoli[i].setVolo(voliTrovati.get(i).get(voloScelto - 1)); 			
		}
		
		
		for(int i = 0; i < tipo_viaggio; i++) {
			//messaggio: seleziona i servizi per il volo i-esimo
			//postoScelto -> variabile per il posto scelto per la tratta i-esima
			listaVoli[i].setPosto(new Posto(postoScelto));
		}
		
		for(int i = 0; i < tipo_viaggio; i++) {
			//messaggio: seleziona i servizi per il volo i-esimo
			//bagaglioScelto -> variabile per il posto scelto per la tratta i-esima
			listaVoli[i].setBagaglio(new Bagaglio(bagaglioScelto));
		}
		
		finchAirlines.creaPrenotazione(cliente, listaVoli);
		
	}

}
