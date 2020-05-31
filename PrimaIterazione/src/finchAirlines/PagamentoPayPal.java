package finchAirlines;

public class PagamentoPayPal extends Pagamento {
	
	PagamentoPayPal(double totale){
		super.setTotale(totale);
	}
	
	public double getTotale() {
		return super.getTotale();
	}

	public void setTotale(double totale) {
		super.setTotale(totale);
	}
	
}
