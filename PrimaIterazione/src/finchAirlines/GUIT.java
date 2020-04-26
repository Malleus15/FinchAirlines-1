package finchAirlines;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;



public class GUIT {
	@SuppressWarnings("deprecation")
	public static void main(String[]args) {
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
		
		Volo volo1 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 19, 00), LocalDateTime.of(2020, Month.MARCH, 15, 20, 00), new DescrizioneVolo("FA0001", 30, aeroporto1, aeroporto2));
		listaVoliDisponibili.add(volo1);
		
		Volo volo2 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 15, 00), LocalDateTime.of(2020, Month.MARCH, 15, 16, 00), new DescrizioneVolo("FA0002", 15, aeroporto1, aeroporto2));
		listaVoliDisponibili.add(volo2);
		
		Volo volo3 = new Volo(LocalDateTime.of(2020, Month.MARCH, 15, 12, 00), LocalDateTime.of(2020, Month.MARCH, 15, 13, 00), new DescrizioneVolo("FA0003", 45, aeroporto1, aeroporto2));
		listaVoliDisponibili.add(volo3);		

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
		listaVoliDisponibili.add(volo11);
		
		
		finchAirlines.setListaVoli(listaVoliDisponibili);
		
		
		
		/*variabili temporanee per la ricerca*/	
		ArrayList<String> partenza = new ArrayList<String>();
		ArrayList<String> destinazione = new ArrayList<String>();
		ArrayList<LocalDateTime> date = new ArrayList<LocalDateTime>();
		int tipo_viaggio;
		
		/*Dati di ricerca*/
		partenza.add("CTA");
		partenza.add("FCO");
		partenza.add("MXP");
		destinazione.add("FCO");
		destinazione.add("MXP");
		destinazione.add("CTA");
		tipo_viaggio = 3;		
		date.add(LocalDateTime.of(2020, Month.MARCH, 15, 15, 00));
		date.add(LocalDateTime.of(2020, Month.MARCH, 22, 15, 00));
		date.add(LocalDateTime.of(2020, Month.MARCH, 29, 15, 00));
		
		VoloPrenotato[] listaVoli = new VoloPrenotato[tipo_viaggio];	
		
													
		
													/*OPERAZIONI GUI*/	
		Scanner scan = new Scanner(System.in);
		String email;
		String password;
		boolean check;
		
		System.out.println("Benvenuto sul sistema di prenotazione di FinchAirlines!\n\n");
		do {
			System.out.println("Inserisci il tuo indirizzo email: ");		
			email = scan.nextLine();
			System.out.println("Inserisci la tua password: ");	
			password = scan.nextLine();
			check = finchAirlines.autenticaCliente(email, password);
			if(!check)
				System.out.println("Email o password errata!\n\n");
		}
		while(!check);
		System.out.println("Login avvenuto correttamente!\n");
		
		System.out.println("Informazioni di ricerca:\n");
		for(int i=0; i < tipo_viaggio; i++) {
			System.out.println("Volo "+(i+1)+":");
			System.out.println("Partenza: "+partenza.get(i)+" Destinazione: "+destinazione.get(i)+" Data: "+date.get(i)+"\n");
		}
		
		System.out.println("Avvio ricerca...\n");
		//Operazione di ricerca
		ArrayList<ArrayList<Volo>> voliTrovati = finchAirlines.ricercaVolo(partenza, destinazione, tipo_viaggio, date); 
		
		
		//messaggi di richiesta di prenotazione (pulsante acquista)
		for(int i = 0; i < tipo_viaggio; i++) {		//i seleziona la tratta
			//messaggio: Seleziona il volo per la tratta i-esima
			System.out.println("Voli trovati per la tratta "+partenza.get(i)+" - "+destinazione.get(i)+":");
			//voloScelto -> variabile per il volo scelto dall'utente per la tratta i-esima
			for(int j = 0; j < voliTrovati.get(i).size(); j++)
				System.out.println((j+1)+". "+voliTrovati.get(i).get(j).getOraPartenza()+"  "+voliTrovati.get(i).get(j).getOraArrivo()+" "+voliTrovati.get(i).get(j).getDescrizioneVolo().getPrezzo()+" �");
			System.out.print("Seleziona il volo: ");
			int voloScelto = scan.nextInt();
			listaVoli[i] = new VoloPrenotato(voliTrovati.get(i).get(voloScelto - 1)); 			
		}
		scan.nextLine();
		
		for(int i = 0; i < tipo_viaggio; i++) {
			//messaggio: seleziona i servizi per il volo i-esimo
			System.out.println("Seleziona il posto e il tipo per la tratta "+partenza.get(i)+" - "+destinazione.get(i)+":");
			//postoScelto -> variabile per il posto scelto per la tratta i-esima
			System.out.print("Inserisci posto: ");
			String numeroPosto = scan.nextLine();
			System.out.print("Inserisci tipo: ");
			String tipoPosto = scan.nextLine();
			listaVoli[i].setPosto(new Posto(numeroPosto, tipoPosto));
		}
		
		for(int i = 0; i < tipo_viaggio; i++) {
			//messaggio: seleziona i servizi per il volo i-esimo
			System.out.print("Seleziona il bagaglio per la tratta "+partenza.get(i)+" - "+destinazione.get(i)+":");
			String bagaglioScelto = scan.nextLine();
			//bagaglioScelto -> variabile per il posto scelto per la tratta i-esima
			listaVoli[i].setBagaglio(new Bagaglio(bagaglioScelto));
		}
		
		for(Cliente cliente: finchAirlines.getListaClienti())
			if(cliente.getEmail().equalsIgnoreCase(email)) {
				finchAirlines.creaPrenotazione(cliente, listaVoli);
				break;
			}
		System.out.println("Prenotazione effettuata con successo!");
		scan.close();
		
	}

}
