package finchAirlines;

public class PagamentoCartaDiCredito extends Pagamento {
	
	PagamentoCartaDiCredito(double totale){
		super.setTotale(totale);
	}
	
	public double getTotale() {
		return super.getTotale();
	}

	public void setTotale(double totale) {
		super.setTotale(totale);
	}
	

}
