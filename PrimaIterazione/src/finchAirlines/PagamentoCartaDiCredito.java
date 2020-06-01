package finchAirlines;

public class PagamentoCartaDiCredito extends Pagamento {
	
	private CartaDiCredito cartaDiCredito;
	private CartaCreditoAdapter cartaCreditoAdapter;
	
	

	public PagamentoCartaDiCredito() {
		this.cartaCreditoAdapter = new CartaCreditoAdapter();
	}


	public CartaCreditoAdapter getCartaCreditoAdapter() {
		return cartaCreditoAdapter;
	}


	public void setCartaCreditoAdapter(CartaCreditoAdapter cartaCreditoAdapter) {
		this.cartaCreditoAdapter = cartaCreditoAdapter;
	}


	public CartaDiCredito getCartaDiCredito() {
		return cartaDiCredito;
	}
	

	public void setCartaDiCredito(CartaDiCredito cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}
	

	
	
	public double getTotale() {
		return super.getTotale();
	}
	

	public void setTotale(double totale) {
		super.setTotale(totale);
	}
	
	public boolean eseguiPagamento(double nuovoTotale, String numeroCarta) {
		this.cartaDiCredito = new CartaDiCredito(numeroCarta);
		return this.cartaCreditoAdapter.paga(this.cartaDiCredito, nuovoTotale);
	}
	

}
