package finchAirlines;

import java.util.ArrayList;
import java.time.LocalDateTime;


public class FinchAirlines {

	private ArrayList<Cliente> listaClienti;
	private ArrayList<Prenotazione> listaPrenotazioni;
	private ArrayList<Volo> listaVoli;
	private ArrayList<Amministratore> listaAmministratori;
	

	public FinchAirlines() {
		this.listaClienti = new ArrayList<Cliente>();
		this.listaPrenotazioni = new ArrayList<Prenotazione>();
		this.listaVoli = new ArrayList<Volo>();
		this.listaAmministratori = new ArrayList<Amministratore>();
	}
	
	


	public ArrayList<Cliente> getListaClienti() {
		return listaClienti;
	}




	public void setListaClienti(ArrayList<Cliente> listaClienti) {
		this.listaClienti = listaClienti;
	}




	public ArrayList<Prenotazione> getListaPrenotazioni() {
		return listaPrenotazioni;
	}




	public void setListaPrenotazioni(ArrayList<Prenotazione> listaPrenotazioni) {
		this.listaPrenotazioni = listaPrenotazioni;
	}




	public ArrayList<Volo> getListaVoli() {
		return listaVoli;
	}




	public void setListaVoli(ArrayList<Volo> listaVoli) {
		this.listaVoli = listaVoli;
	}




	public boolean autenticaCliente(String email, String password) {
		Cliente cliente = ricercaCliente(email);
		return cliente.verificaPassword(password);
		
	}

	public ArrayList<ArrayList<Volo>> ricercaVolo(ArrayList<String> partenza, ArrayList<String> destinazione, int tipo_viaggio, ArrayList<LocalDateTime> date) {
		
		ArrayList<ArrayList<Volo>> voliTrovati = new ArrayList<ArrayList<Volo>>(tipo_viaggio);
		
		for(int i=0; i<tipo_viaggio; i++) {		//crea tipo_viaggio liste di voli per tipo_viaggio date
			ArrayList<Volo> dateVoli = new ArrayList<Volo>();
			ArrayList<Volo> tratteVoli = new ArrayList<Volo>();
			for(Volo volo: this.listaVoli)
				if((volo.getOraPartenza().getDayOfMonth() == date.get(i).getDayOfMonth()) && (volo.getOraPartenza().getMonth() == date.get(i).getMonth()) && (volo.getOraPartenza().getYear() == date.get(i).getYear()))
						dateVoli.add(volo);
			for(Volo volo: dateVoli)
				if(volo.getDescrizioneVolo().getAeroporti()[0].getCodice().equals(partenza.get(i))&&
						volo.getDescrizioneVolo().getAeroporti()[1].getCodice().equals(destinazione.get(i)))
					tratteVoli.add(volo);
			voliTrovati.add(i, tratteVoli);		//cosa aggiunge nelle posizioni corrispondenti a tratte senza voli trovati?
					
		}
		return voliTrovati;
	}

	public void confermaPrenotazione(Cliente cliente, VoloPrenotato[] listaVoli) {
		int numeroPrenotazione = 0;
		if (listaPrenotazioni.size() > 0) 
			numeroPrenotazione = listaPrenotazioni.get(listaPrenotazioni.size()-1).getNumeroPrenotazione();
		/*Calcolare il totale dalla listavoli mediante il prezzo del volo (descrizioneVolo, vedere quando casuale e quando acquistato), il bagaglio e il posto*/
		Prenotazione prenotazione = new Prenotazione(numeroPrenotazione++, cliente, listaVoli);
		prenotazione.inviaEmail(cliente);
		listaPrenotazioni.add(prenotazione);
	}
	
	public Cliente ricercaCliente(String email) {
		for(Cliente cliente: listaClienti)
			if(cliente.getEmail().equalsIgnoreCase(email))
				return cliente;
		return null;
	}
	
	public ArrayList<Prenotazione> effettuaCheckin(Cliente cliente){
		ArrayList<Prenotazione> listaPrenotazioniCliente = new ArrayList<Prenotazione>();
		
		for(Prenotazione prenotazione: this.listaPrenotazioni )
			if(prenotazione.getCliente().equals(cliente))
				listaPrenotazioniCliente.add(prenotazione);
		return listaPrenotazioniCliente;
	}
	
	public Prenotazione selezionaPrenotazione(int numeroPrenotazione, ArrayList<Prenotazione> listaPrenotazioniCliente) {
		for(Prenotazione prenotazione: listaPrenotazioniCliente)
			if(prenotazione.getNumeroPrenotazione() == numeroPrenotazione)
				return prenotazione;
		return null;
	}
	
