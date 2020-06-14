package finchAirlines;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  */




public class UI {
	public static void main(String[]args) {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/FinchAirlines?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pass = "password";
		FinchAirlines finchAirlines = new FinchAirlines();
		Connection myconn;
		/*HibernateUtil 
		Session session = HibernateUtil.getSessionFactory().openSession();*/
		ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
		ArrayList<Volo> listaVoli = new ArrayList();
		try {
			myconn = DriverManager.getConnection(jdbcURL, user, pass);
			Statement sttm = myconn.createStatement();
			ResultSet rs = sttm.executeQuery("SELECT * FROM clienti");
			while(rs.next()) {
				String data_rilascio = rs.getString("data_rilascio");
				String data_scadenza = rs.getString("data_scadenza");
				DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime dataRilascio = LocalDateTime.parse(data_rilascio, data);
				LocalDateTime dataScadenza = LocalDateTime.parse(data_scadenza, data);
				Cliente cliente = new Cliente(rs.getString("nome"), rs.getString("cognome"), rs.getString("email"), rs.getString("telefono"), rs.getString("pass"), new Documento(rs.getString("id_documento"), dataRilascio, dataScadenza, rs.getString("tipo")));
				cliente.setPunti(rs.getInt("punti"));
				listaClienti.add(cliente);
			}
			
			Statement stmVoliCompleti = myconn.createStatement();
			ResultSet rsVoliCompleti = stmVoliCompleti.executeQuery("SELECT v.ora_partenza,v.ora_arrivo,v.prezzo,d.codice, t.nome1,t.nome2,t.codice1,t.codice2,t.citta1,t.citta2,p.nome,p.coefficiente_punti, d.nome_programma_fedelta FROM programmaFedelta p,descrizioneVoli d, voli v, tratte t WHERE d.codice=v.codice AND t.codice1=d.codice1_tratta AND t.codice1=d.codice1_tratta");
			Statement stmProgrammaFedelta = myconn.createStatement();
			ResultSet rsProgrammaFedelta = stmProgrammaFedelta.executeQuery("SELECT * FROM programmaFedelta");
			ArrayList<ProgrammaFedelta> programmaFedeltaList = new ArrayList<>();
			
			while(rsProgrammaFedelta.next()) {
				ProgrammaFedelta programmaFedelta = new ProgrammaFedelta(rsProgrammaFedelta.getString("nome"), rsProgrammaFedelta.getDouble("coefficiente_punti"));
				programmaFedeltaList.add(programmaFedelta);
			}
			while(rsVoliCompleti.next()) {
				//voli.prezzo, voli.ora_partenza, voli.ora_arrivo, descrizioneVoli.codice1_tratte, descrizioneVoli.codice2_tratte, descrizioneVoli.nome
				//String codiceDescrizione = rsVoli.getString("codice");
				
				Aeroporto aeroporto1 = new Aeroporto(rsVoliCompleti.getString("nome1"), rsVoliCompleti.getString("citta1"), rsVoliCompleti.getString("codice1"));
				Aeroporto aeroporto2 = new Aeroporto(rsVoliCompleti.getString("nome2"), rsVoliCompleti.getString("citta2"), rsVoliCompleti.getString("codice2"));
				Aeroporto[] tratte = {aeroporto1, aeroporto2};
				DescrizioneVolo descrizioneVolo = new DescrizioneVolo(rsVoliCompleti.getString("codice"), tratte);
				
				String ora_partenza = rsVoliCompleti.getString("ora_partenza");
				String ora_arrivo = rsVoliCompleti.getString("ora_arrivo");
				DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime oraPartenza = LocalDateTime.parse(ora_partenza, data);
				LocalDateTime oraArrivo = LocalDateTime.parse(ora_arrivo, data);
				
				for(ProgrammaFedelta programmaFedelta: programmaFedeltaList) {
					if(programmaFedelta.getNome().equals(rsVoliCompleti.getString("nome_programma_fedelta")))
						if(programmaFedelta.getNome().equals("nessuno"))
							break;
						else
							descrizioneVolo.assegnaProgrammaFedelta(programmaFedelta);
				}
				Volo volo = new Volo();
				volo.riempiDettagliVolo(descrizioneVolo, rsVoliCompleti.getDouble("prezzo"), oraPartenza, oraArrivo);
				listaVoli.add(volo);
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
			
		
		/*Riempimento listaClienti di FinchAirlines*/
		//finchAirlines.setListaClienti(listaClienti);
		
		Scanner scan = new Scanner(System.in);
		
		//autenticazione
		String email = "";
		String password;
		boolean check;
		
		System.out.println("Benvenuto sul sistema di prenotazione di FinchAirlines!\n\n");
		System.out.println("[1]Login Utente");
		System.out.println("[2]Login Admin");
		int login= scan.nextInt();
		scan.nextLine();
		
		switch(login) {
		case 1:
			do {
				System.out.println("Inserisci il tuo indirizzo email: ");		
				email = scan.nextLine();
				System.out.println("Inserisci la tua password: ");	
				password = scan.nextLine();
				check = finchAirlines.autenticaCliente(email, password);
				if(!check)
					System.out.println("Email o password errata!\n\n");
				break;
			}
			while(!check);
		
		case 2:
			do {
				System.out.println("Inserisci il tuo indirizzo email: ");		
				email = scan.nextLine();
				System.out.println("Inserisci la tua password: ");	
				password = scan.nextLine();
				check = finchAirlines.autenticaAmministratore(email, password);
				if(!check)
					System.out.println("Email o password errata!\n\n");
				break;
			}
			while(!check);
		default:
			System.out.println("Scelta non corretta");
		}
		System.out.println("Login avvenuto correttamente!\n");
		
		//operazioni cliente
		if(login == 1) {
			System.out.println("Seleziona l'operazione da effettuare:");
			System.out.println("[1]Ricerca Volo");
			System.out.println("[2]Effettua il pagamento di una prenotazione");
			System.out.println("[3]Effettua il checkin per un volo");
			int scelta = scan.nextInt();
			switch(scelta) {
			
			case 1:
				System.out.println("Benvenuto, quanti voli vuoi cercare?");
				int tipoViaggio = scan.nextInt();
				scan.nextLine();
				for(int i=0; i < tipoViaggio; i++) {
					System.out.println("seleziona la citt� di partenza per il volo "+i+1);
				}
				System.out.println("Informazioni di ricerca:\n");
				for(int i=0; i < tipoViaggio; i++) {
					System.out.println("Volo "+(i+1)+":");
					//System.out.println("Partenza: "+partenza.get(i)+" Destinazione: "+destinazione.get(i)+" Data: "+date.get(i)+"\n");
				}
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("Scelta non corretta");
			}
		}
		
		//operazioni amministratore
		else {
			System.out.println("Seleziona l'operazione da effettuare:");
			System.out.println("[1]Gestisci voli");
			System.out.println("[2]Gestisci un programma fedelt�");
			int scelta = scan.nextInt();
			switch(scelta) {
			case 1:
				break;
			case 2:
				break;
			default:
				System.out.println("Scelta non corretta");
			}
		}
		
		System.out.println("Seleziona l'operazione da effettuare:");
		
		
		
		
		System.out.println("Benvenuto, quanti voli vuoi inserire?");
		int numeroVoli = scan.nextInt();
		scan.nextLine();
		ArrayList<Volo> voli = finchAirlines.inserisciVoli(numeroVoli);
		Aeroporto[] tratta = finchAirlines.inserisciTratta("Catania Fontanarossa", "Milano Malpensa" , "Catania", "Milano", "CTA", "FCO");
		DescrizioneVolo descrizioneVolo = finchAirlines.inserisciDescrizione("A210", tratta);
		for(int i=0; i<numeroVoli; i++) {
			System.out.println("Inserisci il prezzo per il volo numero "+ (i+1) +":");
			double prezzo = scan.nextDouble();
			scan.nextLine();
			System.out.println("Inserisci il giorno per il volo numero "+ (i+1) +":");
			int giorno = scan.nextInt();
			scan.nextLine();
			System.out.println("Inserisci l'ora di partenza per il volo numero "+ (i+1) +":");
			int ora1 = scan.nextInt();
			scan.nextLine();
			System.out.println("Inserisci l'ora di arrivo per il volo numero "+ (i+1) +":");
			int ora2 = scan.nextInt();
			scan.nextLine();
			LocalDateTime oraPartenza= LocalDateTime.of(2020, Month.MARCH, giorno, ora1, 00);
			LocalDateTime oraArrivo= LocalDateTime.of(2020, Month.MARCH, giorno, ora2, 00);
			finchAirlines.inserisciDettagliVolo(descrizioneVolo, voli.get(i), prezzo , oraPartenza, oraArrivo);
		}
		if(finchAirlines.confermaInserimento(voli))
			System.out.println("voli inseriti con successo!" + finchAirlines.getListaVoli());
		
		
		ProgrammaFedelta programmaFedelta = finchAirlines.inserisciProgrammaFedelta("Pippo", 0.1);
		if(finchAirlines.associaProgrammaFedelta("A210", programmaFedelta))
			System.out.println("programma fedelt� creato con successo");
		
		
		
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
		
		GestisciPrenotazioneHandler gestisciPrenotazione = new GestisciPrenotazioneHandler(tipo_viaggio);
		
													
		
													/*OPERAZIONI GUI*/	
		
		
		
		
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
				System.out.println("["+(j+1)+"] "+voliTrovati.get(i).get(j).getOraPartenza()+"  "+voliTrovati.get(i).get(j).getOraArrivo()+" "+voliTrovati.get(i).get(j).getPrezzo()+" �");
			//Controllare che vengano trovati voli per la data selezionata
			System.out.print("Seleziona il volo: ");
			int voloScelto = scan.nextInt();
			gestisciPrenotazione.selezionaVoli(voliTrovati.get(i).get(voloScelto - 1), i);
					
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
			gestisciPrenotazione.selezionaPosto(numeroPosto, tipoPosto, i);
			
		}
		
		for(int i = 0; i < tipo_viaggio; i++) {
			//messaggio: seleziona i servizi per il volo i-esimo
			System.out.print("Seleziona il bagaglio per la tratta "+partenza.get(i)+" - "+destinazione.get(i)+":");
			String bagaglioScelto = scan.nextLine();
			//bagaglioScelto -> variabile per il posto scelto per la tratta i-esima
			gestisciPrenotazione.selezionaBagaglio(bagaglioScelto, i);
		}
		
		finchAirlines.confermaPrenotazione(finchAirlines.ricercaCliente(email), gestisciPrenotazione.getListaVoli());
		
		System.out.println("Prenotazione effettuata con successo!");
		//scan.close();
		
		
		
		/*pagamento di una prenotazione tramite paypal.
		 *Si dovrebbe effettuare il testing anche del pagamento tramite carta di credito ma le funzioni sono identiche*/
		Prenotazione prenotazione1 = finchAirlines.getListaPrenotazioni().get(0);
		System.out.println("Pagamento tramite paypal della prenotazione num. " + prenotazione1.getNumeroPrenotazione());
		finchAirlines.effettuaPagamentoPayPal(prenotazione1);
		System.out.println("Pagamento di: " + prenotazione1.getTotale());
		int punti = finchAirlines.selezionaSconto(prenotazione1);
		System.out.println("Il cliente possiede i seguenti punti: " + punti);
		int puntiSelezionati = 0;
		
		do {
			System.out.println("Seleziona i punti da utilizare per lo sconto");
			puntiSelezionati = scan.nextInt();
			if ((puntiSelezionati > punti) || (puntiSelezionati<0))
				System.out.println("Selezione non corretta!");
		}
		while((puntiSelezionati > punti) || (puntiSelezionati<0));
		
		double nuovoTotale = finchAirlines.selezionaPunti(puntiSelezionati, prenotazione1.getTotale());
		System.out.println("Selezionati " + puntiSelezionati + "punti, nuovo totale: " + nuovoTotale);
		
		System.out.println("Inserire email per effettuare il pagamento tramite il conto PayPal:");
		scan.nextLine();
		String emailPayPal = scan.nextLine();
		
		if(finchAirlines.pagamentoPayPal(nuovoTotale, prenotazione1, emailPayPal, puntiSelezionati))
			System.out.println("Pagamento effettuato con successo");
		else
			System.out.println("Pagamento non riuscito");
		
		//checkin di una prenotazione
		//precondizione: Login gi� effettuato
		System.out.println("Procedura di checkin avviata!");
		ArrayList<Prenotazione> listaPrenotazioniCliente = finchAirlines.effettuaCheckin(listaClienti.get(0));
		System.out.println("Prenotazioni del cliente: " + listaClienti.get(0).getNome()+ " "+ listaClienti.get(0).getCognome());
		for(Prenotazione prenotazione: listaPrenotazioniCliente)
			System.out.println("Numero prenotazione: "+ prenotazione.getNumeroPrenotazione());
		System.out.println("Seleziona la prenotazione per cui vuoi effettuare il checkin:");
		int numeroPrenotazione = scan.nextInt();
		Prenotazione prenotazioneSelezionata = finchAirlines.selezionaPrenotazione(numeroPrenotazione, listaPrenotazioniCliente);
		if(prenotazioneSelezionata.equals(null))
			System.out.println("Prenotazione non trovata!");
		int i=0;
		for(VoloPrenotato voloPrenotato: prenotazioneSelezionata.getListaVoli()) {
			i++;
			System.out.println("[" + i +"] " + voloPrenotato.getVolo().getDescrizioneVolo().getCodice() + " con partenza in data "+ voloPrenotato.getVolo().getOraPartenza());
		}
		System.out.println("Seleziona il volo per cui vuoi effettuare il checkin:");
		VoloPrenotato voloPrenotato = finchAirlines.selezionaVolo(scan.nextInt() -1, prenotazioneSelezionata);
		
		CartaDiImbarco cartaDiImbarco = finchAirlines.confermaInserimento(prenotazioneSelezionata, voloPrenotato);
		if (cartaDiImbarco.equals(null))
			System.out.println("Impossibile effettuare il checkin.");
		System.out.println("Checkin effettuato.");
		System.out.println("Il volo per cui � stato effettuato il checkin � " + voloPrenotato.getVolo().getDescrizioneVolo().getCodice()+ " con partenza da " + voloPrenotato.getVolo().getDescrizioneVolo().getAeroporti()[0].getCitta()+" in data " + voloPrenotato.getVolo().getOraPartenza());
		
		scan.close();
	}

}
