package finchAirlines;

public class Prenotazione {

	private String numeroPrenotazione;
	private double totale = 0;
	private Cliente cliente;
	private VoloPrenotato[] listaVoli;
	

	public Prenotazione(String numeroPrenotazione, double totale, Cliente cliente, VoloPrenotato[] listaVoli) {
		this.numeroPrenotazione = numeroPrenotazione;
		this.totale = totale;
		this.cliente = cliente;
		this.listaVoli = listaVoli;
	}

	


	public String getNumeroPrenotazione() {
		return numeroPrenotazione;
	}




	public void setNumeroPrenotazione(String numeroPrenotazione) {
		this.numeroPrenotazione = numeroPrenotazione;
	}




	public double getTotale() {
		return totale;
	}




	public void setTotale(double totale) {
		this.totale = totale;
	}




	public Cliente getCliente() {
		return cliente;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public VoloPrenotato[] getListaVoli() {
		return listaVoli;
	}




	public void setListaVoli(VoloPrenotato[] listaVoli) {
		this.listaVoli = listaVoli;
	}




	public void inviaEmail(Cliente cliente) {

	}

}
