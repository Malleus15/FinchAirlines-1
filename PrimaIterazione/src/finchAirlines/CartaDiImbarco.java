package finchAirlines;

public class CartaDiImbarco {
	
	private Prenotazione prenotazione;
	private VoloPrenotato voloPrenotato;
	
	
	public CartaDiImbarco(Prenotazione prenotazione, VoloPrenotato voloPrenotato) {
		this.prenotazione = prenotazione;
		this.voloPrenotato = voloPrenotato;
	}
	
	
	public Prenotazione getPrenotazione() {
		return prenotazione;
	}
	
	
	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}
	
	
	public VoloPrenotato getVoloPrenotato() {
		return voloPrenotato;
	}
	
	
	public void setVoloPrenotato(VoloPrenotato voloPrenotato) {
		this.voloPrenotato = voloPrenotato;
	}

}
