package finchAirlines;

public class PagamentoPayPal extends Pagamento {
	
	private ContoPayPal contoPayPal;
	private PayPalAdapter payPalAdapter;
	
	public PagamentoPayPal() {
		this.payPalAdapter = new PayPalAdapter();
	}
	
	
	public PayPalAdapter getPayPalAdapter() {
		return payPalAdapter;
	}


	public void setPayPalAdapter(PayPalAdapter payPalAdapter) {
		this.payPalAdapter = payPalAdapter;
	}


	public ContoPayPal getContoPayPal() {
		return contoPayPal;
	}
	

	public void setContoPayPal(ContoPayPal contoPayPal) {
		this.contoPayPal = contoPayPal;
	}
	
	
	
	public double getTotale() {
		return super.getTotale();
	}
	

	public void setTotale(double totale) {
		super.setTotale(totale);
	}
	
	public boolean eseguiPagamento(double nuovoTotale, String email) {
		this.contoPayPal = new ContoPayPal(email);
		return this.payPalAdapter.paga(this.contoPayPal, nuovoTotale);
	}


	
}
