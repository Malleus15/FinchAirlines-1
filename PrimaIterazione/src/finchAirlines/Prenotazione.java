package finchAirlines;

public class Prenotazione {

	private int numeroPrenotazione;
	private double totale = 0;
	private Cliente cliente;
	private VoloPrenotato[] listaVoli;
	

	public Prenotazione(int numeroPrenotazione, Cliente cliente, VoloPrenotato[] listaVoli) {
		this.numeroPrenotazione = numeroPrenotazione;
		this.cliente = cliente;
		this.listaVoli = listaVoli;
		calcolaTotaleVoli();
	}

	
	public void calcolaTotaleVoli() {
		for(int i=0; i < listaVoli.length; i++) {
			totale += listaVoli[i].getVolo().getDescrizioneVolo().getPrezzo();
			totale += listaVoli[i].getBagaglio().calcolaPrezzo();
			totale += listaVoli[i].getPosto().calcolaPrezzo();
		}
	}


	public int getNumeroPrenotazione() {
		return numeroPrenotazione;
	}




	public void setNumeroPrenotazione(int numeroPrenotazione) {
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
		System.out.println("***************Email inviata a: "+cliente.getEmail()+" *****************");
	}

}
