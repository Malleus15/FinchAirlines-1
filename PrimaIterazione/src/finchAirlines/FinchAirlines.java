package finchAirlines;

import java.util.ArrayList;
import java.util.Date;


public class FinchAirlines {

	private ArrayList<Cliente> listaClienti;
	private ArrayList<Prenotazione> listaPrenotazioni;
	private ArrayList<Volo> listaVoli;
	

	public FinchAirlines() {
		this.listaClienti = new ArrayList<Cliente>();
		this.listaPrenotazioni = new ArrayList<Prenotazione>();
		this.listaVoli = new ArrayList<Volo>();
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
		for(Cliente cliente: listaClienti)
			if(cliente.getEmail() == email)
				return cliente.verificaPassword(password);
		return false;
	}

	public ArrayList<ArrayList<Volo>> ricercaVolo(ArrayList<String> partenza, ArrayList<String> destinazione, int tipo_viaggio, ArrayList<Date> date) {
		
		ArrayList<ArrayList<Volo>> voliTrovati = new ArrayList<ArrayList<Volo>>(tipo_viaggio);
		
		for(int i=0; i<tipo_viaggio; i++) {		//crea tipo_viaggio liste di voli per tipo_viaggio date
			ArrayList<Volo> dateVoli = new ArrayList<Volo>();
			ArrayList<Volo> tratteVoli = new ArrayList<Volo>();
			for(Volo volo: this.listaVoli)
				if(volo.getOraPartenza().equals(date.get(i)))
						dateVoli.add(volo);
			for(Volo volo: dateVoli)
				if(volo.getDescrizioneVolo().getAeroporti()[0].getCodice() == partenza.get(i)&&
						volo.getDescrizioneVolo().getAeroporti()[1].getCodice() == destinazione.get(i))
					tratteVoli.add(volo);
			voliTrovati.add(i, tratteVoli);		//cosa aggiunge nelle posizioni corrispondenti a tratte senza voli trovati?
					
		}
		return voliTrovati;
	}

	public void creaPrenotazione(Cliente cliente, VoloPrenotato[] listaVoli) {
		int numeroPrenotazione = listaPrenotazioni.get(listaPrenotazioni.size() - 1).getNumeroPrenotazione();
		/*Calcolare il totale dalla listavoli mediante il prezzo del volo (descrizioneVolo, vedere quando casuale e quando acquistato), il bagaglio e il posto*/
		Prenotazione prenotazione = new Prenotazione(numeroPrenotazione++, cliente, listaVoli);
		listaPrenotazioni.add(prenotazione);
	}

}
