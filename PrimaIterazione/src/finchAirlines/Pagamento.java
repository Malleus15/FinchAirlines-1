package finchAirlines;

public abstract class Pagamento {
	
	private double totale;

	public abstract boolean eseguiPagamento(double nuovoTotale, String idConto);
	
	public double getTotale() {
		return this.totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

}