	public VoloPrenotato selezionaVolo(int index, Prenotazione prenotazione) {
		return prenotazione.ricercaVolo(index);
	}
	
	public CartaDiImbarco confermaInserimento(Prenotazione prenotazione, VoloPrenotato voloPrenotato) {
		return new CartaDiImbarco(prenotazione, voloPrenotato);		
	}
	
	public void effettuaPagamentoPayPal(Prenotazione prenotazione) {
		prenotazione.creaPagamentoPayPal();
	}
	
	public void effettuaPagamentoCartaDiCredito(Prenotazione prenotazione) {
		prenotazione.creaPagamentoCartaCredito();
	}
	
	public int selezionaSconto(Prenotazione prenotazione) {
		return prenotazione.getCliente().getPunti();
	}
	
	public double selezionaPunti(int puntiSelezionati, double totale) {
		return calcolaNuovoTotale(puntiSelezionati, totale);
	}
	
	public boolean pagamentoPayPal(double nuovoTotale, Prenotazione prenotazione, String email, int puntiSelezionati) {
		return prenotazione.effettuaPagamento(nuovoTotale, email, puntiSelezionati);
	}
	
	public boolean pagamentoCartaCredito(double nuovoTotale, Prenotazione prenotazione, String numeroCarta, int puntiSelezionati) {
		return prenotazione.effettuaPagamento(nuovoTotale, numeroCarta, puntiSelezionati);
	}
	
	public double calcolaNuovoTotale(double puntiSelezionati, double totale) {
		double sconto = (double) puntiSelezionati / 100;
		return (totale-((totale/100)*sconto));
	}
	
	public ArrayList<Volo> inserisciVoli(int numeroVoli){
		ArrayList<Volo> voli = new ArrayList<Volo>();
		for(int i=0; i<numeroVoli; i++) {
			Volo volo = new Volo();
			voli.add(volo);
		}
		return voli;
	}
	
	public ArrayList<Amministratore> getListaAmministratori() {
		return listaAmministratori;
	}




	public void setListaAmministratori(ArrayList<Amministratore> listaAmministratori) {
		this.listaAmministratori = listaAmministratori;
	}




	public Aeroporto[] inserisciTratta(String aeroporto1, String aeroporto2, String citta1, String citta2, String codice1, String codice2) {
		Aeroporto[] aeroporti = new Aeroporto[2];
		aeroporti[0] = new Aeroporto(aeroporto1,citta1,codice1);
		aeroporti[1] = new Aeroporto(aeroporto2,citta2,codice2);
		return aeroporti;
	}
	
	public DescrizioneVolo inserisciDescrizione(String codiceVolo, Aeroporto[] tratta) {
		return new DescrizioneVolo(codiceVolo, tratta);		
	}
	
	public Volo inserisciDettagliVolo(DescrizioneVolo descrizioneVolo, Volo volo, double prezzo, LocalDateTime oraPartenza, LocalDateTime oraArrivo) {
		volo.riempiDettagliVolo(descrizioneVolo, prezzo, oraPartenza, oraArrivo);
		return volo;
	}
	
	public boolean confermaInserimento(ArrayList<Volo> voli) {
		this.listaVoli.addAll(voli);
		return true;
	}
	
	public ProgrammaFedelta inserisciProgrammaFedelta(String nome, double coefficientePunti) {
		return new ProgrammaFedelta(nome, coefficientePunti);
	}
	
	public boolean associaProgrammaFedelta(String codiceVolo, ProgrammaFedelta programmaFedelta) {
		DescrizioneVolo descrizioneVolo=null;
		for(Volo volo: this.listaVoli) {
			descrizioneVolo = volo.getDescrizioneVolo();
			if(descrizioneVolo.getCodice().equals(codiceVolo))
				break;
			else 
				descrizioneVolo = null;
		}
		if(descrizioneVolo != null) {
			descrizioneVolo.assegnaProgrammaFedelta(programmaFedelta);
			return true;
		}
		return false;
		
	}
	
	public boolean autenticaAmministratore(String email, String password) {
		Amministratore amministratore = ricercaAmministratore(email);
		return amministratore.verificaPassword(password);
		
	}
	
	public Amministratore ricercaAmministratore(String email) {
		for(Amministratore amministratore: listaAmministratori)
			if(amministratore.getEmail().equalsIgnoreCase(email))
				return amministratore;
		return null;
	}
	
	public int accreditaPunti(Prenotazione prenotazione) {
		return prenotazione.accreditaPunti();
	}
}





















