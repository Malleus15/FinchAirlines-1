package finchAirlines;

import java.util.ArrayList;
import java.util.Date;

public class GUIT {
	@SuppressWarnings("deprecation")
	public static void main() {
		FinchAirlines finchAirlines = new FinchAirlines();
		ArrayList<ArrayList<Volo>> voliTrovati;
		VoloPrenotato[] listaVoli;
		
		ArrayList<String> partenza = new ArrayList<String>();
		ArrayList<String> destinazione = new ArrayList<String>();
		ArrayList<Date> date = new ArrayList<Date>();
		
		Cliente cliente = new Cliente("Mario", "Rossi","prova@prova.it", "3333333333", "password", new Documento("12345", new Date(2010, 5, 30), new Date(2023, 9, 21), "CI"));
		
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
		
		//interfaccia utente per le operazioni corrispondenti ai 2 UC individuati
		
		//si può fare solo ricerca senza prenotare e eventuale prenotazione
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
			listaVoli[i].setPosto(new Bagaglio(bagaglioScelto));
		}
		
		finchAirlines.creaPrenotazione(cliente, listaVoli);
		
	}

}
