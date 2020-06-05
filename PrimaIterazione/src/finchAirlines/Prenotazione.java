package finchAirlines;

public class Prenotazione {

	private int numeroPrenotazione;
	private double totale = 0;
	private Cliente cliente;
	private VoloPrenotato[] listaVoli;
	private boolean pagato;
	private Pagamento pagamento;
	

	public Prenotazione(int numeroPrenotazione, Cliente cliente, VoloPrenotato[] listaVoli) {
		this.numeroPrenotazione = numeroPrenotazione;
		this.cliente = cliente;
		this.listaVoli = listaVoli;
		this.pagato = false;
		calcolaTotaleVoli();
	}

	
	public void calcolaTotaleVoli() {
		for(int i=0; i < listaVoli.length; i++) {
			double prezzoVolo = listaVoli[i].getVolo().getDescrizioneVolo().getPrezzo();
			double prezzoBagaglio = listaVoli[i].getBagaglio().calcolaPrezzo();
			double prezzoPosto = listaVoli[i].getPosto().calcolaPrezzo();
			if(prezzoVolo > 0)
				totale += prezzoVolo;
			if(prezzoBagaglio > 0)
				totale += prezzoBagaglio;
			if(prezzoPosto > 0)
				totale += prezzoPosto;
		}
	}
	
	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}
	
	
	public boolean getPagato() {
		return this.pagato;
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
	
	public VoloPrenotato ricercaVolo(int index) {
		if (this.listaVoli[index].getVolo().controllaData())
				return this.listaVoli[index];
		return null;
	}
	

	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public void creaPagamentoPayPal() {
		this.pagamento = new PagamentoPayPal();
	}
	
	public void creaPagamentoCartaCredito() {
		this.pagamento = new PagamentoCartaDiCredito();
		
	}
	
	public boolean effettuaPagamento(double nuovoTotale, String idConto, int puntiSelezionati) {
		this.pagato = this.pagamento.eseguiPagamento(nuovoTotale, idConto);
		if(this.pagato)
			this.cliente.decrementaPunti(puntiSelezionati);
		return this.pagato;
	}

}
